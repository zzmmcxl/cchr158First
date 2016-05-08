package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$1;
import android.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;

class DefaultItemAnimator$5 extends DefaultItemAnimator$VpaListenerAdapter {
   DefaultItemAnimator$5(DefaultItemAnimator var1, RecyclerView$ViewHolder var2, ViewPropertyAnimatorCompat var3) {
      super((DefaultItemAnimator$1)null);
      this.this$0 = var1;
      this.val$holder = var2;
      this.val$animation = var3;
   }

   public void onAnimationCancel(View var1) {
      ViewCompat.setAlpha(var1, 1.0F);
   }

   public void onAnimationEnd(View var1) {
      this.val$animation.setListener((ViewPropertyAnimatorListener)null);
      this.this$0.dispatchAddFinished(this.val$holder);
      DefaultItemAnimator.access$900(this.this$0).remove(this.val$holder);
      DefaultItemAnimator.access$800(this.this$0);
   }

   public void onAnimationStart(View var1) {
      this.this$0.dispatchAddStarting(this.val$holder);
   }
}
