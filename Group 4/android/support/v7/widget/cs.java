/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.widget.gf;

class cs {
    public static final Rect a = new Rect();
    private static Class b;

    static {
        if (Build.VERSION.SDK_INT < 18) return;
        try {
            b = Class.forName("android.graphics.Insets");
            return;
        }
        catch (ClassNotFoundException var0) {
            return;
        }
    }

    static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        switch (n2) {
            default: {
                return mode;
            }
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: {
                return PorterDuff.Mode.SCREEN;
            }
            case 16: 
        }
        if (Build.VERSION.SDK_INT < 11) return mode;
        return PorterDuff.Mode.valueOf((String)"ADD");
    }

    static void a(Drawable drawable) {
        if (Build.VERSION.SDK_INT != 21) return;
        if (!"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) return;
        cs.c(drawable);
    }

    static boolean b(Drawable drawable) {
        boolean bl2 = true;
        if (drawable instanceof LayerDrawable) {
            if (Build.VERSION.SDK_INT < 16) return false;
            boolean bl3 = bl2;
            return bl3;
        }
        if (drawable instanceof InsetDrawable) {
            if (Build.VERSION.SDK_INT >= 14) return bl2;
            return false;
        }
        if (drawable instanceof StateListDrawable) {
            if (Build.VERSION.SDK_INT >= 8) return bl2;
            return false;
        }
        if (drawable instanceof GradientDrawable) {
            if (Build.VERSION.SDK_INT >= 14) return bl2;
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) return bl2;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) return bl2;
        Drawable[] arrdrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
        int n2 = arrdrawable.length;
        int n3 = 0;
        while (n3 < n2) {
            if (!cs.b(arrdrawable[n3])) {
                return false;
            }
            ++n3;
        }
        return bl2;
    }

    private static void c(Drawable drawable) {
        int[] arrn = drawable.getState();
        if (arrn == null || arrn.length == 0) {
            drawable.setState(gf.e);
        } else {
            drawable.setState(gf.h);
        }
        drawable.setState(arrn);
    }
}

