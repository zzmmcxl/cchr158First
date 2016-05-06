package android.support.v4.accessibilityservice;

import android.content.pm.ResolveInfo;
import android.accessibilityservice.AccessibilityServiceInfo;

static class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl
{
    AccessibilityServiceInfoStubImpl() {
        super();
    }
    
    @Override
    public boolean getCanRetrieveWindowContent(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return false;
    }
    
    @Override
    public int getCapabilities(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return 0;
    }
    
    @Override
    public String getDescription(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    @Override
    public String getId(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    @Override
    public ResolveInfo getResolveInfo(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
    
    @Override
    public String getSettingsActivityName(final AccessibilityServiceInfo accessibilityServiceInfo) {
        return null;
    }
}
