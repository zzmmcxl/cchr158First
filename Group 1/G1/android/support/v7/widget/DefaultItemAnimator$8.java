package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

class DefaultItemAnimator$8 extends VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ChangeInfo val$changeInfo;
    final /* synthetic */ View val$newView;
    final /* synthetic */ ViewPropertyAnimatorCompat val$newViewAnimation;
    
    DefaultItemAnimator$8(final DefaultItemAnimator this$0, final ChangeInfo val$changeInfo, final ViewPropertyAnimatorCompat val$newViewAnimation, final View val$newView) {
        this$0 = this$0;
        val$changeInfo = val$changeInfo;
        val$newViewAnimation = val$newViewAnimation;
        val$newView = val$newView;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        val$newViewAnimation.setListener(null);
        ViewCompat.setAlpha(val$newView, 1.0f);
        ViewCompat.setTranslationX(val$newView, 0.0f);
        ViewCompat.setTranslationY(val$newView, 0.0f);
        this$0.dispatchChangeFinished(val$changeInfo.newHolder, false);
        DefaultItemAnimator.access$1300(this$0).remove(val$changeInfo.newHolder);
        DefaultItemAnimator.access$800(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.dispatchChangeStarting(val$changeInfo.newHolder, false);
    }
}