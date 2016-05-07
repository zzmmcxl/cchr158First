/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.TypedArray;
import org.xmlpull.v1.XmlPullParser;

class j {
    public static float a(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, float f2) {
        if (j.a(xmlPullParser, string)) return typedArray.getFloat(n2, f2);
        return f2;
    }

    public static int a(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, int n3) {
        if (j.a(xmlPullParser, string)) return typedArray.getInt(n2, n3);
        return n3;
    }

    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, boolean bl2) {
        if (j.a(xmlPullParser, string)) return typedArray.getBoolean(n2, bl2);
        return bl2;
    }

    public static boolean a(XmlPullParser xmlPullParser, String string) {
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", string) == null) return false;
        return true;
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String string, int n2, int n3) {
        if (j.a(xmlPullParser, string)) return typedArray.getColor(n2, n3);
        return n3;
    }
}

