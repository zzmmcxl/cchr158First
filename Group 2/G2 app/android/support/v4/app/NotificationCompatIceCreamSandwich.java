package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.widget.RemoteViews;

class NotificationCompatIceCreamSandwich {
   public static class Builder implements NotificationBuilderWithBuilderAccessor {
      private android.app.Notification.Builder b;

      public Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13) {
         android.app.Notification.Builder var15 = (new android.app.Notification.Builder(var1)).setWhen(var2.when).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
         boolean var14;
         if((var2.flags & 2) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var15 = var15.setOngoing(var14);
         if((var2.flags & 8) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var15 = var15.setOnlyAlertOnce(var14);
         if((var2.flags & 16) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         var15 = var15.setAutoCancel(var14).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
         if((var2.flags & 128) != 0) {
            var14 = true;
         } else {
            var14 = false;
         }

         this.b = var15.setFullScreenIntent(var9, var14).setLargeIcon(var10).setNumber(var7).setProgress(var11, var12, var13);
      }

      public Notification build() {
         return this.b.getNotification();
      }

      public android.app.Notification.Builder getBuilder() {
         return this.b;
      }
   }
}
