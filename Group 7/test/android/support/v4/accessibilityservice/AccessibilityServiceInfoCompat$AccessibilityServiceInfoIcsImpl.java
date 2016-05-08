package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatIcs;

class AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoCompat$AccessibilityServiceInfoStubImpl {
   public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(var1);
   }

   public int getCapabilities(AccessibilityServiceInfo var1) {
      return this.getCanRetrieveWindowContent(var1)?1:0;
   }

   public String getDescription(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatIcs.getDescription(var1);
   }

   public String getId(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatIcs.getId(var1);
   }

   public ResolveInfo getResolveInfo(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatIcs.getResolveInfo(var1);
   }

   public String getSettingsActivityName(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(var1);
   }
}
