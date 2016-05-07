/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Build;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.view.View;

class dh
implements dt {
    dc a;
    boolean b;

    dh(dc dc2) {
        this.a = dc2;
    }

    @Override
    public void a(View view) {
        Object object;
        this.b = false;
        if (dc.c(this.a) >= 0) {
            bo.a(view, 2, null);
        }
        if (dc.a(this.a) != null) {
            Runnable runnable = dc.a(this.a);
            dc.b(this.a, null);
            runnable.run();
        }
        if (!((object = view.getTag(2113929216)) instanceof dt)) return;
        dt dt2 = (dt)object;
        if (dt2 == null) return;
        dt2.a(view);
    }

    @Override
    public void b(View view) {
        Object object;
        if (dc.c(this.a) >= 0) {
            bo.a(view, dc.c(this.a), null);
            dc.a(this.a, -1);
        }
        if (Build.VERSION.SDK_INT < 16) {
            if (this.b) return;
        }
        if (dc.b(this.a) != null) {
            Runnable runnable = dc.b(this.a);
            dc.a(this.a, null);
            runnable.run();
        }
        dt dt2 = (object = view.getTag(2113929216)) instanceof dt ? (dt)object : null;
        if (dt2 != null) {
            dt2.b(view);
        }
        this.b = true;
    }

    @Override
    public void c(View view) {
        Object object = view.getTag(2113929216);
        if (!(object instanceof dt)) return;
        dt dt2 = (dt)object;
        if (dt2 == null) return;
        dt2.c(view);
    }
}

