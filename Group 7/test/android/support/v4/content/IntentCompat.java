package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.content.IntentCompat$IntentCompatImpl;
import android.support.v4.content.IntentCompat$IntentCompatImplBase;
import android.support.v4.content.IntentCompat$IntentCompatImplHC;
import android.support.v4.content.IntentCompat$IntentCompatImplIcsMr1;

public final class IntentCompat {
   public static final String ACTION_EXTERNAL_APPLICATIONS_AVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE";
   public static final String ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE = "android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE";
   public static final String EXTRA_CHANGED_PACKAGE_LIST = "android.intent.extra.changed_package_list";
   public static final String EXTRA_CHANGED_UID_LIST = "android.intent.extra.changed_uid_list";
   public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
   public static final int FLAG_ACTIVITY_CLEAR_TASK = 32768;
   public static final int FLAG_ACTIVITY_TASK_ON_HOME = 16384;
   private static final IntentCompat$IntentCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 15) {
         IMPL = new IntentCompat$IntentCompatImplIcsMr1();
      } else if(var0 >= 11) {
         IMPL = new IntentCompat$IntentCompatImplHC();
      } else {
         IMPL = new IntentCompat$IntentCompatImplBase();
      }
   }

   public static Intent makeMainActivity(ComponentName var0) {
      return IMPL.makeMainActivity(var0);
   }

   public static Intent makeMainSelectorActivity(String var0, String var1) {
      return IMPL.makeMainSelectorActivity(var0, var1);
   }

   public static Intent makeRestartActivityTask(ComponentName var0) {
      return IMPL.makeRestartActivityTask(var0);
   }
}
