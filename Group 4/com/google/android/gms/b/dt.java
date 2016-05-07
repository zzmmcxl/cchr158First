/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ds;

class dt
implements DialogInterface.OnClickListener {
    final /* synthetic */ ds a;

    dt(ds ds2) {
        this.a = ds2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        Intent intent = this.a.b();
        g.c().a(ds.a(this.a), intent);
    }
}

