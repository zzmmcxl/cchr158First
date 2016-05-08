package android.support.design.widget;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;

class CollapsingToolbarLayout$2 implements ValueAnimatorCompat$AnimatorUpdateListener {
   CollapsingToolbarLayout$2(CollapsingToolbarLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      CollapsingToolbarLayout.access$200(this.this$0, var1.getAnimatedIntValue());
   }
}
