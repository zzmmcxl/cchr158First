package android.support.v7.widget;

import android.view.View;
import android.view.View$OnClickListener;

private class TabClickListener implements View$OnClickListener
{
    final /* synthetic */ ScrollingTabContainerView this$0;
    
    private TabClickListener(final ScrollingTabContainerView this$0) {
        this$0 = this$0;
        super();
    }
    
    TabClickListener(final ScrollingTabContainerView scrollingTabContainerView, final ScrollingTabContainerView$1 runnable) {
        this(scrollingTabContainerView);
    }
    
    public void onClick(final View view) {
        ((TabView)view).getTab().select();
        for (int childCount = ScrollingTabContainerView.access$200(this$0).getChildCount(), i = 0; i < childCount; ++i) {
            final View child = ScrollingTabContainerView.access$200(this$0).getChildAt(i);
            child.setSelected(child == view);
        }
    }
}
