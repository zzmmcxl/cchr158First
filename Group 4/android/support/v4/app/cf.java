/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;
import android.support.v4.app.ck;
import android.support.v4.app.da;
import android.support.v4.app.dc;

class cf {
    public static void a(Notification.Builder builder, ck ck2) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(ck2.a(), ck2.b(), ck2.c());
        if (ck2.f() != null) {
            RemoteInput[] arrremoteInput = da.a(ck2.f());
            int n2 = arrremoteInput.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                builder2.addRemoteInput(arrremoteInput[i2]);
            }
        }
        if (ck2.d() != null) {
            builder2.addExtras(ck2.d());
        }
        builder.addAction(builder2.build());
    }
}

