package android.support.v4.view;

import android.support.v4.view.AccessibilityDelegateCompatIcs$1;
import android.support.v4.view.AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.AccessibilityDelegate;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

class AccessibilityDelegateCompatIcs {
   public static boolean dispatchPopulateAccessibilityEvent(Object var0, View var1, AccessibilityEvent var2) {
      return ((AccessibilityDelegate)var0).dispatchPopulateAccessibilityEvent(var1, var2);
   }

   public static Object newAccessibilityDelegateBridge(AccessibilityDelegateCompatIcs$AccessibilityDelegateBridge var0) {
      return new AccessibilityDelegateCompatIcs$1(var0);
   }

   public static Object newAccessibilityDelegateDefaultImpl() {
      return new AccessibilityDelegate();
   }

   public static void onInitializeAccessibilityEvent(Object var0, View var1, AccessibilityEvent var2) {
      ((AccessibilityDelegate)var0).onInitializeAccessibilityEvent(var1, var2);
   }

   public static void onInitializeAccessibilityNodeInfo(Object var0, View var1, Object var2) {
      ((AccessibilityDelegate)var0).onInitializeAccessibilityNodeInfo(var1, (AccessibilityNodeInfo)var2);
   }

   public static void onPopulateAccessibilityEvent(Object var0, View var1, AccessibilityEvent var2) {
      ((AccessibilityDelegate)var0).onPopulateAccessibilityEvent(var1, var2);
   }

   public static boolean onRequestSendAccessibilityEvent(Object var0, ViewGroup var1, View var2, AccessibilityEvent var3) {
      return ((AccessibilityDelegate)var0).onRequestSendAccessibilityEvent(var1, var2, var3);
   }

   public static void sendAccessibilityEvent(Object var0, View var1, int var2) {
      ((AccessibilityDelegate)var0).sendAccessibilityEvent(var1, var2);
   }

   public static void sendAccessibilityEventUnchecked(Object var0, View var1, AccessibilityEvent var2) {
      ((AccessibilityDelegate)var0).sendAccessibilityEventUnchecked(var1, var2);
   }
}
