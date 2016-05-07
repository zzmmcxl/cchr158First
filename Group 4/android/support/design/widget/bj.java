/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.bk;
import android.support.design.widget.bl;
import android.support.design.widget.bm;

class bj {
    private static bj a;
    private final Object b = new Object();
    private final Handler c;
    private bm d;
    private bm e;

    private bj() {
        this.c = new Handler(Looper.getMainLooper(), (Handler.Callback)new bk(this));
    }

    static bj a() {
        if (a != null) return a;
        a = new bj();
        return a;
    }

    static /* synthetic */ void a(bj bj2, bm bm2) {
        bj2.b(bm2);
    }

    private void a(bm bm2) {
        if (bm.b(bm2) == -2) {
            return;
        }
        int n2 = 2750;
        if (bm.b(bm2) > 0) {
            n2 = bm.b(bm2);
        } else if (bm.b(bm2) == -1) {
            n2 = 1500;
        }
        this.c.removeCallbacksAndMessages((Object)bm2);
        this.c.sendMessageDelayed(Message.obtain((Handler)this.c, (int)0, (Object)bm2), (long)n2);
    }

    private boolean a(bm bm2, int n2) {
        bl bl2 = (bl)bm.a(bm2).get();
        if (bl2 == null) return false;
        this.c.removeCallbacksAndMessages((Object)bm2);
        bl2.a(n2);
        return true;
    }

    private void b() {
        if (this.e == null) return;
        this.d = this.e;
        this.e = null;
        bl bl2 = (bl)bm.a(this.d).get();
        if (bl2 != null) {
            bl2.a();
            return;
        }
        this.d = null;
    }

    private void b(bm bm2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.d == bm2 || this.e == bm2) {
            this.a(bm2, 2);
        }
        // MONITOREXIT : object
        return;
    }

    private boolean f(bl bl2) {
        if (this.d == null) return false;
        if (!this.d.a(bl2)) return false;
        return true;
    }

    private boolean g(bl bl2) {
        if (this.e == null) return false;
        if (!this.e.a(bl2)) return false;
        return true;
    }

    public void a(bl bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) {
            this.d = null;
            if (this.e != null) {
                this.b();
            }
        }
        // MONITOREXIT : object
        return;
    }

    public void a(bl bl2, int n2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) {
            this.a(this.d, n2);
            return;
        } else if (this.g(bl2)) {
            this.a(this.e, n2);
            return;
        }
        // MONITOREXIT : object
        return;
    }

    public void b(bl bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) {
            this.a(this.d);
        }
        // MONITOREXIT : object
        return;
    }

    public void c(bl bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) {
            this.c.removeCallbacksAndMessages((Object)this.d);
        }
        // MONITOREXIT : object
        return;
    }

    public void d(bl bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) {
            this.a(this.d);
        }
        // MONITOREXIT : object
        return;
    }

    public boolean e(bl bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.f(bl2)) return true;
        if (!this.g(bl2)) return false;
        return true;
    }
}

