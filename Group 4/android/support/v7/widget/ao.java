/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.b.c;
import android.support.v4.widget.bi;
import android.support.v7.b.b;
import android.support.v7.widget.aq;
import android.support.v7.widget.ar;
import android.support.v7.widget.gh;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class ao
extends CheckBox
implements bi {
    private ar a = ar.a();
    private aq b;

    public ao(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.checkboxStyle);
    }

    public ao(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        this.b = new aq((CompoundButton)this, this.a);
        this.b.a(attributeSet, n2);
    }

    public int getCompoundPaddingLeft() {
        int n2 = super.getCompoundPaddingLeft();
        if (this.b == null) return n2;
        return this.b.a(n2);
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.b == null) return null;
        return this.b.a();
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.b == null) return null;
        return this.b.b();
    }

    public void setButtonDrawable(int n2) {
        Drawable drawable = this.a != null ? this.a.a(this.getContext(), n2) : c.a(this.getContext(), n2);
        this.setButtonDrawable(drawable);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.b == null) return;
        this.b.c();
    }

    @Override
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.b == null) return;
        this.b.a(colorStateList);
    }

    @Override
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.b == null) return;
        this.b.a(mode);
    }
}

