package android.support.v4.app;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$Style;

public class NotificationCompat$BigPictureStyle extends NotificationCompat$Style {
   Bitmap mBigLargeIcon;
   boolean mBigLargeIconSet;
   Bitmap mPicture;

   public NotificationCompat$BigPictureStyle() {
   }

   public NotificationCompat$BigPictureStyle(NotificationCompat$Builder var1) {
      this.setBuilder(var1);
   }

   public NotificationCompat$BigPictureStyle bigLargeIcon(Bitmap var1) {
      this.mBigLargeIcon = var1;
      this.mBigLargeIconSet = true;
      return this;
   }

   public NotificationCompat$BigPictureStyle bigPicture(Bitmap var1) {
      this.mPicture = var1;
      return this;
   }

   public NotificationCompat$BigPictureStyle setBigContentTitle(CharSequence var1) {
      this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$BigPictureStyle setSummaryText(CharSequence var1) {
      this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(var1);
      this.mSummaryTextSet = true;
      return this;
   }
}
