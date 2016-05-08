package android.support.v4.app;

import android.app.Notification;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.NotificationManagerCompat$Task;

class NotificationManagerCompat$NotifyTask implements NotificationManagerCompat$Task {
   final int id;
   final Notification notif;
   final String packageName;
   final String tag;

   public NotificationManagerCompat$NotifyTask(String var1, int var2, String var3, Notification var4) {
      this.packageName = var1;
      this.id = var2;
      this.tag = var3;
      this.notif = var4;
   }

   public void send(INotificationSideChannel var1) throws RemoteException {
      var1.notify(this.packageName, this.id, this.tag, this.notif);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("NotifyTask[");
      var1.append("packageName:").append(this.packageName);
      var1.append(", id:").append(this.id);
      var1.append(", tag:").append(this.tag);
      var1.append("]");
      return var1.toString();
   }
}
