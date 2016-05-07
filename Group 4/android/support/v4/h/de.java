/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.dc;
import android.support.v4.h.dd;
import android.support.v4.h.df;
import android.support.v4.h.dm;
import android.support.v4.h.dt;
import android.support.v4.h.dv;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class de
implements dm {
    WeakHashMap a = null;

    de() {
    }

    static /* synthetic */ void a(de de2, dc dc2, View view) {
        de2.d(dc2, view);
    }

    private void a(View view) {
        if (this.a == null) return;
        Runnable runnable = (Runnable)this.a.get((Object)view);
        if (runnable == null) return;
        view.removeCallbacks(runnable);
    }

    private void d(dc dc2, View view) {
        Object object = view.getTag(2113929216);
        dt dt2 = object instanceof dt ? (dt)object : null;
        Runnable runnable = dc.a(dc2);
        Runnable runnable2 = dc.b(dc2);
        dc.b(dc2, null);
        dc.a(dc2, null);
        if (runnable != null) {
            runnable.run();
        }
        if (dt2 != null) {
            dt2.a(view);
            dt2.b(view);
        }
        if (runnable2 != null) {
            runnable2.run();
        }
        if (this.a == null) return;
        this.a.remove((Object)view);
    }

    private void e(dc dc2, View view) {
        Runnable runnable = this.a != null ? (Runnable)this.a.get((Object)view) : null;
        if (runnable == null) {
            runnable = new df(this, dc2, view, null);
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            this.a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    @Override
    public long a(dc dc2, View view) {
        return 0;
    }

    @Override
    public void a(dc dc2, View view, float f2) {
        this.e(dc2, view);
    }

    @Override
    public void a(dc dc2, View view, long l2) {
    }

    @Override
    public void a(dc dc2, View view, dt dt2) {
        view.setTag(2113929216, (Object)dt2);
    }

    @Override
    public void a(dc dc2, View view, dv dv2) {
    }

    @Override
    public void a(dc dc2, View view, Interpolator interpolator) {
    }

    @Override
    public void b(dc dc2, View view) {
        this.e(dc2, view);
    }

    @Override
    public void b(dc dc2, View view, float f2) {
        this.e(dc2, view);
    }

    @Override
    public void b(dc dc2, View view, long l2) {
    }

    @Override
    public void c(dc dc2, View view) {
        this.a(view);
        this.d(dc2, view);
    }

    @Override
    public void c(dc dc2, View view, float f2) {
        this.e(dc2, view);
    }
}

