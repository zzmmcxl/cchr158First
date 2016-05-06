package android.support.v7.widget;

import android.view.View;

class ListPopupWindow$1 extends ForwardingListener {
    final /* synthetic */ ListPopupWindow this$0;
    
    ListPopupWindow$1(final ListPopupWindow this$0, final View view) {
        this$0 = this$0;
        super(view);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        return this$0;
    }
}