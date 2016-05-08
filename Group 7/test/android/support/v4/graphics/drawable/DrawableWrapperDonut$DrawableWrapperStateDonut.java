package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;
import android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperState;

class DrawableWrapperDonut$DrawableWrapperStateDonut extends DrawableWrapperDonut$DrawableWrapperState {
   DrawableWrapperDonut$DrawableWrapperStateDonut(@Nullable DrawableWrapperDonut$DrawableWrapperState var1, @Nullable Resources var2) {
      super(var1, var2);
   }

   public Drawable newDrawable(@Nullable Resources var1) {
      return new DrawableWrapperDonut(this, var1);
   }
}
