package android.support.v4.app;

import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.NotificationManagerCompat$Task;

class NotificationManagerCompat$CancelTask implements NotificationManagerCompat$Task {
   final boolean all;
   final int id;
   final String packageName;
   final String tag;

   public NotificationManagerCompat$CancelTask(String var1) {
      this.packageName = var1;
      this.id = 0;
      this.tag = null;
      this.all = true;
   }

   public NotificationManagerCompat$CancelTask(String var1, int var2, String var3) {
      this.packageName = var1;
      this.id = var2;
      this.tag = var3;
      this.all = false;
   }

   public void send(INotificationSideChannel var1) throws RemoteException {
      if(this.all) {
         var1.cancelAll(this.packageName);
      } else {
         var1.cancel(this.packageName, this.id, this.tag);
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("CancelTask[");
      var1.append("packageName:").append(this.packageName);
      var1.append(", id:").append(this.id);
      var1.append(", tag:").append(this.tag);
      var1.append(", all:").append(this.all);
      var1.append("]");
      return var1.toString();
   }
}
