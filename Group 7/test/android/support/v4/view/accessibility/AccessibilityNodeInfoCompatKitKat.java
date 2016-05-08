package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import android.view.accessibility.AccessibilityNodeInfo.RangeInfo;

class AccessibilityNodeInfoCompatKitKat {
   public static boolean canOpenPopup(Object var0) {
      return ((AccessibilityNodeInfo)var0).canOpenPopup();
   }

   static Object getCollectionInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getCollectionInfo();
   }

   static Object getCollectionItemInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getCollectionItemInfo();
   }

   public static Bundle getExtras(Object var0) {
      return ((AccessibilityNodeInfo)var0).getExtras();
   }

   public static int getInputType(Object var0) {
      return ((AccessibilityNodeInfo)var0).getInputType();
   }

   static int getLiveRegion(Object var0) {
      return ((AccessibilityNodeInfo)var0).getLiveRegion();
   }

   static Object getRangeInfo(Object var0) {
      return ((AccessibilityNodeInfo)var0).getRangeInfo();
   }

   public static boolean isContentInvalid(Object var0) {
      return ((AccessibilityNodeInfo)var0).isContentInvalid();
   }

   public static boolean isDismissable(Object var0) {
      return ((AccessibilityNodeInfo)var0).isDismissable();
   }

   public static boolean isMultiLine(Object var0) {
      return ((AccessibilityNodeInfo)var0).isMultiLine();
   }

   public static Object obtainCollectionInfo(int var0, int var1, boolean var2, int var3) {
      return CollectionInfo.obtain(var0, var1, var2);
   }

   public static Object obtainCollectionItemInfo(int var0, int var1, int var2, int var3, boolean var4) {
      return CollectionItemInfo.obtain(var0, var1, var2, var3, var4);
   }

   public static void setCanOpenPopup(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setCanOpenPopup(var1);
   }

   public static void setCollectionInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setCollectionInfo((CollectionInfo)var1);
   }

   public static void setCollectionItemInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setCollectionItemInfo((CollectionItemInfo)var1);
   }

   public static void setContentInvalid(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setContentInvalid(var1);
   }

   public static void setDismissable(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setDismissable(var1);
   }

   public static void setInputType(Object var0, int var1) {
      ((AccessibilityNodeInfo)var0).setInputType(var1);
   }

   static void setLiveRegion(Object var0, int var1) {
      ((AccessibilityNodeInfo)var0).setLiveRegion(var1);
   }

   public static void setMultiLine(Object var0, boolean var1) {
      ((AccessibilityNodeInfo)var0).setMultiLine(var1);
   }

   public static void setRangeInfo(Object var0, Object var1) {
      ((AccessibilityNodeInfo)var0).setRangeInfo((RangeInfo)var1);
   }
}
