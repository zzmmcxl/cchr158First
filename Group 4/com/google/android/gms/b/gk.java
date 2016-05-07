/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.gj;

class gk
implements DialogInterface.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ gj b;

    gk(gj gj2, String string) {
        this.b = gj2;
        this.a = string;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        g.c().a(gj.a(this.b), Intent.createChooser((Intent)new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.a), (CharSequence)"Share via"));
    }
}

