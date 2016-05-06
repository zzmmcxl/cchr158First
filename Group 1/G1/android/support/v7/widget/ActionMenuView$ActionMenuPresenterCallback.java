package android.support.v7.widget;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private class ActionMenuPresenterCallback implements MenuPresenter.Callback
{
    final /* synthetic */ ActionMenuView this$0;
    
    private ActionMenuPresenterCallback(final ActionMenuView this$0) {
        this$0 = this$0;
        super();
    }
    
    ActionMenuPresenterCallback(final ActionMenuView actionMenuView, final ActionMenuView$1 object) {
        this(actionMenuView);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        return false;
    }
}
