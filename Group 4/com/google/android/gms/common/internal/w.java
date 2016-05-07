/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.x;
import android.util.Log;

public class w
implements DialogInterface.OnClickListener {
    private final Activity a;
    private final x b;
    private final Intent c;
    private final int d;

    public w(Activity activity, Intent intent, int n2) {
        this.a = activity;
        this.b = null;
        this.c = intent;
        this.d = n2;
    }

    public w(x x2, Intent intent, int n2) {
        this.a = null;
        this.b = x2;
        this.c = intent;
        this.d = n2;
    }

    public void onClick(DialogInterface dialogInterface, int n2) {
        try {
            if (this.c != null && this.b != null) {
                this.b.a(this.c, this.d);
            } else if (this.c != null) {
                this.a.startActivityForResult(this.c, this.d);
            }
            dialogInterface.dismiss();
            return;
        }
        catch (ActivityNotFoundException var3_3) {
            Log.e((String)"SettingsRedirect", (String)"Can't redirect to app settings for Google Play services");
            return;
        }
    }
}

