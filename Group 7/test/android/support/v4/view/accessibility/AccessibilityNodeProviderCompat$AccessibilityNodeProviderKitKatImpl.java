package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl {
   public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat var1) {
      return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(this, var1));
   }
}
