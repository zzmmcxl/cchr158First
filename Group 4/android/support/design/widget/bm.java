/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.bl;
import java.lang.ref.WeakReference;

class bm {
    private final WeakReference a;
    private int b;

    static /* synthetic */ WeakReference a(bm bm2) {
        return bm2.a;
    }

    static /* synthetic */ int b(bm bm2) {
        return bm2.b;
    }

    boolean a(bl bl2) {
        if (bl2 == null) return false;
        if (this.a.get() != bl2) return false;
        return true;
    }
}

