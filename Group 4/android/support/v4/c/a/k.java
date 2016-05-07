/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.q;
import android.support.v4.c.a.r;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class k {
    public static Drawable a(Drawable drawable) {
        if (drawable instanceof r) return drawable;
        return new r(drawable);
    }

    public static void a(Drawable drawable, int n2) {
        if (!(drawable instanceof q)) return;
        ((q)drawable).a(n2);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        if (!(drawable instanceof q)) return;
        ((q)drawable).a(colorStateList);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        if (!(drawable instanceof q)) return;
        ((q)drawable).a(mode);
    }
}

