package android.support.graphics.drawable;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat$1;

class AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState extends ConstantState {
   private final ConstantState mDelegateState;

   public AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState(ConstantState var1) {
      this.mDelegateState = var1;
   }

   public boolean canApplyTheme() {
      return this.mDelegateState.canApplyTheme();
   }

   public int getChangingConfigurations() {
      return this.mDelegateState.getChangingConfigurations();
   }

   public Drawable newDrawable() {
      AnimatedVectorDrawableCompat var1 = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
      var1.mDelegateDrawable = this.mDelegateState.newDrawable();
      var1.mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(var1));
      return var1;
   }

   public Drawable newDrawable(Resources var1) {
      AnimatedVectorDrawableCompat var2 = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
      var2.mDelegateDrawable = this.mDelegateState.newDrawable(var1);
      var2.mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(var2));
      return var2;
   }

   public Drawable newDrawable(Resources var1, Theme var2) {
      AnimatedVectorDrawableCompat var3 = new AnimatedVectorDrawableCompat((AnimatedVectorDrawableCompat$1)null);
      var3.mDelegateDrawable = this.mDelegateState.newDrawable(var1, var2);
      var3.mDelegateDrawable.setCallback(AnimatedVectorDrawableCompat.access$100(var3));
      return var3;
   }
}
