package android.support.v4.app;

import android.content.ComponentName;
import android.os.IBinder;

class NotificationManagerCompat$ServiceConnectedEvent {
   final ComponentName componentName;
   final IBinder iBinder;

   public NotificationManagerCompat$ServiceConnectedEvent(ComponentName var1, IBinder var2) {
      this.componentName = var1;
      this.iBinder = var2;
   }
}
