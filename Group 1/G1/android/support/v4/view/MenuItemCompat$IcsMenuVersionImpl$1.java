package android.support.v4.view;

import android.view.MenuItem;

class MenuItemCompat$IcsMenuVersionImpl$1 implements SupportActionExpandProxy {
    final /* synthetic */ IcsMenuVersionImpl this$0;
    final /* synthetic */ OnActionExpandListener val$listener;
    
    MenuItemCompat$IcsMenuVersionImpl$1(final IcsMenuVersionImpl this$0, final OnActionExpandListener val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return val$listener.onMenuItemActionCollapse(menuItem);
    }
    
    @Override
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return val$listener.onMenuItemActionExpand(menuItem);
    }
}