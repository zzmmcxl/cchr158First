package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat$1;

class VectorDrawableCompat$VectorDrawableDelegateState extends ConstantState {
   private final ConstantState mDelegateState;

   public VectorDrawableCompat$VectorDrawableDelegateState(ConstantState var1) {
      this.mDelegateState = var1;
   }

   public boolean canApplyTheme() {
      return this.mDelegateState.canApplyTheme();
   }

   public int getChangingConfigurations() {
      return this.mDelegateState.getChangingConfigurations();
   }

   public Drawable newDrawable() {
      VectorDrawableCompat var1 = new VectorDrawableCompat((VectorDrawableCompat$1)null);
      var1.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable();
      return var1;
   }

   public Drawable newDrawable(Resources var1) {
      VectorDrawableCompat var2 = new VectorDrawableCompat((VectorDrawableCompat$1)null);
      var2.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(var1);
      return var2;
   }

   public Drawable newDrawable(Resources var1, Theme var2) {
      VectorDrawableCompat var3 = new VectorDrawableCompat((VectorDrawableCompat$1)null);
      var3.mDelegateDrawable = (VectorDrawable)this.mDelegateState.newDrawable(var1, var2);
      return var3;
   }
}
