/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.h;
import java.util.Iterator;

final class i
implements Iterator {
    final int a;
    int b;
    int c;
    boolean d;
    final /* synthetic */ h e;

    i(h h2, int n2) {
        this.e = h2;
        this.d = false;
        this.a = n2;
        this.b = h2.a();
    }

    @Override
    public boolean hasNext() {
        if (this.c >= this.b) return false;
        return true;
    }

    public Object next() {
        Object object = this.e.a(this.c, this.a);
        this.c = 1 + this.c;
        this.d = true;
        return object;
    }

    @Override
    public void remove() {
        if (!this.d) {
            throw new IllegalStateException();
        }
        this.c = -1 + this.c;
        this.b = -1 + this.b;
        this.d = false;
        this.e.a(this.c);
    }
}

