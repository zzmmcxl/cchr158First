package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorCompat;

class DefaultItemAnimator$7 extends VpaListenerAdapter {
    final /* synthetic */ DefaultItemAnimator this$0;
    final /* synthetic */ ChangeInfo val$changeInfo;
    final /* synthetic */ ViewPropertyAnimatorCompat val$oldViewAnim;
    
    DefaultItemAnimator$7(final DefaultItemAnimator this$0, final ChangeInfo val$changeInfo, final ViewPropertyAnimatorCompat val$oldViewAnim) {
        this$0 = this$0;
        val$changeInfo = val$changeInfo;
        val$oldViewAnim = val$oldViewAnim;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        val$oldViewAnim.setListener(null);
        ViewCompat.setAlpha(view, 1.0f);
        ViewCompat.setTranslationX(view, 0.0f);
        ViewCompat.setTranslationY(view, 0.0f);
        this$0.dispatchChangeFinished(val$changeInfo.oldHolder, true);
        DefaultItemAnimator.access$1300(this$0).remove(val$changeInfo.oldHolder);
        DefaultItemAnimator.access$800(this$0);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.dispatchChangeStarting(val$changeInfo.oldHolder, true);
    }
}