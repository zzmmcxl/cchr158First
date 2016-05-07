/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.b.cu;
import java.util.concurrent.Executor;

class cv
implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ cu b;

    cv(cu cu2, Handler handler) {
        this.b = cu2;
        this.a = handler;
    }

    @Override
    public void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}

