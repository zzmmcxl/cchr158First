/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.fs;
import com.google.android.gms.b.ft;
import com.google.android.gms.b.fu;
import com.google.android.gms.b.fv;
import com.google.android.gms.b.fw;
import com.google.android.gms.b.gx;
import com.google.android.gms.b.gy;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

@fi
public final class fr {
    private static final ExecutorService a = Executors.newFixedThreadPool(10, fr.a("Default"));
    private static final ExecutorService b = Executors.newFixedThreadPool(5, fr.a("Loader"));

    public static gy a(int n2, Runnable runnable) {
        if (n2 != 1) return fr.a(a, new ft(runnable));
        return fr.a(b, new fs(runnable));
    }

    public static gy a(Runnable runnable) {
        return fr.a(0, runnable);
    }

    public static gy a(ExecutorService executorService, Callable callable) {
        gx gx2 = new gx();
        try {
            gx2.a(new fv(gx2, executorService.submit(new fu(gx2, callable))));
            return gx2;
        }
        catch (RejectedExecutionException var3_3) {
            fp.c("Thread execution is rejected.", var3_3);
            gx2.cancel(true);
            return gx2;
        }
    }

    private static ThreadFactory a(String string) {
        return new fw(string);
    }
}

