/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.fo;
import com.google.android.gms.b.fr;
import java.util.concurrent.Future;

@fi
public abstract class fn {
    private final Runnable a;
    private volatile Thread b;
    private boolean c;

    public fn() {
        this.a = new fo(this);
        this.c = false;
    }

    static /* synthetic */ Thread a(fn fn2, Thread thread) {
        fn2.b = thread;
        return thread;
    }

    public abstract void a();

    public final Future b() {
        if (!this.c) return fr.a(this.a);
        return fr.a(1, this.a);
    }
}

