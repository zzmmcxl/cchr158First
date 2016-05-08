package android.support.v4.app;

import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$Style;
import java.util.ArrayList;

public class NotificationCompat$InboxStyle extends NotificationCompat$Style {
   ArrayList<CharSequence> mTexts = new ArrayList();

   public NotificationCompat$InboxStyle() {
   }

   public NotificationCompat$InboxStyle(NotificationCompat$Builder var1) {
      this.setBuilder(var1);
   }

   public NotificationCompat$InboxStyle addLine(CharSequence var1) {
      this.mTexts.add(NotificationCompat$Builder.limitCharSequenceLength(var1));
      return this;
   }

   public NotificationCompat$InboxStyle setBigContentTitle(CharSequence var1) {
      this.mBigContentTitle = NotificationCompat$Builder.limitCharSequenceLength(var1);
      return this;
   }

   public NotificationCompat$InboxStyle setSummaryText(CharSequence var1) {
      this.mSummaryText = NotificationCompat$Builder.limitCharSequenceLength(var1);
      this.mSummaryTextSet = true;
      return this;
   }
}
