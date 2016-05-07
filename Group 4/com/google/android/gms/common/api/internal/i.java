/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.au;
import com.google.android.gms.common.api.internal.h;

class i
implements au {
    final /* synthetic */ h a;

    i(h h2) {
        this.a = h2;
    }

    @Override
    public void a(int n2, boolean bl2) {
        h.a(this.a).lock();
        try {
            if (h.c(this.a) || h.d(this.a) == null || !h.d(this.a).b()) {
                h.a(this.a, false);
                h.a(this.a, n2, bl2);
                return;
            }
            h.a(this.a, true);
            h.e(this.a).a(n2);
            return;
        }
        finally {
            h.a(this.a).unlock();
        }
    }

    @Override
    public void a(Bundle bundle) {
        h.a(this.a).lock();
        try {
            h.a(this.a, bundle);
            h.a(this.a, ConnectionResult.a);
            h.b(this.a);
            return;
        }
        finally {
            h.a(this.a).unlock();
        }
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        h.a(this.a).lock();
        try {
            h.a(this.a, connectionResult);
            h.b(this.a);
            return;
        }
        finally {
            h.a(this.a).unlock();
        }
    }
}

