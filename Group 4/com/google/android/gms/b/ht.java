/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class ht
implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult a;

    ht(JsPromptResult jsPromptResult) {
        this.a = jsPromptResult;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.cancel();
    }
}

