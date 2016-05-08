package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$1;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class AccessibilityDelegateCompatJellyBean {
   public static Object getAccessibilityNodeProvider(Object var0, View var1) {
      return ((AccessibilityDelegate)var0).getAccessibilityNodeProvider(var1);
   }

   public static Object newAccessibilityDelegateBridge(AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean var0) {
      return new AccessibilityDelegateCompatJellyBean$1(var0);
   }

   public static boolean performAccessibilityAction(Object var0, View var1, int var2, Bundle var3) {
      return ((AccessibilityDelegate)var0).performAccessibilityAction(var1, var2, var3);
   }
}
