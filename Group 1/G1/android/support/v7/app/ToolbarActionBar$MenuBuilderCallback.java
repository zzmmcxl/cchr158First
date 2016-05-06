package android.support.v7.app;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;

private final class MenuBuilderCallback implements Callback
{
    final /* synthetic */ ToolbarActionBar this$0;
    
    private MenuBuilderCallback(final ToolbarActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    MenuBuilderCallback(final ToolbarActionBar toolbarActionBar, final ToolbarActionBar$1 runnable) {
        this(toolbarActionBar);
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return false;
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
        if (ToolbarActionBar.access$000(this$0) != null) {
            if (ToolbarActionBar.access$300(this$0).isOverflowMenuShowing()) {
                ToolbarActionBar.access$000(this$0).onPanelClosed(108, (Menu)menuBuilder);
            }
            else if (ToolbarActionBar.access$000(this$0).onPreparePanel(0, (View)null, (Menu)menuBuilder)) {
                ToolbarActionBar.access$000(this$0).onMenuOpened(108, (Menu)menuBuilder);
            }
        }
    }
}
