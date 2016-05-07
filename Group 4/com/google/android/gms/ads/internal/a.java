/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal;

import android.app.Activity;
import com.google.android.gms.ads.internal.client.l;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.purchase.c;
import com.google.android.gms.b.ej;
import com.google.android.gms.b.ev;

public class a
implements m {
    public static void a() {
        l.a = a.class.getName();
    }

    @Override
    public ev a(Activity activity) {
        return new c(activity);
    }

    @Override
    public ej b(Activity activity) {
        return new com.google.android.gms.ads.internal.overlay.c(activity);
    }
}

