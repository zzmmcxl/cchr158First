package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.support.v4.graphics.BitmapCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.view.GravityCompat;

class RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable extends RoundedBitmapDrawable {
   RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(Resources var1, Bitmap var2) {
      super(var1, var2);
   }

   void gravityCompatApply(int var1, int var2, int var3, Rect var4, Rect var5) {
      GravityCompat.apply(var1, var2, var3, var4, var5, 0);
   }

   public boolean hasMipMap() {
      return this.mBitmap != null && BitmapCompat.hasMipMap(this.mBitmap);
   }

   public void setMipMap(boolean var1) {
      if(this.mBitmap != null) {
         BitmapCompat.setHasMipMap(this.mBitmap, var1);
         this.invalidateSelf();
      }

   }
}
