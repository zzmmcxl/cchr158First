package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class DefaultItemAnimator$5 extends VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
    final /* synthetic */ ViewHolder val$holder;
    
    DefaultItemAnimator$5(final DefaultItemAnimator this$0, final ViewHolder val$holder, final ViewPropertyAnimatorCompat val$animation) {
        this$0 = this$0;
        val$holder = val$holder;
        val$animation = val$animation;
        super();
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        ViewCompat.setAlpha(view, 1.0f);
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        val$animation.setListener(null);
        this$0.dispatchAddFinished(val$holder);
        DefaultItemAnimator.access$900(this$0).remove(val$holder);
        DefaultItemAnimator.access$800(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.dispatchAddStarting(val$holder);
    }
}