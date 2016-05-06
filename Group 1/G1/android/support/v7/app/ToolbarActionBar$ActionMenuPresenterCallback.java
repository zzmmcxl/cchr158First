package android.support.v7.app;

import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private final class ActionMenuPresenterCallback implements Callback
{
    private boolean mClosingActionMenu;
    final /* synthetic */ ToolbarActionBar this$0;
    
    private ActionMenuPresenterCallback(final ToolbarActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    ActionMenuPresenterCallback(final ToolbarActionBar toolbarActionBar, final ToolbarActionBar$1 runnable) {
        this(toolbarActionBar);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (mClosingActionMenu) {
            return;
        }
        mClosingActionMenu = true;
        ToolbarActionBar.access$300(this$0).dismissPopupMenus();
        if (ToolbarActionBar.access$000(this$0) != null) {
            ToolbarActionBar.access$000(this$0).onPanelClosed(108, (Menu)menuBuilder);
        }
        mClosingActionMenu = false;
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (ToolbarActionBar.access$000(this$0) != null) {
            ToolbarActionBar.access$000(this$0).onMenuOpened(108, (Menu)menuBuilder);
            return true;
        }
        return false;
    }
}
