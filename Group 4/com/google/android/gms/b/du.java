/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import com.google.android.gms.b.ds;

class du
implements DialogInterface.OnClickListener {
    final /* synthetic */ ds a;

    du(ds ds2) {
        this.a = ds2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.b("Operation denied by user.");
    }
}

