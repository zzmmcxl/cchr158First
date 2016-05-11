package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import com.google.android.gms.internal.zzne;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzaaU;
    private float zzaco;
    private int zzacp;
    private int zzacq;
    private int zzacr;
    private int zzacs;
    private int zzact;
    private int zzacu;
    private String zzacv;
    private int zzacw;
    private int zzacx;
    private int zzxO;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzaco = DEFAULT_FONT_SCALE;
        this.zzacp = WINDOW_TYPE_NONE;
        this.zzxO = WINDOW_TYPE_NONE;
        this.zzacq = WINDOW_TYPE_UNSPECIFIED;
        this.zzacr = WINDOW_TYPE_NONE;
        this.zzacs = WINDOW_TYPE_UNSPECIFIED;
        this.zzact = WINDOW_TYPE_NONE;
        this.zzacu = WINDOW_TYPE_NONE;
        this.zzacv = null;
        this.zzacw = WINDOW_TYPE_UNSPECIFIED;
        this.zzacx = WINDOW_TYPE_UNSPECIFIED;
        this.zzaaU = null;
    }

    @TargetApi(19)
    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzne.zzsk()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case WINDOW_TYPE_NORMAL /*1*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NORMAL);
                break;
            case WINDOW_TYPE_ROUNDED /*2*/:
                textTrackStyle.setEdgeType(WINDOW_TYPE_ROUNDED);
                break;
            default:
                textTrackStyle.setEdgeType(WINDOW_TYPE_NONE);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NORMAL);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontGenericFamily(WINDOW_TYPE_NONE);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(FONT_STYLE_BOLD_ITALIC);
            } else if (isBold) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NORMAL);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(WINDOW_TYPE_ROUNDED);
            } else {
                textTrackStyle.setFontStyle(WINDOW_TYPE_NONE);
            }
        }
        return textTrackStyle;
    }

    private String zzL(int i) {
        Object[] objArr = new Object[FONT_FAMILY_CASUAL];
        objArr[WINDOW_TYPE_NONE] = Integer.valueOf(Color.red(i));
        objArr[WINDOW_TYPE_NORMAL] = Integer.valueOf(Color.green(i));
        objArr[WINDOW_TYPE_ROUNDED] = Integer.valueOf(Color.blue(i));
        objArr[FONT_STYLE_BOLD_ITALIC] = Integer.valueOf(Color.alpha(i));
        return String.format("#%02X%02X%02X%02X", objArr);
    }

    private int zzcd(String str) {
        int i = WINDOW_TYPE_NONE;
        if (str != null && str.length() == 9 && str.charAt(i) == '#') {
            try {
                i = Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(WINDOW_TYPE_NORMAL, FONT_STYLE_BOLD_ITALIC), 16), Integer.parseInt(str.substring(FONT_STYLE_BOLD_ITALIC, FONT_FAMILY_CURSIVE), 16), Integer.parseInt(str.substring(FONT_FAMILY_CURSIVE, 7), 16));
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.zzaaU == null ? WINDOW_TYPE_NORMAL : false) != (textTrackStyle.zzaaU == null ? WINDOW_TYPE_NORMAL : false)) {
            return false;
        }
        if (this.zzaaU != null && textTrackStyle.zzaaU != null && !zznb.zze(this.zzaaU, textTrackStyle.zzaaU)) {
            return false;
        }
        if (!(this.zzaco == textTrackStyle.zzaco && this.zzacp == textTrackStyle.zzacp && this.zzxO == textTrackStyle.zzxO && this.zzacq == textTrackStyle.zzacq && this.zzacr == textTrackStyle.zzacr && this.zzacs == textTrackStyle.zzacs && this.zzacu == textTrackStyle.zzacu && zzf.zza(this.zzacv, textTrackStyle.zzacv) && this.zzacw == textTrackStyle.zzacw && this.zzacx == textTrackStyle.zzacx)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.zzxO;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getEdgeColor() {
        return this.zzacr;
    }

    public int getEdgeType() {
        return this.zzacq;
    }

    public String getFontFamily() {
        return this.zzacv;
    }

    public int getFontGenericFamily() {
        return this.zzacw;
    }

    public float getFontScale() {
        return this.zzaco;
    }

    public int getFontStyle() {
        return this.zzacx;
    }

    public int getForegroundColor() {
        return this.zzacp;
    }

    public int getWindowColor() {
        return this.zzact;
    }

    public int getWindowCornerRadius() {
        return this.zzacu;
    }

    public int getWindowType() {
        return this.zzacs;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzaco), Integer.valueOf(this.zzacp), Integer.valueOf(this.zzxO), Integer.valueOf(this.zzacq), Integer.valueOf(this.zzacr), Integer.valueOf(this.zzacs), Integer.valueOf(this.zzact), Integer.valueOf(this.zzacu), this.zzacv, Integer.valueOf(this.zzacw), Integer.valueOf(this.zzacx), this.zzaaU);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.zzxO = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.zzacr = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > FONT_FAMILY_CASUAL) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzacq = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.zzacv = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > FONT_FAMILY_SMALL_CAPITALS) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzacw = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.zzaco = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > FONT_STYLE_BOLD_ITALIC) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzacx = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.zzacp = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.zzact = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzacu = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > WINDOW_TYPE_ROUNDED) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzacs = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzaco);
            if (this.zzacp != 0) {
                jSONObject.put("foregroundColor", zzL(this.zzacp));
            }
            if (this.zzxO != 0) {
                jSONObject.put("backgroundColor", zzL(this.zzxO));
            }
            switch (this.zzacq) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzacr != 0) {
                jSONObject.put("edgeColor", zzL(this.zzacr));
            }
            switch (this.zzacs) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("windowType", "NONE");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzact != 0) {
                jSONObject.put("windowColor", zzL(this.zzact));
            }
            if (this.zzacs == WINDOW_TYPE_ROUNDED) {
                jSONObject.put("windowRoundedCornerRadius", this.zzacu);
            }
            if (this.zzacv != null) {
                jSONObject.put("fontFamily", this.zzacv);
            }
            switch (this.zzacw) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case FONT_FAMILY_CASUAL /*4*/:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case FONT_FAMILY_CURSIVE /*5*/:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case FONT_FAMILY_SMALL_CAPITALS /*6*/:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzacx) {
                case WINDOW_TYPE_NONE /*0*/:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case WINDOW_TYPE_NORMAL /*1*/:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case WINDOW_TYPE_ROUNDED /*2*/:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case FONT_STYLE_BOLD_ITALIC /*3*/:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzg(JSONObject jSONObject) throws JSONException {
        String string;
        clear();
        this.zzaco = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzacp = zzcd(jSONObject.optString("foregroundColor"));
        this.zzxO = zzcd(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzacq = WINDOW_TYPE_NONE;
            } else if ("OUTLINE".equals(string)) {
                this.zzacq = WINDOW_TYPE_NORMAL;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzacq = WINDOW_TYPE_ROUNDED;
            } else if ("RAISED".equals(string)) {
                this.zzacq = FONT_STYLE_BOLD_ITALIC;
            } else if ("DEPRESSED".equals(string)) {
                this.zzacq = FONT_FAMILY_CASUAL;
            }
        }
        this.zzacr = zzcd(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            string = jSONObject.getString("windowType");
            if ("NONE".equals(string)) {
                this.zzacs = WINDOW_TYPE_NONE;
            } else if ("NORMAL".equals(string)) {
                this.zzacs = WINDOW_TYPE_NORMAL;
            } else if ("ROUNDED_CORNERS".equals(string)) {
                this.zzacs = WINDOW_TYPE_ROUNDED;
            }
        }
        this.zzact = zzcd(jSONObject.optString("windowColor"));
        if (this.zzacs == WINDOW_TYPE_ROUNDED) {
            this.zzacu = jSONObject.optInt("windowRoundedCornerRadius", WINDOW_TYPE_NONE);
        }
        this.zzacv = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            string = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string)) {
                this.zzacw = WINDOW_TYPE_NONE;
            } else if ("MONOSPACED_SANS_SERIF".equals(string)) {
                this.zzacw = WINDOW_TYPE_NORMAL;
            } else if ("SERIF".equals(string)) {
                this.zzacw = WINDOW_TYPE_ROUNDED;
            } else if ("MONOSPACED_SERIF".equals(string)) {
                this.zzacw = FONT_STYLE_BOLD_ITALIC;
            } else if ("CASUAL".equals(string)) {
                this.zzacw = FONT_FAMILY_CASUAL;
            } else if ("CURSIVE".equals(string)) {
                this.zzacw = FONT_FAMILY_CURSIVE;
            } else if ("SMALL_CAPITALS".equals(string)) {
                this.zzacw = FONT_FAMILY_SMALL_CAPITALS;
            }
        }
        if (jSONObject.has("fontStyle")) {
            string = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string)) {
                this.zzacx = WINDOW_TYPE_NONE;
            } else if ("BOLD".equals(string)) {
                this.zzacx = WINDOW_TYPE_NORMAL;
            } else if ("ITALIC".equals(string)) {
                this.zzacx = WINDOW_TYPE_ROUNDED;
            } else if ("BOLD_ITALIC".equals(string)) {
                this.zzacx = FONT_STYLE_BOLD_ITALIC;
            }
        }
        this.zzaaU = jSONObject.optJSONObject("customData");
    }
}
