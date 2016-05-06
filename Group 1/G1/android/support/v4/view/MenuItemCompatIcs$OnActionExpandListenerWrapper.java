package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem$OnActionExpandListener;

static class OnActionExpandListenerWrapper implements MenuItem$OnActionExpandListener
{
    private SupportActionExpandProxy mWrapped;
    
    public OnActionExpandListenerWrapper(final SupportActionExpandProxy mWrapped) {
        super();
        this.mWrapped = mWrapped;
    }
    
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return mWrapped.onMenuItemActionCollapse(menuItem);
    }
    
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return mWrapped.onMenuItemActionExpand(menuItem);
    }
}
