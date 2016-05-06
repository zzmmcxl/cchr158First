package android.support.v7.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;

private class MenuBuilderCallback implements Callback
{
    final /* synthetic */ ActionMenuView this$0;
    
    private MenuBuilderCallback(final ActionMenuView this$0) {
        this$0 = this$0;
        super();
    }
    
    MenuBuilderCallback(final ActionMenuView actionMenuView, final ActionMenuView$1 object) {
        this(actionMenuView);
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return ActionMenuView.access$200(this$0) != null && ActionMenuView.access$200(this$0).onMenuItemClick(menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (ActionMenuView.access$300(this$0) != null) {
            ActionMenuView.access$300(this$0).onMenuModeChange(menuBuilder);
        }
    }
}
