package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl;
import android.support.v4.view.AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1 implements AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean {
   AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl$1(AccessibilityDelegateCompat$AccessibilityDelegateJellyBeanImpl var1, AccessibilityDelegateCompat var2) {
      this.this$0 = var1;
      this.val$compat = var2;
   }

   public boolean dispatchPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      return this.val$compat.dispatchPopulateAccessibilityEvent(var1, var2);
   }

   public Object getAccessibilityNodeProvider(View var1) {
      AccessibilityNodeProviderCompat var2 = this.val$compat.getAccessibilityNodeProvider(var1);
      return var2 != null?var2.getProvider():null;
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

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return this.val$compat.performAccessibilityAction(var1, var2, var3);
   }

   public void sendAccessibilityEvent(View var1, int var2) {
      this.val$compat.sendAccessibilityEvent(var1, var2);
   }

   public void sendAccessibilityEventUnchecked(View var1, AccessibilityEvent var2) {
      this.val$compat.sendAccessibilityEventUnchecked(var1, var2);
   }
}
