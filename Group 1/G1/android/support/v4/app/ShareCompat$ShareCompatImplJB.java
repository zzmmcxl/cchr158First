package android.support.v4.app;

import android.view.MenuItem;

static class ShareCompatImplJB extends ShareCompatImplICS
{
    ShareCompatImplJB() {
        super();
    }
    
    @Override
    public String escapeHtml(final CharSequence charSequence) {
        return ShareCompatJB.escapeHtml(charSequence);
    }
    
    @Override
    boolean shouldAddChooserIntent(final MenuItem menuItem) {
        return false;
    }
}
