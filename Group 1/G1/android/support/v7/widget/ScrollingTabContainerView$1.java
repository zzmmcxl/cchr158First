package android.support.v7.widget;

import android.view.View;

class ScrollingTabContainerView$1 implements Runnable {
    final /* synthetic */ ScrollingTabContainerView this$0;
    final /* synthetic */ View val$tabView;
    
    ScrollingTabContainerView$1(final ScrollingTabContainerView this$0, final View val$tabView) {
        this$0 = this$0;
        val$tabView = val$tabView;
        super();
    }
    
    @Override
    public void run() {
        this$0.smoothScrollTo(val$tabView.getLeft() - (this$0.getWidth() - val$tabView.getWidth()) / 2, 0);
        mTabSelector = null;
    }
}