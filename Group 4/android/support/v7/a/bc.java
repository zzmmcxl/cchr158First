/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.app.Notification;
import android.media.session.MediaSession;
import android.support.v4.app.bm;

class bc {
    public static void a(bm bm2, int[] arrn, Object object) {
        Notification.MediaStyle mediaStyle = new Notification.MediaStyle(bm2.a());
        if (arrn != null) {
            mediaStyle.setShowActionsInCompactView(arrn);
        }
        if (object == null) return;
        mediaStyle.setMediaSession((MediaSession.Token)object);
    }
}

