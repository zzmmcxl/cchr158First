/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import com.google.android.gms.b.dy;

class ea
implements DialogInterface.OnClickListener {
    final /* synthetic */ dy a;

    ea(dy dy2) {
        this.a = dy2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.b("User canceled the download.");
    }
}

