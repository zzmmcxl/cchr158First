package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.graphics.BitmapCompat$BaseBitmapImpl;
import android.support.v4.graphics.BitmapCompat$BitmapImpl;
import android.support.v4.graphics.BitmapCompat$HcMr1BitmapCompatImpl;
import android.support.v4.graphics.BitmapCompat$JbMr2BitmapCompatImpl;
import android.support.v4.graphics.BitmapCompat$KitKatBitmapCompatImpl;

public final class BitmapCompat {
   static final BitmapCompat$BitmapImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 19) {
         IMPL = new BitmapCompat$KitKatBitmapCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new BitmapCompat$JbMr2BitmapCompatImpl();
      } else if(var0 >= 12) {
         IMPL = new BitmapCompat$HcMr1BitmapCompatImpl();
      } else {
         IMPL = new BitmapCompat$BaseBitmapImpl();
      }
   }

   public static int getAllocationByteCount(Bitmap var0) {
      return IMPL.getAllocationByteCount(var0);
   }

   public static boolean hasMipMap(Bitmap var0) {
      return IMPL.hasMipMap(var0);
   }

   public static void setHasMipMap(Bitmap var0, boolean var1) {
      IMPL.setHasMipMap(var0, var1);
   }
}
