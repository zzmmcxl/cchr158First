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
import android.support.v7.widget.az;
import android.support.v7.widget.gh;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ay
extends ImageButton
implements bi {
    private am a;
    private az b;

    public ay(Context context) {
        this(context, null);
    }

    public ay(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.imageButtonStyle);
    }

    public ay(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        ar ar2 = ar.a();
        this.a = new am((View)this, ar2);
        this.a.a(attributeSet, n2);
        this.b = new az((ImageView)this, ar2);
        this.b.a(attributeSet, n2);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a == null) return;
        this.a.c();
    }

    @Override
    public ColorStateList getSupportBackgroundTintList() {
        if (this.a == null) return null;
        return this.a.a();
    }

    @Override
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.a == null) return null;
        return this.a.b();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.a == null) return;
        this.a.a(drawable);
    }

    public void setBackgroundResource(int n2) {
        super.setBackgroundResource(n2);
        if (this.a == null) return;
        this.a.a(n2);
    }

    public void setImageResource(int n2) {
        this.b.a(n2);
    }

    @Override
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.a == null) return;
        this.a.a(colorStateList);
    }

    @Override
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.a == null) return;
        this.a.a(mode);
    }
}

