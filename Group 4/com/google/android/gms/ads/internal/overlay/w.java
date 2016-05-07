/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.os.Handler;
import com.google.android.gms.ads.internal.overlay.p;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fx;

@fi
class w
implements Runnable {
    private p a;
    private boolean b = false;

    w(p p2) {
        this.a = p2;
    }

    public void a() {
        this.b = true;
        fx.a.removeCallbacks((Runnable)this);
    }

    public void b() {
        fx.a.postDelayed((Runnable)this, 250);
    }

    @Override
    public void run() {
        if (this.b) return;
        this.a.h();
        this.b();
    }
}

