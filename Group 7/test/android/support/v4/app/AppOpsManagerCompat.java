package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.AppOpsManagerCompat$1;
import android.support.v4.app.AppOpsManagerCompat$AppOpsManager23;
import android.support.v4.app.AppOpsManagerCompat$AppOpsManagerImpl;

public final class AppOpsManagerCompat {
   private static final AppOpsManagerCompat$AppOpsManagerImpl IMPL;
   public static final int MODE_ALLOWED = 0;
   public static final int MODE_DEFAULT = 3;
   public static final int MODE_IGNORED = 1;

   static {
      if(VERSION.SDK_INT >= 23) {
         IMPL = new AppOpsManagerCompat$AppOpsManager23((AppOpsManagerCompat$1)null);
      } else {
         IMPL = new AppOpsManagerCompat$AppOpsManagerImpl((AppOpsManagerCompat$1)null);
      }
   }

   public static int noteOp(@NonNull Context var0, @NonNull String var1, int var2, @NonNull String var3) {
      return IMPL.noteOp(var0, var1, var2, var3);
   }

   public static int noteProxyOp(@NonNull Context var0, @NonNull String var1, @NonNull String var2) {
      return IMPL.noteProxyOp(var0, var1, var2);
   }

   public static String permissionToOp(@NonNull String var0) {
      return IMPL.permissionToOp(var0);
   }
}
