package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;

class ToolbarWidgetWrapper$2 extends ViewPropertyAnimatorListenerAdapter {
    private boolean mCanceled = false;
    final /* synthetic */ ToolbarWidgetWrapper this$0;
    final /* synthetic */ int val$visibility;
    
    ToolbarWidgetWrapper$2(final ToolbarWidgetWrapper this$0, final int val$visibility) {
        this$0 = this$0;
        val$visibility = val$visibility;
        super();
    }
    
    @Override
    public void onAnimationCancel(final View view) {
        mCanceled = true;
    }
    
    @Override
    public void onAnimationEnd(final View view) {
        if (!mCanceled) {
            ToolbarWidgetWrapper.access$000(this$0).setVisibility(val$visibility);
        }
    }
    
    @Override
    public void onAnimationStart(final View view) {
        ToolbarWidgetWrapper.access$000(this$0).setVisibility(0);
    }
}