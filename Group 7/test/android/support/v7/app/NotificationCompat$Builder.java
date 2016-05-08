package android.support.v7.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat$BuilderExtender;
import android.support.v7.app.NotificationCompat$1;
import android.support.v7.app.NotificationCompat$IceCreamSandwichExtender;
import android.support.v7.app.NotificationCompat$JellybeanExtender;
import android.support.v7.app.NotificationCompat$LollipopExtender;

public class NotificationCompat$Builder extends android.support.v4.app.NotificationCompat$Builder {
   public NotificationCompat$Builder(Context var1) {
      super(var1);
   }

   protected NotificationCompat$BuilderExtender getExtender() {
      return (NotificationCompat$BuilderExtender)(VERSION.SDK_INT >= 21?new NotificationCompat$LollipopExtender((NotificationCompat$1)null):(VERSION.SDK_INT >= 16?new NotificationCompat$JellybeanExtender((NotificationCompat$1)null):(VERSION.SDK_INT >= 14?new NotificationCompat$IceCreamSandwichExtender((NotificationCompat$1)null):super.getExtender())));
   }
}
