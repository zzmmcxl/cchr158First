package android.support.v7.internal.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompatBase;
import android.support.v7.appcompat.R;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

public class NotificationCompatImplBase {
   static final int MAX_MEDIA_BUTTONS = 5;
   static final int MAX_MEDIA_BUTTONS_IN_COMPACT = 3;

   private static RemoteViews applyStandardTemplate(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, int var10, boolean var11) {
      RemoteViews var14 = new RemoteViews(var0.getPackageName(), var10);
      boolean var18 = false;
      boolean var13 = false;
      if(var5 != null && VERSION.SDK_INT >= 16) {
         var14.setImageViewBitmap(R.id.icon, var5);
      } else {
         var14.setViewVisibility(R.id.icon, 8);
      }

      if(var1 != null) {
         var14.setTextViewText(R.id.title, var1);
      }

      if(var2 != null) {
         var14.setTextViewText(R.id.text, var2);
         var18 = true;
      }

      boolean var16;
      if(var3 != null) {
         var14.setTextViewText(R.id.info, var3);
         var14.setViewVisibility(R.id.info, 0);
         var16 = true;
      } else if(var4 > 0) {
         if(var4 > var0.getResources().getInteger(R.integer.status_bar_notification_info_maxnum)) {
            var14.setTextViewText(R.id.info, var0.getResources().getString(R.string.status_bar_notification_info_overflow));
         } else {
            NumberFormat var15 = NumberFormat.getIntegerInstance();
            var14.setTextViewText(R.id.info, var15.format((long)var4));
         }

         var14.setViewVisibility(R.id.info, 0);
         var16 = true;
      } else {
         var14.setViewVisibility(R.id.info, 8);
         var16 = var18;
      }

      var18 = var13;
      if(var6 != null) {
         var18 = var13;
         if(VERSION.SDK_INT >= 16) {
            var14.setTextViewText(R.id.text, var6);
            if(var2 != null) {
               var14.setTextViewText(R.id.text2, var2);
               var14.setViewVisibility(R.id.text2, 0);
               var18 = true;
            } else {
               var14.setViewVisibility(R.id.text2, 8);
               var18 = var13;
            }
         }
      }

      if(var18 && VERSION.SDK_INT >= 16) {
         if(var11) {
            float var12 = (float)var0.getResources().getDimensionPixelSize(R.dimen.notification_subtext_size);
            var14.setTextViewTextSize(R.id.text, 0, var12);
         }

         var14.setViewPadding(R.id.line1, 0, 0, 0, 0);
      }

      if(var8 != 0L) {
         if(var7) {
            var14.setViewVisibility(R.id.chronometer, 0);
            var14.setLong(R.id.chronometer, "setBase", SystemClock.elapsedRealtime() - System.currentTimeMillis() + var8);
            var14.setBoolean(R.id.chronometer, "setStarted", true);
         } else {
            var14.setViewVisibility(R.id.time, 0);
            var14.setLong(R.id.time, "setTime", var8);
         }
      }

      var10 = R.id.line3;
      byte var17;
      if(var16) {
         var17 = 0;
      } else {
         var17 = 8;
      }

      var14.setViewVisibility(var10, var17);
      return var14;
   }

   private static RemoteViews generateBigContentView(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, List var10, boolean var11, PendingIntent var12) {
      int var13 = Math.min(var10.size(), 5);
      RemoteViews var14 = applyStandardTemplate(var0, var1, var2, var3, var4, var5, var6, var7, var8, getBigLayoutResource(var13), false);
      var14.removeAllViews(R.id.media_actions);
      if(var13 > 0) {
         for(var4 = 0; var4 < var13; ++var4) {
            RemoteViews var15 = generateMediaActionButton(var0, (NotificationCompatBase.Action)var10.get(var4));
            var14.addView(R.id.media_actions, var15);
         }
      }

      if(var11) {
         var14.setViewVisibility(R.id.cancel_action, 0);
         var14.setInt(R.id.cancel_action, "setAlpha", var0.getResources().getInteger(R.integer.cancel_button_image_alpha));
         var14.setOnClickPendingIntent(R.id.cancel_action, var12);
         return var14;
      } else {
         var14.setViewVisibility(R.id.cancel_action, 8);
         return var14;
      }
   }

   private static RemoteViews generateContentView(Context var0, CharSequence var1, CharSequence var2, CharSequence var3, int var4, Bitmap var5, CharSequence var6, boolean var7, long var8, List var10, int[] var11, boolean var12, PendingIntent var13) {
      RemoteViews var16 = applyStandardTemplate(var0, var1, var2, var3, var4, var5, var6, var7, var8, R.layout.notification_template_media, true);
      int var15 = var10.size();
      if(var11 == null) {
         var4 = 0;
      } else {
         var4 = Math.min(var11.length, 3);
      }

      var16.removeAllViews(R.id.media_actions);
      if(var4 > 0) {
         for(int var14 = 0; var14 < var4; ++var14) {
            if(var14 >= var15) {
               throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(var14), Integer.valueOf(var15 - 1)}));
            }

            RemoteViews var17 = generateMediaActionButton(var0, (NotificationCompatBase.Action)var10.get(var11[var14]));
            var16.addView(R.id.media_actions, var17);
         }
      }

      if(var12) {
         var16.setViewVisibility(R.id.end_padder, 8);
         var16.setViewVisibility(R.id.cancel_action, 0);
         var16.setOnClickPendingIntent(R.id.cancel_action, var13);
         var16.setInt(R.id.cancel_action, "setAlpha", var0.getResources().getInteger(R.integer.cancel_button_image_alpha));
         return var16;
      } else {
         var16.setViewVisibility(R.id.end_padder, 0);
         var16.setViewVisibility(R.id.cancel_action, 8);
         return var16;
      }
   }

   private static RemoteViews generateMediaActionButton(Context var0, NotificationCompatBase.Action var1) {
      boolean var2;
      if(var1.getActionIntent() == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      RemoteViews var3 = new RemoteViews(var0.getPackageName(), R.layout.notification_media_action);
      var3.setImageViewResource(R.id.action0, var1.getIcon());
      if(!var2) {
         var3.setOnClickPendingIntent(R.id.action0, var1.getActionIntent());
      }

      if(VERSION.SDK_INT >= 15) {
         var3.setContentDescription(R.id.action0, var1.getTitle());
      }

      return var3;
   }

   private static int getBigLayoutResource(int var0) {
      return var0 <= 3?R.layout.notification_template_big_media_narrow:R.layout.notification_template_big_media;
   }

   public static void overrideBigContentView(Notification var0, Context var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, Bitmap var6, CharSequence var7, boolean var8, long var9, List var11, boolean var12, PendingIntent var13) {
      var0.bigContentView = generateBigContentView(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13);
      if(var12) {
         var0.flags |= 2;
      }

   }

   public static void overrideContentView(NotificationBuilderWithBuilderAccessor var0, Context var1, CharSequence var2, CharSequence var3, CharSequence var4, int var5, Bitmap var6, CharSequence var7, boolean var8, long var9, List var11, int[] var12, boolean var13, PendingIntent var14) {
      RemoteViews var15 = generateContentView(var1, var2, var3, var4, var5, var6, var7, var8, var9, var11, var12, var13, var14);
      var0.getBuilder().setContent(var15);
      if(var13) {
         var0.getBuilder().setOngoing(true);
      }

   }
}
