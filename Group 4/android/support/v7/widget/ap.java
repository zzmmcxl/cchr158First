/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ar;
import android.support.v7.widget.bq;
import android.support.v7.widget.gh;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class ap
extends CheckedTextView {
    private static final int[] a = new int[]{16843016};
    private ar b;
    private bq c;

    public ap(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public ap(Context context, AttributeSet attributeSet, int n2) {
        super(gh.a(context), attributeSet, n2);
        this.c = bq.a((TextView)this);
        this.c.a(attributeSet, n2);
        this.c.a();
        this.b = ar.a();
        gk gk2 = gk.a(this.getContext(), attributeSet, a, n2, 0);
        this.setCheckMarkDrawable(gk2.a(0));
        gk2.a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c == null) return;
        this.c.a();
    }

    public void setCheckMarkDrawable(int n2) {
        if (this.b != null) {
            this.setCheckMarkDrawable(this.b.a(this.getContext(), n2));
            return;
        }
        super.setCheckMarkDrawable(n2);
    }

    public void setTextAppearance(Context context, int n2) {
        super.setTextAppearance(context, n2);
        if (this.c == null) return;
        this.c.a(context, n2);
    }
}

