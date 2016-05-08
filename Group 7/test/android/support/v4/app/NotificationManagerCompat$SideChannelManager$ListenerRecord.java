package android.support.v4.app;

import android.content.ComponentName;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.NotificationManagerCompat$Task;
import java.util.LinkedList;

class NotificationManagerCompat$SideChannelManager$ListenerRecord {
   public boolean bound = false;
   public final ComponentName componentName;
   public int retryCount = 0;
   public INotificationSideChannel service;
   public LinkedList<NotificationManagerCompat$Task> taskQueue = new LinkedList();

   public NotificationManagerCompat$SideChannelManager$ListenerRecord(ComponentName var1) {
      this.componentName = var1;
   }
}
