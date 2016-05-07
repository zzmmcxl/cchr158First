/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.h.bo;
import android.support.v7.b.l;
import android.support.v7.widget.ar;
import android.support.v7.widget.cs;
import android.support.v7.widget.gi;
import android.util.AttributeSet;
import android.view.View;

class am {
    private final View a;
    private final ar b;
    private gi c;
    private gi d;
    private gi e;

    am(View view, ar ar2) {
        this.a = view;
        this.b = ar2;
    }

    private boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT != 21) return false;
        if (!(drawable instanceof GradientDrawable)) return false;
        return true;
    }

    private void c(Drawable drawable) {
        PorterDuff.Mode mode;
        if (this.e == null) {
            this.e = new gi();
        }
        gi gi2 = this.e;
        gi2.a();
        ColorStateList colorStateList = bo.x(this.a);
        if (colorStateList != null) {
            gi2.d = true;
            gi2.a = colorStateList;
        }
        if ((mode = bo.y(this.a)) != null) {
            gi2.c = true;
            gi2.b = mode;
        }
        if (!gi2.d) {
            if (!gi2.c) return;
        }
        ar.a(drawable, gi2, this.a.getDrawableState());
    }

    ColorStateList a() {
        if (this.d == null) return null;
        return this.d.a;
    }

    void a(int n2) {
        ColorStateList colorStateList = this.b != null ? this.b.b(this.a.getContext(), n2) : null;
        this.b(colorStateList);
    }

    void a(ColorStateList colorStateList) {
        if (this.d == null) {
            this.d = new gi();
        }
        this.d.a = colorStateList;
        this.d.d = true;
        this.c();
    }

    void a(PorterDuff.Mode mode) {
        if (this.d == null) {
            this.d = new gi();
        }
        this.d.b = mode;
        this.d.c = true;
        this.c();
    }

    void a(Drawable drawable) {
        this.b((ColorStateList)null);
    }

    void a(AttributeSet attributeSet, int n2) {
        TypedArray typedArray = this.a.getContext().obtainStyledAttributes(attributeSet, l.ViewBackgroundHelper, n2, 0);
        try {
            ColorStateList colorStateList;
            if (typedArray.hasValue(l.ViewBackgroundHelper_android_background) && (colorStateList = this.b.b(this.a.getContext(), typedArray.getResourceId(l.ViewBackgroundHelper_android_background, -1))) != null) {
                this.b(colorStateList);
            }
            if (typedArray.hasValue(l.ViewBackgroundHelper_backgroundTint)) {
                bo.a(this.a, typedArray.getColorStateList(l.ViewBackgroundHelper_backgroundTint));
            }
            if (!typedArray.hasValue(l.ViewBackgroundHelper_backgroundTintMode)) return;
            bo.a(this.a, cs.a(typedArray.getInt(l.ViewBackgroundHelper_backgroundTintMode, -1), null));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    PorterDuff.Mode b() {
        if (this.d == null) return null;
        return this.d.b;
    }

    void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.c == null) {
                this.c = new gi();
            }
            this.c.a = colorStateList;
            this.c.d = true;
        } else {
            this.c = null;
        }
        this.c();
    }

    void c() {
        Drawable drawable = this.a.getBackground();
        if (drawable == null) return;
        if (this.d != null) {
            ar.a(drawable, this.d, this.a.getDrawableState());
            return;
        }
        if (this.c != null) {
            ar.a(drawable, this.c, this.a.getDrawableState());
            return;
        }
        if (!this.b(drawable)) return;
        this.c(drawable);
    }
}

