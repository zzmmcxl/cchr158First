package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.support.v4.graphics.BitmapCompat$BitmapImpl;

class BitmapCompat$BaseBitmapImpl implements BitmapCompat$BitmapImpl {
   public int getAllocationByteCount(Bitmap var1) {
      return var1.getRowBytes() * var1.getHeight();
   }

   public boolean hasMipMap(Bitmap var1) {
      return false;
   }

   public void setHasMipMap(Bitmap var1, boolean var2) {
   }
}
