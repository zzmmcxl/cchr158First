package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

private class OnMenuItemClickListenerWrapper extends BaseWrapper<MenuItem$OnMenuItemClickListener> implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ MenuItemWrapperICS this$0;
    
    OnMenuItemClickListenerWrapper(final MenuItemWrapperICS this$0, final MenuItem$OnMenuItemClickListener menuItem$OnMenuItemClickListener) {
        this$0 = this$0;
        super(menuItem$OnMenuItemClickListener);
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return ((MenuItem$OnMenuItemClickListener)this.mWrappedObject).onMenuItemClick(this$0.getMenuItemWrapper(menuItem));
    }
}
