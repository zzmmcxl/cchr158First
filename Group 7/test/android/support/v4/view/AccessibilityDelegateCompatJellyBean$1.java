package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

final class AccessibilityDelegateCompatJellyBean$1 extends AccessibilityDelegate {
   AccessibilityDelegateCompatJellyBean$1(AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean var1) {
      this.val$bridge = var1;
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return this.val$bridge.dispatchPopulateAccessibilityEvent(var1, var2);
   }

   public AccessibilityNodeProvider getAccessibilityNodeProvider(View var1) {
      return (AccessibilityNodeProvider)this.val$bridge.getAccessibilityNodeProvider(var1);
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      this.val$bridge.onInitializeAccessibilityEvent(var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
      this.val$bridge.onInitializeAccessibilityNodeInfo(var1, var2);
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      this.val$bridge.onPopulateAccessibilityEvent(var1, var2);
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return this.val$bridge.onRequestSendAccessibilityEvent(var1, var2, var3);
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return this.val$bridge.performAccessibilityAction(var1, var2, var3);
   }

   public void sendAccessibilityEvent(View var1, int var2) {
      this.val$bridge.sendAccessibilityEvent(var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      this.val$bridge.sendAccessibilityEventUnchecked(var1, var2);
   }
}
