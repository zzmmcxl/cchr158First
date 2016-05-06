package android.support.v4.view;

import android.view.MenuItem;

static class IcsMenuVersionImpl extends HoneycombMenuVersionImpl
{
    IcsMenuVersionImpl() {
        super();
    }
    
    @Override
    public boolean collapseActionView(final MenuItem menuItem) {
        return MenuItemCompatIcs.collapseActionView(menuItem);
    }
    
    @Override
    public boolean expandActionView(final MenuItem menuItem) {
        return MenuItemCompatIcs.expandActionView(menuItem);
    }
    
    @Override
    public boolean isActionViewExpanded(final MenuItem menuItem) {
        return MenuItemCompatIcs.isActionViewExpanded(menuItem);
    }
    
    @Override
    public MenuItem setOnActionExpandListener(final MenuItem menuItem, final OnActionExpandListener onActionExpandListener) {
        if (onActionExpandListener == null) {
            return MenuItemCompatIcs.setOnActionExpandListener(menuItem, null);
        }
        return MenuItemCompatIcs.setOnActionExpandListener(menuItem, (MenuItemCompatIcs.SupportActionExpandProxy)new MenuItemCompatIcs.SupportActionExpandProxy() {
            final /* synthetic */ IcsMenuVersionImpl this$0;
            final /* synthetic */ OnActionExpandListener val$listener;
            
            MenuItemCompat$IcsMenuVersionImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
                return onActionExpandListener.onMenuItemActionCollapse(menuItem);
            }
            
            @Override
            public boolean onMenuItemActionExpand(final MenuItem menuItem) {
                return onActionExpandListener.onMenuItemActionExpand(menuItem);
            }
        });
    }
}
