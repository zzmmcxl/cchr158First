/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

class h {
    public static void a(Activity activity) {
        activity.finishAffinity();
    }

    public static void a(Activity activity, Intent intent, int n2, Bundle bundle) {
        activity.startActivityForResult(intent, n2, bundle);
    }
}

