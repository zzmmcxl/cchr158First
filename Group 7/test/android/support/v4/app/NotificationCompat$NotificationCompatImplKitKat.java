package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImplJellybean;
import android.support.v4.app.NotificationCompatKitKat;
import android.support.v4.app.NotificationCompatKitKat$Builder;
import android.support.v4.app.RemoteInput;

class NotificationCompat$NotificationCompatImplKitKat extends NotificationCompat$NotificationCompatImplJellybean {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      NotificationCompatKitKat$Builder var3 = new NotificationCompatKitKat$Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mShowWhen, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mPeople, var1.mExtras, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
      NotificationCompat.access$000(var3, var1.mActions);
      NotificationCompat.access$100(var3, var1.mStyle);
      return var2.build(var1, var3);
   }

   public NotificationCompat$Action getAction(Notification var1, int var2) {
      return (NotificationCompat$Action)NotificationCompatKitKat.getAction(var1, var2, NotificationCompat$Action.FACTORY, RemoteInput.FACTORY);
   }

   public int getActionCount(Notification var1) {
      return NotificationCompatKitKat.getActionCount(var1);
   }

   public Bundle getExtras(Notification var1) {
      return NotificationCompatKitKat.getExtras(var1);
   }

   public String getGroup(Notification var1) {
      return NotificationCompatKitKat.getGroup(var1);
   }

   public boolean getLocalOnly(Notification var1) {
      return NotificationCompatKitKat.getLocalOnly(var1);
   }

   public String getSortKey(Notification var1) {
      return NotificationCompatKitKat.getSortKey(var1);
   }

   public boolean isGroupSummary(Notification var1) {
      return NotificationCompatKitKat.isGroupSummary(var1);
   }
}
