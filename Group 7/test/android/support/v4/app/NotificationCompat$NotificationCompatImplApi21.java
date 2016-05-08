package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImplApi20;
import android.support.v4.app.NotificationCompatApi21;
import android.support.v4.app.NotificationCompatApi21$Builder;
import android.support.v4.app.NotificationCompatBase$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;

class NotificationCompat$NotificationCompatImplApi21 extends NotificationCompat$NotificationCompatImplApi20 {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      NotificationCompatApi21$Builder var3 = new NotificationCompatApi21$Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mShowWhen, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mCategory, var1.mPeople, var1.mExtras, var1.mColor, var1.mVisibility, var1.mPublicVersion, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
      NotificationCompat.access$000(var3, var1.mActions);
      NotificationCompat.access$100(var3, var1.mStyle);
      return var2.build(var1, var3);
   }

   public Bundle getBundleForUnreadConversation(NotificationCompatBase$UnreadConversation var1) {
      return NotificationCompatApi21.getBundleForUnreadConversation(var1);
   }

   public String getCategory(Notification var1) {
      return NotificationCompatApi21.getCategory(var1);
   }

   public NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase$UnreadConversation$Factory var2, RemoteInputCompatBase$RemoteInput$Factory var3) {
      return NotificationCompatApi21.getUnreadConversationFromBundle(var1, var2, var3);
   }
}
