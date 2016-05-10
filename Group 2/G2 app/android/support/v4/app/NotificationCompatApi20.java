package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Action;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.RemoteInputCompatApi20;
import android.support.v4.app.RemoteInputCompatBase;
import android.widget.RemoteViews;
import java.util.ArrayList;

class NotificationCompatApi20 {
   public static void addAction(android.app.Notification.Builder var0, NotificationCompatBase.Action var1) {
      android.app.Notification.Action.Builder var4 = new android.app.Notification.Action.Builder(var1.getIcon(), var1.getTitle(), var1.getActionIntent());
      if(var1.getRemoteInputs() != null) {
         android.app.RemoteInput[] var5 = RemoteInputCompatApi20.fromCompat(var1.getRemoteInputs());
         int var3 = var5.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            var4.addRemoteInput(var5[var2]);
         }
      }

      if(var1.getExtras() != null) {
         var4.addExtras(var1.getExtras());
      }

      var0.addAction(var4.build());
   }

   public static NotificationCompatBase.Action getAction(Notification var0, int var1, NotificationCompatBase.Factory var2, RemoteInputCompatBase.Factory var3) {
      return getActionCompatFromAction(var0.actions[var1], var2, var3);
   }

   private static NotificationCompatBase.Action getActionCompatFromAction(Action var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      RemoteInputCompatBase.RemoteInput[] var3 = RemoteInputCompatApi20.toCompat(var0.getRemoteInputs(), var2);
      return var1.build(var0.icon, var0.title, var0.actionIntent, var0.getExtras(), var3);
   }

   private static Action getActionFromActionCompat(NotificationCompatBase.Action var0) {
      android.app.Notification.Action.Builder var3 = (new android.app.Notification.Action.Builder(var0.getIcon(), var0.getTitle(), var0.getActionIntent())).addExtras(var0.getExtras());
      RemoteInputCompatBase.RemoteInput[] var4 = var0.getRemoteInputs();
      if(var4 != null) {
         android.app.RemoteInput[] var5 = RemoteInputCompatApi20.fromCompat(var4);
         int var2 = var5.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            var3.addRemoteInput(var5[var1]);
         }
      }

      return var3.build();
   }

   public static NotificationCompatBase.Action[] getActionsFromParcelableArrayList(ArrayList var0, NotificationCompatBase.Factory var1, RemoteInputCompatBase.Factory var2) {
      NotificationCompatBase.Action[] var4;
      if(var0 == null) {
         var4 = null;
      } else {
         NotificationCompatBase.Action[] var5 = var1.newArray(var0.size());
         int var3 = 0;

         while(true) {
            var4 = var5;
            if(var3 >= var5.length) {
               break;
            }

            var5[var3] = getActionCompatFromAction((Action)var0.get(var3), var1, var2);
            ++var3;
         }
      }

      return var4;
   }

   public static String getGroup(Notification var0) {
      return var0.getGroup();
   }

   public static boolean getLocalOnly(Notification var0) {
      return (var0.flags & 256) != 0;
   }

   public static ArrayList getParcelableArrayListForActions(NotificationCompatBase.Action[] var0) {
      ArrayList var3;
      if(var0 == null) {
         var3 = null;
      } else {
         ArrayList var4 = new ArrayList(var0.length);
         int var2 = var0.length;
         int var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            var4.add(getActionFromActionCompat(var0[var1]));
            ++var1;
         }
      }

      return var3;
   }

   public static String getSortKey(Notification var0) {
      return var0.getSortKey();
   }

   public static boolean isGroupSummary(Notification var0) {
      return (var0.flags & 512) != 0;
   }

   public static class Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
      private android.app.Notification.Builder b;
      private Bundle mExtras;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, boolean var15, int var16, CharSequence var17, boolean var18, ArrayList var19, Bundle var20, String var21, boolean var22, String var23) {
         android.app.Notification.Builder var24 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setShowWhen(var14).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         if((var2.flags & 2) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var24 = var24.setOngoing(var14);
         if((var2.flags & 8) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var24 = var24.setOnlyAlertOnce(var14);
         if((var2.flags & 16) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var24 = var24.setAutoCancel(var14).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var17).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         if((var2.flags & 128) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         this.b = var24.setFullScreenIntent(var9, var14).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var15).setPriority(var16).setProgress(var11, var12, var13).setLocalOnly(var18).setGroup(var21).setGroupSummary(var22).setSortKey(var23);
         this.mExtras = new Bundle();
         if(var20 != null) {
            this.mExtras.putAll(var20);
         }

         if(var19 != null && !var19.isEmpty()) {
            this.mExtras.putStringArray("android.people", (String[])var19.toArray(new String[var19.size()]));
         }

      }

      public void addAction(NotificationCompatBase.Action var1) {
         NotificationCompatApi20.addAction(this.b, var1);
      }

      public Notification build() {
         this.b.setExtras(this.mExtras);
         return this.b.build();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.b;
      }
   }
}
