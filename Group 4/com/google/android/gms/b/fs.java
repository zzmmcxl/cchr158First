/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import java.util.concurrent.Callable;

final class fs
implements Callable {
    final /* synthetic */ Runnable a;

    fs(Runnable runnable) {
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

