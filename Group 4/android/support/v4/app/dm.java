/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

class dm {
    public static PendingIntent a(Context context, int n2, Intent[] arrintent, int n3) {
        return PendingIntent.getActivities((Context)context, (int)n2, (Intent[])arrintent, (int)n3);
    }
}

