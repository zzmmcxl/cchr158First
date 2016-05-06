package android.support.v4.view.accessibility;

import android.view.View;

static class AccessibilityRecordJellyBeanImpl extends AccessibilityRecordIcsMr1Impl
{
    AccessibilityRecordJellyBeanImpl() {
        super();
    }
    
    @Override
    public void setSource(final Object o, final View view, final int n) {
        AccessibilityRecordCompatJellyBean.setSource(o, view, n);
    }
}
