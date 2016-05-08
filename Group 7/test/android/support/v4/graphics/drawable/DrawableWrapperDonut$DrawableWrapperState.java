package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableWrapperDonut;

public abstract class DrawableWrapperDonut$DrawableWrapperState extends ConstantState {
   int mChangingConfigurations;
   ConstantState mDrawableState;
   ColorStateList mTint = null;
   Mode mTintMode;

   DrawableWrapperDonut$DrawableWrapperState(@Nullable DrawableWrapperDonut$DrawableWrapperState var1, @Nullable Resources var2) {
      this.mTintMode = DrawableWrapperDonut.DEFAULT_TINT_MODE;
      if(var1 != null) {
         this.mChangingConfigurations = var1.mChangingConfigurations;
         this.mDrawableState = var1.mDrawableState;
         this.mTint = var1.mTint;
         this.mTintMode = var1.mTintMode;
      }

   }

   boolean canConstantState() {
      return this.mDrawableState != null;
   }

   public int getChangingConfigurations() {
      int var2 = this.mChangingConfigurations;
      int var1;
      if(this.mDrawableState != null) {
         var1 = this.mDrawableState.getChangingConfigurations();
      } else {
         var1 = 0;
      }

      return var1 | var2;
   }

   public Drawable newDrawable() {
      return this.newDrawable((Resources)null);
   }

   public abstract Drawable newDrawable(@Nullable Resources var1);
}
