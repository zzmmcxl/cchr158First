package android.support.v4.view;

import android.support.v4.view.ViewConfigurationCompat$ViewConfigurationVersionImpl;
import android.view.ViewConfiguration;

class ViewConfigurationCompat$BaseViewConfigurationVersionImpl implements ViewConfigurationCompat$ViewConfigurationVersionImpl {
   public int getScaledPagingTouchSlop(ViewConfiguration var1) {
      return var1.getScaledTouchSlop();
   }

   public boolean hasPermanentMenuKey(ViewConfiguration var1) {
      return true;
   }
}
