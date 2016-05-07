/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.fj;

class fi
extends Drawable {
    private float a;
    private final Paint b;
    private final RectF c;
    private final Rect d;
    private float e;
    private boolean f = false;
    private boolean g = true;

    public fi(int n2, float f2) {
        this.a = f2;
        this.b = new Paint(5);
        this.b.setColor(n2);
        this.c = new RectF();
        this.d = new Rect();
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = this.getBounds();
        }
        this.c.set((float)rect.left, (float)rect.top, (float)rect.right, (float)rect.bottom);
        this.d.set(rect);
        if (!this.f) return;
        float f2 = fj.a(this.e, this.a, this.g);
        float f3 = fj.b(this.e, this.a, this.g);
        this.d.inset((int)Math.ceil(f3), (int)Math.ceil(f2));
        this.c.set(this.d);
    }

    float a() {
        return this.e;
    }

    void a(float f2) {
        if (f2 == this.a) {
            return;
        }
        this.a = f2;
        this.a(null);
        this.invalidateSelf();
    }

    void a(float f2, boolean bl2, boolean bl3) {
        if (f2 == this.e && this.f == bl2 && this.g == bl3) {
            return;
        }
        this.e = f2;
        this.f = bl2;
        this.g = bl3;
        this.a(null);
        this.invalidateSelf();
    }

    public void a(int n2) {
        this.b.setColor(n2);
        this.invalidateSelf();
    }

    public float b() {
        return this.a;
    }

    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.c, this.a, this.a, this.b);
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.d, this.a);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a(rect);
    }

    public void setAlpha(int n2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

