/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.DownloadManager;
import android.content.DialogInterface;
import com.google.android.gms.b.dy;

class dz
implements DialogInterface.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ dy c;

    dz(dy dy2, String string, String string2) {
        this.c = dy2;
        this.a = string;
        this.b = string2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        DownloadManager downloadManager = (DownloadManager)dy.a(this.c).getSystemService("download");
        try {
            downloadManager.enqueue(this.c.a(this.a, this.b));
            return;
        }
        catch (IllegalStateException var4_4) {
            this.c.b("Could not store picture.");
            return;
        }
    }
}

