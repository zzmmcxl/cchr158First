package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;

final class ViewPropertyAnimatorCompatJB$1 extends AnimatorListenerAdapter {
   ViewPropertyAnimatorCompatJB$1(ViewPropertyAnimatorListener var1, View var2) {
      this.val$listener = var1;
      this.val$view = var2;
   }

   public void onAnimationCancel(Animator var1) {
      this.val$listener.onAnimationCancel(this.val$view);
   }

   public void onAnimationEnd(Animator var1) {
      this.val$listener.onAnimationEnd(this.val$view);
   }

   public void onAnimationStart(Animator var1) {
      this.val$listener.onAnimationStart(this.val$view);
   }
}
