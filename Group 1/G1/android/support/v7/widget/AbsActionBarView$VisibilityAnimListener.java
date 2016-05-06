package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListener;

protected class VisibilityAnimListener implements ViewPropertyAnimatorListener
{
    private boolean mCanceled;
    int mFinalVisibility;
    final /* synthetic */ AbsActionBarView this$0;
    
    protected VisibilityAnimListener(final AbsActionBarView this$0) {
        this$0 = this$0;
        super();
        mCanceled = false;
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        mCanceled = true;
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        if (mCanceled) {
            return;
        }
        mVisibilityAnim = null;
        AbsActionBarView.access$101(this$0, mFinalVisibility);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        AbsActionBarView.access$001(this$0, 0);
        mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(final ViewPropertyAnimatorCompat mVisibilityAnim, final int mFinalVisibility) {
        this$0.mVisibilityAnim = mVisibilityAnim;
        this.mFinalVisibility = mFinalVisibility;
        return this;
    }
}
