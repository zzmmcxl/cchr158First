/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.aa;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class p {
    public static Drawable a(Drawable drawable) {
        if (drawable instanceof aa) return drawable;
        return new aa(drawable);
    }

    public static void a(Drawable drawable, float f2, float f3) {
        drawable.setHotspot(f2, f3);
    }

    public static void a(Drawable drawable, int n2) {
        drawable.setTint(n2);
    }

    public static void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        drawable.setHotspotBounds(n2, n3, n4, n5);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        drawable.applyTheme(theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static boolean b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter c(Drawable drawable) {
        return drawable.getColorFilter();
    }
}

