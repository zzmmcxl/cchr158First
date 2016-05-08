package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.design.widget.SnackbarManager;
import android.support.design.widget.SwipeDismissBehavior;
import android.view.MotionEvent;
import android.view.View;

final class Snackbar$Behavior extends SwipeDismissBehavior<Snackbar$SnackbarLayout> {
   Snackbar$Behavior(Snackbar var1) {
      this.this$0 = var1;
   }

   public boolean canSwipeDismissView(View var1) {
      return var1 instanceof Snackbar$SnackbarLayout;
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, Snackbar$SnackbarLayout var2, MotionEvent var3) {
      if(var1.isPointInChildBounds(var2, (int)var3.getX(), (int)var3.getY())) {
         switch(var3.getActionMasked()) {
         case 0:
            SnackbarManager.getInstance().cancelTimeout(Snackbar.access$200(this.this$0));
            break;
         case 1:
         case 3:
            SnackbarManager.getInstance().restoreTimeout(Snackbar.access$200(this.this$0));
         case 2:
         }
      }

      return super.onInterceptTouchEvent(var1, var2, var3);
   }
}
