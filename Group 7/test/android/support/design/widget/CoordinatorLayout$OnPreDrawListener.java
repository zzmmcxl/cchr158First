package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.view.ViewTreeObserver.OnPreDrawListener;

class CoordinatorLayout$OnPreDrawListener implements OnPreDrawListener {
   CoordinatorLayout$OnPreDrawListener(CoordinatorLayout var1) {
      this.this$0 = var1;
   }

   public boolean onPreDraw() {
      this.this$0.dispatchOnDependentViewChanged(false);
      return true;
   }
}
