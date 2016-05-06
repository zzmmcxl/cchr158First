package android.support.v7.widget;

import android.view.MenuItem;
import android.view.View;
import android.support.v7.view.menu.ActionMenuItem;
import android.view.View$OnClickListener;

class ToolbarWidgetWrapper$1 implements View$OnClickListener {
    final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.access$000(this$0).getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.access$100(this$0));
    final /* synthetic */ ToolbarWidgetWrapper this$0;
    
    ToolbarWidgetWrapper$1(final ToolbarWidgetWrapper this$0) {
        this$0 = this$0;
        super();
    }
    
    public void onClick(final View view) {
        if (ToolbarWidgetWrapper.access$200(this$0) != null && ToolbarWidgetWrapper.access$300(this$0)) {
            ToolbarWidgetWrapper.access$200(this$0).onMenuItemSelected(0, (MenuItem)mNavItem);
        }
    }
}