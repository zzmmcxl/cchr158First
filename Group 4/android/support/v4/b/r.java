/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.b;

import android.os.Process;
import android.support.v4.b.p;
import android.support.v4.b.q;
import android.support.v4.b.x;

class r
extends x {
    final /* synthetic */ p a;

    r(p p2) {
        this.a = p2;
        super(null);
    }

    public Object call() {
        p.a(this.a).set(true);
        Process.setThreadPriority((int)10);
        return p.a(this.a, this.a.a(this.b));
    }
}

