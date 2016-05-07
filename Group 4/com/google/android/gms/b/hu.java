/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.DialogInterface;
import android.text.Editable;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class hu
implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult a;
    final /* synthetic */ EditText b;

    hu(JsPromptResult jsPromptResult, EditText editText) {
        this.a = jsPromptResult;
        this.b = editText;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        this.a.confirm(this.b.getText().toString());
    }
}

