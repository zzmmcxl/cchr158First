package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.view.View;
import java.util.Comparator;

class CoordinatorLayout$1 implements Comparator<View> {
   CoordinatorLayout$1(CoordinatorLayout var1) {
      this.this$0 = var1;
   }

   public int compare(View var1, View var2) {
      return var1 == var2?0:(((CoordinatorLayout$LayoutParams)var1.getLayoutParams()).dependsOn(this.this$0, var1, var2)?1:(((CoordinatorLayout$LayoutParams)var2.getLayoutParams()).dependsOn(this.this$0, var2, var1)?-1:0));
   }
}
