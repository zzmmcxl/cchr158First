package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

final class ViewPropertyAnimatorCompatKK$1 implements AnimatorUpdateListener {
   ViewPropertyAnimatorCompatKK$1(ViewPropertyAnimatorUpdateListener var1, View var2) {
      this.val$listener = var1;
      this.val$view = var2;
   }

   public void onAnimationUpdate(ValueAnimator var1) {
      this.val$listener.onAnimationUpdate(this.val$view);
   }
}
