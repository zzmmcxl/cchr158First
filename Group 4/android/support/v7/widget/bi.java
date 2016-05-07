/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.ar;
import android.support.v7.widget.be;
import android.support.v7.widget.gk;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;

class bi
extends be {
    private static final int[] b = new int[]{16843074};
    private final SeekBar c;

    bi(SeekBar seekBar, ar ar2) {
        super((ProgressBar)seekBar, ar2);
        this.c = seekBar;
    }

    @Override
    void a(AttributeSet attributeSet, int n2) {
        super.a(attributeSet, n2);
        gk gk2 = gk.a(this.c.getContext(), attributeSet, b, n2, 0);
        Drawable drawable = gk2.b(0);
        if (drawable != null) {
            this.c.setThumb(drawable);
        }
        gk2.a();
    }
}

