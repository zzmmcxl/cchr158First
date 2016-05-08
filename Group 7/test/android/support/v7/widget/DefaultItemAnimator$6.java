package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$1;
import android.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;

class DefaultItemAnimator$6 extends DefaultItemAnimator$VpaListenerAdapter {
   DefaultItemAnimator$6(DefaultItemAnimator var1, RecyclerView$ViewHolder var2, int var3, int var4, ViewPropertyAnimatorCompat var5) {
      super((DefaultItemAnimator$1)null);
      this.this$0 = var1;
      this.val$holder = var2;
      this.val$deltaX = var3;
      this.val$deltaY = var4;
      this.val$animation = var5;
   }

   public void onAnimationCancel(View var1) {
      if(this.val$deltaX != 0) {
         ViewCompat.setTranslationX(var1, 0.0F);
      }

      if(this.val$deltaY != 0) {
         ViewCompat.setTranslationY(var1, 0.0F);
      }

   }

   public void onAnimationEnd(View var1) {
      this.val$animation.setListener((ViewPropertyAnimatorListener)null);
      this.this$0.dispatchMoveFinished(this.val$holder);
      DefaultItemAnimator.access$1100(this.this$0).remove(this.val$holder);
      DefaultItemAnimator.access$800(this.this$0);
   }

   public void onAnimationStart(View var1) {
      this.this$0.dispatchMoveStarting(this.val$holder);
   }
}
