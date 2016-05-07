/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.IntentSender;
import android.support.v4.app.aa;
import android.support.v4.app.ah;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.ba;
import com.google.android.gms.common.j;
import java.util.List;

class bc
implements Runnable {
    final /* synthetic */ ba a;
    private final int b;
    private final ConnectionResult c;

    public bc(ba ba2, int n2, ConnectionResult connectionResult) {
        this.a = ba2;
        this.b = n2;
        this.c = connectionResult;
    }

    @Override
    public void run() {
        if (!ba.a(this.a)) return;
        if (ba.b(this.a)) {
            return;
        }
        ba.a(this.a, true);
        ba.a(this.a, this.b);
        ba.a(this.a, this.c);
        if (this.c.a()) {
            try {
                int n2 = 1 + (1 + this.a.g().f().d().indexOf(this.a) << 16);
                this.c.a(this.a.g(), n2);
                return;
            }
            catch (IntentSender.SendIntentException var4_2) {
                this.a.L();
                return;
            }
        }
        if (this.a.K().a(this.c.c())) {
            this.a.a(this.b, this.c);
            return;
        }
        if (this.c.c() == 18) {
            this.a.b(this.b, this.c);
            return;
        }
        ba.a(this.a, this.b, this.c);
    }
}

