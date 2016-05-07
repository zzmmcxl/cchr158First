/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class hs
implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsPromptResult a;

    hs(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.cancel();
    }
}

