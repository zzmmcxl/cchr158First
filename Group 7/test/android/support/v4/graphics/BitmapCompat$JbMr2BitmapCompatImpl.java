package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat$HcMr1BitmapCompatImpl;
import android.support.v4.graphics.BitmapCompatJellybeanMR2;

class BitmapCompat$JbMr2BitmapCompatImpl extends BitmapCompat$HcMr1BitmapCompatImpl {
   public boolean hasMipMap(Bitmap var1) {
      return BitmapCompatJellybeanMR2.hasMipMap(var1);
   }

   public void setHasMipMap(Bitmap var1, boolean var2) {
      BitmapCompatJellybeanMR2.setHasMipMap(var1, var2);
   }
}
