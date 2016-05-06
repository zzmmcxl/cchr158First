package android.support.v7.widget;

import android.view.View;

class AppCompatSpinner$1 extends ForwardingListener {
    final /* synthetic */ AppCompatSpinner this$0;
    final /* synthetic */ DropdownPopup val$popup;
    
    AppCompatSpinner$1(final AppCompatSpinner this$0, final View view, final DropdownPopup val$popup) {
        this$0 = this$0;
        val$popup = val$popup;
        super(view);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        return val$popup;
    }
    
    public boolean onForwardingStarted() {
        if (!AppCompatSpinner.access$000(this$0).isShowing()) {
            AppCompatSpinner.access$000(this$0).show();
        }
        return true;
    }
}