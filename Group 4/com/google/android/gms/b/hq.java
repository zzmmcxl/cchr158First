/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class hq
implements DialogInterface.OnClickListener {
    final /* synthetic */ JsResult a;

    hq(JsResult jsResult) {
        this.a = jsResult;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.cancel();
    }
}

