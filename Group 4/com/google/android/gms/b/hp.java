/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class hp
implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsResult a;

    hp(JsResult jsResult) {
        this.a = jsResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}

