package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar$5$1;
import android.support.design.widget.Snackbar$SnackbarLayout$OnAttachStateChangeListener;
import android.view.View;

class Snackbar$5 implements Snackbar$SnackbarLayout$OnAttachStateChangeListener {
   Snackbar$5(Snackbar var1) {
      this.this$0 = var1;
   }

   public void onViewAttachedToWindow(View var1) {
   }

   public void onViewDetachedFromWindow(View var1) {
      if(this.this$0.isShownOrQueued()) {
         Snackbar.access$100().post(new Snackbar$5$1(this));
      }

   }
}
