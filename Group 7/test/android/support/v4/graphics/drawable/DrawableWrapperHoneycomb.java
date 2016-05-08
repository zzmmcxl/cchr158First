package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;
import android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperState;
import android.support.v4.graphics.drawable.DrawableWrapperHoneycomb$DrawableWrapperStateHoneycomb;

class DrawableWrapperHoneycomb extends DrawableWrapperDonut {
   DrawableWrapperHoneycomb(Drawable var1) {
      super(var1);
   }

   DrawableWrapperHoneycomb(DrawableWrapperDonut$DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
   }

   public void jumpToCurrentState() {
      this.mDrawable.jumpToCurrentState();
   }

   @NonNull
   DrawableWrapperDonut$DrawableWrapperState mutateConstantState() {
      return new DrawableWrapperHoneycomb$DrawableWrapperStateHoneycomb(this.mState, (Resources)null);
   }
}
