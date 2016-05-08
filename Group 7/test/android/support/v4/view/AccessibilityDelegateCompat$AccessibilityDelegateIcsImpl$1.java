package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl;
import android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1 implements AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge {
   AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl var1, AccessibilityDelegateCompat var2) {
      this.this$0 = var1;
      this.val$compat = var2;
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return this.val$compat.dispatchPopulateAccessibilityEvent(var1, var2);
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      this.val$compat.onInitializeAccessibilityEvent(var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, Object var2) {
      this.val$compat.onInitializeAccessibilityNodeInfo(var1, new AccessibilityNodeInfoCompat(var2));
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      this.val$compat.onPopulateAccessibilityEvent(var1, var2);
   }

   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return this.val$compat.onRequestSendAccessibilityEvent(var1, var2, var3);
   }

   public void sendAccessibilityEvent(View var1, int var2) {
      this.val$compat.sendAccessibilityEvent(var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      this.val$compat.sendAccessibilityEventUnchecked(var1, var2);
   }
}
