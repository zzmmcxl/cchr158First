/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.h.bi;
import android.support.v7.widget.am;
import android.support.v7.widget.ar;
import android.support.v7.widget.bq;
import android.support.v7.widget.gh;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class bs
extends TextView
implements bi {
    private ar a = ar.a();
    private am b;
    private bq c;

    public bs(Context context) {
        this(context, null);
    }

    public bs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public bs(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        this.b = new am((View)this, this.a);
        this.b.a(attributeSet, n2);
        this.c = bq.a(this);
        this.c.a(attributeSet, n2);
        this.c.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.b != null) {
            this.b.c();
        }
        if (this.c == null) return;
        this.c.a();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.b == null) return null;
        return this.b.a();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.b == null) return null;
        return this.b.b();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.b == null) return;
        this.b.a(drawable);
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.b == null) return;
        this.b.a(n2);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.b == null) return;
        this.b.a(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b == null) return;
        this.b.a(mode);
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.c == null) return;
        this.c.a(context, n2);
    }
}

