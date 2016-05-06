package android.support.design.widget;

import android.view.MenuItem;
import android.support.v7.view.menu.MenuBuilder;

class NavigationView$1 implements Callback {
    final /* synthetic */ NavigationView this$0;
    
    NavigationView$1(final NavigationView this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean onMenuItemSelected(final MenuBuilder menuBuilder, final MenuItem menuItem) {
        return NavigationView.access$000(this$0) != null && NavigationView.access$000(this$0).onNavigationItemSelected(menuItem);
    }
    
    @Override
    public void onMenuModeChange(final MenuBuilder menuBuilder) {
    }
}