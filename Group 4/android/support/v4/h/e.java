/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.os.Bundle;
import android.support.v4.h.a;
import android.support.v4.h.a.w;
import android.support.v4.h.b;
import android.support.v4.h.f;
import android.support.v4.h.k;
import android.view.View;

class e
extends b {
    e() {
    }

    @Override
    public w a(Object object, View view) {
        Object object2 = k.a(object, view);
        if (object2 == null) return null;
        return new w(object2);
    }

    @Override
    public Object a(a a2) {
        return k.a(new f(this, a2));
    }

    @Override
    public boolean a(Object object, View view, int n2, Bundle bundle) {
        return k.a(object, view, n2, bundle);
    }
}

