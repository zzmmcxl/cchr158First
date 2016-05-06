package android.support.v7.widget;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem$OnMenuItemClickListener;

private class ShareMenuItemOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    private ShareMenuItemOnMenuItemClickListener(final ShareActionProvider this$0) {
        this$0 = this$0;
        super();
    }
    
    ShareMenuItemOnMenuItemClickListener(final ShareActionProvider shareActionProvider, final ShareActionProvider$1 object) {
        this(shareActionProvider);
    }
    
    public boolean onMenuItemClick(final MenuItem menuItem) {
        final Intent chooseActivity = ActivityChooserModel.get(ShareActionProvider.access$100(this$0), ShareActionProvider.access$200(this$0)).chooseActivity(menuItem.getItemId());
        if (chooseActivity != null) {
            final String action = chooseActivity.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                ShareActionProvider.access$300(this$0, chooseActivity);
            }
            ShareActionProvider.access$100(this$0).startActivity(chooseActivity);
        }
        return true;
    }
}
