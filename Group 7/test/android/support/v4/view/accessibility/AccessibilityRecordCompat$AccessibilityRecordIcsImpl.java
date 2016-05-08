package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat$AccessibilityRecordStubImpl;
import android.support.v4.view.accessibility.AccessibilityRecordCompatIcs;
import android.view.View;
import java.util.List;

class AccessibilityRecordCompat$AccessibilityRecordIcsImpl extends AccessibilityRecordCompat$AccessibilityRecordStubImpl {
   public int getAddedCount(Object var1) {
      return AccessibilityRecordCompatIcs.getAddedCount(var1);
   }

   public CharSequence getBeforeText(Object var1) {
      return AccessibilityRecordCompatIcs.getBeforeText(var1);
   }

   public CharSequence getClassName(Object var1) {
      return AccessibilityRecordCompatIcs.getClassName(var1);
   }

   public CharSequence getContentDescription(Object var1) {
      return AccessibilityRecordCompatIcs.getContentDescription(var1);
   }

   public int getCurrentItemIndex(Object var1) {
      return AccessibilityRecordCompatIcs.getCurrentItemIndex(var1);
   }

   public int getFromIndex(Object var1) {
      return AccessibilityRecordCompatIcs.getFromIndex(var1);
   }

   public int getItemCount(Object var1) {
      return AccessibilityRecordCompatIcs.getItemCount(var1);
   }

   public Parcelable getParcelableData(Object var1) {
      return AccessibilityRecordCompatIcs.getParcelableData(var1);
   }

   public int getRemovedCount(Object var1) {
      return AccessibilityRecordCompatIcs.getRemovedCount(var1);
   }

   public int getScrollX(Object var1) {
      return AccessibilityRecordCompatIcs.getScrollX(var1);
   }

   public int getScrollY(Object var1) {
      return AccessibilityRecordCompatIcs.getScrollY(var1);
   }

   public AccessibilityNodeInfoCompat getSource(Object var1) {
      return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityRecordCompatIcs.getSource(var1));
   }

   public List<CharSequence> getText(Object var1) {
      return AccessibilityRecordCompatIcs.getText(var1);
   }

   public int getToIndex(Object var1) {
      return AccessibilityRecordCompatIcs.getToIndex(var1);
   }

   public int getWindowId(Object var1) {
      return AccessibilityRecordCompatIcs.getWindowId(var1);
   }

   public boolean isChecked(Object var1) {
      return AccessibilityRecordCompatIcs.isChecked(var1);
   }

   public boolean isEnabled(Object var1) {
      return AccessibilityRecordCompatIcs.isEnabled(var1);
   }

   public boolean isFullScreen(Object var1) {
      return AccessibilityRecordCompatIcs.isFullScreen(var1);
   }

   public boolean isPassword(Object var1) {
      return AccessibilityRecordCompatIcs.isPassword(var1);
   }

   public boolean isScrollable(Object var1) {
      return AccessibilityRecordCompatIcs.isScrollable(var1);
   }

   public Object obtain() {
      return AccessibilityRecordCompatIcs.obtain();
   }

   public Object obtain(Object var1) {
      return AccessibilityRecordCompatIcs.obtain(var1);
   }

   public void recycle(Object var1) {
      AccessibilityRecordCompatIcs.recycle(var1);
   }

   public void setAddedCount(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setAddedCount(var1, var2);
   }

   public void setBeforeText(Object var1, CharSequence var2) {
      AccessibilityRecordCompatIcs.setBeforeText(var1, var2);
   }

   public void setChecked(Object var1, boolean var2) {
      AccessibilityRecordCompatIcs.setChecked(var1, var2);
   }

   public void setClassName(Object var1, CharSequence var2) {
      AccessibilityRecordCompatIcs.setClassName(var1, var2);
   }

   public void setContentDescription(Object var1, CharSequence var2) {
      AccessibilityRecordCompatIcs.setContentDescription(var1, var2);
   }

   public void setCurrentItemIndex(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setCurrentItemIndex(var1, var2);
   }

   public void setEnabled(Object var1, boolean var2) {
      AccessibilityRecordCompatIcs.setEnabled(var1, var2);
   }

   public void setFromIndex(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setFromIndex(var1, var2);
   }

   public void setFullScreen(Object var1, boolean var2) {
      AccessibilityRecordCompatIcs.setFullScreen(var1, var2);
   }

   public void setItemCount(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setItemCount(var1, var2);
   }

   public void setParcelableData(Object var1, Parcelable var2) {
      AccessibilityRecordCompatIcs.setParcelableData(var1, var2);
   }

   public void setPassword(Object var1, boolean var2) {
      AccessibilityRecordCompatIcs.setPassword(var1, var2);
   }

   public void setRemovedCount(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setRemovedCount(var1, var2);
   }

   public void setScrollX(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setScrollX(var1, var2);
   }

   public void setScrollY(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setScrollY(var1, var2);
   }

   public void setScrollable(Object var1, boolean var2) {
      AccessibilityRecordCompatIcs.setScrollable(var1, var2);
   }

   public void setSource(Object var1, View var2) {
      AccessibilityRecordCompatIcs.setSource(var1, var2);
   }

   public void setToIndex(Object var1, int var2) {
      AccessibilityRecordCompatIcs.setToIndex(var1, var2);
   }
}
