package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatApi20;
import android.support.v4.app.NotificationCompatBase$Action;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompatApi20$Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
   private Builder b;
   private Bundle mExtras;

   public NotificationCompatApi20$Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, boolean var15, int var16, CharSequence var17, boolean var18, ArrayList<String> var19, Bundle var20, String var21, boolean var22, String var23) {
      Builder var24 = (new Builder(var1)).setWhen(var2.when).setShowWhen(var14).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
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

   public void addAction(NotificationCompatBase$Action var1) {
      NotificationCompatApi20.addAction(this.b, var1);
   }

   public Notification build() {
      this.b.setExtras(this.mExtras);
      return this.b.build();
   }

   public Builder getBuilder() {
      return this.b;
   }
}
