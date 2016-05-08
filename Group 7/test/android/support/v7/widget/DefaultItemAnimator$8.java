package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$1;
import android.support.v7.widget.DefaultItemAnimator$ChangeInfo;
import android.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter;
import android.view.View;

class DefaultItemAnimator$8 extends DefaultItemAnimator$VpaListenerAdapter {
   DefaultItemAnimator$8(DefaultItemAnimator var1, DefaultItemAnimator$ChangeInfo var2, ViewPropertyAnimatorCompat var3, View var4) {
      super((DefaultItemAnimator$1)null);
      this.this$0 = var1;
      this.val$changeInfo = var2;
      this.val$newViewAnimation = var3;
      this.val$newView = var4;
   }

   public void onAnimationEnd(View var1) {
      this.val$newViewAnimation.setListener((ViewPropertyAnimatorListener)null);
      ViewCompat.setAlpha(this.val$newView, 1.0F);
      ViewCompat.setTranslationX(this.val$newView, 0.0F);
      ViewCompat.setTranslationY(this.val$newView, 0.0F);
      this.this$0.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
      DefaultItemAnimator.access$1300(this.this$0).remove(this.val$changeInfo.newHolder);
      DefaultItemAnimator.access$800(this.this$0);
   }

   public void onAnimationStart(View var1) {
      this.this$0.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
   }
}
