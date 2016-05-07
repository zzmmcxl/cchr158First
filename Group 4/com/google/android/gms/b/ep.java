/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.b.di;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.k;
import com.google.android.gms.b.kl;
import com.google.android.gms.b.l;
import com.google.android.gms.b.lt;
import com.google.android.gms.b.me;
import java.util.concurrent.BlockingQueue;

public class ep
extends Thread {
    private final BlockingQueue a;
    private final di b;
    private final k c;
    private final kl d;
    private volatile boolean e = false;

    public ep(BlockingQueue blockingQueue, di di2, k k2, kl kl2) {
        this.a = blockingQueue;
        this.b = di2;
        this.c = k2;
        this.d = kl2;
    }

    @TargetApi(value=14)
    private void a(hy hy2) {
        if (Build.VERSION.SDK_INT < 14) return;
        TrafficStats.setThreadStatsTag((int)hy2.c());
    }

    private void a(hy hy2, lt lt2) {
        lt lt3 = hy2.a(lt2);
        this.d.a(hy2, lt3);
    }

    public void a() {
        this.e = true;
        this.interrupt();
    }

    @Override
    public void run() {
        Process.setThreadPriority((int)10);
        do {
            fk fk2;
            long l2;
            hy hy2;
            block11 : {
                l2 = SystemClock.elapsedRealtime();
                try {
                    hy2 = (hy)this.a.take();
                }
                catch (InterruptedException var3_2) {
                    if (!this.e) continue;
                    return;
                }
                hy2.b("network-queue-take");
                if (hy2.g()) {
                    hy2.c("network-discard-cancelled");
                }
                this.a(hy2);
                fk2 = this.b.a(hy2);
                hy2.b("network-http-complete");
                if (!fk2.d || !hy2.u()) break block11;
                hy2.c("not-modified");
                continue;
            }
            try {
                jk jk2 = hy2.a(fk2);
                hy2.b("network-parse-complete");
                if (hy2.p() && jk2.b != null) {
                    this.c.a(hy2.e(), jk2.b);
                    hy2.b("network-cache-written");
                }
                hy2.t();
                this.d.a(hy2, jk2);
                continue;
            }
            catch (lt var8_7) {
                var8_7.a(SystemClock.elapsedRealtime() - l2);
                this.a(hy2, var8_7);
            }
            catch (Exception var5_4) {
                Object[] arrobject = new Object[]{var5_4.toString()};
                me.a(var5_4, "Unhandled exception %s", arrobject);
                lt lt2 = new lt(var5_4);
                lt2.a(SystemClock.elapsedRealtime() - l2);
                this.d.a(hy2, lt2);
                continue;
            }
            break;
        } while (true);
    }
}

