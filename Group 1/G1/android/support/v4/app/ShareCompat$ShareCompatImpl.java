package android.support.v4.app;

import android.view.MenuItem;

interface ShareCompatImpl
{
    void configureMenuItem(final MenuItem p0, final IntentBuilder p1);
    
    String escapeHtml(final CharSequence p0);
}
