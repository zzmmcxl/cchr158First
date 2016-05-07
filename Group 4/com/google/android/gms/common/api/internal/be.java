/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Message;
import com.google.android.gms.common.api.internal.bd;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.api.w;

class be
implements Runnable {
    final /* synthetic */ w a;
    final /* synthetic */ bd b;

    be(bd bd2, w w2) {
        this.b = bd2;
        this.a = w2;
    }

    @Override
    public void run() {
        try {
            t t2 = bd.a(this.b).a(this.a);
            bd.b(this.b).sendMessage(bd.b(this.b).obtainMessage(0, (Object)t2));
            return;
        }
        catch (RuntimeException var3_3) {
            bd.b(this.b).sendMessage(bd.b(this.b).obtainMessage(1, (Object)var3_3));
            return;
        }
        finally {
            bd.a(this.b, this.a);
            n n2 = (n)bd.c(this.b).get();
            if (n2 == null) return;
            n2.b(this.b);
        }
    }
}

