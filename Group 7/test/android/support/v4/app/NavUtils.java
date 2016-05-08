package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils$NavUtilsImpl;
import android.support.v4.app.NavUtils$NavUtilsImplBase;
import android.support.v4.app.NavUtils$NavUtilsImplJB;
import android.support.v4.content.IntentCompat;

public final class NavUtils {
   private static final NavUtils$NavUtilsImpl IMPL;
   public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
   private static final String TAG = "NavUtils";

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new NavUtils$NavUtilsImplJB();
      } else {
         IMPL = new NavUtils$NavUtilsImplBase();
      }
   }

   public static Intent getParentActivityIntent(Activity var0) {
      return IMPL.getParentActivityIntent(var0);
   }

   public static Intent getParentActivityIntent(Context var0, ComponentName var1) throws NameNotFoundException {
      String var2 = getParentActivityName(var0, var1);
      if(var2 == null) {
         return null;
      } else {
         var1 = new ComponentName(var1.getPackageName(), var2);
         return getParentActivityName(var0, var1) == null?IntentCompat.makeMainActivity(var1):(new Intent()).setComponent(var1);
      }
   }

   public static Intent getParentActivityIntent(Context var0, Class<?> var1) throws NameNotFoundException {
      String var2 = getParentActivityName(var0, new ComponentName(var0, var1));
      if(var2 == null) {
         return null;
      } else {
         ComponentName var3 = new ComponentName(var0, var2);
         return getParentActivityName(var0, var3) == null?IntentCompat.makeMainActivity(var3):(new Intent()).setComponent(var3);
      }
   }

   @Nullable
   public static String getParentActivityName(Activity var0) {
      try {
         String var2 = getParentActivityName(var0, var0.getComponentName());
         return var2;
      } catch (NameNotFoundException var1) {
         throw new IllegalArgumentException(var1);
      }
   }

   @Nullable
   public static String getParentActivityName(Context var0, ComponentName var1) throws NameNotFoundException {
      ActivityInfo var2 = var0.getPackageManager().getActivityInfo(var1, 128);
      return IMPL.getParentActivityName(var0, var2);
   }

   public static void navigateUpFromSameTask(Activity var0) {
      Intent var1 = getParentActivityIntent(var0);
      if(var1 == null) {
         throw new IllegalArgumentException("Activity " + var0.getClass().getSimpleName() + " does not have a parent activity name specified." + " (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data> " + " element in your manifest?)");
      } else {
         navigateUpTo(var0, var1);
      }
   }

   public static void navigateUpTo(Activity var0, Intent var1) {
      IMPL.navigateUpTo(var0, var1);
   }

   public static boolean shouldUpRecreateTask(Activity var0, Intent var1) {
      return IMPL.shouldUpRecreateTask(var0, var1);
   }
}
