package android.support.v7.widget;

import android.widget.AbsListView;
import android.widget.AbsListView$OnScrollListener;

private class PopupScrollListener implements AbsListView$OnScrollListener
{
    final /* synthetic */ ListPopupWindow this$0;
    
    private PopupScrollListener(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    PopupScrollListener(final ListPopupWindow listPopupWindow, final ListPopupWindow$1 forwardingListener) {
        this(listPopupWindow);
    }
    
    public void onScroll(final AbsListView absListView, final int n, final int n2, final int n3) {
    }
    
    public void onScrollStateChanged(final AbsListView absListView, final int n) {
        if (n == 1 && !this$0.isInputMethodNotNeeded() && ListPopupWindow.access$1100(this$0).getContentView() != null) {
            ListPopupWindow.access$1300(this$0).removeCallbacks((Runnable)ListPopupWindow.access$1200(this$0));
            ListPopupWindow.access$1200(this$0).run();
        }
    }
}
