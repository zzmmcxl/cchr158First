/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ar;
import android.util.AttributeSet;

public class gk {
    private final Context a;
    private final TypedArray b;

    private gk(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static gk a(Context context, AttributeSet attributeSet, int[] arrn) {
        return new gk(context, context.obtainStyledAttributes(attributeSet, arrn));
    }

    public static gk a(Context context, AttributeSet attributeSet, int[] arrn, int n2, int n3) {
        return new gk(context, context.obtainStyledAttributes(attributeSet, arrn, n2, n3));
    }

    public float a(int n2, float f2) {
        return this.b.getFloat(n2, f2);
    }

    public int a(int n2, int n3) {
        return this.b.getInt(n2, n3);
    }

    public Drawable a(int n2) {
        if (!this.b.hasValue(n2)) return this.b.getDrawable(n2);
        int n3 = this.b.getResourceId(n2, 0);
        if (n3 == 0) return this.b.getDrawable(n2);
        return ar.a().a(this.a, n3);
    }

    public void a() {
        this.b.recycle();
    }

    public boolean a(int n2, boolean bl2) {
        return this.b.getBoolean(n2, bl2);
    }

    public int b(int n2, int n3) {
        return this.b.getColor(n2, n3);
    }

    public Drawable b(int n2) {
        if (!this.b.hasValue(n2)) return null;
        int n3 = this.b.getResourceId(n2, 0);
        if (n3 == 0) return null;
        return ar.a().a(this.a, n3, true);
    }

    public int c(int n2, int n3) {
        return this.b.getInteger(n2, n3);
    }

    public CharSequence c(int n2) {
        return this.b.getText(n2);
    }

    public int d(int n2, int n3) {
        return this.b.getDimensionPixelOffset(n2, n3);
    }

    public String d(int n2) {
        return this.b.getString(n2);
    }

    public int e(int n2, int n3) {
        return this.b.getDimensionPixelSize(n2, n3);
    }

    public CharSequence[] e(int n2) {
        return this.b.getTextArray(n2);
    }

    public int f(int n2, int n3) {
        return this.b.getLayoutDimension(n2, n3);
    }

    public boolean f(int n2) {
        return this.b.hasValue(n2);
    }

    public int g(int n2, int n3) {
        return this.b.getResourceId(n2, n3);
    }
}

