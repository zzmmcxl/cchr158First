/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.concurrent.Callable;

final class ft
implements Callable {
    final /* synthetic */ Runnable a;

    ft(Runnable runnable) {
        this.a = runnable;
    }

    public Void a() {
        this.a.run();
        return null;
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

