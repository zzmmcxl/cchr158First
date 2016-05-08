package android.support.v4.app;

import android.app.Notification;
import android.support.v4.app.NotificationCompat$Builder;

public abstract class NotificationCompat$Style {
   CharSequence mBigContentTitle;
   NotificationCompat$Builder mBuilder;
   CharSequence mSummaryText;
   boolean mSummaryTextSet = false;

   public Notification build() {
      Notification var1 = null;
      if(this.mBuilder != null) {
         var1 = this.mBuilder.build();
      }

      return var1;
   }

   public void setBuilder(NotificationCompat$Builder var1) {
      if(this.mBuilder != var1) {
         this.mBuilder = var1;
         if(this.mBuilder != null) {
            this.mBuilder.setStyle(this);
         }
      }

   }
}
