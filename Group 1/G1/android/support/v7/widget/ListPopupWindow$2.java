package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$2 implements Runnable {
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$2(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public void run() {
        final View anchorView = this$0.getAnchorView();
        if (anchorView != null && anchorView.getWindowToken() != null) {
            this$0.show();
        }
    }
}