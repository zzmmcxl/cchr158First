/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.IBinder;
import android.support.v4.h.bi;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class cc {
    private static Field a;
    private static boolean b;
    private static Field c;
    private static boolean d;

    static ColorStateList a(View view) {
        if (!(view instanceof bi)) return null;
        return ((bi)view).getSupportBackgroundTintList();
    }

    static void a(View view, int n2) {
        int n3 = view.getTop();
        view.offsetTopAndBottom(n2);
        if (n2 == 0) return;
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            int n4 = Math.abs(n2);
            ((View)viewParent).invalidate(view.getLeft(), n3 - n4, view.getRight(), n4 + (n3 + view.getHeight()));
            return;
        }
        view.invalidate();
    }

    static void a(View view, ColorStateList colorStateList) {
        if (!(view instanceof bi)) return;
        ((bi)view).setSupportBackgroundTintList(colorStateList);
    }

    static void a(View view, PorterDuff.Mode mode) {
        if (!(view instanceof bi)) return;
        ((bi)view).setSupportBackgroundTintMode(mode);
    }

    static PorterDuff.Mode b(View view) {
        if (!(view instanceof bi)) return null;
        return ((bi)view).getSupportBackgroundTintMode();
    }

    static void b(View view, int n2) {
        int n3 = view.getLeft();
        view.offsetLeftAndRight(n2);
        if (n2 == 0) return;
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            int n4 = Math.abs(n2);
            ((View)viewParent).invalidate(n3 - n4, view.getTop(), n4 + (n3 + view.getWidth()), view.getBottom());
            return;
        }
        view.invalidate();
    }

    static boolean c(View view) {
        if (view.getWidth() <= 0) return false;
        if (view.getHeight() <= 0) return false;
        return true;
    }

    static int d(View view) {
        if (!b) {
            try {
                a = View.class.getDeclaredField("mMinWidth");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException var3_3) {}
            b = true;
        }
        if (a == null) return 0;
        try {
            return (Integer)a.get((Object)view);
        }
        catch (Exception var1_2) {
            // empty catch block
        }
        return 0;
    }

    static int e(View view) {
        if (!d) {
            try {
                c = View.class.getDeclaredField("mMinHeight");
                c.setAccessible(true);
            }
            catch (NoSuchFieldException var3_3) {}
            d = true;
        }
        if (c == null) return 0;
        try {
            return (Integer)c.get((Object)view);
        }
        catch (Exception var1_2) {
            // empty catch block
        }
        return 0;
    }

    static boolean f(View view) {
        if (view.getWindowToken() == null) return false;
        return true;
    }
}

