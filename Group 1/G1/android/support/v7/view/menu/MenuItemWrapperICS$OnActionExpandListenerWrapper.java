package android.support.v7.view.menu;

import android.view.MenuItem;
import android.support.v4.view.MenuItemCompat;
import android.view.MenuItem$OnActionExpandListener;

private class OnActionExpandListenerWrapper extends BaseWrapper<MenuItem$OnActionExpandListener> implements OnActionExpandListener
{
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    OnActionExpandListenerWrapper(final MenuItemWrapperICS this$0, final MenuItem$OnActionExpandListener menuItem$OnActionExpandListener) {
        this$0 = this$0;
        super(menuItem$OnActionExpandListener);
    }
    
    @Override
    public boolean onMenuItemActionCollapse(final MenuItem menuItem) {
        return ((MenuItem$OnActionExpandListener)this.mWrappedObject).onMenuItemActionCollapse(this$0.getMenuItemWrapper(menuItem));
    }
    
    @Override
    public boolean onMenuItemActionExpand(final MenuItem menuItem) {
        return ((MenuItem$OnActionExpandListener)this.mWrappedObject).onMenuItemActionExpand(this$0.getMenuItemWrapper(menuItem));
    }
}
