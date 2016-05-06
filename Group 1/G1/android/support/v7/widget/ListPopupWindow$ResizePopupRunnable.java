package android.support.v7.widget;

import android.view.View;
import android.support.v4.view.ViewCompat;

private class ResizePopupRunnable implements Runnable
{
    final /* synthetic */ ListPopupWindow this$0;
    
    private ResizePopupRunnable(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    ResizePopupRunnable(final ListPopupWindow listPopupWindow, final ListPopupWindow$1 forwardingListener) {
        this(listPopupWindow);
    }
    
    @Override
    public void run() {
        if (ListPopupWindow.access$600(this$0) != null && ViewCompat.isAttachedToWindow((View)ListPopupWindow.access$600(this$0)) && ListPopupWindow.access$600(this$0).getCount() > ListPopupWindow.access$600(this$0).getChildCount() && ListPopupWindow.access$600(this$0).getChildCount() <= mListItemExpandMaximum) {
            ListPopupWindow.access$1100(this$0).setInputMethodMode(2);
            this$0.show();
        }
    }
}
