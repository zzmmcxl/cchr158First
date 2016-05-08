package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class AccessibilityDelegateCompatIcs$1 extends AccessibilityDelegate {
   AccessibilityDelegateCompatIcs$1(AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge var1) {
      this.val$bridge = var1;
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return this.val$bridge.dispatchPopulateAccessibilityEvent(var1, var2);
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

   public void sendAccessibilityEvent(View var1, int var2) {
      this.val$bridge.sendAccessibilityEvent(var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      this.val$bridge.sendAccessibilityEventUnchecked(var1, var2);
   }
}
