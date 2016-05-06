package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;

static class AccessibilityServiceInfoJellyBeanMr2 extends AccessibilityServiceInfoIcsImpl
{
    AccessibilityServiceInfoJellyBeanMr2() {
        super();
    }
    
    @Override
    public int getCapabilities(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return AccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(accessibilityServiceInfo);
    }
}
