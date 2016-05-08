package android.support.v4.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat$CancelTask;
import android.support.v4.app.NotificationManagerCompat$Impl;
import android.support.v4.app.NotificationManagerCompat$ImplBase;
import android.support.v4.app.NotificationManagerCompat$ImplEclair;
import android.support.v4.app.NotificationManagerCompat$ImplIceCreamSandwich;
import android.support.v4.app.NotificationManagerCompat$NotifyTask;
import android.support.v4.app.NotificationManagerCompat$SideChannelManager;
import android.support.v4.app.NotificationManagerCompat$Task;
import java.util.HashSet;
import java.util.Set;

public final class NotificationManagerCompat {
   public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
   public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
   private static final NotificationManagerCompat$Impl IMPL;
   static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
   private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
   private static final int SIDE_CHANNEL_BIND_FLAGS;
   private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
   private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
   private static final String TAG = "NotifManCompat";
   private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
   private static String sEnabledNotificationListeners;
   private static final Object sEnabledNotificationListenersLock = new Object();
   private static final Object sLock = new Object();
   private static NotificationManagerCompat$SideChannelManager sSideChannelManager;
   private final Context mContext;
   private final NotificationManager mNotificationManager;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new NotificationManagerCompat$ImplIceCreamSandwich();
      } else if(VERSION.SDK_INT >= 5) {
         IMPL = new NotificationManagerCompat$ImplEclair();
      } else {
         IMPL = new NotificationManagerCompat$ImplBase();
      }

      SIDE_CHANNEL_BIND_FLAGS = IMPL.getSideChannelBindFlags();
   }

   private NotificationManagerCompat(Context var1) {
      this.mContext = var1;
      this.mNotificationManager = (NotificationManager)this.mContext.getSystemService("notification");
   }

   public static NotificationManagerCompat from(Context var0) {
      return new NotificationManagerCompat(var0);
   }

   public static Set<String> getEnabledListenerPackages(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void pushSideChannelQueue(NotificationManagerCompat$Task param1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean useSideChannelForNotification(Notification var0) {
      Bundle var1 = NotificationCompat.getExtras(var0);
      return var1 != null && var1.getBoolean("android.support.useSideChannel");
   }

   public void cancel(int var1) {
      this.cancel((String)null, var1);
   }

   public void cancel(String var1, int var2) {
      IMPL.cancelNotification(this.mNotificationManager, var1, var2);
      if(VERSION.SDK_INT <= 19) {
         this.pushSideChannelQueue(new NotificationManagerCompat$CancelTask(this.mContext.getPackageName(), var2, var1));
      }

   }

   public void cancelAll() {
      this.mNotificationManager.cancelAll();
      if(VERSION.SDK_INT <= 19) {
         this.pushSideChannelQueue(new NotificationManagerCompat$CancelTask(this.mContext.getPackageName()));
      }

   }

   public void notify(int var1, Notification var2) {
      this.notify((String)null, var1, var2);
   }

   public void notify(String var1, int var2, Notification var3) {
      if(useSideChannelForNotification(var3)) {
         this.pushSideChannelQueue(new NotificationManagerCompat$NotifyTask(this.mContext.getPackageName(), var2, var1, var3));
         IMPL.cancelNotification(this.mNotificationManager, var1, var2);
      } else {
         IMPL.postNotification(this.mNotificationManager, var1, var2, var3);
      }
   }
}
