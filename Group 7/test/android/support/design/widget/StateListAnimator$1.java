package android.support.design.widget;

import android.support.design.widget.StateListAnimator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class StateListAnimator$1 implements AnimationListener {
   StateListAnimator$1(StateListAnimator var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(Animation var1) {
      if(StateListAnimator.access$000(this.this$0) == var1) {
         StateListAnimator.access$002(this.this$0, (Animation)null);
      }

   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
