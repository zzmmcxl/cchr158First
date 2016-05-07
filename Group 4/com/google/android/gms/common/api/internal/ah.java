/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ap;
import com.google.android.gms.common.api.internal.z;
import java.lang.ref.WeakReference;

class ah
extends ap {
    private WeakReference a;

    ah(z z2) {
        this.a = new WeakReference<z>(z2);
    }

    @Override
    public void a() {
        z z2 = (z)this.a.get();
        if (z2 == null) {
            return;
        }
        z.b(z2);
    }
}

