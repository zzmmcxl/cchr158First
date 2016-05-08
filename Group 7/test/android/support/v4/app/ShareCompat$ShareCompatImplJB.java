package android.support.v4.app;

import android.support.v4.app.ShareCompat$ShareCompatImplICS;
import android.support.v4.app.ShareCompatJB;
import android.view.MenuItem;

class ShareCompat$ShareCompatImplJB extends ShareCompat$ShareCompatImplICS {
   public String escapeHtml(CharSequence var1) {
      return ShareCompatJB.escapeHtml(var1);
   }

   boolean shouldAddChooserIntent(MenuItem var1) {
      return false;
   }
}
