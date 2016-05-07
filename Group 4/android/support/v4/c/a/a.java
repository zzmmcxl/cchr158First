/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.c.a.b;
import android.support.v4.c.a.c;
import android.support.v4.c.a.d;
import android.support.v4.c.a.e;
import android.support.v4.c.a.f;
import android.support.v4.c.a.g;
import android.support.v4.c.a.h;
import android.support.v4.c.a.i;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    static final c a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            a = new i();
            return;
        }
        if (n2 >= 21) {
            a = new h();
            return;
        }
        if (n2 >= 19) {
            a = new g();
            return;
        }
        if (n2 >= 17) {
            a = new f();
            return;
        }
        if (n2 >= 11) {
            a = new e();
            return;
        }
        if (n2 >= 5) {
            a = new d();
            return;
        }
        a = new b();
    }

    public static void a(Drawable drawable) {
        a.a(drawable);
    }

    public static void a(Drawable drawable, float f2, float f3) {
        a.a(drawable, f2, f3);
    }

    public static void a(Drawable drawable, int n2) {
        a.a(drawable, n2);
    }

    public static void a(Drawable drawable, int n2, int n3, int n4, int n5) {
        a.a(drawable, n2, n3, n4, n5);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        a.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        a.a(drawable, theme);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        a.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void a(Drawable drawable, PorterDuff.Mode mode) {
        a.a(drawable, mode);
    }

    public static void a(Drawable drawable, boolean bl2) {
        a.a(drawable, bl2);
    }

    public static void b(Drawable drawable, int n2) {
        a.b(drawable, n2);
    }

    public static boolean b(Drawable drawable) {
        return a.b(drawable);
    }

    public static int c(Drawable drawable) {
        return a.e(drawable);
    }

    public static boolean d(Drawable drawable) {
        return a.f(drawable);
    }

    public static ColorFilter e(Drawable drawable) {
        return a.g(drawable);
    }

    public static Drawable f(Drawable drawable) {
        return a.c(drawable);
    }

    public static int g(Drawable drawable) {
        return a.d(drawable);
    }
}

