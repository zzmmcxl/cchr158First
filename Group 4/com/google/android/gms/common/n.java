/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.l;
import java.lang.ref.WeakReference;

abstract class n
extends l {
    private static final WeakReference b = new WeakReference<Object>(null);
    private WeakReference a = b;

    n(byte[] arrby) {
        super(arrby);
    }

    @Override
    byte[] a() {
        // MONITORENTER : this
        byte[] arrby = (byte[])this.a.get();
        if (arrby == null) {
            arrby = this.b();
            this.a = new WeakReference<byte[]>(arrby);
        }
        // MONITOREXIT : this
        return arrby;
    }

    protected abstract byte[] b();
}

