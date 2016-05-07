/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;
import com.google.android.gms.a.e;
import com.google.android.gms.a.f;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.b.ev;
import com.google.android.gms.b.ew;
import com.google.android.gms.b.ey;
import com.google.android.gms.b.ez;
import com.google.android.gms.b.fd;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;

@fi
public final class fc
extends e {
    private static final fc a = new fc();

    private fc() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    public static ev a(Activity activity) {
        try {
            if (!fc.b(activity)) {
                ev ev2 = a.c(activity);
                if (ev2 != null) return ev2;
            }
            fp.a("Using AdOverlay from the client jar.");
            ev ev3 = n.b().a(activity);
            return ev3;
        }
        catch (fd var1_3) {
            fp.d(var1_3.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        throw new fd("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    private ev c(Activity activity) {
        try {
            a a2 = d.a((Object)activity);
            return ew.a(((ey)this.a((Context)activity)).a(a2));
        }
        catch (RemoteException var3_4) {
            fp.c("Could not create remote InAppPurchaseManager.", (Throwable)var3_4);
            return null;
        }
        catch (f var2_5) {
            fp.c("Could not create remote InAppPurchaseManager.", var2_5);
            return null;
        }
    }

    protected ey a(IBinder iBinder) {
        return ez.a(iBinder);
    }

    @Override
    protected /* synthetic */ Object b(IBinder iBinder) {
        return this.a(iBinder);
    }
}

