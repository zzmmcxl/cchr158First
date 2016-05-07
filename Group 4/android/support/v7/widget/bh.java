/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.support.v7.b.b;
import android.support.v7.widget.ar;
import android.support.v7.widget.bi;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class bh
extends SeekBar {
    private bi a;
    private ar b = ar.a();

    public bh(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.seekBarStyle);
    }

    public bh(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a = new bi(this, this.b);
        this.a.a(attributeSet, n2);
    }
}

