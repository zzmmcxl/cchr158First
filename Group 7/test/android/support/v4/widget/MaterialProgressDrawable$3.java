package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.widget.MaterialProgressDrawable;

class MaterialProgressDrawable$3 implements Callback {
   MaterialProgressDrawable$3(MaterialProgressDrawable var1) {
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
