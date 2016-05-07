/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.bf;

@TargetApi(value=11)
public class a
extends DialogFragment {
    private Dialog a = null;
    private DialogInterface.OnCancelListener b = null;

    public static a a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        a a2 = new a();
        Dialog dialog2 = (Dialog)bf.a((Object)dialog, (Object)"Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        a2.a = dialog2;
        if (onCancelListener == null) return a2;
        a2.b = onCancelListener;
        return a2;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.b == null) return;
        this.b.onCancel(dialogInterface);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a != null) return this.a;
        this.setShowsDialog(false);
        return this.a;
    }

    public void show(FragmentManager fragmentManager, String string) {
        super.show(fragmentManager, string);
    }
}

