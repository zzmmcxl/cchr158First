/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.b.ev;
import com.google.android.gms.b.fc;
import com.google.android.gms.b.fp;

public class InAppPurchaseActivity
extends Activity {
    private ev a;

    protected void onActivityResult(int n2, int n3, Intent intent) {
        try {
            if (this.a != null) {
                this.a.a(n2, n3, intent);
            }
        }
        catch (RemoteException var4_4) {
            fp.c("Could not forward onActivityResult to in-app purchase manager:", (Throwable)var4_4);
        }
        super.onActivityResult(n2, n3, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = fc.a(this);
        if (this.a == null) {
            fp.d("Could not create in-app purchase manager.");
            this.finish();
            return;
        }
        try {
            this.a.a();
            return;
        }
        catch (RemoteException var2_2) {
            fp.c("Could not forward onCreate to in-app purchase manager:", (Throwable)var2_2);
            this.finish();
            return;
        }
    }

    protected void onDestroy() {
        try {
            if (this.a != null) {
                this.a.b();
            }
        }
        catch (RemoteException var1_1) {
            fp.c("Could not forward onDestroy to in-app purchase manager:", (Throwable)var1_1);
        }
        super.onDestroy();
    }
}

