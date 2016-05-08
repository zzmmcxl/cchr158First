package android.support.v7.app;

import android.app.Notification;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat$Style;
import android.support.v7.app.NotificationCompat$MediaStyle;
import android.support.v7.app.NotificationCompatImpl21;
import android.support.v7.app.NotificationCompatImplBase;

public class NotificationCompat extends android.support.v4.app.NotificationCompat {
   private static void addBigMediaStyleToBuilderJellybean(Notification var0, android.support.v4.app.NotificationCompat$Builder var1) {
      if(var1.mStyle instanceof NotificationCompat$MediaStyle) {
         NotificationCompat$MediaStyle var2 = (NotificationCompat$MediaStyle)var1.mStyle;
         NotificationCompatImplBase.overrideBigContentView(var0, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mNumber, var1.mLargeIcon, var1.mSubText, var1.mUseChronometer, var1.mNotification.when, var1.mActions, var2.mShowCancelButton, var2.mCancelButtonIntent);
      }

   }

   private static void addMediaStyleToBuilderIcs(NotificationBuilderWithBuilderAccessor var0, android.support.v4.app.NotificationCompat$Builder var1) {
      if(var1.mStyle instanceof NotificationCompat$MediaStyle) {
         NotificationCompat$MediaStyle var2 = (NotificationCompat$MediaStyle)var1.mStyle;
         NotificationCompatImplBase.overrideContentView(var0, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mNumber, var1.mLargeIcon, var1.mSubText, var1.mUseChronometer, var1.mNotification.when, var1.mActions, var2.mActionsToShowInCompact, var2.mShowCancelButton, var2.mCancelButtonIntent);
      }

   }

   private static void addMediaStyleToBuilderLollipop(NotificationBuilderWithBuilderAccessor var0, NotificationCompat$Style var1) {
      if(var1 instanceof NotificationCompat$MediaStyle) {
         NotificationCompat$MediaStyle var3 = (NotificationCompat$MediaStyle)var1;
         int[] var2 = var3.mActionsToShowInCompact;
         Object var4;
         if(var3.mToken != null) {
            var4 = var3.mToken.getToken();
         } else {
            var4 = null;
         }

         NotificationCompatImpl21.addMediaStyle(var0, var2, var4);
      }

   }
}
