package android.support.v4.app;

import java.util.ArrayList;
import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.content.Context;
import java.util.List;
import android.app.Notification$Builder;
import android.util.SparseArray;
import android.app.Notification$Action;
import android.os.Bundle;
import android.app.Notification;

class NotificationCompatKitKat
{
    NotificationCompatKitKat() {
        super();
    }
    
    public static NotificationCompatBase.Action getAction(final Notification notification, final int n, final NotificationCompatBase.Action.Factory factory, final RemoteInputCompatBase.RemoteInput.Factory factory2) {
        final Notification$Action notification$Action = notification.actions[n];
        final SparseArray sparseParcelableArray = notification.extras.getSparseParcelableArray("android.support.actionExtras");
        Bundle bundle = null;
        if (sparseParcelableArray != null) {
            bundle = (Bundle)sparseParcelableArray.get(n);
        }
        return NotificationCompatJellybean.readAction(factory, factory2, notification$Action.icon, notification$Action.title, notification$Action.actionIntent, bundle);
    }
    
    public static int getActionCount(final Notification notification) {
        if (notification.actions != null) {
            return notification.actions.length;
        }
        return 0;
    }
    
    public static Bundle getExtras(final Notification notification) {
        return notification.extras;
    }
    
    public static String getGroup(final Notification notification) {
        return notification.extras.getString("android.support.groupKey");
    }
    
    public static boolean getLocalOnly(final Notification notification) {
        return notification.extras.getBoolean("android.support.localOnly");
    }
    
    public static String getSortKey(final Notification notification) {
        return notification.extras.getString("android.support.sortKey");
    }
    
    public static boolean isGroupSummary(final Notification notification) {
        return notification.extras.getBoolean("android.support.isGroupSummary");
    }
}
