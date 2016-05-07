/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.graphics.Path;
import android.support.a.a.f;
import android.support.a.a.i;

class q {
    protected i[] m = null;
    String n;
    int o;

    public q() {
    }

    public q(q q2) {
        this.n = q2.n;
        this.o = q2.o;
        this.m = f.a(q2.m);
    }

    public void a(Path path) {
        path.reset();
        if (this.m == null) return;
        i.a(this.m, path);
    }

    public boolean a() {
        return false;
    }

    public String b() {
        return this.n;
    }
}

