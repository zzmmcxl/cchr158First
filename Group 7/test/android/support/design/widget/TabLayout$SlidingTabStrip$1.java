package android.support.design.widget;

import android.support.design.widget.AnimationUtils;
import android.support.design.widget.TabLayout$SlidingTabStrip;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;

class TabLayout$SlidingTabStrip$1 implements ValueAnimatorCompat$AnimatorUpdateListener {
   TabLayout$SlidingTabStrip$1(TabLayout$SlidingTabStrip var1, int var2, int var3, int var4, int var5) {
      this.this$1 = var1;
      this.val$startLeft = var2;
      this.val$targetLeft = var3;
      this.val$startRight = var4;
      this.val$targetRight = var5;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      float var2 = var1.getAnimatedFraction();
      TabLayout$SlidingTabStrip.access$2400(this.this$1, AnimationUtils.lerp(this.val$startLeft, this.val$targetLeft, var2), AnimationUtils.lerp(this.val$startRight, this.val$targetRight, var2));
   }
}
