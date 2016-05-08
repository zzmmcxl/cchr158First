package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateStubImpl implements AccessibilityDelegateCompat$AccessibilityDelegateImpl {
   public boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      return false;
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(Object var1, View var2) {
      return null;
   }

   public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1) {
      return null;
   }

   public Object newAccessiblityDelegateDefaultImpl() {
      return null;
   }

   public void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
   }

   public void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3) {
   }

   public void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
   }

   public boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4) {
      return true;
   }

   public boolean performAccessibilityAction(Object var1, View var2, int var3, Bundle var4) {
      return false;
   }

   public void sendAccessibilityEvent(Object var1, View var2, int var3) {
   }

   public void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3) {
   }
}
