package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperHoneycomb;

class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
   DrawableWrapperKitKat(Drawable var1) {
      super(var1);
   }

   public boolean isAutoMirrored() {
      return this.mDrawable.isAutoMirrored();
   }

   public void setAutoMirrored(boolean var1) {
      this.mDrawable.setAutoMirrored(var1);
   }
}
