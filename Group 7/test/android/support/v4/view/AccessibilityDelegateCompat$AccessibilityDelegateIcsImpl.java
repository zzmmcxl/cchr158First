package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1;
import android.support.v4.view.AccessibilityDelegateCompat$AccessibilityDelegateStubImpl;
import android.support.v4.view.AccessibilityDelegateCompatIcs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl extends AccessibilityDelegateCompat$AccessibilityDelegateStubImpl {
   public boolean dispatchPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      return AccessibilityDelegateCompatIcs.dispatchPopulateAccessibilityEvent(var1, var2, var3);
   }

   public Object newAccessiblityDelegateBridge(AccessibilityDelegateCompat var1) {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateBridge(new AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(this, var1));
   }

   public Object newAccessiblityDelegateDefaultImpl() {
      return AccessibilityDelegateCompatIcs.newAccessibilityDelegateDefaultImpl();
   }

   public void onInitializeAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityEvent(var1, var2, var3);
   }

   public void onInitializeAccessibilityNodeInfo(Object var1, View var2, AccessibilityNodeInfoCompat var3) {
      AccessibilityDelegateCompatIcs.onInitializeAccessibilityNodeInfo(var1, var2, var3.getInfo());
   }

   public void onPopulateAccessibilityEvent(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.onPopulateAccessibilityEvent(var1, var2, var3);
   }

   public boolean onRequestSendAccessibilityEvent(Object var1, ViewGroup var2, View var3, AccessibilityEvent var4) {
      return AccessibilityDelegateCompatIcs.onRequestSendAccessibilityEvent(var1, var2, var3, var4);
   }

   public void sendAccessibilityEvent(Object var1, View var2, int var3) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEvent(var1, var2, var3);
   }

   public void sendAccessibilityEventUnchecked(Object var1, View var2, AccessibilityEvent var3) {
      AccessibilityDelegateCompatIcs.sendAccessibilityEventUnchecked(var1, var2, var3);
   }
}
