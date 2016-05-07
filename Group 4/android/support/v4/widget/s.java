/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.v4.widget.t;
import android.support.v4.widget.u;
import android.support.v4.widget.v;
import android.support.v4.widget.w;

public final class s {
    private static final v b;
    private Object a;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            b = new w();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            b = new u();
            return;
        }
        b = new t();
    }

    public s(Context context) {
        this.a = b.a(context);
    }

    public void a(int n2, int n3) {
        b.a(this.a, n2, n3);
    }

    public boolean a() {
        return b.a(this.a);
    }

    public boolean a(float f2, float f3) {
        return b.a(this.a, f2, f3);
    }

    public boolean a(int n2) {
        return b.a(this.a, n2);
    }

    public boolean a(Canvas canvas) {
        return b.a(this.a, canvas);
    }

    public boolean b() {
        return b.b(this.a);
    }
}

