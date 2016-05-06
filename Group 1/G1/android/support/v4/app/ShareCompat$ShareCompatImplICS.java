package android.support.v4.app;

import android.view.MenuItem;

static class ShareCompatImplICS extends ShareCompatImplBase
{
    ShareCompatImplICS() {
        super();
    }
    
    @Override
    public void configureMenuItem(final MenuItem menuItem, final IntentBuilder intentBuilder) {
        ShareCompatICS.configureMenuItem(menuItem, intentBuilder.getActivity(), intentBuilder.getIntent());
        if (this.shouldAddChooserIntent(menuItem)) {
            menuItem.setIntent(intentBuilder.createChooserIntent());
        }
    }
    
    boolean shouldAddChooserIntent(final MenuItem menuItem) {
        return !menuItem.hasSubMenu();
    }
}
