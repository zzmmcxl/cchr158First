/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import com.google.android.gms.ads.internal.a;
import com.google.android.gms.ads.internal.client.d;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ej;
import com.google.android.gms.b.ev;
import com.google.android.gms.b.fi;

@fi
public class l {
    public static String a = null;
    private m b;

    public l() {
        a.a();
        if (a == null) {
            b.d("No client jar implementation found.");
            this.b = new d();
            return;
        }
        try {
            this.b = (m)l.class.getClassLoader().loadClass(a).newInstance();
            return;
        }
        catch (Exception var1_1) {
            b.c("Failed to instantiate ClientApi class.", var1_1);
            this.b = new d();
            return;
        }
    }

    public ev a(Activity activity) {
        return this.b.a(activity);
    }

    public ej b(Activity activity) {
        return this.b.b(activity);
    }
}

