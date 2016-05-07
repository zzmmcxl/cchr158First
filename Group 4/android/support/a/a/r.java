/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region;
import android.support.a.a.l;
import android.support.a.a.o;
import android.support.a.a.p;
import android.support.a.a.q;
import android.support.v4.g.a;
import java.util.ArrayList;

class r {
    private static final Matrix j = new Matrix();
    float a = 0.0f;
    float b = 0.0f;
    float c = 0.0f;
    float d = 0.0f;
    int e = 255;
    String f = null;
    final a g = new a();
    private final Path h;
    private final Path i;
    private final Matrix k = new Matrix();
    private Paint l;
    private Paint m;
    private PathMeasure n;
    private int o;
    private final p p;

    public r() {
        this.p = new p();
        this.h = new Path();
        this.i = new Path();
    }

    public r(r r2) {
        this.p = new p(r2.p, this.g);
        this.h = new Path(r2.h);
        this.i = new Path(r2.i);
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.o = r2.o;
        this.e = r2.e;
        this.f = r2.f;
        if (r2.f == null) return;
        this.g.put(r2.f, this);
    }

    private static float a(float f2, float f3, float f4, float f5) {
        return f2 * f5 - f3 * f4;
    }

    private float a(Matrix matrix) {
        float[] arrf = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(arrf);
        float f2 = (float)Math.hypot(arrf[0], arrf[1]);
        float f3 = (float)Math.hypot(arrf[2], arrf[3]);
        float f4 = r.a(arrf[0], arrf[1], arrf[2], arrf[3]);
        float f5 = Math.max(f2, f3);
        float f6 = f5 FCMPL 0.0f;
        float f7 = 0.0f;
        if (f6 <= 0) return f7;
        return Math.abs(f4) / f5;
    }

    static /* synthetic */ Paint a(r r2, Paint paint) {
        r2.m = paint;
        return paint;
    }

    static /* synthetic */ p a(r r2) {
        return r2.p;
    }

    private void a(p p2, Matrix matrix, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
        p.b(p2).set(matrix);
        p.b(p2).preConcat(p.c(p2));
        int n4 = 0;
        while (n4 < p2.a.size()) {
            Object e2 = p2.a.get(n4);
            if (e2 instanceof p) {
                this.a((p)e2, p.b(p2), canvas, n2, n3, colorFilter);
            } else if (e2 instanceof q) {
                this.a(p2, (q)e2, canvas, n2, n3, colorFilter);
            }
            ++n4;
        }
    }

    private void a(p p2, q q2, Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
        float f2 = (float)n2 / this.c;
        float f3 = (float)n3 / this.d;
        float f4 = Math.min(f2, f3);
        Matrix matrix = p.b(p2);
        this.k.set(matrix);
        this.k.postScale(f2, f3);
        float f5 = this.a(matrix);
        if (f5 == 0.0f) {
            return;
        }
        q2.a(this.h);
        Path path = this.h;
        this.i.reset();
        if (q2.a()) {
            this.i.addPath(path, this.k);
            canvas.clipPath(this.i, Region.Op.REPLACE);
            return;
        }
        o o2 = (o)q2;
        if (o2.g != 0.0f || o2.h != 1.0f) {
            float f6 = (o2.g + o2.i) % 1.0f;
            float f7 = (o2.h + o2.i) % 1.0f;
            if (this.n == null) {
                this.n = new PathMeasure();
            }
            this.n.setPath(this.h, false);
            float f8 = this.n.getLength();
            float f9 = f6 * f8;
            float f10 = f7 * f8;
            path.reset();
            if (f9 > f10) {
                this.n.getSegment(f9, f8, path, true);
                this.n.getSegment(0.0f, f10, path, true);
            } else {
                this.n.getSegment(f9, f10, path, true);
            }
            path.rLineTo(0.0f, 0.0f);
        }
        this.i.addPath(path, this.k);
        if (o2.c != 0) {
            if (this.m == null) {
                this.m = new Paint();
                this.m.setStyle(Paint.Style.FILL);
                this.m.setAntiAlias(true);
            }
            Paint paint = this.m;
            paint.setColor(l.a(o2.c, o2.f));
            paint.setColorFilter(colorFilter);
            canvas.drawPath(this.i, paint);
        }
        if (o2.a == 0) return;
        if (this.l == null) {
            this.l = new Paint();
            this.l.setStyle(Paint.Style.STROKE);
            this.l.setAntiAlias(true);
        }
        Paint paint = this.l;
        if (o2.k != null) {
            paint.setStrokeJoin(o2.k);
        }
        if (o2.j != null) {
            paint.setStrokeCap(o2.j);
        }
        paint.setStrokeMiter(o2.l);
        paint.setColor(l.a(o2.a, o2.d));
        paint.setColorFilter(colorFilter);
        paint.setStrokeWidth(f5 * f4 * o2.b);
        canvas.drawPath(this.i, paint);
    }

    static /* synthetic */ Paint b(r r2) {
        return r2.m;
    }

    static /* synthetic */ Paint b(r r2, Paint paint) {
        r2.l = paint;
        return paint;
    }

    static /* synthetic */ Paint c(r r2) {
        return r2.l;
    }

    public int a() {
        return this.e;
    }

    public void a(float f2) {
        this.a((int)(255.0f * f2));
    }

    public void a(int n2) {
        this.e = n2;
    }

    public void a(Canvas canvas, int n2, int n3, ColorFilter colorFilter) {
        this.a(this.p, j, canvas, n2, n3, colorFilter);
    }

    public float b() {
        return (float)this.a() / 255.0f;
    }
}

