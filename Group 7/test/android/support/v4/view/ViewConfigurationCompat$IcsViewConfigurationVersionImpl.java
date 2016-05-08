package android.support.v4.view;

import android.support.v4.view.ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl;
import android.support.v4.view.ViewConfigurationCompatICS;
import android.view.ViewConfiguration;

class ViewConfigurationCompat$IcsViewConfigurationVersionImpl extends ViewConfigurationCompat$HoneycombViewConfigurationVersionImpl {
   public boolean hasPermanentMenuKey(ViewConfiguration var1) {
      return ViewConfigurationCompatICS.hasPermanentMenuKey(var1);
   }
}
