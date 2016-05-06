package android.support.design.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

private class FlingRunnable implements Runnable
{
    private final V mLayout;
    private final CoordinatorLayout mParent;
    final /* synthetic */ HeaderBehavior this$0;
    
    FlingRunnable(final HeaderBehavior this$0, final CoordinatorLayout mParent, final V mLayout) {
        this$0 = this$0;
        super();
        mParent = mParent;
        mLayout = mLayout;
    }
    
    @Override
    public void run() {
        if (mLayout != null && HeaderBehavior.access$000(this$0) != null) {
            if (!HeaderBehavior.access$000(this$0).computeScrollOffset()) {
                this$0.onFlingFinished(mParent, mLayout);
                return;
            }
            this$0.setHeaderTopBottomOffset(mParent, mLayout, HeaderBehavior.access$000(this$0).getCurrY());
            ViewCompat.postOnAnimation(mLayout, this);
        }
    }
}
