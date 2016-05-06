package android.support.v4.view;

import android.view.ViewConfiguration;

class ViewConfigurationCompatFroyo
{
    ViewConfigurationCompatFroyo() {
        super();
    }
    
    public static int getScaledPagingTouchSlop(final ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }
}
