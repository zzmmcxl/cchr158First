package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

interface AccessibilityServiceInfoCompat$AccessibilityServiceInfoVersionImpl {
   boolean getCanRetrieveWindowContent(AccessibilityServiceInfo var1);

   int getCapabilities(AccessibilityServiceInfo var1);

   String getDescription(AccessibilityServiceInfo var1);

   String getId(AccessibilityServiceInfo var1);

   ResolveInfo getResolveInfo(AccessibilityServiceInfo var1);

   String getSettingsActivityName(AccessibilityServiceInfo var1);
}
