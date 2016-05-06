package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;

class ValueAnimatorCompatImplHoneycombMr1$1 implements ValueAnimator$AnimatorUpdateListener {
    final /* synthetic */ ValueAnimatorCompatImplHoneycombMr1 this$0;
    final /* synthetic */ AnimatorUpdateListenerProxy val$updateListener;
    
    ValueAnimatorCompatImplHoneycombMr1$1(final ValueAnimatorCompatImplHoneycombMr1 this$0, final AnimatorUpdateListenerProxy val$updateListener) {
        this$0 = this$0;
        val$updateListener = val$updateListener;
        super();
    }
    
    public void onAnimationUpdate(final ValueAnimator valueAnimator) {
        val$updateListener.onAnimationUpdate();
    }
}