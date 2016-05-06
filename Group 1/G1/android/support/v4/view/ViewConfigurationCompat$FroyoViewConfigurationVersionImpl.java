package android.support.v4.view;

import android.view.ViewConfiguration;

static class FroyoViewConfigurationVersionImpl extends BaseViewConfigurationVersionImpl
{
    FroyoViewConfigurationVersionImpl() {
        super();
    }
    
    @Override
    public int getScaledPagingTouchSlop(final ViewConfiguration viewConfiguration) {
        return ViewConfigurationCompatFroyo.getScaledPagingTouchSlop(viewConfiguration);
    }
}
