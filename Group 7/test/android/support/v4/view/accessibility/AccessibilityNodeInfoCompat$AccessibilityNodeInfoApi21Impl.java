package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21$CollectionItemInfo;
import android.view.View;
import java.util.List;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl {
   public void addAction(Object var1, Object var2) {
      AccessibilityNodeInfoCompatApi21.addAction(var1, var2);
   }

   public int getAccessibilityActionId(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(var1);
   }

   public CharSequence getAccessibilityActionLabel(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(var1);
   }

   public List<Object> getActionList(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getActionList(var1);
   }

   public CharSequence getError(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getError(var1);
   }

   public int getMaxTextLength(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getMaxTextLength(var1);
   }

   public Object getWindow(Object var1) {
      return AccessibilityNodeInfoCompatApi21.getWindow(var1);
   }

   public boolean isCollectionItemSelected(Object var1) {
      return AccessibilityNodeInfoCompatApi21$CollectionItemInfo.isSelected(var1);
   }

   public Object newAccessibilityAction(int var1, CharSequence var2) {
      return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(var1, var2);
   }

   public Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4) {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(var1, var2, var3, var4);
   }

   public Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
      return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(var1, var2, var3, var4, var5, var6);
   }

   public boolean removeAction(Object var1, Object var2) {
      return AccessibilityNodeInfoCompatApi21.removeAction(var1, var2);
   }

   public boolean removeChild(Object var1, View var2) {
      return AccessibilityNodeInfoCompatApi21.removeChild(var1, var2);
   }

   public boolean removeChild(Object var1, View var2, int var3) {
      return AccessibilityNodeInfoCompatApi21.removeChild(var1, var2, var3);
   }

   public void setError(Object var1, CharSequence var2) {
      AccessibilityNodeInfoCompatApi21.setError(var1, var2);
   }

   public void setMaxTextLength(Object var1, int var2) {
      AccessibilityNodeInfoCompatApi21.setMaxTextLength(var1, var2);
   }
}
