/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ar;
import android.support.v7.widget.bq;
import android.support.v7.widget.gi;
import android.util.AttributeSet;
import android.widget.TextView;

class br
extends bq {
    private static final int[] b = new int[]{16843666, 16843667};
    private gi c;
    private gi d;

    br(TextView textView) {
        super(textView);
    }

    @Override
    void a() {
        super.a();
        if (this.c == null) {
            if (this.d == null) return;
        }
        Drawable[] arrdrawable = this.a.getCompoundDrawablesRelative();
        this.a(arrdrawable[0], this.c);
        this.a(arrdrawable[2], this.d);
    }

    @Override
    void a(AttributeSet attributeSet, int n2) {
        super.a(attributeSet, n2);
        Context context = this.a.getContext();
        ar ar2 = ar.a();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b, n2, 0);
        if (typedArray.hasValue(0)) {
            this.c = br.a(context, ar2, typedArray.getResourceId(0, 0));
        }
        if (typedArray.hasValue(1)) {
            this.d = br.a(context, ar2, typedArray.getResourceId(1, 0));
        }
        typedArray.recycle();
    }
}

