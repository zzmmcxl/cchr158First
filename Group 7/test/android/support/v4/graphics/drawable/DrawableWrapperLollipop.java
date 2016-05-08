package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableWrapperDonut$DrawableWrapperState;
import android.support.v4.graphics.drawable.DrawableWrapperKitKat;
import android.support.v4.graphics.drawable.DrawableWrapperLollipop$DrawableWrapperStateLollipop;

class DrawableWrapperLollipop extends DrawableWrapperKitKat {
   DrawableWrapperLollipop(Drawable var1) {
      super(var1);
   }

   DrawableWrapperLollipop(DrawableWrapperDonut$DrawableWrapperState var1, Resources var2) {
      super(var1, var2);
   }

   public Rect getDirtyBounds() {
      return this.mDrawable.getDirtyBounds();
   }

   public void getOutline(Outline var1) {
      this.mDrawable.getOutline(var1);
   }

   protected boolean isCompatTintEnabled() {
      boolean var2 = false;
      boolean var1 = var2;
      if(VERSION.SDK_INT == 21) {
         Drawable var3 = this.mDrawable;
         if(!(var3 instanceof GradientDrawable) && !(var3 instanceof DrawableContainer)) {
            var1 = var2;
            if(!(var3 instanceof InsetDrawable)) {
               return var1;
            }
         }

         var1 = true;
      }

      return var1;
   }

   @NonNull
   DrawableWrapperDonut$DrawableWrapperState mutateConstantState() {
      return new DrawableWrapperLollipop$DrawableWrapperStateLollipop(this.mState, (Resources)null);
   }

   public void setHotspot(float var1, float var2) {
      this.mDrawable.setHotspot(var1, var2);
   }

   public void setHotspotBounds(int var1, int var2, int var3, int var4) {
      this.mDrawable.setHotspotBounds(var1, var2, var3, var4);
   }

   public boolean setState(int[] var1) {
      if(super.setState(var1)) {
         this.invalidateSelf();
         return true;
      } else {
         return false;
      }
   }

   public void setTint(int var1) {
      if(this.isCompatTintEnabled()) {
         this.setCompatTint(var1);
      } else {
         this.mDrawable.setTint(var1);
      }
   }

   public void setTintList(ColorStateList var1) {
      if(this.isCompatTintEnabled()) {
         this.setCompatTintList(var1);
      } else {
         this.mDrawable.setTintList(var1);
      }
   }

   public void setTintMode(Mode var1) {
      if(this.isCompatTintEnabled()) {
         this.setCompatTintMode(var1);
      } else {
         this.mDrawable.setTintMode(var1);
      }
   }
}
