package android.support.v7.app;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$Style;
import android.support.v4.media.session.MediaSessionCompat$Token;

public class NotificationCompat$MediaStyle extends NotificationCompat$Style {
   int[] mActionsToShowInCompact = null;
   PendingIntent mCancelButtonIntent;
   boolean mShowCancelButton;
   MediaSessionCompat$Token mToken;

   public NotificationCompat$MediaStyle() {
   }

   public NotificationCompat$MediaStyle(android.support.v4.app.NotificationCompat$Builder var1) {
      this.setBuilder(var1);
   }

   public NotificationCompat$MediaStyle setCancelButtonIntent(PendingIntent var1) {
      this.mCancelButtonIntent = var1;
      return this;
   }

   public NotificationCompat$MediaStyle setMediaSession(MediaSessionCompat$Token var1) {
      this.mToken = var1;
      return this;
   }

   public NotificationCompat$MediaStyle setShowActionsInCompactView(int... var1) {
      this.mActionsToShowInCompact = var1;
      return this;
   }

   public NotificationCompat$MediaStyle setShowCancelButton(boolean var1) {
      this.mShowCancelButton = var1;
      return this;
   }
}
