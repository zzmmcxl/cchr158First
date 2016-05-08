package android.support.design.widget;

import android.support.design.widget.Snackbar;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SwipeDismissBehavior$OnDismissListener;
import android.view.View;

class Snackbar$4 implements SwipeDismissBehavior$OnDismissListener {
   Snackbar$4(Snackbar var1) {
      this.this$0 = var1;
   }

   public void onDismiss(View var1) {
      var1.setVisibility(8);
      Snackbar.access$000(this.this$0, 0);
   }

   public void onDragStateChanged(int var1) {
      switch(var1) {
      case 0:
         SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this.this$0));
         return;
      case 1:
      case 2:
         SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this.this$0));
         return;
      default:
      }
   }
}
