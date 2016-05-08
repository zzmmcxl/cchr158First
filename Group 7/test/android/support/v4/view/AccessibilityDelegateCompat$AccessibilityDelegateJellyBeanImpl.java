package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl extends AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl {
   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2) {
      var1 = AccessibilityDelegateCompatJellyBean.getAccessibilityNodeProvider(var1, var2);
      return var1 != null?new AccessibilityNodeProviderCompat(var1):null;
   }

   public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1) {
      return AccessibilityDelegateCompatJellyBean.newAccessibilityDelegateBridge(new AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1(this, var1));
   }

   public boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4) {
      return AccessibilityDelegateCompatJellyBean.performAccessibilityAction(var1, var2, var3, var4);
   }
}
