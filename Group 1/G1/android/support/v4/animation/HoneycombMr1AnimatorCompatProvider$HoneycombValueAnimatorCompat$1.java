package android.support.v4.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

class HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1 implements ValueAnimator$AnimatorUpdateListener {
    final /* synthetic */ HoneycombValueAnimatorCompat this$0;
    final /* synthetic */ AnimatorUpdateListenerCompat val$animatorUpdateListener;
    
    HoneycombMr1AnimatorCompatProvider$HoneycombValueAnimatorCompat$1(final HoneycombValueAnimatorCompat this$0, final AnimatorUpdateListenerCompat val$animatorUpdateListener) {
        this$0 = this$0;
        val$animatorUpdateListener = val$animatorUpdateListener;
        super();
    }
    
    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
        val$animatorUpdateListener.onAnimationUpdate(this$0);
    }
}