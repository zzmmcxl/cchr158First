/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.h.bi;
import android.support.v7.b.b;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.bq;
import android.support.v7.widget.gh;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class bb
extends MultiAutoCompleteTextView
implements bi {
    private static final int[] a = new int[]{16843126};
    private ar b = ar.a();
    private am c;
    private bq d;

    public bb(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.autoCompleteTextViewStyle);
    }

    public bb(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        gk gk2 = gk.a(this.getContext(), attributeSet, a, n2, 0);
        if (gk2.f(0)) {
            this.setDropDownBackgroundDrawable(gk2.a(0));
        }
        gk2.a();
        this.c = new am((View)this, this.b);
        this.c.a(attributeSet, n2);
        this.d = bq.a((TextView)this);
        this.d.a(attributeSet, n2);
        this.d.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c != null) {
            this.c.c();
        }
        if (this.d == null) return;
        this.d.a();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.c == null) return null;
        return this.c.a();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.c == null) return null;
        return this.c.b();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.c == null) return;
        this.c.a(drawable);
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.c == null) return;
        this.c.a(n2);
    }

    public void setDropDownBackgroundResource(int n2) {
        if (this.b != null) {
            this.setDropDownBackgroundDrawable(this.b.a(this.getContext(), n2));
            return;
        }
        super.setDropDownBackgroundResource(n2);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.c == null) return;
        this.c.a(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.c == null) return;
        this.c.a(mode);
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.d == null) return;
        this.d.a(context, n2);
    }
}

