package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class DefaultItemAnimator$6 extends VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ViewPropertyAnimatorCompat val$animation;
    final /* synthetic */ int val$deltaX;
    final /* synthetic */ int val$deltaY;
    final /* synthetic */ ViewHolder val$holder;
    
    DefaultItemAnimator$6(final DefaultItemAnimator this$0, final ViewHolder val$holder, final int val$deltaX, final int val$deltaY, final ViewPropertyAnimatorCompat val$animation) {
        this$0 = this$0;
        val$holder = val$holder;
        val$deltaX = val$deltaX;
        val$deltaY = val$deltaY;
        val$animation = val$animation;
        super();
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        if (val$deltaX != 0) {
            ViewCompat.setTranslationX(view, 0.0f);
        }
        if (val$deltaY != 0) {
            ViewCompat.setTranslationY(view, 0.0f);
        }
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        val$animation.setListener(null);
        this$0.dispatchMoveFinished(val$holder);
        DefaultItemAnimator.access$1100(this$0).remove(val$holder);
        DefaultItemAnimator.access$800(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.dispatchMoveStarting(val$holder);
    }
}