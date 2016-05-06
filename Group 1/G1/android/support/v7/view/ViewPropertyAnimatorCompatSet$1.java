package android.support.v7.view;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ViewPropertyAnimatorCompatSet$1 extends ViewPropertyAnimatorListenerAdapter {
    private int mProxyEndCount = 0;
    private boolean mProxyStarted = false;
    final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;
    
    ViewPropertyAnimatorCompatSet$1(final ViewPropertyAnimatorCompatSet this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        final int mProxyEndCount = 1 + this.mProxyEndCount;
        this.mProxyEndCount = mProxyEndCount;
        if (mProxyEndCount == ViewPropertyAnimatorCompatSet.access$200(this$0).size()) {
            if (ViewPropertyAnimatorCompatSet.access$000(this$0) != null) {
                ViewPropertyAnimatorCompatSet.access$000(this$0).onAnimationEnd(null);
            }
            this.onEnd();
        }
    }
    
    @Override
    public void onAnimationStart(final View view) {
        if (!mProxyStarted) {
            mProxyStarted = true;
            if (ViewPropertyAnimatorCompatSet.access$000(this$0) != null) {
                ViewPropertyAnimatorCompatSet.access$000(this$0).onAnimationStart(null);
            }
        }
    }
    
    void onEnd() {
        mProxyEndCount = 0;
        mProxyStarted = false;
        ViewPropertyAnimatorCompatSet.access$100(this$0);
    }
}