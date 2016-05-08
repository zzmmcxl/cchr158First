package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat$1;
import android.support.v4.app.ActivityCompat$OnRequestPermissionsResultCallback;
import android.support.v4.app.ActivityCompat$SharedElementCallback21Impl;
import android.support.v4.app.ActivityCompat21;
import android.support.v4.app.ActivityCompat21$SharedElementCallback21;
import android.support.v4.app.ActivityCompat22;
import android.support.v4.app.ActivityCompatApi23;
import android.support.v4.app.ActivityCompatHoneycomb;
import android.support.v4.app.ActivityCompatJB;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.ContextCompat;

public class ActivityCompat extends ContextCompat {
   private static ActivityCompat21$SharedElementCallback21 createCallback(SharedElementCallback var0) {
      ActivityCompat$SharedElementCallback21Impl var1 = null;
      if(var0 != null) {
         var1 = new ActivityCompat$SharedElementCallback21Impl(var0);
      }

      return var1;
   }

   public static void finishAffinity(Activity var0) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.finishAffinity(var0);
      } else {
         var0.finish();
      }
   }

   public static void finishAfterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.finishAfterTransition(var0);
      } else {
         var0.finish();
      }
   }

   public static boolean invalidateOptionsMenu(Activity var0) {
      if(VERSION.SDK_INT >= 11) {
         ActivityCompatHoneycomb.invalidateOptionsMenu(var0);
         return true;
      } else {
         return false;
      }
   }

   public static void postponeEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.postponeEnterTransition(var0);
      }

   }

   public static void requestPermissions(@NonNull Activity var0, @NonNull String[] var1, int var2) {
      if(VERSION.SDK_INT >= 23) {
         ActivityCompatApi23.requestPermissions(var0, var1, var2);
      } else if(var0 instanceof ActivityCompat$OnRequestPermissionsResultCallback) {
         (new Handler(Looper.getMainLooper())).post(new ActivityCompat$1(var1, var0, var2));
         return;
      }

   }

   public static void setEnterSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setEnterSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static void setExitSharedElementCallback(Activity var0, SharedElementCallback var1) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.setExitSharedElementCallback(var0, createCallback(var1));
      }

   }

   public static boolean shouldShowRequestPermissionRationale(@NonNull Activity var0, @NonNull String var1) {
      return VERSION.SDK_INT >= 23?ActivityCompatApi23.shouldShowRequestPermissionRationale(var0, var1):false;
   }

   public static void startActivity(Activity var0, Intent var1, @Nullable Bundle var2) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivity(var0, var1, var2);
      } else {
         var0.startActivity(var1);
      }
   }

   public static void startActivityForResult(Activity var0, Intent var1, int var2, @Nullable Bundle var3) {
      if(VERSION.SDK_INT >= 16) {
         ActivityCompatJB.startActivityForResult(var0, var1, var2, var3);
      } else {
         var0.startActivityForResult(var1, var2);
      }
   }

   public static void startPostponedEnterTransition(Activity var0) {
      if(VERSION.SDK_INT >= 21) {
         ActivityCompat21.startPostponedEnterTransition(var0);
      }

   }

   public Uri getReferrer(Activity var1) {
      Uri var4;
      if(VERSION.SDK_INT >= 22) {
         var4 = ActivityCompat22.getReferrer(var1);
      } else {
         Intent var3 = var1.getIntent();
         Uri var2 = (Uri)var3.getParcelableExtra("android.intent.extra.REFERRER");
         var4 = var2;
         if(var2 == null) {
            String var5 = var3.getStringExtra("android.intent.extra.REFERRER_NAME");
            if(var5 != null) {
               return Uri.parse(var5);
            }

            return null;
         }
      }

      return var4;
   }
}
