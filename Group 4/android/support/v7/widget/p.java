/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.a;
import android.support.v7.b.b;
import android.support.v7.widget.ba;
import android.support.v7.widget.k;
import android.support.v7.widget.q;
import android.support.v7.widget.u;
import android.util.AttributeSet;
import android.view.View;

class p
extends ba
implements u {
    final /* synthetic */ k a;
    private final float[] b;

    public p(k k2, Context context) {
        this.a = k2;
        super(context, null, b.actionOverflowButtonStyle);
        this.b = new float[2];
        this.setClickable(true);
        this.setFocusable(true);
        this.setVisibility(0);
        this.setEnabled(true);
        this.setOnTouchListener((View.OnTouchListener)new q(this, (View)this, k2));
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public boolean d() {
        return false;
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        this.playSoundEffect(0);
        this.a.d();
        return true;
    }

    protected boolean setFrame(int n2, int n3, int n4, int n5) {
        boolean bl2 = super.setFrame(n2, n3, n4, n5);
        Drawable drawable = this.getDrawable();
        Drawable drawable2 = this.getBackground();
        if (drawable == null) return bl2;
        if (drawable2 == null) return bl2;
        int n6 = this.getWidth();
        int n7 = this.getHeight();
        int n8 = Math.max(n6, n7) / 2;
        int n9 = this.getPaddingLeft() - this.getPaddingRight();
        int n10 = this.getPaddingTop() - this.getPaddingBottom();
        int n11 = (n6 + n9) / 2;
        int n12 = (n7 + n10) / 2;
        a.a(drawable2, n11 - n8, n12 - n8, n11 + n8, n12 + n8);
        return bl2;
    }
}

