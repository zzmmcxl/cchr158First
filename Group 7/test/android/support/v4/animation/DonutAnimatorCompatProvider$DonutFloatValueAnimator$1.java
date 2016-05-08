package android.support.v4.animation;

import android.support.v4.animation.DonutAnimatorCompatProvider$DonutFloatValueAnimator;

class DonutAnimatorCompatProvider$DonutFloatValueAnimator$1 implements Runnable {
   DonutAnimatorCompatProvider$DonutFloatValueAnimator$1(DonutAnimatorCompatProvider$DonutFloatValueAnimator var1) {
      this.this$0 = var1;
   }

   public void run() {
      float var1 = (float)(DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$000(this.this$0) - DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$100(this.this$0)) * 1.0F / (float)DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$200(this.this$0);
      if(var1 > 1.0F || this.this$0.mTarget.getParent() == null) {
         var1 = 1.0F;
      }

      DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$302(this.this$0, var1);
      DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$400(this.this$0);
      if(DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$300(this.this$0) >= 1.0F) {
         DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$500(this.this$0);
      } else {
         this.this$0.mTarget.postDelayed(DonutAnimatorCompatProvider$DonutFloatValueAnimator.access$600(this.this$0), 16L);
      }
   }
}
