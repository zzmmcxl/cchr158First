package android.support.v4.view;

import android.view.MenuItem;

public final class MenuCompat
{
    private MenuCompat() {
        super();
    }
    
    @Deprecated
    public static void setShowAsAction(final MenuItem menuItem, final int n) {
        MenuItemCompat.setShowAsAction(menuItem, n);
    }
}
