package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation;
import android.support.v4.app.RemoteInput;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$CarExtender$UnreadConversation$Builder {
   private long mLatestTimestamp;
   private final List<String> mMessages = new ArrayList();
   private final String mParticipant;
   private PendingIntent mReadPendingIntent;
   private RemoteInput mRemoteInput;
   private PendingIntent mReplyPendingIntent;

   public NotificationCompat$CarExtender$UnreadConversation$Builder(String var1) {
      this.mParticipant = var1;
   }

   public NotificationCompat$CarExtender$UnreadConversation$Builder addMessage(String var1) {
      this.mMessages.add(var1);
      return this;
   }

   public NotificationCompat$CarExtender$UnreadConversation build() {
      String[] var3 = (String[])this.mMessages.toArray(new String[this.mMessages.size()]);
      String var4 = this.mParticipant;
      RemoteInput var5 = this.mRemoteInput;
      PendingIntent var6 = this.mReplyPendingIntent;
      PendingIntent var7 = this.mReadPendingIntent;
      long var1 = this.mLatestTimestamp;
      return new NotificationCompat$CarExtender$UnreadConversation(var3, var5, var6, var7, new String[]{var4}, var1);
   }

   public NotificationCompat$CarExtender$UnreadConversation$Builder setLatestTimestamp(long var1) {
      this.mLatestTimestamp = var1;
      return this;
   }

   public NotificationCompat$CarExtender$UnreadConversation$Builder setReadPendingIntent(PendingIntent var1) {
      this.mReadPendingIntent = var1;
      return this;
   }

   public NotificationCompat$CarExtender$UnreadConversation$Builder setReplyAction(PendingIntent var1, RemoteInput var2) {
      this.mRemoteInput = var2;
      this.mReplyPendingIntent = var1;
      return this;
   }
}
