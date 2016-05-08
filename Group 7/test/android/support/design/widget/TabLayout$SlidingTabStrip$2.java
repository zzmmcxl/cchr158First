package android.support.design.widget;

import android.support.design.widget.TabLayout$SlidingTabStrip;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorListenerAdapter;

class TabLayout$SlidingTabStrip$2 extends ValueAnimatorCompat$AnimatorListenerAdapter {
   TabLayout$SlidingTabStrip$2(TabLayout$SlidingTabStrip var1, int var2) {
      this.this$1 = var1;
      this.val$position = var2;
   }

   public void onAnimationEnd(ValueAnimatorCompat var1) {
      TabLayout$SlidingTabStrip.access$2502(this.this$1, this.val$position);
      TabLayout$SlidingTabStrip.access$2602(this.this$1, 0.0F);
   }
}
