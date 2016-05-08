package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Snackbar$10 implements AnimationListener {
   Snackbar$10(Snackbar var1, int var2) {
      this.this$0 = var1;
      this.val$event = var2;
   }

   public void onAnimationEnd(Animation var1) {
      Snackbar.access$300(this.this$0, this.val$event);
   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
