package android.support.v4.app;

import java.util.LinkedList;
import android.os.Message;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import java.util.Iterator;
import android.util.Log;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import android.os.HandlerThread;
import android.os.Handler;
import android.content.ServiceConnection;
import android.os.Handler$Callback;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Bundle;
import android.app.Notification;
import android.content.ComponentName;
import android.provider.Settings$Secure;
import android.os.Build$VERSION;
import java.util.HashSet;
import android.app.NotificationManager;
import android.content.Context;
import java.util.Set;

public final class NotificationManagerCompat
{
    public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
    public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
    private static final Impl IMPL;
    static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final int SIDE_CHANNEL_BIND_FLAGS = 0;
    private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
    private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
    private static final String TAG = "NotifManCompat";
    private static Set<String> sEnabledNotificationListenerPackages;
    private static String sEnabledNotificationListeners;
    private static final Object sEnabledNotificationListenersLock;
    private static final Object sLock;
    private static SideChannelManager sSideChannelManager;
    private final Context mContext;
    private final NotificationManager mNotificationManager;
    
    static {
        sEnabledNotificationListenersLock = new Object();
        sEnabledNotificationListenerPackages = new HashSet<String>();
        sLock = new Object();
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (Impl)new ImplIceCreamSandwich();
        }
        else if (Build$VERSION.SDK_INT >= 5) {
            IMPL = (Impl)new ImplEclair();
        }
        else {
            IMPL = (Impl)new ImplBase();
        }
    }
    
    private NotificationManagerCompat(final Context mContext) {
        super();
        mContext = mContext;
        mNotificationManager = (NotificationManager)mContext.getSystemService("notification");
    }
    
    static /* synthetic */ int access$000() {
        return SIDE_CHANNEL_BIND_FLAGS;
    }
    
    public static NotificationManagerCompat from(final Context context) {
        return new NotificationManagerCompat(context);
    }
    
    public static Set<String> getEnabledListenerPackages(final Context context) {
        final String string = Settings$Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        Label_0106: {
            if (string == null || string.equals(sEnabledNotificationListeners)) {
                break Label_0106;
            }
            final String[] split = string.split(":");
            final HashSet sEnabledNotificationListenerPackages = new HashSet<String>(split.length);
            for (int length = split.length, i = 0; i < length; ++i) {
                final ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i]);
                if (unflattenFromString != null) {
                    sEnabledNotificationListenerPackages.add(unflattenFromString.getPackageName());
                }
            }
            synchronized (sEnabledNotificationListenersLock) {
                NotificationManagerCompat.sEnabledNotificationListenerPackages = (Set<String>)sEnabledNotificationListenerPackages;
                sEnabledNotificationListeners = string;
                return NotificationManagerCompat.sEnabledNotificationListenerPackages;
            }
        }
    }
    
    private void pushSideChannelQueue(final Task task) {
        synchronized (sLock) {
            if (sSideChannelManager == null) {
                sSideChannelManager = new SideChannelManager(mContext.getApplicationContext());
            }
            // monitorexit(NotificationManagerCompat.sLock)
            sSideChannelManager.queueTask(task);
        }
    }
    
    private static boolean useSideChannelForNotification(final Notification notification) {
        final Bundle extras = NotificationCompat.getExtras(notification);
        return extras != null && extras.getBoolean("android.support.useSideChannel");
    }
    
    public void cancel(final int n) {
        this.cancel(null, n);
    }
    
    public void cancel(final String s, final int n) {
        IMPL.cancelNotification(mNotificationManager, s, n);
        if (Build$VERSION.SDK_INT <= 19) {
            this.pushSideChannelQueue((Task)new CancelTask(mContext.getPackageName(), n, s));
        }
    }
    
    public void cancelAll() {
        mNotificationManager.cancelAll();
        if (Build$VERSION.SDK_INT <= 19) {
            this.pushSideChannelQueue((Task)new CancelTask(mContext.getPackageName()));
        }
    }
    
    public void notify(final int n, final Notification notification) {
        this.notify(null, n, notification);
    }
    
    public void notify(final String s, final int n, final Notification notification) {
        if (useSideChannelForNotification(notification)) {
            this.pushSideChannelQueue((Task)new NotifyTask(mContext.getPackageName(), n, s, notification));
            IMPL.cancelNotification(mNotificationManager, s, n);
            return;
        }
        IMPL.postNotification(mNotificationManager, s, n, notification);
    }
}
