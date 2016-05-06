package android.support.v4.view;

import android.view.ViewConfiguration;

class ViewConfigurationCompatICS
{
    ViewConfigurationCompatICS() {
        super();
    }
    
    static boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }
}
