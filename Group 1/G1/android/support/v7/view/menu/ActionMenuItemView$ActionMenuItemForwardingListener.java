package android.support.v7.view.menu;

import android.view.View;
import android.support.v7.widget.ListPopupWindow;

private class ActionMenuItemForwardingListener extends ForwardingListener
{
    final /* synthetic */ ActionMenuItemView this$0;
    
    public ActionMenuItemForwardingListener(final ActionMenuItemView this$0) {
        this$0 = this$0;
        super((View)this$0);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        if (ActionMenuItemView.access$000(this$0) != null) {
            return ActionMenuItemView.access$000(this$0).getPopup();
        }
        return null;
    }
    
    @Override
    protected boolean onForwardingStarted() {
        final ItemInvoker access$100 = ActionMenuItemView.access$100(this$0);
        boolean b = false;
        if (access$100 != null) {
            final boolean invokeItem = ActionMenuItemView.access$100(this$0).invokeItem(ActionMenuItemView.access$200(this$0));
            b = false;
            if (invokeItem) {
                final ListPopupWindow popup = this.getPopup();
                b = false;
                if (popup != null) {
                    final boolean showing = popup.isShowing();
                    b = false;
                    if (showing) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }
}
