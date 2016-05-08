package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat$CarExtender$UnreadConversation$1;
import android.support.v4.app.NotificationCompatBase$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInput;

public class NotificationCompat$CarExtender$UnreadConversation extends NotificationCompatBase$UnreadConversation {
   static final NotificationCompatBase$UnreadConversation$Factory FACTORY = new NotificationCompat$CarExtender$UnreadConversation$1();
   private final long mLatestTimestamp;
   private final String[] mMessages;
   private final String[] mParticipants;
   private final PendingIntent mReadPendingIntent;
   private final RemoteInput mRemoteInput;
   private final PendingIntent mReplyPendingIntent;

   NotificationCompat$CarExtender$UnreadConversation(String[] var1, RemoteInput var2, PendingIntent var3, PendingIntent var4, String[] var5, long var6) {
      this.mMessages = var1;
      this.mRemoteInput = var2;
      this.mReadPendingIntent = var4;
      this.mReplyPendingIntent = var3;
      this.mParticipants = var5;
      this.mLatestTimestamp = var6;
   }

   public long getLatestTimestamp() {
      return this.mLatestTimestamp;
   }

   public String[] getMessages() {
      return this.mMessages;
   }

   public String getParticipant() {
      return this.mParticipants.length > 0?this.mParticipants[0]:null;
   }

   public String[] getParticipants() {
      return this.mParticipants;
   }

   public PendingIntent getReadPendingIntent() {
      return this.mReadPendingIntent;
   }

   public RemoteInput getRemoteInput() {
      return this.mRemoteInput;
   }

   public PendingIntent getReplyPendingIntent() {
      return this.mReplyPendingIntent;
   }
}
