/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.bf;
import com.google.android.gms.measurement.internal.bl;
import com.google.android.gms.measurement.internal.bt;
import com.google.android.gms.measurement.internal.bx;

class bk
extends BroadcastReceiver {
    static final String a = bk.class.getName();
    private final bx b;
    private boolean c;
    private boolean d;

    bk(bx bx2) {
        com.google.android.gms.common.internal.bf.a(bx2);
        this.b = bx2;
    }

    static /* synthetic */ bx a(bk bk2) {
        return bk2.b;
    }

    private Context d() {
        return this.b.p();
    }

    private bc e() {
        return this.b.f();
    }

    public void a() {
        this.b.a();
        this.b.x();
        if (this.c) {
            return;
        }
        this.d().registerReceiver((BroadcastReceiver)this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = this.b.o().b();
        this.e().z().a("Registering connectivity change receiver. Network connected", this.d);
        this.c = true;
    }

    public void b() {
        this.b.a();
        this.b.x();
        if (!this.c()) {
            return;
        }
        this.e().z().a("Unregistering connectivity change receiver");
        this.c = false;
        this.d = false;
        Context context = this.d();
        try {
            context.unregisterReceiver((BroadcastReceiver)this);
            return;
        }
        catch (IllegalArgumentException var2_2) {
            this.e().b().a("Failed to unregister the network broadcast receiver", var2_2);
            return;
        }
    }

    public boolean c() {
        this.b.x();
        return this.c;
    }

    public void onReceive(Context context, Intent intent) {
        this.b.a();
        String string = intent.getAction();
        this.e().z().a("NetworkBroadcastReceiver received action", string);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(string)) {
            boolean bl2 = this.b.o().b();
            if (this.d == bl2) return;
            this.d = bl2;
            this.b.h().a(new bl(this, bl2));
            return;
        }
        this.e().c().a("NetworkBroadcastReceiver received unknown action", string);
    }
}

