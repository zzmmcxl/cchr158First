/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.a.a.l;
import android.support.a.a.m;
import android.support.a.a.r;

class s
extends Drawable.ConstantState {
    int a;
    r b;
    ColorStateList c = null;
    PorterDuff.Mode d = l.b;
    boolean e;
    Bitmap f;
    ColorStateList g;
    PorterDuff.Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public s() {
        this.b = new r();
    }

    public s(s s2) {
        if (s2 == null) return;
        this.a = s2.a;
        this.b = new r(s2.b);
        if (r.b(s2.b) != null) {
            r.a(this.b, new Paint(r.b(s2.b)));
        }
        if (r.c(s2.b) != null) {
            r.b(this.b, new Paint(r.c(s2.b)));
        }
        this.c = s2.c;
        this.d = s2.d;
        this.e = s2.e;
    }

    public Paint a(ColorFilter colorFilter) {
        if (!this.a() && colorFilter == null) {
            return null;
        }
        if (this.l == null) {
            this.l = new Paint();
            this.l.setFilterBitmap(true);
        }
        this.l.setAlpha(this.b.a());
        this.l.setColorFilter(colorFilter);
        return this.l;
    }

    public void a(int n2, int n3) {
        this.f.eraseColor(0);
        Canvas canvas = new Canvas(this.f);
        this.b.a(canvas, n2, n3, null);
    }

    public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        Paint paint = this.a(colorFilter);
        canvas.drawBitmap(this.f, null, rect, paint);
    }

    public boolean a() {
        if (this.b.a() >= 255) return false;
        return true;
    }

    public void b(int n2, int n3) {
        if (this.f != null) {
            if (this.c(n2, n3)) return;
        }
        this.f = Bitmap.createBitmap((int)n2, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        this.k = true;
    }

    public boolean b() {
        if (this.k) return false;
        if (this.g != this.c) return false;
        if (this.h != this.d) return false;
        if (this.j != this.e) return false;
        if (this.i != this.b.a()) return false;
        return true;
    }

    public void c() {
        this.g = this.c;
        this.h = this.d;
        this.i = this.b.a();
        this.j = this.e;
        this.k = false;
    }

    public boolean c(int n2, int n3) {
        if (n2 != this.f.getWidth()) return false;
        if (n3 != this.f.getHeight()) return false;
        return true;
    }

    public int getChangingConfigurations() {
        return this.a;
    }

    public Drawable newDrawable() {
        return new l(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new l(this, null);
    }
}

