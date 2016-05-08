package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput;

public abstract class NotificationCompatBase$UnreadConversation {
   abstract long getLatestTimestamp();

   abstract String[] getMessages();

   abstract String getParticipant();

   abstract String[] getParticipants();

   abstract PendingIntent getReadPendingIntent();

   abstract RemoteInputCompatBase$RemoteInput getRemoteInput();

   abstract PendingIntent getReplyPendingIntent();
}
