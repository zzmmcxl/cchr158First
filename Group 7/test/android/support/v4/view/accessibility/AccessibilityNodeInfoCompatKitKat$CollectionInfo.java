package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;

class AccessibilityNodeInfoCompatKitKat$CollectionInfo {
   static int getColumnCount(Object var0) {
      return ((CollectionInfo)var0).getColumnCount();
   }

   static int getRowCount(Object var0) {
      return ((CollectionInfo)var0).getRowCount();
   }

   static boolean isHierarchical(Object var0) {
      return ((CollectionInfo)var0).isHierarchical();
   }
}
