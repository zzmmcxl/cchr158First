package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.view.View;

private class SettleRunnable implements Runnable
{
    private final int mTargetState;
    private final View mView;
    final /* synthetic */ BottomSheetBehavior this$0;
    
    SettleRunnable(final BottomSheetBehavior this$0, final View mView, final int mTargetState) {
        this$0 = this$0;
        super();
        mView = mView;
        mTargetState = mTargetState;
    }
    
    @Override
    public void run() {
        if (BottomSheetBehavior.access$1200(this$0) != null && BottomSheetBehavior.access$1200(this$0).continueSettling(true)) {
            ViewCompat.postOnAnimation(mView, this);
            return;
        }
        BottomSheetBehavior.access$600(this$0, mTargetState);
    }
}
