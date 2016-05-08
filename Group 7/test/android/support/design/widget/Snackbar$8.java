package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class Snackbar$8 implements AnimationListener {
   Snackbar$8(Snackbar var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(Animation var1) {
      Snackbar.access$700(this.this$0);
   }

   public void onAnimationRepeat(Animation var1) {
   }

   public void onAnimationStart(Animation var1) {
   }
}
