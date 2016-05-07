/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.view.View;
import com.google.android.gms.b.p;

class q
implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ p b;

    q(p p2, View view) {
        this.b = p2;
        this.a = view;
    }

    @Override
    public void run() {
        this.b.b(this.a);
    }
}

