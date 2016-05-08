package android.support.v4.view.accessibility;

import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import java.util.List;

interface AccessibilityRecordCompat$AccessibilityRecordImpl {
   int getAddedCount(Object var1);

   CharSequence getBeforeText(Object var1);

   CharSequence getClassName(Object var1);

   CharSequence getContentDescription(Object var1);

   int getCurrentItemIndex(Object var1);

   int getFromIndex(Object var1);

   int getItemCount(Object var1);

   int getMaxScrollX(Object var1);

   int getMaxScrollY(Object var1);

   Parcelable getParcelableData(Object var1);

   int getRemovedCount(Object var1);

   int getScrollX(Object var1);

   int getScrollY(Object var1);

   AccessibilityNodeInfoCompat getSource(Object var1);

   List<CharSequence> getText(Object var1);

   int getToIndex(Object var1);

   int getWindowId(Object var1);

   boolean isChecked(Object var1);

   boolean isEnabled(Object var1);

   boolean isFullScreen(Object var1);

   boolean isPassword(Object var1);

   boolean isScrollable(Object var1);

   Object obtain();

   Object obtain(Object var1);

   void recycle(Object var1);

   void setAddedCount(Object var1, int var2);

   void setBeforeText(Object var1, CharSequence var2);

   void setChecked(Object var1, boolean var2);

   void setClassName(Object var1, CharSequence var2);

   void setContentDescription(Object var1, CharSequence var2);

   void setCurrentItemIndex(Object var1, int var2);

   void setEnabled(Object var1, boolean var2);

   void setFromIndex(Object var1, int var2);

   void setFullScreen(Object var1, boolean var2);

   void setItemCount(Object var1, int var2);

   void setMaxScrollX(Object var1, int var2);

   void setMaxScrollY(Object var1, int var2);

   void setParcelableData(Object var1, Parcelable var2);

   void setPassword(Object var1, boolean var2);

   void setRemovedCount(Object var1, int var2);

   void setScrollX(Object var1, int var2);

   void setScrollY(Object var1, int var2);

   void setScrollable(Object var1, boolean var2);

   void setSource(Object var1, View var2);

   void setSource(Object var1, View var2, int var3);

   void setToIndex(Object var1, int var2);
}
