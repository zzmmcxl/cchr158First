package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;

class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
   DrawableWrapperHoneycomb(Drawable var1) {
      super(var1);
   }

   public void jumpToCurrentState() {
      this.mDrawable.jumpToCurrentState();
   }
}
