/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Process;

class ks
implements Runnable {
    private final Runnable a;
    private final int b;

    public ks(Runnable runnable, int n2) {
        this.a = runnable;
        this.b = n2;
    }

    @Override
    public void run() {
        Process.setThreadPriority((int)this.b);
        this.a.run();
    }
}

