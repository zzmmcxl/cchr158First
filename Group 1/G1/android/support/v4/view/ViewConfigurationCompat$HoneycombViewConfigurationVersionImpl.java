package android.support.v4.view;

import android.view.ViewConfiguration;

static class HoneycombViewConfigurationVersionImpl extends FroyoViewConfigurationVersionImpl
{
    HoneycombViewConfigurationVersionImpl() {
        super();
    }
    
    @Override
    public boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return false;
    }
}
