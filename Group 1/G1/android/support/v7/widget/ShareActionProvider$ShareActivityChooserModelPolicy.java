package android.support.v7.widget;

import android.content.Intent;

private class ShareActivityChooserModelPolicy implements OnChooseActivityListener
{
    final /* synthetic */ ShareActionProvider this$0;
    
    private ShareActivityChooserModelPolicy(final ShareActionProvider this$0) {
        this$0 = this$0;
        super();
    }
    
    ShareActivityChooserModelPolicy(final ShareActionProvider shareActionProvider, final ShareActionProvider$1 object) {
        this(shareActionProvider);
    }
    
    @Override
    public boolean onChooseActivity(final ActivityChooserModel activityChooserModel, final Intent intent) {
        if (ShareActionProvider.access$500(this$0) != null) {
            ShareActionProvider.access$500(this$0).onShareTargetSelected(this$0, intent);
        }
        return false;
    }
}
