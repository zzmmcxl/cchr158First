package android.support.design.internal;

import android.support.v7.view.menu.MenuItemImpl;

private static class NavigationMenuTextItem implements NavigationMenuItem
{
    private final MenuItemImpl mMenuItem;
    
    private NavigationMenuTextItem(final MenuItemImpl mMenuItem) {
        super();
        this.mMenuItem = mMenuItem;
    }
    
    NavigationMenuTextItem(final MenuItemImpl menuItemImpl, final NavigationMenuPresenter$1 view$OnClickListener) {
        this(menuItemImpl);
    }
    
    public MenuItemImpl getMenuItem() {
        return mMenuItem;
    }
}
