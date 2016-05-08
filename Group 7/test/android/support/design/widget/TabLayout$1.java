package android.support.design.widget;

import android.support.design.widget.TabLayout;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;

class TabLayout$1 implements ValueAnimatorCompat$AnimatorUpdateListener {
   TabLayout$1(TabLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      this.this$0.scrollTo(var1.getAnimatedIntValue(), 0);
   }
}
