package android.support.v4.app;

import android.support.v4.app.ShareCompat$IntentBuilder;
import android.view.MenuItem;

interface ShareCompat$ShareCompatImpl {
   void configureMenuItem(MenuItem var1, ShareCompat$IntentBuilder var2);

   String escapeHtml(CharSequence var1);
}
