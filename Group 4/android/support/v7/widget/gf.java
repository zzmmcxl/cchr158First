/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.c.a;
import android.util.AttributeSet;
import android.util.TypedValue;

class gf {
    static final int[] a;
    static final int[] b;
    static final int[] c;
    static final int[] d;
    static final int[] e;
    static final int[] f;
    static final int[] g;
    static final int[] h;
    private static final ThreadLocal i;
    private static final int[] j;

    static {
        i = new ThreadLocal();
        a = new int[]{-16842910};
        b = new int[]{16842908};
        c = new int[]{16843518};
        d = new int[]{16842919};
        e = new int[]{16842912};
        f = new int[]{16842913};
        g = new int[]{-16842919, -16842908};
        h = new int[0];
        j = new int[1];
    }

    public static int a(Context context, int n2) {
        gf.j[0] = n2;
        TypedArray typedArray = context.obtainStyledAttributes(null, j);
        try {
            int n3 = typedArray.getColor(0, 0);
            return n3;
        }
        finally {
            typedArray.recycle();
        }
    }

    static int a(Context context, int n2, float f2) {
        int n3 = gf.a(context, n2);
        return a.b(n3, Math.round(f2 * (float)Color.alpha((int)n3)));
    }

    private static TypedValue a() {
        TypedValue typedValue = (TypedValue)i.get();
        if (typedValue != null) return typedValue;
        typedValue = new TypedValue();
        i.set(typedValue);
        return typedValue;
    }

    public static ColorStateList b(Context context, int n2) {
        gf.j[0] = n2;
        TypedArray typedArray = context.obtainStyledAttributes(null, j);
        try {
            ColorStateList colorStateList = typedArray.getColorStateList(0);
            return colorStateList;
        }
        finally {
            typedArray.recycle();
        }
    }

    public static int c(Context context, int n2) {
        ColorStateList colorStateList = gf.b(context, n2);
        if (colorStateList != null && colorStateList.isStateful()) {
            return colorStateList.getColorForState(a, colorStateList.getDefaultColor());
        }
        TypedValue typedValue = gf.a();
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return gf.a(context, n2, typedValue.getFloat());
    }
}

