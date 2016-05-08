package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.os.Bundle;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v4.app.NotificationCompatBase$Action$Factory;
import android.support.v4.app.NotificationCompatJellybean;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;
import android.util.SparseArray;

class NotificationCompatKitKat {
   public static NotificationCompatBase$Action getAction(Notification var0, int var1, NotificationCompatBase$Action$Factory var2, RemoteInputCompatBase$RemoteInput$Factory var3) {
      Action var5 = var0.actions[var1];
      Object var4 = null;
      SparseArray var6 = var0.extras.getSparseParcelableArray("android.support.actionExtras");
      Bundle var7 = (Bundle)var4;
      if(var6 != null) {
         var7 = (Bundle)var6.get(var1);
      }

      return NotificationCompatJellybean.readAction(var2, var3, var5.icon, var5.title, var5.actionIntent, var7);
   }

   public static int getActionCount(Notification var0) {
      return var0.actions != null?var0.actions.length:0;
   }

   public static Bundle getExtras(Notification var0) {
      return var0.extras;
   }

   public static String getGroup(Notification var0) {
      return var0.extras.getString("android.support.groupKey");
   }

   public static boolean getLocalOnly(Notification var0) {
      return var0.extras.getBoolean("android.support.localOnly");
   }

   public static String getSortKey(Notification var0) {
      return var0.extras.getString("android.support.sortKey");
   }

   public static boolean isGroupSummary(Notification var0) {
      return var0.extras.getBoolean("android.support.isGroupSummary");
   }
}
