/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.b;
import com.google.android.gms.ads.internal.purchase.d;
import com.google.android.gms.ads.internal.purchase.e;
import com.google.android.gms.ads.internal.purchase.h;
import com.google.android.gms.ads.internal.purchase.i;
import com.google.android.gms.b.eq;
import com.google.android.gms.b.ew;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;

@fi
public class c
extends ew
implements ServiceConnection {
    e a;
    private final Activity b;
    private Context c;
    private eq d;
    private b e;
    private d f;
    private h g;
    private i h;
    private String i = null;

    public c(Activity activity) {
        this.b = activity;
        this.a = e.a(this.b.getApplicationContext());
    }

    @Override
    public void a() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel = GInAppPurchaseManagerInfoParcel.a(this.b.getIntent());
        this.g = gInAppPurchaseManagerInfoParcel.e;
        this.h = gInAppPurchaseManagerInfoParcel.b;
        this.d = gInAppPurchaseManagerInfoParcel.c;
        this.e = new b(this.b.getApplicationContext());
        this.c = gInAppPurchaseManagerInfoParcel.d;
        if (this.b.getResources().getConfiguration().orientation == 2) {
            this.b.setRequestedOrientation(g.e().a());
        } else {
            this.b.setRequestedOrientation(g.e().b());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.b.bindService(intent, (ServiceConnection)this, 1);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(int var1_1, int var2_2, Intent var3_3) {
        if (var1_1 != 1001) return;
        try {
            var6_4 = g.j().a(var3_3);
            if (var2_2 != -1) ** GOTO lbl-1000
            g.j();
            if (var6_4 == 0) {
                var8_5 = this.h.a(this.i, var2_2, var3_3);
                var9_6 = false;
                if (var8_5) {
                    var9_6 = true;
                }
            } else lbl-1000: // 2 sources:
            {
                this.a.a(this.f);
                var9_6 = false;
            }
            this.d.b(var6_4);
            this.b.finish();
            this.a(this.d.a(), var9_6, var2_2, var3_3);
            return;
        }
        catch (RemoteException var5_7) {
            fp.d("Fail to process purchase result.");
            this.b.finish();
            return;
        }
        finally {
            this.i = null;
        }
    }

    protected void a(String string, boolean bl2, int n2, Intent intent) {
        if (this.g == null) return;
        this.g.a(string, bl2, n2, intent, this.f);
    }

    @Override
    public void b() {
        this.b.unbindService((ServiceConnection)this);
        this.e.a();
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public void onServiceConnected(ComponentName var1_1, IBinder var2_2) {
        this.e.a(var2_2);
        try {
            this.i = this.h.a();
            var4_3 = this.e.a(this.b.getPackageName(), this.d.a(), this.i);
            var5_4 = (PendingIntent)var4_3.getParcelable("BUY_INTENT");
            if (var5_4 == null) {
                var6_5 = g.j().a(var4_3);
                this.d.b(var6_5);
                this.a(this.d.a(), false, var6_5, null);
                this.b.finish();
                return;
            }
            this.f = new d(this.d.a(), this.i);
            this.a.b(this.f);
            this.b.startIntentSenderForResult(var5_4.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
            return;
        }
        catch (RemoteException var3_6) {}
        ** GOTO lbl-1000
        catch (IntentSender.SendIntentException var3_8) {}
lbl-1000: // 2 sources:
        {
            fp.c("Error when connecting in-app billing service", (Throwable)var3_7);
            this.b.finish();
            return;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        fp.c("In-app billing service disconnected.");
        this.e.a();
    }
}

