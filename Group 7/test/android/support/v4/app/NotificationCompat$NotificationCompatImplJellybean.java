package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompatJellybean;
import android.support.v4.app.NotificationCompatJellybean$Builder;
import android.support.v4.app.RemoteInput;
import java.util.ArrayList;

class NotificationCompat$NotificationCompatImplJellybean extends NotificationCompat$NotificationCompatImplBase {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      NotificationCompatJellybean$Builder var3 = new NotificationCompatJellybean$Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate, var1.mUseChronometer, var1.mPriority, var1.mSubText, var1.mLocalOnly, var1.mExtras, var1.mGroupKey, var1.mGroupSummary, var1.mSortKey);
      NotificationCompat.access$000(var3, var1.mActions);
      NotificationCompat.access$100(var3, var1.mStyle);
      return var2.build(var1, var3);
   }

   public NotificationCompat$Action getAction(Notification var1, int var2) {
      return (NotificationCompat$Action)NotificationCompatJellybean.getAction(var1, var2, NotificationCompat$Action.FACTORY, RemoteInput.FACTORY);
   }

   public int getActionCount(Notification var1) {
      return NotificationCompatJellybean.getActionCount(var1);
   }

   public NotificationCompat$Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1) {
      return (NotificationCompat$Action[])((NotificationCompat$Action[])NotificationCompatJellybean.getActionsFromParcelableArrayList(var1, NotificationCompat$Action.FACTORY, RemoteInput.FACTORY));
   }

   public Bundle getExtras(Notification var1) {
      return NotificationCompatJellybean.getExtras(var1);
   }

   public String getGroup(Notification var1) {
      return NotificationCompatJellybean.getGroup(var1);
   }

   public boolean getLocalOnly(Notification var1) {
      return NotificationCompatJellybean.getLocalOnly(var1);
   }

   public ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat$Action[] var1) {
      return NotificationCompatJellybean.getParcelableArrayListForActions(var1);
   }

   public String getSortKey(Notification var1) {
      return NotificationCompatJellybean.getSortKey(var1);
   }

   public boolean isGroupSummary(Notification var1) {
      return NotificationCompatJellybean.isGroupSummary(var1);
   }
}
