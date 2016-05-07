/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.aa;
import android.support.v4.app.ah;
import android.support.v4.app.x;
import android.util.TypedValue;
import com.google.android.gms.b.ki;
import com.google.android.gms.b.kn;
import com.google.android.gms.common.a;
import com.google.android.gms.common.b;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.r;

public final class e
extends r {
    @Deprecated
    public static final int a = r.b;

    @TargetApi(value=11)
    public static void a(Activity activity, DialogInterface.OnCancelListener onCancelListener, String string, Dialog dialog) {
        boolean bl2;
        try {
            bl2 = activity instanceof aa;
        }
        catch (NoClassDefFoundError var4_6) {
            bl2 = false;
        }
        if (bl2) {
            ah ah2 = ((aa)activity).f();
            f.a(dialog, onCancelListener).a(ah2, string);
            return;
        }
        if (!kn.a()) throw new RuntimeException("This Activity does not support Fragments.");
        FragmentManager fragmentManager = activity.getFragmentManager();
        a.a(dialog, onCancelListener).show(fragmentManager, string);
    }

    @Deprecated
    public static boolean a(int n2, Activity activity, int n3) {
        return e.a(n2, activity, n3, null);
    }

    @Deprecated
    public static boolean a(int n2, Activity activity, int n3, DialogInterface.OnCancelListener onCancelListener) {
        return e.a(n2, activity, null, n3, onCancelListener);
    }

    public static boolean a(int n2, Activity activity, x x2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = e.b(n2, activity, x2, n3, onCancelListener);
        if (dialog == null) {
            return false;
        }
        e.a(activity, onCancelListener, "GooglePlayServicesErrorDialog", dialog);
        return true;
    }

    @Deprecated
    public static boolean a(Context context, int n2) {
        return r.c(context, n2);
    }

    @TargetApi(value=14)
    private static Dialog b(int n2, Activity activity, x x2, int n3, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder;
        String string;
        block7 : {
            if (n2 == 0) {
                return null;
            }
            if (ki.a((Context)activity) && n2 == 2) {
                n2 = 42;
            }
            if (e.a((Context)activity, n2)) {
                n2 = 18;
            }
            boolean bl2 = kn.c();
            builder = null;
            if (bl2) {
                TypedValue typedValue = new TypedValue();
                activity.getTheme().resolveAttribute(16843529, typedValue, true);
                boolean bl3 = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId));
                builder = null;
                if (bl3 && (builder = new AlertDialog.Builder((Context)activity, 5)) != null) break block7;
            }
            builder = new AlertDialog.Builder((Context)activity);
        }
        builder.setMessage((CharSequence)v.a((Context)activity, n2, e.f((Context)activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent intent = b.a().a((Context)activity, n2, "d");
        w w2 = x2 == null ? new w(activity, intent, n3) : new w(x2, intent, n3);
        String string2 = v.b((Context)activity, n2);
        if (string2 != null) {
            builder.setPositiveButton((CharSequence)string2, (DialogInterface.OnClickListener)w2);
        }
        if ((string = v.a((Context)activity, n2)) == null) return builder.create();
        builder.setTitle((CharSequence)string);
        return builder.create();
    }
}

