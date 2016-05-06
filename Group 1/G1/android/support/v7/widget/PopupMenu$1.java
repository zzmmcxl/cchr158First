package android.support.v7.widget;

import android.view.View;

class PopupMenu$1 extends ForwardingListener {
    final /* synthetic */ PopupMenu this$0;
    
    PopupMenu$1(final PopupMenu this$0, final View view) {
        this$0 = this$0;
        super(view);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        return PopupMenu.access$000(this$0).getPopup();
    }
    
    @Override
    protected boolean onForwardingStarted() {
        this$0.show();
        return true;
    }
    
    @Override
    protected boolean onForwardingStopped() {
        this$0.dismiss();
        return true;
    }
}