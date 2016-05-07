/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.by;
import android.support.v7.widget.fk;

class bz
implements fk {
    final /* synthetic */ by a;

    bz(by by2) {
        this.a = by2;
    }

    @Override
    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }
}

