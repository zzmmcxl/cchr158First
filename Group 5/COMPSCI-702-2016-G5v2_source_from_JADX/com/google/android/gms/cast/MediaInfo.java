package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzaaN;
    private int zzaaO;
    private String zzaaP;
    private MediaMetadata zzaaQ;
    private long zzaaR;
    private List<MediaTrack> zzaaS;
    private TextTrackStyle zzaaT;
    private JSONObject zzaaU;

    public static class Builder {
        private final MediaInfo zzaaV;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzaaV = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzaaV.zznN();
            return this.zzaaV;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.zzaaV.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzaaV.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.zzaaV.zzu(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.zzaaV.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.zzaaV.zzx(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.zzaaV.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzaaV.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzaaN = contentId;
        this.zzaaO = STREAM_TYPE_INVALID;
        this.zzaaR = UNKNOWN_DURATION;
    }

    MediaInfo(JSONObject json) throws JSONException {
        int i = STREAM_TYPE_NONE;
        this.zzaaN = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzaaO = STREAM_TYPE_NONE;
        } else if ("BUFFERED".equals(string)) {
            this.zzaaO = STREAM_TYPE_BUFFERED;
        } else if ("LIVE".equals(string)) {
            this.zzaaO = STREAM_TYPE_LIVE;
        } else {
            this.zzaaO = STREAM_TYPE_INVALID;
        }
        this.zzaaP = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.zzaaQ = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.zzaaQ.zzg(jSONObject);
        }
        this.zzaaR = UNKNOWN_DURATION;
        if (json.has("duration") && !json.isNull("duration")) {
            double optDouble = json.optDouble("duration", 0.0d);
            if (!(Double.isNaN(optDouble) || Double.isInfinite(optDouble))) {
                this.zzaaR = zzf.zzg(optDouble);
            }
        }
        if (json.has("tracks")) {
            this.zzaaS = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            while (i < jSONArray.length()) {
                this.zzaaS.add(new MediaTrack(jSONArray.getJSONObject(i)));
                i += STREAM_TYPE_BUFFERED;
            }
        } else {
            this.zzaaS = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzg(jSONObject2);
            this.zzaaT = textTrackStyle;
        } else {
            this.zzaaT = null;
        }
        this.zzaaU = json.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.zzaaU == null ? STREAM_TYPE_BUFFERED : false) != (mediaInfo.zzaaU == null ? STREAM_TYPE_BUFFERED : false)) {
            return false;
        }
        if (this.zzaaU != null && mediaInfo.zzaaU != null && !zznb.zze(this.zzaaU, mediaInfo.zzaaU)) {
            return false;
        }
        if (!(zzf.zza(this.zzaaN, mediaInfo.zzaaN) && this.zzaaO == mediaInfo.zzaaO && zzf.zza(this.zzaaP, mediaInfo.zzaaP) && zzf.zza(this.zzaaQ, mediaInfo.zzaaQ) && this.zzaaR == mediaInfo.zzaaR)) {
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

    public List<MediaTrack> getMediaTracks() {
        return this.zzaaS;
    }

    public MediaMetadata getMetadata() {
        return this.zzaaQ;
    }

    public long getStreamDuration() {
        return this.zzaaR;
    }

    public int getStreamType() {
        return this.zzaaO;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzaaT;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaaN, Integer.valueOf(this.zzaaO), this.zzaaP, this.zzaaQ, Long.valueOf(this.zzaaR), String.valueOf(this.zzaaU));
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzaaP = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < STREAM_TYPE_INVALID || streamType > STREAM_TYPE_LIVE) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzaaO = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzaaT = textTrackStyle;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.zzaaN);
            switch (this.zzaaO) {
                case STREAM_TYPE_BUFFERED /*1*/:
                    obj = "BUFFERED";
                    break;
                case STREAM_TYPE_LIVE /*2*/:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.zzaaP != null) {
                jSONObject.put("contentType", this.zzaaP);
            }
            if (this.zzaaQ != null) {
                jSONObject.put("metadata", this.zzaaQ.toJson());
            }
            if (this.zzaaR <= UNKNOWN_DURATION) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzaaR));
            }
            if (this.zzaaS != null) {
                JSONArray jSONArray = new JSONArray();
                for (MediaTrack toJson : this.zzaaS) {
                    jSONArray.put(toJson.toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzaaT != null) {
                jSONObject.put("textTrackStyle", this.zzaaT.toJson());
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzaaQ = mediaMetadata;
    }

    void zznN() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzaaN)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.zzaaP)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.zzaaO == STREAM_TYPE_INVALID) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzu(List<MediaTrack> list) {
        this.zzaaS = list;
    }

    void zzx(long j) throws IllegalArgumentException {
        if (j >= 0 || j == UNKNOWN_DURATION) {
            this.zzaaR = j;
            return;
        }
        throw new IllegalArgumentException("Invalid stream duration");
    }
}
