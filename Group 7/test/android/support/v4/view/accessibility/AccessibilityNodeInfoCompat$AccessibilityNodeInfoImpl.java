package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import java.util.List;

interface AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl {
   void addAction(Object var1, int var2);

   void addAction(Object var1, Object var2);

   void addChild(Object var1, View var2);

   void addChild(Object var1, View var2, int var3);

   boolean canOpenPopup(Object var1);

   List<Object> findAccessibilityNodeInfosByText(Object var1, String var2);

   List<Object> findAccessibilityNodeInfosByViewId(Object var1, String var2);

   Object findFocus(Object var1, int var2);

   Object focusSearch(Object var1, int var2);

   int getAccessibilityActionId(Object var1);

   CharSequence getAccessibilityActionLabel(Object var1);

   List<Object> getActionList(Object var1);

   int getActions(Object var1);

   void getBoundsInParent(Object var1, Rect var2);

   void getBoundsInScreen(Object var1, Rect var2);

   Object getChild(Object var1, int var2);

   int getChildCount(Object var1);

   CharSequence getClassName(Object var1);

   Object getCollectionInfo(Object var1);

   int getCollectionInfoColumnCount(Object var1);

   int getCollectionInfoRowCount(Object var1);

   int getCollectionItemColumnIndex(Object var1);

   int getCollectionItemColumnSpan(Object var1);

   Object getCollectionItemInfo(Object var1);

   int getCollectionItemRowIndex(Object var1);

   int getCollectionItemRowSpan(Object var1);

   CharSequence getContentDescription(Object var1);

   CharSequence getError(Object var1);

   Bundle getExtras(Object var1);

   int getInputType(Object var1);

   Object getLabelFor(Object var1);

   Object getLabeledBy(Object var1);

   int getLiveRegion(Object var1);

   int getMaxTextLength(Object var1);

   int getMovementGranularities(Object var1);

   CharSequence getPackageName(Object var1);

   Object getParent(Object var1);

   Object getRangeInfo(Object var1);

   CharSequence getText(Object var1);

   int getTextSelectionEnd(Object var1);

   int getTextSelectionStart(Object var1);

   Object getTraversalAfter(Object var1);

   Object getTraversalBefore(Object var1);

   String getViewIdResourceName(Object var1);

   Object getWindow(Object var1);

   int getWindowId(Object var1);

   boolean isAccessibilityFocused(Object var1);

   boolean isCheckable(Object var1);

   boolean isChecked(Object var1);

   boolean isClickable(Object var1);

   boolean isCollectionInfoHierarchical(Object var1);

   boolean isCollectionItemHeading(Object var1);

   boolean isCollectionItemSelected(Object var1);

   boolean isContentInvalid(Object var1);

   boolean isDismissable(Object var1);

   boolean isEditable(Object var1);

   boolean isEnabled(Object var1);

   boolean isFocusable(Object var1);

   boolean isFocused(Object var1);

   boolean isLongClickable(Object var1);

   boolean isMultiLine(Object var1);

   boolean isPassword(Object var1);

   boolean isScrollable(Object var1);

   boolean isSelected(Object var1);

   boolean isVisibleToUser(Object var1);

   Object newAccessibilityAction(int var1, CharSequence var2);

   Object obtain();

   Object obtain(View var1);

   Object obtain(View var1, int var2);

   Object obtain(Object var1);

   Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4);

   Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6);

   boolean performAction(Object var1, int var2);

   boolean performAction(Object var1, int var2, Bundle var3);

   void recycle(Object var1);

   boolean refresh(Object var1);

   boolean removeAction(Object var1, Object var2);

   boolean removeChild(Object var1, View var2);

   boolean removeChild(Object var1, View var2, int var3);

   void setAccessibilityFocused(Object var1, boolean var2);

   void setBoundsInParent(Object var1, Rect var2);

   void setBoundsInScreen(Object var1, Rect var2);

   void setCanOpenPopup(Object var1, boolean var2);

   void setCheckable(Object var1, boolean var2);

   void setChecked(Object var1, boolean var2);

   void setClassName(Object var1, CharSequence var2);

   void setClickable(Object var1, boolean var2);

   void setCollectionInfo(Object var1, Object var2);

   void setCollectionItemInfo(Object var1, Object var2);

   void setContentDescription(Object var1, CharSequence var2);

   void setContentInvalid(Object var1, boolean var2);

   void setDismissable(Object var1, boolean var2);

   void setEditable(Object var1, boolean var2);

   void setEnabled(Object var1, boolean var2);

   void setError(Object var1, CharSequence var2);

   void setFocusable(Object var1, boolean var2);

   void setFocused(Object var1, boolean var2);

   void setInputType(Object var1, int var2);

   void setLabelFor(Object var1, View var2);

   void setLabelFor(Object var1, View var2, int var3);

   void setLabeledBy(Object var1, View var2);

   void setLabeledBy(Object var1, View var2, int var3);

   void setLiveRegion(Object var1, int var2);

   void setLongClickable(Object var1, boolean var2);

   void setMaxTextLength(Object var1, int var2);

   void setMovementGranularities(Object var1, int var2);

   void setMultiLine(Object var1, boolean var2);

   void setPackageName(Object var1, CharSequence var2);

   void setParent(Object var1, View var2);

   void setParent(Object var1, View var2, int var3);

   void setPassword(Object var1, boolean var2);

   void setRangeInfo(Object var1, Object var2);

   void setScrollable(Object var1, boolean var2);

   void setSelected(Object var1, boolean var2);

   void setSource(Object var1, View var2);

   void setSource(Object var1, View var2, int var3);

   void setText(Object var1, CharSequence var2);

   void setTextSelection(Object var1, int var2, int var3);

   void setTraversalAfter(Object var1, View var2);

   void setTraversalAfter(Object var1, View var2, int var3);

   void setTraversalBefore(Object var1, View var2);

   void setTraversalBefore(Object var1, View var2, int var3);

   void setViewIdResourceName(Object var1, String var2);

   void setVisibleToUser(Object var1, boolean var2);
}
