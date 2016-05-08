package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat$Action;
import android.support.v4.app.NotificationCompat$Builder;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v4.app.NotificationCompatBase$UnreadConversation;
import android.support.v4.app.NotificationCompatBase$UnreadConversation$Factory;
import android.support.v4.app.RemoteInputCompatBase$RemoteInput$Factory;
import java.util.ArrayList;

interface NotificationCompat$NotificationCompatImpl {
   Notification build(NotificationCompat$Builder var1, NotificationCompat$BuilderExtender var2);

   NotificationCompat$Action getAction(Notification var1, int var2);

   int getActionCount(Notification var1);

   NotificationCompat$Action[] getActionsFromParcelableArrayList(ArrayList<Parcelable> var1);

   Bundle getBundleForUnreadConversation(NotificationCompatBase$UnreadConversation var1);

   String getCategory(Notification var1);

   Bundle getExtras(Notification var1);

   String getGroup(Notification var1);

   boolean getLocalOnly(Notification var1);

   ArrayList<Parcelable> getParcelableArrayListForActions(NotificationCompat$Action[] var1);

   String getSortKey(Notification var1);

   NotificationCompatBase$UnreadConversation getUnreadConversationFromBundle(Bundle var1, NotificationCompatBase$UnreadConversation$Factory var2, RemoteInputCompatBase$RemoteInput$Factory var3);

   boolean isGroupSummary(Notification var1);
}
