package android.support.design.widget;

import android.support.design.widget.TextInputLayout;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;

class TextInputLayout$4 implements ValueAnimatorCompat$AnimatorUpdateListener {
   TextInputLayout$4(TextInputLayout var1) {
      this.this$0 = var1;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      TextInputLayout.access$500(this.this$0).setExpansionFraction(var1.getAnimatedFloatValue());
   }
}
