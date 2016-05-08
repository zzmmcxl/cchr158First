package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;

class AnimatedVectorDrawableCompat$1 implements Callback {
   AnimatedVectorDrawableCompat$1(AnimatedVectorDrawableCompat var1) {
      this.this$0 = var1;
   }

   public void invalidateDrawable(Drawable var1) {
      this.this$0.invalidateSelf();
   }

   public void scheduleDrawable(Drawable var1, Runnable var2, long var3) {
      this.this$0.scheduleSelf(var2, var3);
   }

   public void unscheduleDrawable(Drawable var1, Runnable var2) {
      this.this$0.unscheduleSelf(var2);
   }
}
