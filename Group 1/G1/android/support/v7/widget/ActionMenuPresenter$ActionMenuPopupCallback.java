package android.support.v7.widget;

import android.support.v7.view.menu.ActionMenuItemView;

private class ActionMenuPopupCallback extends PopupCallback
{
    final /* synthetic */ ActionMenuPresenter this$0;
    
    private ActionMenuPopupCallback(final ActionMenuPresenter this$0) {
        this$0 = this$0;
        super();
    }
    
    ActionMenuPopupCallback(final ActionMenuPresenter actionMenuPresenter, final ActionMenuPresenter$1 object) {
        this(actionMenuPresenter);
    }
    
    @Override
    public ListPopupWindow getPopup() {
        if (ActionMenuPresenter.access$800(this$0) != null) {
            return ActionMenuPresenter.access$800(this$0).getPopup();
        }
        return null;
    }
}
