package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$Extender;
import android.support.v4.app.NotificationCompat$Style;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$Builder {
   private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
   public ArrayList<NotificationCompat$Action> mActions = new ArrayList();
   String mCategory;
   int mColor = 0;
   public CharSequence mContentInfo;
   PendingIntent mContentIntent;
   public CharSequence mContentText;
   public CharSequence mContentTitle;
   public Context mContext;
   Bundle mExtras;
   PendingIntent mFullScreenIntent;
   String mGroupKey;
   boolean mGroupSummary;
   public Bitmap mLargeIcon;
   boolean mLocalOnly = false;
   public Notification mNotification = new Notification();
   public int mNumber;
   public ArrayList<String> mPeople;
   int mPriority;
   int mProgress;
   boolean mProgressIndeterminate;
   int mProgressMax;
   Notification mPublicVersion;
   boolean mShowWhen = true;
   String mSortKey;
   public NotificationCompat$Style mStyle;
   public CharSequence mSubText;
   RemoteViews mTickerView;
   public boolean mUseChronometer;
   int mVisibility = 0;

   public NotificationCompat$Builder(Context var1) {
      this.mContext = var1;
      this.mNotification.when = System.currentTimeMillis();
      this.mNotification.audioStreamType = -1;
      this.mPriority = 0;
      this.mPeople = new ArrayList();
   }

   protected static CharSequence limitCharSequenceLength(CharSequence var0) {
      return var0 != null && var0.length() > 5120?var0.subSequence(0, 5120):var0;
   }

   private void setFlag(int var1, boolean var2) {
      Notification var3;
      if(var2) {
         var3 = this.mNotification;
         var3.flags |= var1;
      } else {
         var3 = this.mNotification;
         var3.flags &= ~var1;
      }
   }

   public NotificationCompat$Builder addAction(int var1, CharSequence var2, PendingIntent var3) {
      this.mActions.add(new NotificationCompat$Action(var1, var2, var3));
      return this;
   }

   public NotificationCompat$Builder addAction(NotificationCompat$Action var1) {
      this.mActions.add(var1);
      return this;
   }

   public NotificationCompat$Builder addExtras(Bundle var1) {
      if(var1 != null) {
         if(this.mExtras != null) {
            this.mExtras.putAll(var1);
            return this;
         }

         this.mExtras = new Bundle(var1);
      }

      return this;
   }

   public NotificationCompat$Builder addPerson(String var1) {
      this.mPeople.add(var1);
      return this;
   }

   public Notification build() {
      return NotificationCompat.access$200().build(this, this.getExtender());
   }

   public NotificationCompat$Builder extend(NotificationCompat$Extender var1) {
      var1.extend(this);
      return this;
   }

   protected NotificationCompat$BuilderExtender getExtender() {
      return new NotificationCompat$BuilderExtender();
   }

   public Bundle getExtras() {
      if(this.mExtras == null) {
         this.mExtras = new Bundle();
      }

      return this.mExtras;
   }

   @Deprecated
   public Notification getNotification() {
      return this.build();
   }

   public NotificationCompat$Builder setAutoCancel(boolean var1) {
      this.setFlag(16, var1);
      return this;
   }

   public NotificationCompat$Builder setCategory(String var1) {
      this.mCategory = var1;
      return this;
   }

   public NotificationCompat$Builder setColor(@ColorInt int var1) {
      this.mColor = var1;
      return this;
   }

   public NotificationCompat$Builder setContent(RemoteViews var1) {
      this.mNotification.contentView = var1;
      return this;
   }

   public NotificationCompat$Builder setContentInfo(CharSequence var1) {
      this.mContentInfo = limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$Builder setContentIntent(PendingIntent var1) {
      this.mContentIntent = var1;
      return this;
   }

   public NotificationCompat$Builder setContentText(CharSequence var1) {
      this.mContentText = limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$Builder setContentTitle(CharSequence var1) {
      this.mContentTitle = limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$Builder setDefaults(int var1) {
      this.mNotification.defaults = var1;
      if((var1 & 4) != 0) {
         Notification var2 = this.mNotification;
         var2.flags |= 1;
      }

      return this;
   }

   public NotificationCompat$Builder setDeleteIntent(PendingIntent var1) {
      this.mNotification.deleteIntent = var1;
      return this;
   }

   public NotificationCompat$Builder setExtras(Bundle var1) {
      this.mExtras = var1;
      return this;
   }

   public NotificationCompat$Builder setFullScreenIntent(PendingIntent var1, boolean var2) {
      this.mFullScreenIntent = var1;
      this.setFlag(128, var2);
      return this;
   }

   public NotificationCompat$Builder setGroup(String var1) {
      this.mGroupKey = var1;
      return this;
   }

   public NotificationCompat$Builder setGroupSummary(boolean var1) {
      this.mGroupSummary = var1;
      return this;
   }

   public NotificationCompat$Builder setLargeIcon(Bitmap var1) {
      this.mLargeIcon = var1;
      return this;
   }

   public NotificationCompat$Builder setLights(@ColorInt int var1, int var2, int var3) {
      byte var4 = 1;
      this.mNotification.ledARGB = var1;
      this.mNotification.ledOnMS = var2;
      this.mNotification.ledOffMS = var3;
      boolean var6;
      if(this.mNotification.ledOnMS != 0 && this.mNotification.ledOffMS != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      Notification var5 = this.mNotification;
      var2 = this.mNotification.flags;
      byte var7;
      if(var6) {
         var7 = var4;
      } else {
         var7 = 0;
      }

      var5.flags = var7 | var2 & -2;
      return this;
   }

   public NotificationCompat$Builder setLocalOnly(boolean var1) {
      this.mLocalOnly = var1;
      return this;
   }

   public NotificationCompat$Builder setNumber(int var1) {
      this.mNumber = var1;
      return this;
   }

   public NotificationCompat$Builder setOngoing(boolean var1) {
      this.setFlag(2, var1);
      return this;
   }

   public NotificationCompat$Builder setOnlyAlertOnce(boolean var1) {
      this.setFlag(8, var1);
      return this;
   }

   public NotificationCompat$Builder setPriority(int var1) {
      this.mPriority = var1;
      return this;
   }

   public NotificationCompat$Builder setProgress(int var1, int var2, boolean var3) {
      this.mProgressMax = var1;
      this.mProgress = var2;
      this.mProgressIndeterminate = var3;
      return this;
   }

   public NotificationCompat$Builder setPublicVersion(Notification var1) {
      this.mPublicVersion = var1;
      return this;
   }

   public NotificationCompat$Builder setShowWhen(boolean var1) {
      this.mShowWhen = var1;
      return this;
   }

   public NotificationCompat$Builder setSmallIcon(int var1) {
      this.mNotification.icon = var1;
      return this;
   }

   public NotificationCompat$Builder setSmallIcon(int var1, int var2) {
      this.mNotification.icon = var1;
      this.mNotification.iconLevel = var2;
      return this;
   }

   public NotificationCompat$Builder setSortKey(String var1) {
      this.mSortKey = var1;
      return this;
   }

   public NotificationCompat$Builder setSound(Uri var1) {
      this.mNotification.sound = var1;
      this.mNotification.audioStreamType = -1;
      return this;
   }

   public NotificationCompat$Builder setSound(Uri var1, int var2) {
      this.mNotification.sound = var1;
      this.mNotification.audioStreamType = var2;
      return this;
   }

   public NotificationCompat$Builder setStyle(NotificationCompat$Style var1) {
      if(this.mStyle != var1) {
         this.mStyle = var1;
         if(this.mStyle != null) {
            this.mStyle.setBuilder(this);
         }
      }

      return this;
   }

   public NotificationCompat$Builder setSubText(CharSequence var1) {
      this.mSubText = limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$Builder setTicker(CharSequence var1) {
      this.mNotification.tickerText = limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$Builder setTicker(CharSequence var1, RemoteViews var2) {
      this.mNotification.tickerText = limitCharSequenceLength(var1);
      this.mTickerView = var2;
      return this;
   }

   public NotificationCompat$Builder setUsesChronometer(boolean var1) {
      this.mUseChronometer = var1;
      return this;
   }

   public NotificationCompat$Builder setVibrate(long[] var1) {
      this.mNotification.vibrate = var1;
      return this;
   }

   public NotificationCompat$Builder setVisibility(int var1) {
      this.mVisibility = var1;
      return this;
   }

   public NotificationCompat$Builder setWhen(long var1) {
      this.mNotification.when = var1;
      return this;
   }
}
