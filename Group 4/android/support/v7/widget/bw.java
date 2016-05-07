/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.bv;
import android.support.v7.widget.fk;

class bw
implements fk {
    final /* synthetic */ bv a;

    bw(bv bv2) {
        this.a = bv2;
    }

    @Override
    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        float f3 = 2.0f * f2;
        float f4 = rectF.width() - f3 - 1.0f;
        float f5 = rectF.height() - f3 - 1.0f;
        if (f2 >= 1.0f) {
            this.a.a.set(- f2, - f2, f2, f2 += 0.5f);
            int n2 = canvas.save();
            canvas.translate(f2 + rectF.left, f2 + rectF.top);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(f4, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(f5, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.translate(f4, 0.0f);
            canvas.rotate(90.0f);
            canvas.drawArc(this.a.a, 180.0f, 90.0f, true, paint);
            canvas.restoreToCount(n2);
            canvas.drawRect(f2 + rectF.left - 1.0f, rectF.top, 1.0f + (rectF.right - f2), f2 + rectF.top, paint);
            canvas.drawRect(f2 + rectF.left - 1.0f, 1.0f + (rectF.bottom - f2), 1.0f + (rectF.right - f2), rectF.bottom, paint);
        }
        canvas.drawRect(rectF.left, rectF.top + Math.max(0.0f, f2 - 1.0f), rectF.right, 1.0f + (rectF.bottom - f2), paint);
    }
}

