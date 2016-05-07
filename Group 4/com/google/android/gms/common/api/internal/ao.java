/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.b.kr;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class ao {
    private static final ExecutorService a = Executors.newFixedThreadPool(2, new kr("GAC_Executor"));

    public static ExecutorService a() {
        return a;
    }
}

