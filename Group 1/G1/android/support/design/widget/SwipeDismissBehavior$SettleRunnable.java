package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

private class SettleRunnable implements Runnable
{
    private final boolean mDismiss;
    private final View mView;
    final /* synthetic */ SwipeDismissBehavior this$0;
    
    SettleRunnable(final SwipeDismissBehavior this$0, final View mView, final boolean mDismiss) {
        this$0 = this$0;
        super();
        mView = mView;
        mDismiss = mDismiss;
    }
    
    @Override
    public void run() {
        if (SwipeDismissBehavior.access$100(this$0) != null && SwipeDismissBehavior.access$100(this$0).continueSettling(true)) {
            ViewCompat.postOnAnimation(mView, this);
        }
        else if (mDismiss && SwipeDismissBehavior.access$000(this$0) != null) {
            SwipeDismissBehavior.access$000(this$0).onDismiss(mView);
        }
    }
}
