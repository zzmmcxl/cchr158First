package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzUZ;
    private String zzaaL;
    private String zzaaN;
    private String zzaaP;
    private JSONObject zzaaU;
    private int zzabB;
    private int zzabC;

    public static class Builder {
        private final MediaTrack zzabD;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.zzabD = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.zzabD;
        }

        public Builder setContentId(String contentId) {
            this.zzabD.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.zzabD.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzabD.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.zzabD.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzabD.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.zzabD.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.zzabD.zzbe(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.zzUZ = id;
        if (type <= 0 || type > TYPE_VIDEO) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.zzabB = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        zzg(json);
    }

    private void clear() {
        this.zzUZ = 0;
        this.zzabB = TYPE_UNKNOWN;
        this.zzaaN = null;
        this.mName = null;
        this.zzaaL = null;
        this.zzabC = SUBTYPE_UNKNOWN;
        this.zzaaU = null;
    }

    private void zzg(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzUZ = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzabB = TYPE_TEXT;
        } else if ("AUDIO".equals(string)) {
            this.zzabB = TYPE_AUDIO;
        } else if ("VIDEO".equals(string)) {
            this.zzabB = TYPE_VIDEO;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzaaN = jSONObject.optString("trackContentId", null);
        this.zzaaP = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzaaL = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            string = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string)) {
                this.zzabC = TYPE_TEXT;
            } else if ("CAPTIONS".equals(string)) {
                this.zzabC = TYPE_AUDIO;
            } else if ("DESCRIPTIONS".equals(string)) {
                this.zzabC = TYPE_VIDEO;
            } else if ("CHAPTERS".equals(string)) {
                this.zzabC = SUBTYPE_CHAPTERS;
            } else if ("METADATA".equals(string)) {
                this.zzabC = SUBTYPE_METADATA;
            } else {
                throw new JSONException("invalid subtype: " + string);
            }
        }
        this.zzabC = TYPE_UNKNOWN;
        this.zzaaU = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.zzaaU == null ? TYPE_TEXT : false) != (mediaTrack.zzaaU == null ? TYPE_TEXT : false)) {
            return false;
        }
        if (this.zzaaU != null && mediaTrack.zzaaU != null && !zznb.zze(this.zzaaU, mediaTrack.zzaaU)) {
            return false;
        }
        if (!(this.zzUZ == mediaTrack.zzUZ && this.zzabB == mediaTrack.zzabB && zzf.zza(this.zzaaN, mediaTrack.zzaaN) && zzf.zza(this.zzaaP, mediaTrack.zzaaP) && zzf.zza(this.mName, mediaTrack.mName) && zzf.zza(this.zzaaL, mediaTrack.zzaaL) && this.zzabC == mediaTrack.zzabC)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzaaN;
    }

    public String getContentType() {
        return this.zzaaP;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public long getId() {
        return this.zzUZ;
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzabC;
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzUZ), Integer.valueOf(this.zzabB), this.zzaaN, this.zzaaP, this.mName, this.zzaaL, Integer.valueOf(this.zzabC), this.zzaaU);
    }

    public void setContentId(String contentId) {
        this.zzaaN = contentId;
    }

    public void setContentType(String contentType) {
        this.zzaaP = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    void setLanguage(String language) {
        this.zzaaL = language;
    }

    void setName(String name) {
        this.mName = name;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzUZ);
            switch (this.zzabB) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("type", "TEXT");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("type", "AUDIO");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzaaN != null) {
                jSONObject.put("trackContentId", this.zzaaN);
            }
            if (this.zzaaP != null) {
                jSONObject.put("trackContentType", this.zzaaP);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzaaL)) {
                jSONObject.put("language", this.zzaaL);
            }
            switch (this.zzabC) {
                case TYPE_TEXT /*1*/:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case TYPE_AUDIO /*2*/:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case TYPE_VIDEO /*3*/:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case SUBTYPE_CHAPTERS /*4*/:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case SUBTYPE_METADATA /*5*/:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzbe(int i) throws IllegalArgumentException {
        if (i <= SUBTYPE_UNKNOWN || i > SUBTYPE_METADATA) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzabB == TYPE_TEXT) {
            this.zzabC = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
