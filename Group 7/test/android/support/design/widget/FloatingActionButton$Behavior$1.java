package android.support.design.widget;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.FloatingActionButton$Behavior;
import android.support.design.widget.ValueAnimatorCompat;
import android.support.design.widget.ValueAnimatorCompat$AnimatorUpdateListener;
import android.support.v4.view.ViewCompat;

class FloatingActionButton$Behavior$1 implements ValueAnimatorCompat$AnimatorUpdateListener {
   FloatingActionButton$Behavior$1(FloatingActionButton$Behavior var1, FloatingActionButton var2) {
      this.this$0 = var1;
      this.val$fab = var2;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      ViewCompat.setTranslationY(this.val$fab, var1.getAnimatedFloatValue());
   }
}
