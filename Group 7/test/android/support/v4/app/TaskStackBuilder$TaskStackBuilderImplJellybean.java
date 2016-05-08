package android.support.v4.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder$TaskStackBuilderImpl;
import android.support.v4.app.TaskStackBuilderJellybean;

class TaskStackBuilder$TaskStackBuilderImplJellybean implements TaskStackBuilder$TaskStackBuilderImpl {
   public PendingIntent getPendingIntent(Context var1, Intent[] var2, int var3, int var4, Bundle var5) {
      var2[0] = (new Intent(var2[0])).addFlags(268484608);
      return TaskStackBuilderJellybean.getActivitiesPendingIntent(var1, var3, var2, var4, var5);
   }
}
