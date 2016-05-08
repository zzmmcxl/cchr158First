package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper$RecoverAnimation;

class ItemTouchHelper$RecoverAnimation$1 implements AnimatorUpdateListenerCompat {
   ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper$RecoverAnimation var1, ItemTouchHelper var2) {
      this.this$1 = var1;
      this.val$this$0 = var2;
   }

   public void onAnimationUpdate(ValueAnimatorCompat var1) {
      this.this$1.setFraction(var1.getAnimatedFraction());
   }
}
