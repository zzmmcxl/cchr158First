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
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.ei;
import com.google.android.gms.b.ej;
import com.google.android.gms.b.ek;
import com.google.android.gms.b.em;
import com.google.android.gms.b.en;
import com.google.android.gms.b.fi;

@fi
public final class eh
extends e {
    private static final eh a = new eh();

    private eh() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static ej a(Activity activity) {
        try {
            if (!eh.b(activity)) {
                ej ej2 = a.c(activity);
                if (ej2 != null) return ej2;
            }
            b.a("Using AdOverlay from the client jar.");
            ej ej3 = n.b().b(activity);
            return ej3;
        }
        catch (ei var1_3) {
            b.d(var1_3.getMessage());
            return null;
        }
    }

    private static boolean b(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        throw new ei("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private ej c(Activity activity) {
        try {
            a a2 = d.a((Object)activity);
            return ek.a(((em)this.a((Context)activity)).a(a2));
        }
        catch (RemoteException var3_4) {
            b.c("Could not create remote AdOverlay.", (Throwable)var3_4);
            return null;
        }
        catch (f var2_5) {
            b.c("Could not create remote AdOverlay.", var2_5);
            return null;
        }
    }

    protected em a(IBinder iBinder) {
        return en.a(iBinder);
    }

    @Override
    protected /* synthetic */ Object b(IBinder iBinder) {
        return this.a(iBinder);
    }
}

