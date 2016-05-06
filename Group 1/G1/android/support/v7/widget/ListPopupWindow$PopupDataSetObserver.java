package android.support.v7.widget;

import android.database.DataSetObserver;

private class PopupDataSetObserver extends DataSetObserver
{
    final /* synthetic */ ListPopupWindow this$0;
    
    private PopupDataSetObserver(final ListPopupWindow this$0) {
        this$0 = this$0;
        super();
    }
    
    PopupDataSetObserver(final ListPopupWindow listPopupWindow, final ListPopupWindow$1 forwardingListener) {
        this(listPopupWindow);
    }
    
    public void onChanged() {
        if (this$0.isShowing()) {
            this$0.show();
        }
    }
    
    public void onInvalidated() {
        this$0.dismiss();
    }
}
