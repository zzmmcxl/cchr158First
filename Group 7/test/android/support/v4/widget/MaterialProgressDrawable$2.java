package android.support.v4.widget;

import android.support.v4.widget.MaterialProgressDrawable;
import android.support.v4.widget.MaterialProgressDrawable$Ring;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MaterialProgressDrawable$2 implements AnimationListener {
   MaterialProgressDrawable$2(MaterialProgressDrawable var1, MaterialProgressDrawable$Ring var2) {
      this.this$0 = var1;
      this.val$ring = var2;
   }

   public void onAnimationEnd(Animation var1) {
   }

   public void onAnimationRepeat(Animation var1) {
      this.val$ring.storeOriginals();
      this.val$ring.goToNextColor();
      this.val$ring.setStartTrim(this.val$ring.getEndTrim());
      if(this.this$0.mFinishing) {
         this.this$0.mFinishing = false;
         var1.setDuration(1332L);
         this.val$ring.setShowArrow(false);
      } else {
         MaterialProgressDrawable.access$402(this.this$0, (MaterialProgressDrawable.access$400(this.this$0) + 1.0F) % 5.0F);
      }
   }

   public void onAnimationStart(Animation var1) {
      MaterialProgressDrawable.access$402(this.this$0, 0.0F);
   }
}
