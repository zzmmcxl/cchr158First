package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class DefaultItemAnimator$4 extends VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
    final /* synthetic */ ViewHolder val$holder;
    
    DefaultItemAnimator$4(final DefaultItemAnimator this$0, final ViewHolder val$holder, final ViewPropertyAnimatorCompat val$animation) {
        this$0 = this$0;
        val$holder = val$holder;
        val$animation = val$animation;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        val$animation.setListener(null);
        ViewCompat.setAlpha(view, 1.0f);
        this$0.dispatchRemoveFinished(val$holder);
        DefaultItemAnimator.access$700(this$0).remove(val$holder);
        DefaultItemAnimator.access$800(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.dispatchRemoveStarting(val$holder);
    }
}