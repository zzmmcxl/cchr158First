/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Process;
import com.google.android.gms.b.ax;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.jk;
import com.google.android.gms.b.k;
import com.google.android.gms.b.kl;
import com.google.android.gms.b.l;
import com.google.android.gms.b.me;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class aw
extends Thread {
    private static final boolean a = me.b;
    private final BlockingQueue b;
    private final BlockingQueue c;
    private final k d;
    private final kl e;
    private volatile boolean f = false;

    public aw(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, k k2, kl kl2) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = k2;
        this.e = kl2;
    }

    static /* synthetic */ BlockingQueue a(aw aw2) {
        return aw2.c;
    }

    public void a() {
        this.f = true;
        this.interrupt();
    }

    @Override
    public void run() {
        if (a) {
            me.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority((int)10);
        this.d.a();
        do {
            hy hy2;
            l l2;
            try {
                do {
                    hy2 = (hy)this.b.take();
                    hy2.b("cache-queue-take");
                    if (hy2.g()) {
                        hy2.c("cache-discard-canceled");
                        continue;
                    }
                    l2 = this.d.a(hy2.e());
                    if (l2 == null) {
                        hy2.b("cache-miss");
                        this.c.put(hy2);
                        continue;
                    }
                    break;
                } while (true);
            }
            catch (InterruptedException var1_1) {
                if (!this.f) continue;
                return;
            }
            if (l2.a()) {
                hy2.b("cache-hit-expired");
                hy2.a(l2);
                this.c.put(hy2);
                continue;
            }
            hy2.b("cache-hit");
            jk jk2 = hy2.a(new fk(l2.a, l2.g));
            hy2.b("cache-hit-parsed");
            if (!l2.b()) {
                this.e.a(hy2, jk2);
                continue;
            }
            hy2.b("cache-hit-refresh-needed");
            hy2.a(l2);
            jk2.d = true;
            this.e.a(hy2, jk2, new ax(this, hy2));
        } while (true);
    }
}

