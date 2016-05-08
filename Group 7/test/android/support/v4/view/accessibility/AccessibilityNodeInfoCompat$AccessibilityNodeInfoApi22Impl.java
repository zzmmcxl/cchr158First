package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi22;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl {
   public Object getTraversalAfter(Object var1) {
      return AccessibilityNodeInfoCompatApi22.getTraversalAfter(var1);
   }

   public Object getTraversalBefore(Object var1) {
      return AccessibilityNodeInfoCompatApi22.getTraversalBefore(var1);
   }

   public void setTraversalAfter(Object var1, View var2) {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(var1, var2);
   }

   public void setTraversalAfter(Object var1, View var2, int var3) {
      AccessibilityNodeInfoCompatApi22.setTraversalAfter(var1, var2, var3);
   }

   public void setTraversalBefore(Object var1, View var2) {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(var1, var2);
   }

   public void setTraversalBefore(Object var1, View var2, int var3) {
      AccessibilityNodeInfoCompatApi22.setTraversalBefore(var1, var2, var3);
   }
}
