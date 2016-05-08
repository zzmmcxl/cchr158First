package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl {
   public List<Object> findAccessibilityNodeInfosByViewId(Object var1, String var2) {
      return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(var1, var2);
   }

   public int getTextSelectionEnd(Object var1) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(var1);
   }

   public int getTextSelectionStart(Object var1) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(var1);
   }

   public String getViewIdResourceName(Object var1) {
      return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(var1);
   }

   public boolean isEditable(Object var1) {
      return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(var1);
   }

   public boolean refresh(Object var1) {
      return AccessibilityNodeInfoCompatJellybeanMr2.refresh(var1);
   }

   public void setEditable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatJellybeanMr2.setEditable(var1, var2);
   }

   public void setTextSelection(Object var1, int var2, int var3) {
      AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(var1, var2, var3);
   }

   public void setViewIdResourceName(Object var1, String var2) {
      AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(var1, var2);
   }
}
