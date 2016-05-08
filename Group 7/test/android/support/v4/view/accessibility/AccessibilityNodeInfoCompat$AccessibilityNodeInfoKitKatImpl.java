package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionInfo;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat$CollectionItemInfo;

class AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl {
   public boolean canOpenPopup(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.canOpenPopup(var1);
   }

   public Object getCollectionInfo(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(var1);
   }

   public int getCollectionInfoColumnCount(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionInfo.getColumnCount(var1);
   }

   public int getCollectionInfoRowCount(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionInfo.getRowCount(var1);
   }

   public int getCollectionItemColumnIndex(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getColumnIndex(var1);
   }

   public int getCollectionItemColumnSpan(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getColumnSpan(var1);
   }

   public Object getCollectionItemInfo(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(var1);
   }

   public int getCollectionItemRowIndex(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getRowIndex(var1);
   }

   public int getCollectionItemRowSpan(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.getRowSpan(var1);
   }

   public Bundle getExtras(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getExtras(var1);
   }

   public int getInputType(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getInputType(var1);
   }

   public int getLiveRegion(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getLiveRegion(var1);
   }

   public Object getRangeInfo(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.getRangeInfo(var1);
   }

   public boolean isCollectionInfoHierarchical(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionInfo.isHierarchical(var1);
   }

   public boolean isCollectionItemHeading(Object var1) {
      return AccessibilityNodeInfoCompatKitKat$CollectionItemInfo.isHeading(var1);
   }

   public boolean isContentInvalid(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.isContentInvalid(var1);
   }

   public boolean isDismissable(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.isDismissable(var1);
   }

   public boolean isMultiLine(Object var1) {
      return AccessibilityNodeInfoCompatKitKat.isMultiLine(var1);
   }

   public Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(var1, var2, var3, var4);
   }

   public Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
      return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(var1, var2, var3, var4, var5);
   }

   public void setCanOpenPopup(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(var1, var2);
   }

   public void setCollectionInfo(Object var1, Object var2) {
      AccessibilityNodeInfoCompatKitKat.setCollectionInfo(var1, var2);
   }

   public void setCollectionItemInfo(Object var1, Object var2) {
      AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(var1, var2);
   }

   public void setContentInvalid(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatKitKat.setContentInvalid(var1, var2);
   }

   public void setDismissable(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatKitKat.setDismissable(var1, var2);
   }

   public void setInputType(Object var1, int var2) {
      AccessibilityNodeInfoCompatKitKat.setInputType(var1, var2);
   }

   public void setLiveRegion(Object var1, int var2) {
      AccessibilityNodeInfoCompatKitKat.setLiveRegion(var1, var2);
   }

   public void setMultiLine(Object var1, boolean var2) {
      AccessibilityNodeInfoCompatKitKat.setMultiLine(var1, var2);
   }

   public void setRangeInfo(Object var1, Object var2) {
      AccessibilityNodeInfoCompatKitKat.setRangeInfo(var1, var2);
   }
}
