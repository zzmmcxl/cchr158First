package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImpl;
import android.support.v4.app.NotificationCompatBase;
import android.support.v4.app.NotificationCompatBase$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;
import java.util.ArrayList;

class NotificationCompat$NotificationCompatImplBase implements NotificationCompat$NotificationCompatImpl {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      Notification var3 = NotificationCompatBase.add(var1.mNotification, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent);
      if(var1.mPriority > 0) {
         var3.flags |= 128;
      }

      return var3;
   }

   public NotificationCompat$Action getAction(Notification var1, int var2) {
      return null;
   }

   public int getActionCount(Notification var1) {
      return 0;
   }

   public NotificationCompat$Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1) {
      return null;
   }

   public Bundle getBundleForUnreadConversation(NotificationCompatBase$UnreadConversation var1) {
      return null;
   }

   public String getCategory(Notification var1) {
      return null;
   }

   public Bundle getExtras(Notification var1) {
      return null;
   }

   public String getGroup(Notification var1) {
      return null;
   }

   public boolean getLocalOnly(Notification var1) {
      return false;
   }

   public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat$Action[] var1) {
      return null;
   }

   public String getSortKey(Notification var1) {
      return null;
   }

   public NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase$UnreadConversation$Factory var2, RemoteInputCompatBase$RemoteInput$Factory var3) {
      return null;
   }

   public boolean isGroupSummary(Notification var1) {
      return false;
   }
}
