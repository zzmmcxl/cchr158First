package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

interface NavUtils$NavUtilsImpl {
   Intent getParentActivityIntent(Activity var1);

   String getParentActivityName(Context var1, ActivityInfo var2);

   void navigateUpTo(Activity var1, Intent var2);

   boolean shouldUpRecreateTask(Activity var1, Intent var2);
}
