package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl;

class TaskStackBuilder$TaskStackBuilderImplBase implements TaskStackBuilder$TaskStackBuilderImpl {
   public PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
      Intent var6 = new Intent(var2[var2.length - 1]);
      var6.addFlags(268435456);
      return PendingIntent.getActivity(var1, var3, var6, var4);
   }
}
