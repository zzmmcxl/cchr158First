package android.support.v7.widget;

import android.view.MenuItem;

class Toolbar$1 implements ActionMenuView.OnMenuItemClickListener {
    final /* synthetic */ Toolbar this$0;
    
    Toolbar$1(final Toolbar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return Toolbar.access$000(this$0) != null && Toolbar.access$000(this$0).onMenuItemClick(menuItem);
    }
}