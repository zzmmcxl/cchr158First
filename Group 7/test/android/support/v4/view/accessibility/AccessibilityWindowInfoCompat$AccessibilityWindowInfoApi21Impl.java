package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$1;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompatApi21;

class AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl extends AccessibilityWindowInfoCompat$AccessibilityWindowInfoStubImpl {
   private AccessibilityWindowInfoCompat$AccessibilityWindowInfoApi21Impl() {
      super((AccessibilityWindowInfoCompat$1)null);
   }

   public void getBoundsInScreen(Object var1, Rect var2) {
      AccessibilityWindowInfoCompatApi21.getBoundsInScreen(var1, var2);
   }

   public Object getChild(Object var1, int var2) {
      return AccessibilityWindowInfoCompatApi21.getChild(var1, var2);
   }

   public int getChildCount(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getChildCount(var1);
   }

   public int getId(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getId(var1);
   }

   public int getLayer(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getLayer(var1);
   }

   public Object getParent(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getParent(var1);
   }

   public Object getRoot(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getRoot(var1);
   }

   public int getType(Object var1) {
      return AccessibilityWindowInfoCompatApi21.getType(var1);
   }

   public boolean isAccessibilityFocused(Object var1) {
      return AccessibilityWindowInfoCompatApi21.isAccessibilityFocused(var1);
   }

   public boolean isActive(Object var1) {
      return AccessibilityWindowInfoCompatApi21.isActive(var1);
   }

   public boolean isFocused(Object var1) {
      return AccessibilityWindowInfoCompatApi21.isFocused(var1);
   }

   public Object obtain() {
      return AccessibilityWindowInfoCompatApi21.obtain();
   }

   public Object obtain(Object var1) {
      return AccessibilityWindowInfoCompatApi21.obtain(var1);
   }

   public void recycle(Object var1) {
      AccessibilityWindowInfoCompatApi21.recycle(var1);
   }
}
