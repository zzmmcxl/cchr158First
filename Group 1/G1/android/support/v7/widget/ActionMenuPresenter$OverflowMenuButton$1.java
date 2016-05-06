package android.support.v7.widget;

import android.view.View;

class ActionMenuPresenter$OverflowMenuButton$1 extends ForwardingListener {
    final /* synthetic */ OverflowMenuButton this$1;
    final /* synthetic */ ActionMenuPresenter val$this$0;
    
    ActionMenuPresenter$OverflowMenuButton$1(final OverflowMenuButton this$1, final View view, final ActionMenuPresenter val$this$0) {
        this$1 = this$1;
        val$this$0 = val$this$0;
        super(view);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        if (ActionMenuPresenter.access$200(this$0) == null) {
            return null;
        }
        return ActionMenuPresenter.access$200(this$0).getPopup();
    }
    
    public boolean onForwardingStarted() {
        this$0.showOverflowMenu();
        return true;
    }
    
    public boolean onForwardingStopped() {
        if (ActionMenuPresenter.access$300(this$0) != null) {
            return false;
        }
        this$0.hideOverflowMenu();
        return true;
    }
}