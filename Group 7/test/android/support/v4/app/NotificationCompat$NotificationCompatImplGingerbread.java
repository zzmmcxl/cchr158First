package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompat$NotificationCompatImplBase;
import android.support.v4.app.NotificationCompatGingerbread;

class NotificationCompat$NotificationCompatImplGingerbread extends NotificationCompat$NotificationCompatImplBase {
   public Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2) {
      Notification var3 = NotificationCompatGingerbread.add(var1.mNotification, var1.mContext, var1.mContentTitle, var1.mContentText, var1.mContentIntent, var1.mFullScreenIntent);
      if(var1.mPriority > 0) {
         var3.flags |= 128;
      }

      return var3;
   }
}
