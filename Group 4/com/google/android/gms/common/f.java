/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ah;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.bf;

public class f
extends w {
    private Dialog ai = null;
    private DialogInterface.OnCancelListener aj = null;

    public static f a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        f f2 = new f();
        Dialog dialog2 = (Dialog)bf.a((Object)dialog, (Object)"Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        f2.ai = dialog2;
        if (onCancelListener == null) return f2;
        f2.aj = onCancelListener;
        return f2;
    }

    @Override
    public void a(ah ah2, String string) {
        super.a(ah2, string);
    }

    @Override
    public Dialog c(Bundle bundle) {
        if (this.ai != null) return this.ai;
        this.b(false);
        return this.ai;
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        if (this.aj == null) return;
        this.aj.onCancel(dialogInterface);
    }
}

