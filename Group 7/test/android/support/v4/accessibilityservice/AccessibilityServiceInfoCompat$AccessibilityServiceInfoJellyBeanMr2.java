package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl;
import android.support.v4.accessibilityservice.AccessibilityServiceInfoCompatJellyBeanMr2;

class AccessibilityServiceInfoCompat$AccessibilityServiceInfoJellyBeanMr2 extends AccessibilityServiceInfoCompat$AccessibilityServiceInfoIcsImpl {
   public int getCapabilities(AccessibilityServiceInfo var1) {
      return AccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(var1);
   }
}
