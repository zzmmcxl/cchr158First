/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.j;

abstract class ap
extends BroadcastReceiver {
    protected Context c;

    ap() {
    }

    public static ap a(Context context, ap ap2) {
        return ap.a(context, ap2, j.b());
    }

    public static ap a(Context context, ap ap2, j j2) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        context.registerReceiver((BroadcastReceiver)ap2, intentFilter);
        ap2.c = context;
        if (j2.a(context, "com.google.android.gms")) return ap2;
        ap2.a();
        ap2.b();
        return null;
    }

    protected abstract void a();

    public void b() {
        // MONITORENTER : this
        if (this.c != null) {
            this.c.unregisterReceiver((BroadcastReceiver)this);
        }
        this.c = null;
        // MONITOREXIT : this
        return;
    }

    public void onReceive(Context context, Intent intent) {
        Uri uri = intent.getData();
        String string = null;
        if (uri != null) {
            string = uri.getSchemeSpecificPart();
        }
        if (!"com.google.android.gms".equals(string)) return;
        this.a();
        this.b();
    }
}

