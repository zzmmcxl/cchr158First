package android.support.v4.app;

import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$Style;

public class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
   CharSequence mBigText;

   public NotificationCompat$BigTextStyle() {
   }

   public NotificationCompat$BigTextStyle(NotificationCompat$Builder var1) {
      this.setBuilder(var1);
   }

   public NotificationCompat$BigTextStyle bigText(CharSequence var1) {
      this.mBigText = NotificationCompat$Builder.limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$BigTextStyle setBigContentTitle(CharSequence var1) {
      this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$BigTextStyle setSummaryText(CharSequence var1) {
      this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(var1);
      this.mSummaryTextSet = true;
      return this;
   }
}
