/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Activity;
import android.support.v4.app.f;

class e {
    public static void a(Activity activity, String[] arrstring, int n2) {
        if (activity instanceof f) {
            ((f)activity).a_(n2);
        }
        activity.requestPermissions(arrstring, n2);
    }
}

