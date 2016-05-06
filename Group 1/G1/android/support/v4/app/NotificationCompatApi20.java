package android.support.v4.app;

import android.graphics.Bitmap;
import android.app.PendingIntent;
import android.widget.RemoteViews;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import android.app.Notification$Action;
import android.app.Notification;
import android.app.RemoteInput;
import android.app.Notification$Action$Builder;
import android.app.Notification$Builder;

class NotificationCompatApi20
{
    NotificationCompatApi20() {
        super();
    }
    
    public static void addAction(final Notification$Builder notification$Builder, final NotificationCompatBase.Action action) {
        final Notification$Action$Builder notification$Action$Builder = new Notification$Action$Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            final RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(action.getRemoteInputs());
            for (int length = fromCompat.length, i = 0; i < length; ++i) {
                notification$Action$Builder.addRemoteInput(fromCompat[i]);
            }
        }
        if (action.getExtras() != null) {
            notification$Action$Builder.addExtras(action.getExtras());
        }
        notification$Builder.addAction(notification$Action$Builder.build());
    }
    
    public static NotificationCompatBase.Action getAction(final Notification notification, final int n, final NotificationCompatBase.Action.Factory factory, final RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return getActionCompatFromAction(notification.actions[n], factory, factory2);
    }
    
    private static NotificationCompatBase.Action getActionCompatFromAction(final Notification$Action notification$Action, final NotificationCompatBase.Action.Factory factory, final RemoteInputCompatBase.RemoteInput.Factory factory2) {
        return factory.build(notification$Action.icon, notification$Action.title, notification$Action.actionIntent, notification$Action.getExtras(), RemoteInputCompatApi20.toCompat(notification$Action.getRemoteInputs(), factory2));
    }
    
    private static Notification$Action getActionFromActionCompat(final NotificationCompatBase.Action action) {
        final Notification$Action$Builder addExtras = new Notification$Action$Builder(action.getIcon(), action.getTitle(), action.getActionIntent()).addExtras(action.getExtras());
        final RemoteInputCompatBase.RemoteInput[] remoteInputs = action.getRemoteInputs();
        if (remoteInputs != null) {
            final RemoteInput[] fromCompat = RemoteInputCompatApi20.fromCompat(remoteInputs);
            for (int length = fromCompat.length, i = 0; i < length; ++i) {
                addExtras.addRemoteInput(fromCompat[i]);
            }
        }
        return addExtras.build();
    }
    
    public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(final ArrayList<Parcelable> list, final NotificationCompatBase.Action.Factory factory, final RemoteInputCompatBase.RemoteInput.Factory factory2) {
        Object[] array;
        if (list == null) {
            array = null;
        }
        else {
            array = factory.newArray(list.size());
            for (int i = 0; i < array.length; ++i) {
                array[i] = getActionCompatFromAction((Notification$Action)list.get(i), factory, factory2);
            }
        }
        return (NotificationCompatBase.Action[])array;
    }
    
    public static String getGroup(final Notification notification) {
        return notification.getGroup();
    }
    
    public static boolean getLocalOnly(final Notification notification) {
        return (0x100 & notification.flags) != 0x0;
    }
    
    public static ArrayList<Parcelable> getParcelableArrayListForActions(final NotificationCompatBase.Action[] array) {
        ArrayList<Parcelable> list;
        if (array == null) {
            list = null;
        }
        else {
            list = new ArrayList<Parcelable>(array.length);
            for (int length = array.length, i = 0; i < length; ++i) {
                list.add((Parcelable)getActionFromActionCompat(array[i]));
            }
        }
        return list;
    }
    
    public static String getSortKey(final Notification notification) {
        return notification.getSortKey();
    }
    
    public static boolean isGroupSummary(final Notification notification) {
        return (0x200 & notification.flags) != 0x0;
    }
}
