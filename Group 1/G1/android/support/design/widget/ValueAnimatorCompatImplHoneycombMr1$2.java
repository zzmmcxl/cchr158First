package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ValueAnimatorCompatImplHoneycombMr1$2 extends android.animation.AnimatorListenerAdapter {
    final /* synthetic */ ValueAnimatorCompatImplHoneycombMr1 this$0;
    final /* synthetic */ AnimatorListenerProxy val$listener;
    
    ValueAnimatorCompatImplHoneycombMr1$2(final ValueAnimatorCompatImplHoneycombMr1 this$0, final AnimatorListenerProxy val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    public void onAnimationCancel(final Animator animator) {
        val$listener.onAnimationCancel();
    }
    
    public void onAnimationEnd(final Animator animator) {
        val$listener.onAnimationEnd();
    }
    
    public void onAnimationStart(final Animator animator) {
        val$listener.onAnimationStart();
    }
}