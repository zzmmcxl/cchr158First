package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl extends AccessibilityNodeProviderCompat$AccessibilityNodeProviderStubImpl {
   public Object newAccessibilityNodeProviderBridge(AccessibilityNodeProviderCompat var1) {
      return AccessibilityNodeProviderCompatJellyBean.newAccessibilityNodeProviderBridge(new AccessibilityNodeProviderCompat$AccessibilityNodeProviderJellyBeanImpl$1(this, var1));
   }
}
