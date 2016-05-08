package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationBuilderWithActions;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase$Action;
import android.support.v4.app.NotificationCompatJellybean;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationCompatJellybean$Builder implements NotificationBuilderWithBuilderAccessor, NotificationBuilderWithActions {
   private Builder b;
   private List<Bundle> mActionExtrasList = new ArrayList();
   private final Bundle mExtras;

   public NotificationCompatJellybean$Builder(Context var1, Notification var2, CharSequence var3, CharSequence var4, CharSequence var5, RemoteViews var6, int var7, PendingIntent var8, PendingIntent var9, Bitmap var10, int var11, int var12, boolean var13, boolean var14, int var15, CharSequence var16, boolean var17, Bundle var18, String var19, boolean var20, String var21) {
      Builder var23 = (new Builder(var1)).setWhen(var2.when).setSmallIcon(var2.icon, var2.iconLevel).setContent(var2.contentView).setTicker(var2.tickerText, var6).setSound(var2.sound, var2.audioStreamType).setVibrate(var2.vibrate).setLights(var2.ledARGB, var2.ledOnMS, var2.ledOffMS);
      boolean var22;
      if((var2.flags & 2) != 0) {
         var22 = true;
      } else {
         var22 = false;
      }

      var23 = var23.setOngoing(var22);
      if((var2.flags & 8) != 0) {
         var22 = true;
      } else {
         var22 = false;
      }

      var23 = var23.setOnlyAlertOnce(var22);
      if((var2.flags & 16) != 0) {
         var22 = true;
      } else {
         var22 = false;
      }

      var23 = var23.setAutoCancel(var22).setDefaults(var2.defaults).setContentTitle(var3).setContentText(var4).setSubText(var16).setContentInfo(var5).setContentIntent(var8).setDeleteIntent(var2.deleteIntent);
      if((var2.flags & 128) != 0) {
         var22 = true;
      } else {
         var22 = false;
      }

      this.b = var23.setFullScreenIntent(var9, var22).setLargeIcon(var10).setNumber(var7).setUsesChronometer(var14).setPriority(var15).setProgress(var11, var12, var13);
      this.mExtras = new Bundle();
      if(var18 != null) {
         this.mExtras.putAll(var18);
      }

      if(var17) {
         this.mExtras.putBoolean("android.support.localOnly", true);
      }

      if(var19 != null) {
         this.mExtras.putString("android.support.groupKey", var19);
         if(var20) {
            this.mExtras.putBoolean("android.support.isGroupSummary", true);
         } else {
            this.mExtras.putBoolean("android.support.useSideChannel", true);
         }
      }

      if(var21 != null) {
         this.mExtras.putString("android.support.sortKey", var21);
      }

   }

   public void addAction(NotificationCompatBase$Action var1) {
      this.mActionExtrasList.add(NotificationCompatJellybean.writeActionAndGetExtras(this.b, var1));
   }

   public Notification build() {
      Notification var1 = this.b.build();
      Bundle var2 = NotificationCompatJellybean.getExtras(var1);
      Bundle var3 = new Bundle(this.mExtras);
      Iterator var4 = this.mExtras.keySet().iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         if(var2.containsKey(var5)) {
            var3.remove(var5);
         }
      }

      var2.putAll(var3);
      SparseArray var6 = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
      if(var6 != null) {
         NotificationCompatJellybean.getExtras(var1).putSparseParcelableArray("android.support.actionExtras", var6);
      }

      return var1;
   }

   public Builder getBuilder() {
      return this.b;
   }
}
