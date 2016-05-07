/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.o;

public class p
implements o {
    private final Object[] a;
    private int b;

    public p(int n2) {
        if (n2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.a = new Object[n2];
    }

    private boolean b(Object object) {
        int n2 = 0;
        do {
            int n3 = this.b;
            boolean bl2 = false;
            if (n2 >= n3) return bl2;
            if (this.a[n2] == object) {
                return true;
            }
            ++n2;
        } while (true);
    }

    @Override
    public Object a() {
        if (this.b <= 0) return null;
        int n2 = -1 + this.b;
        Object object = this.a[n2];
        this.a[n2] = null;
        this.b = -1 + this.b;
        return object;
    }

    @Override
    public boolean a(Object object) {
        if (this.b(object)) {
            throw new IllegalStateException("Already in the pool!");
        }
        if (this.b >= this.a.length) return false;
        this.a[this.b] = object;
        this.b = 1 + this.b;
        return true;
    }
}

