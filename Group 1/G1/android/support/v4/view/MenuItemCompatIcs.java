package android.support.v4.view;

import android.view.MenuItem$OnActionExpandListener;
import android.view.MenuItem;

class MenuItemCompatIcs
{
    MenuItemCompatIcs() {
        super();
    }
    
    public static boolean collapseActionView(final MenuItem menuItem) {
        return menuItem.collapseActionView();
    }
    
    public static boolean expandActionView(final MenuItem menuItem) {
        return menuItem.expandActionView();
    }
    
    public static boolean isActionViewExpanded(final MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }
    
    public static MenuItem setOnActionExpandListener(final MenuItem menuItem, final SupportActionExpandProxy supportActionExpandProxy) {
        return menuItem.setOnActionExpandListener((MenuItem$OnActionExpandListener)new OnActionExpandListenerWrapper(supportActionExpandProxy));
    }
}
