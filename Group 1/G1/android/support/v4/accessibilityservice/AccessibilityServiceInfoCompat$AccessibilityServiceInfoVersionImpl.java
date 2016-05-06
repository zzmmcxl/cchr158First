package android.support.v4.accessibilityservice;

import android.content.pm.ResolveInfo;
import android.accessibilityservice.AccessibilityServiceInfo;

interface AccessibilityServiceInfoVersionImpl
{
    boolean getCanRetrieveWindowContent(final AccessibilityServiceInfo p0);
    
    int getCapabilities(final AccessibilityServiceInfo p0);
    
    String getDescription(final AccessibilityServiceInfo p0);
    
    String getId(final AccessibilityServiceInfo p0);
    
    ResolveInfo getResolveInfo(final AccessibilityServiceInfo p0);
    
    String getSettingsActivityName(final AccessibilityServiceInfo p0);
}
