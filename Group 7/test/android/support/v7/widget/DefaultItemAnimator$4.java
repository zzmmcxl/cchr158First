package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DefaultItemAnimator$1;
import android.support.v7.widget.DefaultItemAnimator$VpaListenerAdapter;
import android.support.v7.widget.RecyclerView$ViewHolder;
import android.view.View;

class DefaultItemAnimator$4 extends DefaultItemAnimator$VpaListenerAdapter {
   DefaultItemAnimator$4(DefaultItemAnimator var1, RecyclerView$ViewHolder var2, ViewPropertyAnimatorCompat var3) {
      super((DefaultItemAnimator$1)null);
      this.this$0 = var1;
      this.val$holder = var2;
      this.val$animation = var3;
   }

   public void onAnimationEnd(View var1) {
      this.val$animation.setListener((ViewPropertyAnimatorListener)null);
      ViewCompat.setAlpha(var1, 1.0F);
      this.this$0.dispatchRemoveFinished(this.val$holder);
      DefaultItemAnimator.access$700(this.this$0).remove(this.val$holder);
      DefaultItemAnimator.access$800(this.this$0);
   }

   public void onAnimationStart(View var1) {
      this.this$0.dispatchRemoveStarting(this.val$holder);
   }
}
