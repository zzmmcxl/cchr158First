/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.hy;

class hz
implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ hy c;

    hz(hy hy2, String string, long l2) {
        this.c = hy2;
        this.a = string;
        this.b = l2;
    }

    @Override
    public void run() {
        hy.b(this.c).a(this.a, this.b);
        hy.b(this.c).a(this.toString());
    }
}

