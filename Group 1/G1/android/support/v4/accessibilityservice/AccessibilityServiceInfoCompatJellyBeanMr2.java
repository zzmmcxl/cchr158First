package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;

class AccessibilityServiceInfoCompatJellyBeanMr2
{
    AccessibilityServiceInfoCompatJellyBeanMr2() {
        super();
    }
    
    public static int getCapabilities(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }
}
