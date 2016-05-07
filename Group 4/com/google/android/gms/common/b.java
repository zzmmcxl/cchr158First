/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.common.e;
import com.google.android.gms.common.j;
import com.google.android.gms.d;

public class b
extends j {
    public static final int a;
    private static final b c;

    static {
        c = new b();
        a = j.b;
    }

    b() {
    }

    public static b a() {
        return c;
    }

    @Override
    public int a(Context context) {
        return super.a(context);
    }

    public Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar((Context)activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setView((View)progressBar);
        String string = e.f((Context)activity);
        builder.setMessage((CharSequence)activity.getResources().getString(d.common_google_play_services_updating_text, new Object[]{string}));
        builder.setTitle(d.common_google_play_services_updating_title);
        builder.setPositiveButton((CharSequence)"", null);
        AlertDialog alertDialog = builder.create();
        e.a(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", (Dialog)alertDialog);
        return alertDialog;
    }

    @Override
    public Intent a(Context context, int n2, String string) {
        return super.a(context, n2, string);
    }

    @Override
    public final boolean a(int n2) {
        return super.a(n2);
    }

    public boolean a(Activity activity, int n2, int n3) {
        return e.a(n2, activity, n3);
    }

    @Override
    public boolean a(Context context, int n2) {
        return super.a(context, n2);
    }

    @Deprecated
    @Override
    public Intent b(int n2) {
        return super.b(n2);
    }
}

