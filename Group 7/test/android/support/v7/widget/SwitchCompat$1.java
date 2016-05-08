package android.support.v7.widget;

import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.SwitchCompat$ThumbAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SwitchCompat$1 implements AnimationListener {
   SwitchCompat$1(SwitchCompat var1, boolean var2) {
      this.this$0 = var1;
      this.val$newCheckedState = var2;
   }

   public void onAnimationEnd(Animation var1) {
      if(SwitchCompat.access$100(this.this$0) == var1) {
         SwitchCompat var3 = this.this$0;
         float var2;
         if(this.val$newCheckedState) {
            var2 = 1.0F;
         } else {
            var2 = 0.0F;
         }

         SwitchCompat.access$200(var3, var2);
         SwitchCompat.access$102(this.this$0, (SwitchCompat$ThumbAnimation)null);
      }

   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
