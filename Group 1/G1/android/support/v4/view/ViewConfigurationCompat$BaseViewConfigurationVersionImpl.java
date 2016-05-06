package android.support.v4.view;

import android.view.ViewConfiguration;

static class BaseViewConfigurationVersionImpl implements ViewConfigurationVersionImpl
{
    BaseViewConfigurationVersionImpl() {
        super();
    }
    
    @Override
    public int getScaledPagingTouchSlop(final ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledTouchSlop();
    }
    
    @Override
    public boolean hasPermanentMenuKey(final ViewConfiguration viewConfiguration) {
        return true;
    }
}
