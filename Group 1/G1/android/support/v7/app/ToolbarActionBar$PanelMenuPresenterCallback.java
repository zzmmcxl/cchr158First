package android.support.v7.app;

import android.view.Menu;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPresenter;

private final class PanelMenuPresenterCallback implements Callback
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    private PanelMenuPresenterCallback(final ToolbarActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    PanelMenuPresenterCallback(final ToolbarActionBar toolbarActionBar, final ToolbarActionBar$1 runnable) {
        this(toolbarActionBar);
    }
    
    @Override
    public void onCloseMenu(final MenuBuilder menuBuilder, final boolean b) {
        if (ToolbarActionBar.access$000(this$0) != null) {
            ToolbarActionBar.access$000(this$0).onPanelClosed(0, (Menu)menuBuilder);
        }
    }
    
    @Override
    public boolean onOpenSubMenu(final MenuBuilder menuBuilder) {
        if (menuBuilder == null && ToolbarActionBar.access$000(this$0) != null) {
            ToolbarActionBar.access$000(this$0).onMenuOpened(0, (Menu)menuBuilder);
        }
        return true;
    }
}
