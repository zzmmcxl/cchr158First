package android.support.v4.view;

import android.support.v4.view.ViewConfigurationCompat$BaseViewConfigurationVersionImpl;
import android.support.v4.view.ViewConfigurationCompatFroyo;
import android.view.ViewConfiguration;

class ViewConfigurationCompat$FroyoViewConfigurationVersionImpl extends ViewConfigurationCompat$BaseViewConfigurationVersionImpl {
   public int getScaledPagingTouchSlop(ViewConfiguration var1) {
      return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(var1);
   }
}
