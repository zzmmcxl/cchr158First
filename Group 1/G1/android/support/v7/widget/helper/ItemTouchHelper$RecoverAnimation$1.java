package android.support.v7.widget.helper;

import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;

class ItemTouchHelper$RecoverAnimation$1 implements AnimatorUpdateListenerCompat {
    final /* synthetic */ RecoverAnimation this$1;
    final /* synthetic */ ItemTouchHelper val$this$0;
    
    ItemTouchHelper$RecoverAnimation$1(final RecoverAnimation this$1, final ItemTouchHelper val$this$0) {
        this$1 = this$1;
        val$this$0 = val$this$0;
        super();
    }
    
    @Override
    public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
        this$1.setFraction(valueAnimatorCompat.getAnimatedFraction());
    }
}