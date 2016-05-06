package android.support.v7.widget;

import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListener;

protected class VisibilityAnimListener implements ViewPropertyAnimatorListener
{
    private boolean mCanceled;
    private int mFinalVisibility;
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    protected VisibilityAnimListener(final ScrollingTabContainerView this$0) {
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
        this$0.setVisibility(mFinalVisibility);
    }
    
    @Override
    public void onAnimationStart(final View view) {
        this$0.setVisibility(0);
        mCanceled = false;
    }
    
    public VisibilityAnimListener withFinalVisibility(final ViewPropertyAnimatorCompat mVisibilityAnim, final int mFinalVisibility) {
        this.mFinalVisibility = mFinalVisibility;
        this$0.mVisibilityAnim = mVisibilityAnim;
        return this;
    }
}
