package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$1;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityWindowInfoCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AccessibilityNodeInfoCompat {
   public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
   public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
   public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
   public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
   public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
   public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
   public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
   public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
   public static final int ACTION_CLEAR_FOCUS = 2;
   public static final int ACTION_CLEAR_SELECTION = 8;
   public static final int ACTION_CLICK = 16;
   public static final int ACTION_COLLAPSE = 524288;
   public static final int ACTION_COPY = 16384;
   public static final int ACTION_CUT = 65536;
   public static final int ACTION_DISMISS = 1048576;
   public static final int ACTION_EXPAND = 262144;
   public static final int ACTION_FOCUS = 1;
   public static final int ACTION_LONG_CLICK = 32;
   public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
   public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
   public static final int ACTION_PASTE = 32768;
   public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
   public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
   public static final int ACTION_SCROLL_BACKWARD = 8192;
   public static final int ACTION_SCROLL_FORWARD = 4096;
   public static final int ACTION_SELECT = 4;
   public static final int ACTION_SET_SELECTION = 131072;
   public static final int ACTION_SET_TEXT = 2097152;
   public static final int FOCUS_ACCESSIBILITY = 2;
   public static final int FOCUS_INPUT = 1;
   private static final AccessibilityNodeInfoCompat$AccessibilityNodeInfoImpl IMPL;
   public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
   public static final int MOVEMENT_GRANULARITY_LINE = 4;
   public static final int MOVEMENT_GRANULARITY_PAGE = 16;
   public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
   public static final int MOVEMENT_GRANULARITY_WORD = 2;
   private final Object mInfo;

   static {
      if(VERSION.SDK_INT >= 22) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi22Impl();
      } else if(VERSION.SDK_INT >= 21) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoApi21Impl();
      } else if(VERSION.SDK_INT >= 19) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoKitKatImpl();
      } else if(VERSION.SDK_INT >= 18) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr2Impl();
      } else if(VERSION.SDK_INT >= 17) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanMr1Impl();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoJellybeanImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoIcsImpl();
      } else {
         IMPL = new AccessibilityNodeInfoCompat$AccessibilityNodeInfoStubImpl();
      }
   }

   public AccessibilityNodeInfoCompat(Object var1) {
      this.mInfo = var1;
   }

   private static String getActionSymbolicName(int var0) {
      switch(var0) {
      case 1:
         return "ACTION_FOCUS";
      case 2:
         return "ACTION_CLEAR_FOCUS";
      case 4:
         return "ACTION_SELECT";
      case 8:
         return "ACTION_CLEAR_SELECTION";
      case 16:
         return "ACTION_CLICK";
      case 32:
         return "ACTION_LONG_CLICK";
      case 64:
         return "ACTION_ACCESSIBILITY_FOCUS";
      case 128:
         return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
      case 256:
         return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
      case 512:
         return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
      case 1024:
         return "ACTION_NEXT_HTML_ELEMENT";
      case 2048:
         return "ACTION_PREVIOUS_HTML_ELEMENT";
      case 4096:
         return "ACTION_SCROLL_FORWARD";
      case 8192:
         return "ACTION_SCROLL_BACKWARD";
      case 16384:
         return "ACTION_COPY";
      case 32768:
         return "ACTION_PASTE";
      case 65536:
         return "ACTION_CUT";
      case 131072:
         return "ACTION_SET_SELECTION";
      default:
         return "ACTION_UNKNOWN";
      }
   }

   public static AccessibilityNodeInfoCompat obtain() {
      return wrapNonNullInstance(IMPL.obtain());
   }

   public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat var0) {
      return wrapNonNullInstance(IMPL.obtain(var0.mInfo));
   }

   public static AccessibilityNodeInfoCompat obtain(View var0) {
      return wrapNonNullInstance(IMPL.obtain(var0));
   }

   public static AccessibilityNodeInfoCompat obtain(View var0, int var1) {
      return wrapNonNullInstance(IMPL.obtain(var0, var1));
   }

   static AccessibilityNodeInfoCompat wrapNonNullInstance(Object var0) {
      return var0 != null?new AccessibilityNodeInfoCompat(var0):null;
   }

   public void addAction(int var1) {
      IMPL.addAction(this.mInfo, var1);
   }

   public void addAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat var1) {
      IMPL.addAction(this.mInfo, AccessibilityNodeInfoCompat$AccessibilityActionCompat.access$100(var1));
   }

   public void addChild(View var1) {
      IMPL.addChild(this.mInfo, var1);
   }

   public void addChild(View var1, int var2) {
      IMPL.addChild(this.mInfo, var1, var2);
   }

   public boolean canOpenPopup() {
      return IMPL.canOpenPopup(this.mInfo);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         AccessibilityNodeInfoCompat var2 = (AccessibilityNodeInfoCompat)var1;
         if(this.mInfo == null) {
            if(var2.mInfo != null) {
               return false;
            }
         } else if(!this.mInfo.equals(var2.mInfo)) {
            return false;
         }
      }

      return true;
   }

   public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String var1) {
      ArrayList var4 = new ArrayList();
      List var5 = IMPL.findAccessibilityNodeInfosByText(this.mInfo, var1);
      int var3 = var5.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         var4.add(new AccessibilityNodeInfoCompat(var5.get(var2)));
      }

      return var4;
   }

   public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String var1) {
      List var4 = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, var1);
      Object var5;
      if(var4 != null) {
         ArrayList var2 = new ArrayList();
         Iterator var3 = var4.iterator();

         while(true) {
            var5 = var2;
            if(!var3.hasNext()) {
               break;
            }

            var2.add(new AccessibilityNodeInfoCompat(var3.next()));
         }
      } else {
         var5 = Collections.emptyList();
      }

      return (List)var5;
   }

   public AccessibilityNodeInfoCompat findFocus(int var1) {
      return wrapNonNullInstance(IMPL.findFocus(this.mInfo, var1));
   }

   public AccessibilityNodeInfoCompat focusSearch(int var1) {
      return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, var1));
   }

   public List<AccessibilityNodeInfoCompat$AccessibilityActionCompat> getActionList() {
      List var5 = IMPL.getActionList(this.mInfo);
      Object var3;
      if(var5 != null) {
         ArrayList var4 = new ArrayList();
         int var2 = var5.size();
         int var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            var4.add(new AccessibilityNodeInfoCompat$AccessibilityActionCompat(var5.get(var1), (AccessibilityNodeInfoCompat$1)null));
            ++var1;
         }
      } else {
         var3 = Collections.emptyList();
      }

      return (List)var3;
   }

   public int getActions() {
      return IMPL.getActions(this.mInfo);
   }

   public void getBoundsInParent(Rect var1) {
      IMPL.getBoundsInParent(this.mInfo, var1);
   }

   public void getBoundsInScreen(Rect var1) {
      IMPL.getBoundsInScreen(this.mInfo, var1);
   }

   public AccessibilityNodeInfoCompat getChild(int var1) {
      return wrapNonNullInstance(IMPL.getChild(this.mInfo, var1));
   }

   public int getChildCount() {
      return IMPL.getChildCount(this.mInfo);
   }

   public CharSequence getClassName() {
      return IMPL.getClassName(this.mInfo);
   }

   public AccessibilityNodeInfoCompat$CollectionInfoCompat getCollectionInfo() {
      Object var1 = IMPL.getCollectionInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat$CollectionInfoCompat(var1, (AccessibilityNodeInfoCompat$1)null);
   }

   public AccessibilityNodeInfoCompat$CollectionItemInfoCompat getCollectionItemInfo() {
      Object var1 = IMPL.getCollectionItemInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(var1, (AccessibilityNodeInfoCompat$1)null);
   }

   public CharSequence getContentDescription() {
      return IMPL.getContentDescription(this.mInfo);
   }

   public CharSequence getError() {
      return IMPL.getError(this.mInfo);
   }

   public Bundle getExtras() {
      return IMPL.getExtras(this.mInfo);
   }

   public Object getInfo() {
      return this.mInfo;
   }

   public int getInputType() {
      return IMPL.getInputType(this.mInfo);
   }

   public AccessibilityNodeInfoCompat getLabelFor() {
      return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
   }

   public AccessibilityNodeInfoCompat getLabeledBy() {
      return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
   }

   public int getLiveRegion() {
      return IMPL.getLiveRegion(this.mInfo);
   }

   public int getMaxTextLength() {
      return IMPL.getMaxTextLength(this.mInfo);
   }

   public int getMovementGranularities() {
      return IMPL.getMovementGranularities(this.mInfo);
   }

   public CharSequence getPackageName() {
      return IMPL.getPackageName(this.mInfo);
   }

   public AccessibilityNodeInfoCompat getParent() {
      return wrapNonNullInstance(IMPL.getParent(this.mInfo));
   }

   public AccessibilityNodeInfoCompat$RangeInfoCompat getRangeInfo() {
      Object var1 = IMPL.getRangeInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat$RangeInfoCompat(var1, (AccessibilityNodeInfoCompat$1)null);
   }

   public CharSequence getText() {
      return IMPL.getText(this.mInfo);
   }

   public int getTextSelectionEnd() {
      return IMPL.getTextSelectionEnd(this.mInfo);
   }

   public int getTextSelectionStart() {
      return IMPL.getTextSelectionStart(this.mInfo);
   }

   public AccessibilityNodeInfoCompat getTraversalAfter() {
      return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
   }

   public AccessibilityNodeInfoCompat getTraversalBefore() {
      return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
   }

   public String getViewIdResourceName() {
      return IMPL.getViewIdResourceName(this.mInfo);
   }

   public AccessibilityWindowInfoCompat getWindow() {
      return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
   }

   public int getWindowId() {
      return IMPL.getWindowId(this.mInfo);
   }

   public int hashCode() {
      return this.mInfo == null?0:this.mInfo.hashCode();
   }

   public boolean isAccessibilityFocused() {
      return IMPL.isAccessibilityFocused(this.mInfo);
   }

   public boolean isCheckable() {
      return IMPL.isCheckable(this.mInfo);
   }

   public boolean isChecked() {
      return IMPL.isChecked(this.mInfo);
   }

   public boolean isClickable() {
      return IMPL.isClickable(this.mInfo);
   }

   public boolean isContentInvalid() {
      return IMPL.isContentInvalid(this.mInfo);
   }

   public boolean isDismissable() {
      return IMPL.isDismissable(this.mInfo);
   }

   public boolean isEditable() {
      return IMPL.isEditable(this.mInfo);
   }

   public boolean isEnabled() {
      return IMPL.isEnabled(this.mInfo);
   }

   public boolean isFocusable() {
      return IMPL.isFocusable(this.mInfo);
   }

   public boolean isFocused() {
      return IMPL.isFocused(this.mInfo);
   }

   public boolean isLongClickable() {
      return IMPL.isLongClickable(this.mInfo);
   }

   public boolean isMultiLine() {
      return IMPL.isMultiLine(this.mInfo);
   }

   public boolean isPassword() {
      return IMPL.isPassword(this.mInfo);
   }

   public boolean isScrollable() {
      return IMPL.isScrollable(this.mInfo);
   }

   public boolean isSelected() {
      return IMPL.isSelected(this.mInfo);
   }

   public boolean isVisibleToUser() {
      return IMPL.isVisibleToUser(this.mInfo);
   }

   public boolean performAction(int var1) {
      return IMPL.performAction(this.mInfo, var1);
   }

   public boolean performAction(int var1, Bundle var2) {
      return IMPL.performAction(this.mInfo, var1, var2);
   }

   public void recycle() {
      IMPL.recycle(this.mInfo);
   }

   public boolean refresh() {
      return IMPL.refresh(this.mInfo);
   }

   public boolean removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat var1) {
      return IMPL.removeAction(this.mInfo, AccessibilityNodeInfoCompat$AccessibilityActionCompat.access$100(var1));
   }

   public boolean removeChild(View var1) {
      return IMPL.removeChild(this.mInfo, var1);
   }

   public boolean removeChild(View var1, int var2) {
      return IMPL.removeChild(this.mInfo, var1, var2);
   }

   public void setAccessibilityFocused(boolean var1) {
      IMPL.setAccessibilityFocused(this.mInfo, var1);
   }

   public void setBoundsInParent(Rect var1) {
      IMPL.setBoundsInParent(this.mInfo, var1);
   }

   public void setBoundsInScreen(Rect var1) {
      IMPL.setBoundsInScreen(this.mInfo, var1);
   }

   public void setCanOpenPopup(boolean var1) {
      IMPL.setCanOpenPopup(this.mInfo, var1);
   }

   public void setCheckable(boolean var1) {
      IMPL.setCheckable(this.mInfo, var1);
   }

   public void setChecked(boolean var1) {
      IMPL.setChecked(this.mInfo, var1);
   }

   public void setClassName(CharSequence var1) {
      IMPL.setClassName(this.mInfo, var1);
   }

   public void setClickable(boolean var1) {
      IMPL.setClickable(this.mInfo, var1);
   }

   public void setCollectionInfo(Object var1) {
      IMPL.setCollectionInfo(this.mInfo, ((AccessibilityNodeInfoCompat$CollectionInfoCompat)var1).mInfo);
   }

   public void setCollectionItemInfo(Object var1) {
      IMPL.setCollectionItemInfo(this.mInfo, AccessibilityNodeInfoCompat$CollectionItemInfoCompat.access$300((AccessibilityNodeInfoCompat$CollectionItemInfoCompat)var1));
   }

   public void setContentDescription(CharSequence var1) {
      IMPL.setContentDescription(this.mInfo, var1);
   }

   public void setContentInvalid(boolean var1) {
      IMPL.setContentInvalid(this.mInfo, var1);
   }

   public void setDismissable(boolean var1) {
      IMPL.setDismissable(this.mInfo, var1);
   }

   public void setEditable(boolean var1) {
      IMPL.setEditable(this.mInfo, var1);
   }

   public void setEnabled(boolean var1) {
      IMPL.setEnabled(this.mInfo, var1);
   }

   public void setError(CharSequence var1) {
      IMPL.setError(this.mInfo, var1);
   }

   public void setFocusable(boolean var1) {
      IMPL.setFocusable(this.mInfo, var1);
   }

   public void setFocused(boolean var1) {
      IMPL.setFocused(this.mInfo, var1);
   }

   public void setInputType(int var1) {
      IMPL.setInputType(this.mInfo, var1);
   }

   public void setLabelFor(View var1) {
      IMPL.setLabelFor(this.mInfo, var1);
   }

   public void setLabelFor(View var1, int var2) {
      IMPL.setLabelFor(this.mInfo, var1, var2);
   }

   public void setLabeledBy(View var1) {
      IMPL.setLabeledBy(this.mInfo, var1);
   }

   public void setLabeledBy(View var1, int var2) {
      IMPL.setLabeledBy(this.mInfo, var1, var2);
   }

   public void setLiveRegion(int var1) {
      IMPL.setLiveRegion(this.mInfo, var1);
   }

   public void setLongClickable(boolean var1) {
      IMPL.setLongClickable(this.mInfo, var1);
   }

   public void setMaxTextLength(int var1) {
      IMPL.setMaxTextLength(this.mInfo, var1);
   }

   public void setMovementGranularities(int var1) {
      IMPL.setMovementGranularities(this.mInfo, var1);
   }

   public void setMultiLine(boolean var1) {
      IMPL.setMultiLine(this.mInfo, var1);
   }

   public void setPackageName(CharSequence var1) {
      IMPL.setPackageName(this.mInfo, var1);
   }

   public void setParent(View var1) {
      IMPL.setParent(this.mInfo, var1);
   }

   public void setParent(View var1, int var2) {
      IMPL.setParent(this.mInfo, var1, var2);
   }

   public void setPassword(boolean var1) {
      IMPL.setPassword(this.mInfo, var1);
   }

   public void setRangeInfo(AccessibilityNodeInfoCompat$RangeInfoCompat var1) {
      IMPL.setRangeInfo(this.mInfo, AccessibilityNodeInfoCompat$RangeInfoCompat.access$600(var1));
   }

   public void setScrollable(boolean var1) {
      IMPL.setScrollable(this.mInfo, var1);
   }

   public void setSelected(boolean var1) {
      IMPL.setSelected(this.mInfo, var1);
   }

   public void setSource(View var1) {
      IMPL.setSource(this.mInfo, var1);
   }

   public void setSource(View var1, int var2) {
      IMPL.setSource(this.mInfo, var1, var2);
   }

   public void setText(CharSequence var1) {
      IMPL.setText(this.mInfo, var1);
   }

   public void setTextSelection(int var1, int var2) {
      IMPL.setTextSelection(this.mInfo, var1, var2);
   }

   public void setTraversalAfter(View var1) {
      IMPL.setTraversalAfter(this.mInfo, var1);
   }

   public void setTraversalAfter(View var1, int var2) {
      IMPL.setTraversalAfter(this.mInfo, var1, var2);
   }

   public void setTraversalBefore(View var1) {
      IMPL.setTraversalBefore(this.mInfo, var1);
   }

   public void setTraversalBefore(View var1, int var2) {
      IMPL.setTraversalBefore(this.mInfo, var1, var2);
   }

   public void setViewIdResourceName(String var1) {
      IMPL.setViewIdResourceName(this.mInfo, var1);
   }

   public void setVisibleToUser(boolean var1) {
      IMPL.setVisibleToUser(this.mInfo, var1);
   }

   public String toString() {
      StringBuilder var4 = new StringBuilder();
      var4.append(super.toString());
      Rect var5 = new Rect();
      this.getBoundsInParent(var5);
      var4.append("; boundsInParent: " + var5);
      this.getBoundsInScreen(var5);
      var4.append("; boundsInScreen: " + var5);
      var4.append("; packageName: ").append(this.getPackageName());
      var4.append("; className: ").append(this.getClassName());
      var4.append("; text: ").append(this.getText());
      var4.append("; contentDescription: ").append(this.getContentDescription());
      var4.append("; viewId: ").append(this.getViewIdResourceName());
      var4.append("; checkable: ").append(this.isCheckable());
      var4.append("; checked: ").append(this.isChecked());
      var4.append("; focusable: ").append(this.isFocusable());
      var4.append("; focused: ").append(this.isFocused());
      var4.append("; selected: ").append(this.isSelected());
      var4.append("; clickable: ").append(this.isClickable());
      var4.append("; longClickable: ").append(this.isLongClickable());
      var4.append("; enabled: ").append(this.isEnabled());
      var4.append("; password: ").append(this.isPassword());
      var4.append("; scrollable: " + this.isScrollable());
      var4.append("; [");
      int var1 = this.getActions();

      while(var1 != 0) {
         int var3 = 1 << Integer.numberOfTrailingZeros(var1);
         int var2 = var1 & ~var3;
         var4.append(getActionSymbolicName(var3));
         var1 = var2;
         if(var2 != 0) {
            var4.append(", ");
            var1 = var2;
         }
      }

      var4.append("]");
      return var4.toString();
   }
}
