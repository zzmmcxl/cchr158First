package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class CoordinatorLayout$ApplyInsetsListener implements OnApplyWindowInsetsListener {
   private CoordinatorLayout$ApplyInsetsListener(CoordinatorLayout var1) {
      this.this$0 = var1;
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return CoordinatorLayout.access$200(this.this$0, var2);
   }
}
