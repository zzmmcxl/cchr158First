package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatIcs;
import android.view.View;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl {
   public void addAction(Object var1, int var2) {
      AccessibilityNodeInfoCompatIcs.addAction(var1, var2);
   }

   public void addChild(Object var1, View var2) {
      AccessibilityNodeInfoCompatIcs.addChild(var1, var2);
   }

   public List<Object> findAccessibilityNodeInfosByText(Object var1, String var2) {
      return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(var1, var2);
   }

   public int getActions(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getActions(var1);
   }

   public void getBoundsInParent(Object var1, Rect var2) {
      AccessibilityNodeInfoCompatIcs.getBoundsInParent(var1, var2);
   }

   public void getBoundsInScreen(Object var1, Rect var2) {
      AccessibilityNodeInfoCompatIcs.getBoundsInScreen(var1, var2);
   }

   public Object getChild(Object var1, int var2) {
      return AccessibilityNodeInfoCompatIcs.getChild(var1, var2);
   }

   public int getChildCount(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getChildCount(var1);
   }

   public CharSequence getClassName(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getClassName(var1);
   }

   public CharSequence getContentDescription(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getContentDescription(var1);
   }

   public CharSequence getPackageName(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getPackageName(var1);
   }

   public Object getParent(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getParent(var1);
   }

   public CharSequence getText(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getText(var1);
   }

   public int getWindowId(Object var1) {
      return AccessibilityNodeInfoCompatIcs.getWindowId(var1);
   }

   public boolean isCheckable(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isCheckable(var1);
   }

   public boolean isChecked(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isChecked(var1);
   }

   public boolean isClickable(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isClickable(var1);
   }

   public boolean isEnabled(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isEnabled(var1);
   }

   public boolean isFocusable(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isFocusable(var1);
   }

   public boolean isFocused(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isFocused(var1);
   }

   public boolean isLongClickable(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isLongClickable(var1);
   }

   public boolean isPassword(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isPassword(var1);
   }

   public boolean isScrollable(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isScrollable(var1);
   }

   public boolean isSelected(Object var1) {
      return AccessibilityNodeInfoCompatIcs.isSelected(var1);
   }

   public Object obtain() {
      return AccessibilityNodeInfoCompatIcs.obtain();
   }

   public Object obtain(View var1) {
      return AccessibilityNodeInfoCompatIcs.obtain(var1);
   }

   public Object obtain(Object var1) {
      return AccessibilityNodeInfoCompatIcs.obtain(var1);
   }

   public boolean performAction(Object var1, int var2) {
      return AccessibilityNodeInfoCompatIcs.performAction(var1, var2);
   }

   public void recycle(Object var1) {
      AccessibilityNodeInfoCompatIcs.recycle(var1);
   }

   public void setBoundsInParent(Object var1, Rect var2) {
      AccessibilityNodeInfoCompatIcs.setBoundsInParent(var1, var2);
   }

   public void setBoundsInScreen(Object var1, Rect var2) {
      AccessibilityNodeInfoCompatIcs.setBoundsInScreen(var1, var2);
   }

   public void setCheckable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setCheckable(var1, var2);
   }

   public void setChecked(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setChecked(var1, var2);
   }

   public void setClassName(Object var1, CharSequence var2) {
      AccessibilityNodeInfoCompatIcs.setClassName(var1, var2);
   }

   public void setClickable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setClickable(var1, var2);
   }

   public void setContentDescription(Object var1, CharSequence var2) {
      AccessibilityNodeInfoCompatIcs.setContentDescription(var1, var2);
   }

   public void setEnabled(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setEnabled(var1, var2);
   }

   public void setFocusable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setFocusable(var1, var2);
   }

   public void setFocused(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setFocused(var1, var2);
   }

   public void setLongClickable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setLongClickable(var1, var2);
   }

   public void setPackageName(Object var1, CharSequence var2) {
      AccessibilityNodeInfoCompatIcs.setPackageName(var1, var2);
   }

   public void setParent(Object var1, View var2) {
      AccessibilityNodeInfoCompatIcs.setParent(var1, var2);
   }

   public void setPassword(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setPassword(var1, var2);
   }

   public void setScrollable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setScrollable(var1, var2);
   }

   public void setSelected(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatIcs.setSelected(var1, var2);
   }

   public void setSource(Object var1, View var2) {
      AccessibilityNodeInfoCompatIcs.setSource(var1, var2);
   }

   public void setText(Object var1, CharSequence var2) {
      AccessibilityNodeInfoCompatIcs.setText(var1, var2);
   }
}
