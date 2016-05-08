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
import java.util.Iterator;

public class NotificationCompatApi21$Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
   private Builder b;

   public NotificationCompatApi21$Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, boolean var15, int var16, CharSequence var17, boolean var18, String var19, ArrayList<String> var20, Bundle var21, int var22, int var23, Notification var24, String var25, boolean var26, String var27) {
      Builder var28 = (new Builder(var1)).setWhen(var2.when).setShowWhen(var14).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
      if((var2.flags & 2) != 0) {
         var14 = true;
      } else {
         var14 = false;
      }

      var28 = var28.setOngoing(var14);
      if((var2.flags & 8) != 0) {
         var14 = true;
      } else {
         var14 = false;
      }

      var28 = var28.setOnlyAlertOnce(var14);
      if((var2.flags & 16) != 0) {
         var14 = true;
      } else {
         var14 = false;
      }

      var28 = var28.setAutoCancel(var14).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var17).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
      if((var2.flags & 128) != 0) {
         var14 = true;
      } else {
         var14 = false;
      }

      this.b = var28.setFullScreenIntent(var9, var14).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var15).setPriority(var16).setProgress(var11, var12, var13).setLocalOnly(var18).setExtras(var21).setGroup(var25).setGroupSummary(var26).setSortKey(var27).setCategory(var19).setColor(var22).setVisibility(var23).setPublicVersion(var24);
      Iterator var30 = var20.iterator();

      while(var30.hasNext()) {
         String var29 = (String)var30.next();
         this.b.addPerson(var29);
      }

   }

   public void addAction(NotificationCompatBase$Action var1) {
      NotificationCompatApi20.addAction(this.b, var1);
   }

   public Notification build() {
      return this.b.build();
   }

   public Builder getBuilder() {
      return this.b;
   }
}
