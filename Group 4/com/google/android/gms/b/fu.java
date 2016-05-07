/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Process;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.gx;
import java.util.concurrent.Callable;

final class fu
implements Runnable {
    final /* synthetic */ gx a;
    final /* synthetic */ Callable b;

    fu(gx gx2, Callable callable) {
        this.a = gx2;
        this.b = callable;
    }

    @Override
    public void run() {
        try {
            Process.setThreadPriority((int)10);
            this.a.b(this.b.call());
            return;
        }
        catch (Exception var1_1) {
            g.f().a(var1_1, true);
            this.a.cancel(true);
            return;
        }
    }
}

