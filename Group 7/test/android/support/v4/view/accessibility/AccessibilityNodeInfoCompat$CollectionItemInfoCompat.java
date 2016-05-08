package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;

public class AccessibilityNodeInfoCompat$CollectionItemInfoCompat {
   private final Object mInfo;

   private AccessibilityNodeInfoCompat$CollectionItemInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   public static AccessibilityNodeInfoCompat$CollectionItemInfoCompat obtain(int var0, int var1, int var2, int var3, boolean var4, boolean var5) {
      return new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(AccessibilityNodeInfoCompat.access$000().obtainCollectionItemInfo(var0, var1, var2, var3, var4, var5));
   }

   public int getColumnIndex() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnIndex(this.mInfo);
   }

   public int getColumnSpan() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionItemColumnSpan(this.mInfo);
   }

   public int getRowIndex() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowIndex(this.mInfo);
   }

   public int getRowSpan() {
      return AccessibilityNodeInfoCompat.access$000().getCollectionItemRowSpan(this.mInfo);
   }

   public boolean isHeading() {
      return AccessibilityNodeInfoCompat.access$000().isCollectionItemHeading(this.mInfo);
   }

   public boolean isSelected() {
      return AccessibilityNodeInfoCompat.access$000().isCollectionItemSelected(this.mInfo);
   }
}
