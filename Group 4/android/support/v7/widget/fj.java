/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.c.b;
import android.support.v7.c.c;
import android.support.v7.widget.fk;

class fj
extends Drawable {
    static final double a = Math.cos(Math.toRadians(45.0));
    static fk c;
    final int b;
    Paint d;
    Paint e;
    Paint f;
    final RectF g;
    float h;
    Path i;
    float j;
    float k;
    float l;
    float m;
    private boolean n = true;
    private final int o;
    private final int p;
    private boolean q = true;
    private boolean r = false;

    fj(Resources resources, int n2, float f2, float f3, float f4) {
        this.o = resources.getColor(b.cardview_shadow_start_color);
        this.p = resources.getColor(b.cardview_shadow_end_color);
        this.b = resources.getDimensionPixelSize(c.cardview_compat_inset_shadow);
        this.d = new Paint(5);
        this.d.setColor(n2);
        this.e = new Paint(5);
        this.e.setStyle(Paint.Style.FILL);
        this.h = (int)(0.5f + f2);
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        this.a(f3, f4);
    }

    static float a(float f2, float f3, boolean bl2) {
        if (!bl2) return 1.5f * f2;
        return (float)((double)(1.5f * f2) + (1.0 - a) * (double)f3);
    }

    private void a(Canvas canvas) {
        float f2 = - this.h - this.l;
        float f3 = this.h + (float)this.b + this.m / 2.0f;
        boolean bl2 = this.g.width() - 2.0f * f3 > 0.0f;
        boolean bl3 = this.g.height() - 2.0f * f3 > 0.0f;
        int n2 = canvas.save();
        canvas.translate(f3 + this.g.left, f3 + this.g.top);
        canvas.drawPath(this.i, this.e);
        if (bl2) {
            canvas.drawRect(0.0f, f2, this.g.width() - 2.0f * f3, - this.h, this.f);
        }
        canvas.restoreToCount(n2);
        int n3 = canvas.save();
        canvas.translate(this.g.right - f3, this.g.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (bl2) {
            canvas.drawRect(0.0f, f2, this.g.width() - 2.0f * f3, - this.h + this.l, this.f);
        }
        canvas.restoreToCount(n3);
        int n4 = canvas.save();
        canvas.translate(f3 + this.g.left, this.g.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (bl3) {
            canvas.drawRect(0.0f, f2, this.g.height() - 2.0f * f3, - this.h, this.f);
        }
        canvas.restoreToCount(n4);
        int n5 = canvas.save();
        canvas.translate(this.g.right - f3, f3 + this.g.top);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (bl3) {
            canvas.drawRect(0.0f, f2, this.g.height() - 2.0f * f3, - this.h, this.f);
        }
        canvas.restoreToCount(n5);
    }

    static float b(float f2, float f3, boolean bl2) {
        if (!bl2) return f2;
        return (float)((double)f2 + (1.0 - a) * (double)f3);
    }

    private void b(Rect rect) {
        float f2 = 1.5f * this.k;
        this.g.set((float)rect.left + this.k, f2 + (float)rect.top, (float)rect.right - this.k, (float)rect.bottom - f2);
        this.f();
    }

    private int d(float f2) {
        int n2 = (int)(0.5f + f2);
        if (n2 % 2 != 1) return n2;
        --n2;
        return n2;
    }

    private void f() {
        RectF rectF = new RectF(- this.h, - this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(- this.l, - this.l);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(- this.h, 0.0f);
        this.i.rLineTo(- this.l, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f2 = this.h / (this.h + this.l);
        Paint paint = this.e;
        float f3 = this.h + this.l;
        int[] arrn = new int[]{this.o, this.o, this.p};
        paint.setShader((Shader)new RadialGradient(0.0f, 0.0f, f3, arrn, new float[]{0.0f, f2, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f;
        float f4 = - this.h + this.l;
        float f5 = - this.h - this.l;
        int[] arrn2 = new int[]{this.o, this.o, this.p};
        paint2.setShader((Shader)new LinearGradient(0.0f, f4, 0.0f, f5, arrn2, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    float a() {
        return this.h;
    }

    void a(float f2) {
        float f3 = (int)(0.5f + f2);
        if (this.h == f3) {
            return;
        }
        this.h = f3;
        this.n = true;
        this.invalidateSelf();
    }

    void a(float f2, float f3) {
        float f4;
        if (f2 < 0.0f) throw new IllegalArgumentException("invalid shadow size");
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float f5 = this.d(f2);
        if (f5 > (f4 = (float)this.d(f3))) {
            if (!this.r) {
                this.r = true;
            }
            f5 = f4;
        }
        if (this.m == f5 && this.k == f4) {
            return;
        }
        this.m = f5;
        this.k = f4;
        this.l = (int)(0.5f + (f5 * 1.5f + (float)this.b));
        this.j = f4 + (float)this.b;
        this.n = true;
        this.invalidateSelf();
    }

    public void a(int n2) {
        this.d.setColor(n2);
        this.invalidateSelf();
    }

    void a(Rect rect) {
        this.getPadding(rect);
    }

    public void a(boolean bl2) {
        this.q = bl2;
        this.invalidateSelf();
    }

    float b() {
        return this.m;
    }

    void b(float f2) {
        this.a(f2, this.k);
    }

    float c() {
        return this.k;
    }

    void c(float f2) {
        this.a(this.m, f2);
    }

    float d() {
        return 2.0f * Math.max(this.k, this.h + (float)this.b + this.k / 2.0f) + 2.0f * (this.k + (float)this.b);
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            this.b(this.getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.m / 2.0f);
        this.a(canvas);
        canvas.translate(0.0f, (- this.m) / 2.0f);
        c.a(canvas, this.g, this.h, this.d);
    }

    float e() {
        return 2.0f * Math.max(this.k, this.h + (float)this.b + 1.5f * this.k / 2.0f) + 2.0f * (1.5f * this.k + (float)this.b);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int n2 = (int)Math.ceil(fj.a(this.k, this.h, this.q));
        int n3 = (int)Math.ceil(fj.b(this.k, this.h, this.q));
        rect.set(n3, n2, n3, n2);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    public void setAlpha(int n2) {
        this.d.setAlpha(n2);
        this.e.setAlpha(n2);
        this.f.setAlpha(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
        this.e.setColorFilter(colorFilter);
        this.f.setColorFilter(colorFilter);
    }
}

