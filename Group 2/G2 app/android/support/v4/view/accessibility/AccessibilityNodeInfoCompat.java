package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi22;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatIcs;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellyBean;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatJellybeanMr2;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
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
   public static final int ACTION_COPY = 16384;
   public static final int ACTION_CUT = 65536;
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
   private static final AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl IMPL;
   public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
   public static final int MOVEMENT_GRANULARITY_LINE = 4;
   public static final int MOVEMENT_GRANULARITY_PAGE = 16;
   public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
   public static final int MOVEMENT_GRANULARITY_WORD = 2;
   private final Object mInfo;

   static {
      if(VERSION.SDK_INT >= 22) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi22Impl();
      } else if(VERSION.SDK_INT >= 21) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl();
      } else if(VERSION.SDK_INT >= 19) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl();
      } else if(VERSION.SDK_INT >= 18) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl();
      } else if(VERSION.SDK_INT >= 16) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl();
      } else if(VERSION.SDK_INT >= 14) {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl();
      } else {
         IMPL = new AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl();
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

   public void addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat var1) {
      IMPL.addAction(this.mInfo, var1.mAction);
   }

   public void addChild(View var1) {
      IMPL.addChild(this.mInfo, var1);
   }

   public void addChild(View var1, int var2) {
      IMPL.addChild(this.mInfo, var1, var2);
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

   public List findAccessibilityNodeInfosByText(String var1) {
      ArrayList var4 = new ArrayList();
      List var5 = IMPL.findAccessibilityNodeInfosByText(this.mInfo, var1);
      int var3 = var5.size();

      for(int var2 = 0; var2 < var3; ++var2) {
         var4.add(new AccessibilityNodeInfoCompat(var5.get(var2)));
      }

      return var4;
   }

   public AccessibilityNodeInfoCompat findFocus(int var1) {
      return wrapNonNullInstance(IMPL.findFocus(this.mInfo, var1));
   }

   public AccessibilityNodeInfoCompat focusSearch(int var1) {
      return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, var1));
   }

   public List getActionList() {
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

            var4.add(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(var5.get(var1)));
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

   public AccessibilityNodeInfoCompat.CollectionInfoCompat getCollectionInfo() {
      Object var1 = IMPL.getCollectionInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat.CollectionInfoCompat(var1);
   }

   public AccessibilityNodeInfoCompat.CollectionItemInfoCompat getCollectionItemInfo() {
      Object var1 = IMPL.getCollectionItemInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(var1);
   }

   public CharSequence getContentDescription() {
      return IMPL.getContentDescription(this.mInfo);
   }

   public CharSequence getError() {
      return IMPL.getError(this.mInfo);
   }

   public Object getInfo() {
      return this.mInfo;
   }

   public int getLiveRegion() {
      return IMPL.getLiveRegion(this.mInfo);
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

   public AccessibilityNodeInfoCompat.RangeInfoCompat getRangeInfo() {
      Object var1 = IMPL.getRangeInfo(this.mInfo);
      return var1 == null?null:new AccessibilityNodeInfoCompat.RangeInfoCompat(var1);
   }

   public CharSequence getText() {
      return IMPL.getText(this.mInfo);
   }

   public String getViewIdResourceName() {
      return IMPL.getViewIdResourceName(this.mInfo);
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

   public void setAccessibilityFocused(boolean var1) {
      IMPL.setAccessibilityFocused(this.mInfo, var1);
   }

   public void setBoundsInParent(Rect var1) {
      IMPL.setBoundsInParent(this.mInfo, var1);
   }

   public void setBoundsInScreen(Rect var1) {
      IMPL.setBoundsInScreen(this.mInfo, var1);
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
      IMPL.setCollectionInfo(this.mInfo, ((AccessibilityNodeInfoCompat.CollectionInfoCompat)var1).mInfo);
   }

   public void setCollectionItemInfo(Object var1) {
      IMPL.setCollectionItemInfo(this.mInfo, ((AccessibilityNodeInfoCompat.CollectionItemInfoCompat)var1).mInfo);
   }

   public void setContentDescription(CharSequence var1) {
      IMPL.setContentDescription(this.mInfo, var1);
   }

   public void setContentInvalid(boolean var1) {
      IMPL.setContentInvalid(this.mInfo, var1);
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

   public void setLabelFor(View var1) {
      IMPL.setLabelFor(this.mInfo, var1);
   }

   public void setLabelFor(View var1, int var2) {
      IMPL.setLabelFor(this.mInfo, var1, var2);
   }

   public void setLiveRegion(int var1) {
      IMPL.setLiveRegion(this.mInfo, var1);
   }

   public void setLongClickable(boolean var1) {
      IMPL.setLongClickable(this.mInfo, var1);
   }

   public void setMovementGranularities(int var1) {
      IMPL.setMovementGranularities(this.mInfo, var1);
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

   public static class AccessibilityActionCompat {
      private final Object mAction;

      public AccessibilityActionCompat(int var1, CharSequence var2) {
         this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(var1, var2));
      }

      private AccessibilityActionCompat(Object var1) {
         this.mAction = var1;
      }

      // $FF: synthetic method
      AccessibilityActionCompat(Object var1, Object var2) {
         this(var1);
      }

      public int getId() {
         return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
      }

      public CharSequence getLabel() {
         return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
      }
   }

   static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoKitKatImpl {
      public void addAction(Object var1, Object var2) {
         AccessibilityNodeInfoCompatApi21.addAction(var1, var2);
      }

      public int getAccessibilityActionId(Object var1) {
         return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(var1);
      }

      public CharSequence getAccessibilityActionLabel(Object var1) {
         return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(var1);
      }

      public List getActionList(Object var1) {
         return AccessibilityNodeInfoCompatApi21.getActionList(var1);
      }

      public CharSequence getError(Object var1) {
         return AccessibilityNodeInfoCompatApi21.getError(var1);
      }

      public boolean isCollectionItemSelected(Object var1) {
         return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(var1);
      }

      public Object newAccessibilityAction(int var1, CharSequence var2) {
         return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(var1, var2);
      }

      public Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4) {
         return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(var1, var2, var3, var4);
      }

      public Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
         return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(var1, var2, var3, var4, var5, var6);
      }

      public void setError(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatApi21.setError(var1, var2);
      }

      public void setLabelFor(Object var1, View var2) {
         AccessibilityNodeInfoCompatApi21.setLabelFor(var1, var2);
      }

      public void setLabelFor(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatApi21.setLabelFor(var1, var2, var3);
      }
   }

   static class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoApi21Impl {
      public AccessibilityNodeInfoCompat getTraversalAfter(Object var1) {
         var1 = AccessibilityNodeInfoCompatApi22.getTraversalAfter(var1);
         return var1 == null?null:new AccessibilityNodeInfoCompat(var1);
      }

      public AccessibilityNodeInfoCompat getTraversalBefore(Object var1) {
         var1 = AccessibilityNodeInfoCompatApi22.getTraversalBefore(var1);
         return var1 == null?null:new AccessibilityNodeInfoCompat(var1);
      }

      public void setTraversalAfter(Object var1, View var2) {
         AccessibilityNodeInfoCompatApi22.setTraversalAfter(var1, var2);
      }

      public void setTraversalAfter(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatApi22.setTraversalAfter(var1, var2, var3);
      }

      public void setTraversalBefore(Object var1, View var2) {
         AccessibilityNodeInfoCompatApi22.setTraversalBefore(var1, var2);
      }

      public void setTraversalBefore(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatApi22.setTraversalBefore(var1, var2, var3);
      }
   }

   static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoStubImpl {
      public void addAction(Object var1, int var2) {
         AccessibilityNodeInfoCompatIcs.addAction(var1, var2);
      }

      public void addChild(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.addChild(var1, var2);
      }

      public List findAccessibilityNodeInfosByText(Object var1, String var2) {
         return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(var1, var2);
      }

      public int getActions(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getActions(var1);
      }

      public void getBoundsInParent(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.getBoundsInParent(var1, var2);
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.getBoundsInScreen(var1, var2);
      }

      public Object getChild(Object var1, int var2) {
         return AccessibilityNodeInfoCompatIcs.getChild(var1, var2);
      }

      public int getChildCount(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getChildCount(var1);
      }

      public CharSequence getClassName(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getClassName(var1);
      }

      public CharSequence getContentDescription(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getContentDescription(var1);
      }

      public CharSequence getPackageName(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getPackageName(var1);
      }

      public Object getParent(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getParent(var1);
      }

      public CharSequence getText(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getText(var1);
      }

      public int getWindowId(Object var1) {
         return AccessibilityNodeInfoCompatIcs.getWindowId(var1);
      }

      public boolean isCheckable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isCheckable(var1);
      }

      public boolean isChecked(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isChecked(var1);
      }

      public boolean isClickable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isClickable(var1);
      }

      public boolean isEnabled(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isEnabled(var1);
      }

      public boolean isFocusable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isFocusable(var1);
      }

      public boolean isFocused(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isFocused(var1);
      }

      public boolean isLongClickable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isLongClickable(var1);
      }

      public boolean isPassword(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isPassword(var1);
      }

      public boolean isScrollable(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isScrollable(var1);
      }

      public boolean isSelected(Object var1) {
         return AccessibilityNodeInfoCompatIcs.isSelected(var1);
      }

      public Object obtain() {
         return AccessibilityNodeInfoCompatIcs.obtain();
      }

      public Object obtain(View var1) {
         return AccessibilityNodeInfoCompatIcs.obtain(var1);
      }

      public Object obtain(Object var1) {
         return AccessibilityNodeInfoCompatIcs.obtain(var1);
      }

      public boolean performAction(Object var1, int var2) {
         return AccessibilityNodeInfoCompatIcs.performAction(var1, var2);
      }

      public void recycle(Object var1) {
         AccessibilityNodeInfoCompatIcs.recycle(var1);
      }

      public void setBoundsInParent(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.setBoundsInParent(var1, var2);
      }

      public void setBoundsInScreen(Object var1, Rect var2) {
         AccessibilityNodeInfoCompatIcs.setBoundsInScreen(var1, var2);
      }

      public void setCheckable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setCheckable(var1, var2);
      }

      public void setChecked(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setChecked(var1, var2);
      }

      public void setClassName(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setClassName(var1, var2);
      }

      public void setClickable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setClickable(var1, var2);
      }

      public void setContentDescription(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setContentDescription(var1, var2);
      }

      public void setEnabled(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setEnabled(var1, var2);
      }

      public void setFocusable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setFocusable(var1, var2);
      }

      public void setFocused(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setFocused(var1, var2);
      }

      public void setLongClickable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setLongClickable(var1, var2);
      }

      public void setPackageName(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setPackageName(var1, var2);
      }

      public void setParent(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.setParent(var1, var2);
      }

      public void setPassword(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setPassword(var1, var2);
      }

      public void setScrollable(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setScrollable(var1, var2);
      }

      public void setSelected(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatIcs.setSelected(var1, var2);
      }

      public void setSource(Object var1, View var2) {
         AccessibilityNodeInfoCompatIcs.setSource(var1, var2);
      }

      public void setText(Object var1, CharSequence var2) {
         AccessibilityNodeInfoCompatIcs.setText(var1, var2);
      }
   }

   interface AccessibilityNodeInfoImpl {
      void addAction(Object var1, int var2);

      void addAction(Object var1, Object var2);

      void addChild(Object var1, View var2);

      void addChild(Object var1, View var2, int var3);

      List findAccessibilityNodeInfosByText(Object var1, String var2);

      Object findFocus(Object var1, int var2);

      Object focusSearch(Object var1, int var2);

      int getAccessibilityActionId(Object var1);

      CharSequence getAccessibilityActionLabel(Object var1);

      List getActionList(Object var1);

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

      int getLiveRegion(Object var1);

      int getMovementGranularities(Object var1);

      CharSequence getPackageName(Object var1);

      Object getParent(Object var1);

      Object getRangeInfo(Object var1);

      CharSequence getText(Object var1);

      AccessibilityNodeInfoCompat getTraversalAfter(Object var1);

      AccessibilityNodeInfoCompat getTraversalBefore(Object var1);

      String getViewIdResourceName(Object var1);

      int getWindowId(Object var1);

      boolean isAccessibilityFocused(Object var1);

      boolean isCheckable(Object var1);

      boolean isChecked(Object var1);

      boolean isClickable(Object var1);

      boolean isCollectionInfoHierarchical(Object var1);

      boolean isCollectionItemHeading(Object var1);

      boolean isCollectionItemSelected(Object var1);

      boolean isContentInvalid(Object var1);

      boolean isEnabled(Object var1);

      boolean isFocusable(Object var1);

      boolean isFocused(Object var1);

      boolean isLongClickable(Object var1);

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

      void setAccessibilityFocused(Object var1, boolean var2);

      void setBoundsInParent(Object var1, Rect var2);

      void setBoundsInScreen(Object var1, Rect var2);

      void setCheckable(Object var1, boolean var2);

      void setChecked(Object var1, boolean var2);

      void setClassName(Object var1, CharSequence var2);

      void setClickable(Object var1, boolean var2);

      void setCollectionInfo(Object var1, Object var2);

      void setCollectionItemInfo(Object var1, Object var2);

      void setContentDescription(Object var1, CharSequence var2);

      void setContentInvalid(Object var1, boolean var2);

      void setEnabled(Object var1, boolean var2);

      void setError(Object var1, CharSequence var2);

      void setFocusable(Object var1, boolean var2);

      void setFocused(Object var1, boolean var2);

      void setLabelFor(Object var1, View var2);

      void setLabelFor(Object var1, View var2, int var3);

      void setLiveRegion(Object var1, int var2);

      void setLongClickable(Object var1, boolean var2);

      void setMovementGranularities(Object var1, int var2);

      void setPackageName(Object var1, CharSequence var2);

      void setParent(Object var1, View var2);

      void setParent(Object var1, View var2, int var3);

      void setPassword(Object var1, boolean var2);

      void setScrollable(Object var1, boolean var2);

      void setSelected(Object var1, boolean var2);

      void setSource(Object var1, View var2);

      void setSource(Object var1, View var2, int var3);

      void setText(Object var1, CharSequence var2);

      void setTraversalAfter(Object var1, View var2);

      void setTraversalAfter(Object var1, View var2, int var3);

      void setTraversalBefore(Object var1, View var2);

      void setTraversalBefore(Object var1, View var2, int var3);

      void setViewIdResourceName(Object var1, String var2);

      void setVisibleToUser(Object var1, boolean var2);
   }

   static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoIcsImpl {
      public void addChild(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.addChild(var1, var2, var3);
      }

      public Object findFocus(Object var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.findFocus(var1, var2);
      }

      public Object focusSearch(Object var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.focusSearch(var1, var2);
      }

      public int getMovementGranularities(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(var1);
      }

      public boolean isAccessibilityFocused(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(var1);
      }

      public boolean isVisibleToUser(Object var1) {
         return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(var1);
      }

      public Object obtain(View var1, int var2) {
         return AccessibilityNodeInfoCompatJellyBean.obtain(var1, var2);
      }

      public boolean performAction(Object var1, int var2, Bundle var3) {
         return AccessibilityNodeInfoCompatJellyBean.performAction(var1, var2, var3);
      }

      public void setAccessibilityFocused(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(var1, var2);
      }

      public void setMovementGranularities(Object var1, int var2) {
         AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(var1, var2);
      }

      public void setParent(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.setParent(var1, var2, var3);
      }

      public void setSource(Object var1, View var2, int var3) {
         AccessibilityNodeInfoCompatJellyBean.setSource(var1, var2, var3);
      }

      public void setVisibleToUser(Object var1, boolean var2) {
         AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(var1, var2);
      }
   }

   static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanImpl {
      public String getViewIdResourceName(Object var1) {
         return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(var1);
      }

      public void setViewIdResourceName(Object var1, String var2) {
         AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(var1, var2);
      }
   }

   static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoCompat.AccessibilityNodeInfoJellybeanMr2Impl {
      public Object getCollectionInfo(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(var1);
      }

      public int getCollectionInfoColumnCount(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(var1);
      }

      public int getCollectionInfoRowCount(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(var1);
      }

      public int getCollectionItemColumnIndex(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(var1);
      }

      public int getCollectionItemColumnSpan(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(var1);
      }

      public Object getCollectionItemInfo(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(var1);
      }

      public int getCollectionItemRowIndex(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(var1);
      }

      public int getCollectionItemRowSpan(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(var1);
      }

      public int getLiveRegion(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.getLiveRegion(var1);
      }

      public Object getRangeInfo(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.getRangeInfo(var1);
      }

      public boolean isCollectionInfoHierarchical(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(var1);
      }

      public boolean isCollectionItemHeading(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(var1);
      }

      public boolean isContentInvalid(Object var1) {
         return AccessibilityNodeInfoCompatKitKat.isContentInvalid(var1);
      }

      public Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4) {
         return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(var1, var2, var3, var4);
      }

      public Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
         return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(var1, var2, var3, var4, var5);
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

      public void setLiveRegion(Object var1, int var2) {
         AccessibilityNodeInfoCompatKitKat.setLiveRegion(var1, var2);
      }
   }

   static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl {
      public void addAction(Object var1, int var2) {
      }

      public void addAction(Object var1, Object var2) {
      }

      public void addChild(Object var1, View var2) {
      }

      public void addChild(Object var1, View var2, int var3) {
      }

      public List findAccessibilityNodeInfosByText(Object var1, String var2) {
         return Collections.emptyList();
      }

      public Object findFocus(Object var1, int var2) {
         return null;
      }

      public Object focusSearch(Object var1, int var2) {
         return null;
      }

      public int getAccessibilityActionId(Object var1) {
         return 0;
      }

      public CharSequence getAccessibilityActionLabel(Object var1) {
         return null;
      }

      public List getActionList(Object var1) {
         return null;
      }

      public int getActions(Object var1) {
         return 0;
      }

      public void getBoundsInParent(Object var1, Rect var2) {
      }

      public void getBoundsInScreen(Object var1, Rect var2) {
      }

      public Object getChild(Object var1, int var2) {
         return null;
      }

      public int getChildCount(Object var1) {
         return 0;
      }

      public CharSequence getClassName(Object var1) {
         return null;
      }

      public Object getCollectionInfo(Object var1) {
         return null;
      }

      public int getCollectionInfoColumnCount(Object var1) {
         return 0;
      }

      public int getCollectionInfoRowCount(Object var1) {
         return 0;
      }

      public int getCollectionItemColumnIndex(Object var1) {
         return 0;
      }

      public int getCollectionItemColumnSpan(Object var1) {
         return 0;
      }

      public Object getCollectionItemInfo(Object var1) {
         return null;
      }

      public int getCollectionItemRowIndex(Object var1) {
         return 0;
      }

      public int getCollectionItemRowSpan(Object var1) {
         return 0;
      }

      public CharSequence getContentDescription(Object var1) {
         return null;
      }

      public CharSequence getError(Object var1) {
         return null;
      }

      public int getLiveRegion(Object var1) {
         return 0;
      }

      public int getMovementGranularities(Object var1) {
         return 0;
      }

      public CharSequence getPackageName(Object var1) {
         return null;
      }

      public Object getParent(Object var1) {
         return null;
      }

      public Object getRangeInfo(Object var1) {
         return null;
      }

      public CharSequence getText(Object var1) {
         return null;
      }

      public AccessibilityNodeInfoCompat getTraversalAfter(Object var1) {
         return null;
      }

      public AccessibilityNodeInfoCompat getTraversalBefore(Object var1) {
         return null;
      }

      public String getViewIdResourceName(Object var1) {
         return null;
      }

      public int getWindowId(Object var1) {
         return 0;
      }

      public boolean isAccessibilityFocused(Object var1) {
         return false;
      }

      public boolean isCheckable(Object var1) {
         return false;
      }

      public boolean isChecked(Object var1) {
         return false;
      }

      public boolean isClickable(Object var1) {
         return false;
      }

      public boolean isCollectionInfoHierarchical(Object var1) {
         return false;
      }

      public boolean isCollectionItemHeading(Object var1) {
         return false;
      }

      public boolean isCollectionItemSelected(Object var1) {
         return false;
      }

      public boolean isContentInvalid(Object var1) {
         return false;
      }

      public boolean isEnabled(Object var1) {
         return false;
      }

      public boolean isFocusable(Object var1) {
         return false;
      }

      public boolean isFocused(Object var1) {
         return false;
      }

      public boolean isLongClickable(Object var1) {
         return false;
      }

      public boolean isPassword(Object var1) {
         return false;
      }

      public boolean isScrollable(Object var1) {
         return false;
      }

      public boolean isSelected(Object var1) {
         return false;
      }

      public boolean isVisibleToUser(Object var1) {
         return false;
      }

      public Object newAccessibilityAction(int var1, CharSequence var2) {
         return null;
      }

      public Object obtain() {
         return null;
      }

      public Object obtain(View var1) {
         return null;
      }

      public Object obtain(View var1, int var2) {
         return null;
      }

      public Object obtain(Object var1) {
         return null;
      }

      public Object obtainCollectionInfo(int var1, int var2, boolean var3, int var4) {
         return null;
      }

      public Object obtainCollectionItemInfo(int var1, int var2, int var3, int var4, boolean var5, boolean var6) {
         return null;
      }

      public boolean performAction(Object var1, int var2) {
         return false;
      }

      public boolean performAction(Object var1, int var2, Bundle var3) {
         return false;
      }

      public void recycle(Object var1) {
      }

      public void setAccessibilityFocused(Object var1, boolean var2) {
      }

      public void setBoundsInParent(Object var1, Rect var2) {
      }

      public void setBoundsInScreen(Object var1, Rect var2) {
      }

      public void setCheckable(Object var1, boolean var2) {
      }

      public void setChecked(Object var1, boolean var2) {
      }

      public void setClassName(Object var1, CharSequence var2) {
      }

      public void setClickable(Object var1, boolean var2) {
      }

      public void setCollectionInfo(Object var1, Object var2) {
      }

      public void setCollectionItemInfo(Object var1, Object var2) {
      }

      public void setContentDescription(Object var1, CharSequence var2) {
      }

      public void setContentInvalid(Object var1, boolean var2) {
      }

      public void setEnabled(Object var1, boolean var2) {
      }

      public void setError(Object var1, CharSequence var2) {
      }

      public void setFocusable(Object var1, boolean var2) {
      }

      public void setFocused(Object var1, boolean var2) {
      }

      public void setLabelFor(Object var1, View var2) {
      }

      public void setLabelFor(Object var1, View var2, int var3) {
      }

      public void setLiveRegion(Object var1, int var2) {
      }

      public void setLongClickable(Object var1, boolean var2) {
      }

      public void setMovementGranularities(Object var1, int var2) {
      }

      public void setPackageName(Object var1, CharSequence var2) {
      }

      public void setParent(Object var1, View var2) {
      }

      public void setParent(Object var1, View var2, int var3) {
      }

      public void setPassword(Object var1, boolean var2) {
      }

      public void setScrollable(Object var1, boolean var2) {
      }

      public void setSelected(Object var1, boolean var2) {
      }

      public void setSource(Object var1, View var2) {
      }

      public void setSource(Object var1, View var2, int var3) {
      }

      public void setText(Object var1, CharSequence var2) {
      }

      public void setTraversalAfter(Object var1, View var2) {
      }

      public void setTraversalAfter(Object var1, View var2, int var3) {
      }

      public void setTraversalBefore(Object var1, View var2) {
      }

      public void setTraversalBefore(Object var1, View var2, int var3) {
      }

      public void setViewIdResourceName(Object var1, String var2) {
      }

      public void setVisibleToUser(Object var1, boolean var2) {
      }
   }

   public static class CollectionInfoCompat {
      public static final int SELECTION_MODE_MULTIPLE = 2;
      public static final int SELECTION_MODE_NONE = 0;
      public static final int SELECTION_MODE_SINGLE = 1;
      final Object mInfo;

      private CollectionInfoCompat(Object var1) {
         this.mInfo = var1;
      }

      // $FF: synthetic method
      CollectionInfoCompat(Object var1, Object var2) {
         this(var1);
      }

      public static AccessibilityNodeInfoCompat.CollectionInfoCompat obtain(int var0, int var1, boolean var2, int var3) {
         return new AccessibilityNodeInfoCompat.CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(var0, var1, var2, var3));
      }

      public int getColumnCount() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
      }

      public int getRowCount() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
      }

      public boolean isHierarchical() {
         return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
      }
   }

   public static class CollectionItemInfoCompat {
      private final Object mInfo;

      private CollectionItemInfoCompat(Object var1) {
         this.mInfo = var1;
      }

      // $FF: synthetic method
      CollectionItemInfoCompat(Object var1, Object var2) {
         this(var1);
      }

      public static AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain(int var0, int var1, int var2, int var3, boolean var4, boolean var5) {
         return new AccessibilityNodeInfoCompat.CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(var0, var1, var2, var3, var4, var5));
      }

      public int getColumnIndex() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
      }

      public int getColumnSpan() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
      }

      public int getRowIndex() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
      }

      public int getRowSpan() {
         return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
      }

      public boolean isHeading() {
         return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
      }

      public boolean isSelected() {
         return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
      }
   }

   public static class RangeInfoCompat {
      public static final int RANGE_TYPE_FLOAT = 1;
      public static final int RANGE_TYPE_INT = 0;
      public static final int RANGE_TYPE_PERCENT = 2;
      private final Object mInfo;

      private RangeInfoCompat(Object var1) {
         this.mInfo = var1;
      }

      // $FF: synthetic method
      RangeInfoCompat(Object var1, Object var2) {
         this(var1);
      }

      public float getCurrent() {
         return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
      }

      public float getMax() {
         return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
      }

      public float getMin() {
         return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
      }

      public int getType() {
         return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
      }
   }
}
