package android.support.v7.app;

import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

class ToolbarActionBar$2 implements OnMenuItemClickListener {
    final /* synthetic */ ToolbarActionBar this$0;
    
    ToolbarActionBar$2(final ToolbarActionBar this$0) {
        this$0 = this$0;
        super();
    }
    
    @Override
    public boolean onMenuItemClick(final MenuItem menuItem) {
        return ToolbarActionBar.access$000(this$0).onMenuItemSelected(0, menuItem);
    }
}