package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean;
import android.view.View;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl {
   public void addChild(Object var1, View var2, int var3) {
      AccessibilityNodeInfoCompatJellyBean.addChild(var1, var2, var3);
   }

   public Object findFocus(Object var1, int var2) {
      return AccessibilityNodeInfoCompatJellyBean.findFocus(var1, var2);
   }

   public Object focusSearch(Object var1, int var2) {
      return AccessibilityNodeInfoCompatJellyBean.focusSearch(var1, var2);
   }

   public int getMovementGranularities(Object var1) {
      return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(var1);
   }

   public boolean isAccessibilityFocused(Object var1) {
      return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(var1);
   }

   public boolean isVisibleToUser(Object var1) {
      return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(var1);
   }

   public Object obtain(View var1, int var2) {
      return AccessibilityNodeInfoCompatJellyBean.obtain(var1, var2);
   }

   public boolean performAction(Object var1, int var2, Bundle var3) {
      return AccessibilityNodeInfoCompatJellyBean.performAction(var1, var2, var3);
   }

   public void setAccessibilityFocused(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(var1, var2);
   }

   public void setMovementGranularities(Object var1, int var2) {
      AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(var1, var2);
   }

   public void setParent(Object var1, View var2, int var3) {
      AccessibilityNodeInfoCompatJellyBean.setParent(var1, var2, var3);
   }

   public void setSource(Object var1, View var2, int var3) {
      AccessibilityNodeInfoCompatJellyBean.setSource(var1, var2, var3);
   }

   public void setVisibleToUser(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(var1, var2);
   }
}
