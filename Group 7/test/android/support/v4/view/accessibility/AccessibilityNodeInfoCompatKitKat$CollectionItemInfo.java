package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;

class AccessibilityNodeInfoCompatKitKat$CollectionItemInfo {
   static int getColumnIndex(Object var0) {
      return ((CollectionItemInfo)var0).getColumnIndex();
   }

   static int getColumnSpan(Object var0) {
      return ((CollectionItemInfo)var0).getColumnSpan();
   }

   static int getRowIndex(Object var0) {
      return ((CollectionItemInfo)var0).getRowIndex();
   }

   static int getRowSpan(Object var0) {
      return ((CollectionItemInfo)var0).getRowSpan();
   }

   static boolean isHeading(Object var0) {
      return ((CollectionItemInfo)var0).isHeading();
   }
}
