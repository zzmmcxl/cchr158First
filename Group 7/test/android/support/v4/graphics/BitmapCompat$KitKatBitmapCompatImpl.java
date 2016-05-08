package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat$JbMr2BitmapCompatImpl;
import android.support.v4.graphics.BitmapCompatKitKat;

class BitmapCompat$KitKatBitmapCompatImpl extends BitmapCompat$JbMr2BitmapCompatImpl {
   public int getAllocationByteCount(Bitmap var1) {
      return BitmapCompatKitKat.getAllocationByteCount(var1);
   }
}
