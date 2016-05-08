package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.os.Build.VERSION;
import android.support.v4.app.ShareCompat$IntentBuilder;
import android.support.v4.app.ShareCompat$ShareCompatImpl;
import android.support.v4.app.ShareCompat$ShareCompatImplBase;
import android.support.v4.app.ShareCompat$ShareCompatImplICS;
import android.support.v4.app.ShareCompat$ShareCompatImplJB;
import android.view.Menu;
import android.view.MenuItem;

public final class ShareCompat {
   public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
   public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
   private static ShareCompat$ShareCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 16) {
         IMPL = new ShareCompat$ShareCompatImplJB();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new ShareCompat$ShareCompatImplICS();
      } else {
         IMPL = new ShareCompat$ShareCompatImplBase();
      }
   }

   public static void configureMenuItem(Menu var0, int var1, ShareCompat$IntentBuilder var2) {
      MenuItem var3 = var0.findItem(var1);
      if(var3 == null) {
         throw new IllegalArgumentException("Could not find menu item with id " + var1 + " in the supplied menu");
      } else {
         configureMenuItem(var3, var2);
      }
   }

   public static void configureMenuItem(MenuItem var0, ShareCompat$IntentBuilder var1) {
      IMPL.configureMenuItem(var0, var1);
   }

   public static ComponentName getCallingActivity(Activity var0) {
      ComponentName var2 = var0.getCallingActivity();
      ComponentName var1 = var2;
      if(var2 == null) {
         var1 = (ComponentName)var0.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
      }

      return var1;
   }

   public static String getCallingPackage(Activity var0) {
      String var2 = var0.getCallingPackage();
      String var1 = var2;
      if(var2 == null) {
         var1 = var0.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
      }

      return var1;
   }
}
