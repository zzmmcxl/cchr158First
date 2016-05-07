/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.h.bo;
import android.support.v7.b.b;
import android.support.v7.widget.ar;
import android.support.v7.widget.be;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RatingBar;

public class bg
extends RatingBar {
    private be a;
    private ar b = ar.a();

    public bg(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.ratingBarStyle);
    }

    public bg(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = new be((ProgressBar)this, this.b);
        this.a.a(attributeSet, n2);
    }

    protected void onMeasure(int n2, int n3) {
        // MONITORENTER : this
        super.onMeasure(n2, n3);
        Bitmap bitmap = this.a.a();
        if (bitmap != null) {
            this.setMeasuredDimension(bo.a(bitmap.getWidth() * this.getNumStars(), n2, 0), this.getMeasuredHeight());
        }
        // MONITOREXIT : this
        return;
    }
}

