package android.support.v4.view;

import android.view.ViewConfiguration;

static class IcsViewConfigurationVersionImpl extends HoneycombViewConfigurationVersionImpl
{
    IcsViewConfigurationVersionImpl() {
        super();
    }
    
    @Override
    public boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return ViewConfigurationCompatICS.hasPermanentMenuKey(viewConfiguration);
    }
}
