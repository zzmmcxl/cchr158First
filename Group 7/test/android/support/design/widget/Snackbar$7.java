package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.view.View;

class Snackbar$7 extends ViewPropertyAnimatorListenerAdapter {
   Snackbar$7(Snackbar var1) {
      this.this$0 = var1;
   }

   public void onAnimationEnd(View var1) {
      Snackbar.access$700(this.this$0);
   }

   public void onAnimationStart(View var1) {
      if(!Snackbar.access$600(this.this$0).isEnabled()) {
         Snackbar.access$500(this.this$0).animateChildrenIn(70, 180);
      }

   }
}
