package android.support.design.widget;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout$Behavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;

class AppBarLayout$Behavior$1 implements ValueAnimatorCompat$AnimatorUpdateListener {
   AppBarLayout$Behavior$1(AppBarLayout$Behavior var1, CoordinatorLayout var2, AppBarLayout var3) {
      this.this$0 = var1;
      this.val$coordinatorLayout = var2;
      this.val$child = var3;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      this.this$0.setHeaderTopBottomOffset(this.val$coordinatorLayout, this.val$child, var1.getAnimatedIntValue());
   }
}
