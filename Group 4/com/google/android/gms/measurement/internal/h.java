/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.bc;
import com.google.android.gms.measurement.internal.be;
import com.google.android.gms.measurement.internal.d;
import com.google.android.gms.measurement.internal.e;
import com.google.android.gms.measurement.internal.u;

@TargetApi(value=14)
class h
implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ d a;

    private h(d d2) {
        this.a = d2;
    }

    /* synthetic */ h(d d2, e e2) {
        this(d2);
    }

    private boolean a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) return false;
        this.a.a("auto", "_ldl", string);
        return true;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.a.s().z().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) return;
            Uri uri = intent.getData();
            if (uri == null) return;
            if (!uri.isHierarchical()) return;
            String string = uri.getQueryParameter("referrer");
            if (TextUtils.isEmpty((CharSequence)string)) {
                return;
            }
            if (!string.contains("gclid")) {
                this.a.s().y().a("Activity created with data 'referrer' param without gclid");
                return;
            }
            this.a.s().y().a("Activity created with referrer", string);
            this.a(string);
            return;
        }
        catch (Throwable var3_6) {
            this.a.s().b().a("Throwable caught in onActivityCreated", var3_6);
            return;
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.a.q().c();
    }

    public void onActivityResumed(Activity activity) {
        this.a.q().b();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

