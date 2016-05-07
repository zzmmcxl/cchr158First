/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.c.a.a;
import android.support.v4.widget.e;
import android.support.v7.b.l;
import android.support.v7.widget.ar;
import android.support.v7.widget.cs;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class aq {
    private final CompoundButton a;
    private final ar b;
    private ColorStateList c = null;
    private PorterDuff.Mode d = null;
    private boolean e = false;
    private boolean f = false;
    private boolean g;

    aq(CompoundButton compoundButton, ar ar2) {
        this.a = compoundButton;
        this.b = ar2;
    }

    int a(int n2) {
        if (Build.VERSION.SDK_INT >= 17) return n2;
        Drawable drawable = e.a(this.a);
        if (drawable == null) return n2;
        n2 += drawable.getIntrinsicWidth();
        return n2;
    }

    ColorStateList a() {
        return this.c;
    }

    void a(ColorStateList colorStateList) {
        this.c = colorStateList;
        this.e = true;
        this.d();
    }

    void a(PorterDuff.Mode mode) {
        this.d = mode;
        this.f = true;
        this.d();
    }

    void a(AttributeSet attributeSet, int n2) {
        TypedArray typedArray = this.a.getContext().obtainStyledAttributes(attributeSet, l.CompoundButton, n2, 0);
        try {
            int n3;
            if (typedArray.hasValue(l.CompoundButton_android_button) && (n3 = typedArray.getResourceId(l.CompoundButton_android_button, 0)) != 0) {
                this.a.setButtonDrawable(this.b.a(this.a.getContext(), n3));
            }
            if (typedArray.hasValue(l.CompoundButton_buttonTint)) {
                e.a(this.a, typedArray.getColorStateList(l.CompoundButton_buttonTint));
            }
            if (!typedArray.hasValue(l.CompoundButton_buttonTintMode)) return;
            e.a(this.a, cs.a(typedArray.getInt(l.CompoundButton_buttonTintMode, -1), null));
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    PorterDuff.Mode b() {
        return this.d;
    }

    void c() {
        if (this.g) {
            this.g = false;
            return;
        }
        this.g = true;
        this.d();
    }

    void d() {
        Drawable drawable = e.a(this.a);
        if (drawable == null) return;
        if (!this.e) {
            if (!this.f) return;
        }
        Drawable drawable2 = a.f(drawable).mutate();
        if (this.e) {
            a.a(drawable2, this.c);
        }
        if (this.f) {
            a.a(drawable2, this.d);
        }
        if (drawable2.isStateful()) {
            drawable2.setState(this.a.getDrawableState());
        }
        this.a.setButtonDrawable(drawable2);
    }
}

