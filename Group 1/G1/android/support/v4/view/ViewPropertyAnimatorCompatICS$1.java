package android.support.v4.view;

import android.animation.Animator;
import android.view.View;
import android.animation.AnimatorListenerAdapter;

static final class ViewPropertyAnimatorCompatICS$1 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewPropertyAnimatorListener val$listener;
    final /* synthetic */ View val$view;
    
    ViewPropertyAnimatorCompatICS$1(final ViewPropertyAnimatorListener val$listener, final View val$view) {
        this.val$listener = val$listener;
        this.val$view = val$view;
        super();
    }
    
    public void onAnimationCancel(final Animator animator) {
        val$listener.onAnimationCancel(val$view);
    }
    
    public void onAnimationEnd(final Animator animator) {
        val$listener.onAnimationEnd(val$view);
    }
    
    public void onAnimationStart(final Animator animator) {
        val$listener.onAnimationStart(val$view);
    }
}