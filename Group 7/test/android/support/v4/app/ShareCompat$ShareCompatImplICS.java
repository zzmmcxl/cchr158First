package android.support.v4.app;

import android.support.v4.app.ShareCompat$IntentBuilder;
import android.support.v4.app.ShareCompat$ShareCompatImplBase;
import android.support.v4.app.ShareCompatICS;
import android.view.MenuItem;

class ShareCompat$ShareCompatImplICS extends ShareCompat$ShareCompatImplBase {
   public void configureMenuItem(MenuItem var1, ShareCompat$IntentBuilder var2) {
      ShareCompatICS.configureMenuItem(var1, var2.getActivity(), var2.getIntent());
      if(this.shouldAddChooserIntent(var1)) {
         var1.setIntent(var2.createChooserIntent());
      }

   }

   boolean shouldAddChooserIntent(MenuItem var1) {
      return !var1.hasSubMenu();
   }
}
