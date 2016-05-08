package android.support.v4.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperState;
import android.support.v4.graphics.drawable.DrawableWrapperHoneycomb;
import android.support.v4.graphics.drawable.DrawableWrapperKitKat$DrawableWrapperStateKitKat;

class DrawableWrapperKitKat extends DrawableWrapperHoneycomb {
   DrawableWrapperKitKat(Drawable var1) {
      super(var1);
   }

   DrawableWrapperKitKat(DrawableWrapperDonut$DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
   }

   public boolean isAutoMirrored() {
      return this.mDrawable.isAutoMirrored();
   }

   @NonNull
   DrawableWrapperDonut$DrawableWrapperState mutateConstantState() {
      return new DrawableWrapperKitKat$DrawableWrapperStateKitKat(this.mState, (Resources)null);
   }

   public void setAutoMirrored(boolean var1) {
      this.mDrawable.setAutoMirrored(var1);
   }
}
