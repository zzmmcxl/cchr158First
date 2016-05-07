/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.g;

import android.support.v4.g.a;
import android.support.v4.g.h;
import java.util.Map;

class b
extends h {
    final /* synthetic */ a a;

    b(a a2) {
        this.a = a2;
    }

    @Override
    protected int a() {
        return this.a.h;
    }

    @Override
    protected int a(Object object) {
        return this.a.a(object);
    }

    @Override
    protected Object a(int n2, int n3) {
        return this.a.g[n3 + (n2 << 1)];
    }

    @Override
    protected Object a(int n2, Object object) {
        return this.a.a(n2, object);
    }

    @Override
    protected void a(int n2) {
        this.a.d(n2);
    }

    @Override
    protected void a(Object object, Object object2) {
        this.a.put(object, object2);
    }

    @Override
    protected int b(Object object) {
        return this.a.b(object);
    }

    @Override
    protected Map b() {
        return this.a;
    }

    @Override
    protected void c() {
        this.a.clear();
    }
}

