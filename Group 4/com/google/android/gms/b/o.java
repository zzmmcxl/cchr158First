/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.b.fi;

@fi
@TargetApi(value=14)
public class o
implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private Context b;
    private final Object c;

    private void a(Activity activity) {
        Object object = this.c;
        // MONITORENTER : object
        if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
            this.a = activity;
        }
        // MONITOREXIT : object
        return;
    }

    public Activity a() {
        return this.a;
    }

    public Context b() {
        return this.b;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        Object object = this.c;
        // MONITORENTER : object
        if (this.a == null) {
            // MONITOREXIT : object
            return;
        }
        if (this.a.equals((Object)activity)) {
            this.a = null;
        }
        // MONITOREXIT : object
        return;
    }

    public void onActivityPaused(Activity activity) {
        this.a(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.a(activity);
    }

    public void onActivityStopped(Activity activity) {
    }
}

