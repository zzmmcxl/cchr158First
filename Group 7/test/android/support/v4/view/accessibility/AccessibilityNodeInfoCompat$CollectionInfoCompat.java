package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class AccessibilityNodeInfoCompat$CollectionInfoCompat {
   public static final int SELECTION_MODE_MULTIPLE = 2;
   public static final int SELECTION_MODE_NONE = 0;
   public static final int SELECTION_MODE_SINGLE = 1;
   final Object mInfo;

   private AccessibilityNodeInfoCompat$CollectionInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   public static AccessibilityNodeInfoCompat$CollectionInfoCompat obtain(int var0, int var1, boolean var2, int var3) {
      return new AccessibilityNodeInfoCompat$CollectionInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionInfo(var0, var1, var2, var3));
   }

   public int getColumnCount() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionInfoColumnCount(this.mInfo);
   }

   public int getRowCount() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionInfoRowCount(this.mInfo);
   }

   public boolean isHierarchical() {
      return AccessibilityNodeInfoCompat.access$000().isCollectionInfoHierarchical(this.mInfo);
   }
}
