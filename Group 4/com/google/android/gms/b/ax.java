/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.aw;
import com.google.android.gms.b.hy;

class ax
implements Runnable {
    final /* synthetic */ hy a;
    final /* synthetic */ aw b;

    ax(aw aw2, hy hy2) {
        this.b = aw2;
        this.a = hy2;
    }

    @Override
    public void run() {
        try {
            aw.a(this.b).put(this.a);
            return;
        }
        catch (InterruptedException var1_1) {
            return;
        }
    }
}

