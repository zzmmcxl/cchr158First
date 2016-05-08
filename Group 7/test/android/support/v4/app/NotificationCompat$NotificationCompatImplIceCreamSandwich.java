package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompatIceCreamSandwich$Builder;

class NotificationCompat$NotificationCompatImplIceCreamSandwich extends NotificationCompat$NotificationCompatImplBase {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      return var2.build(var1, new NotificationCompatIceCreamSandwich$Builder(var1.mContext, var1.mNotification, var1.mContentTitle, var1.mContentText, var1.mContentInfo, var1.mTickerView, var1.mNumber, var1.mContentIntent, var1.mFullScreenIntent, var1.mLargeIcon, var1.mProgressMax, var1.mProgress, var1.mProgressIndeterminate));
   }
}
