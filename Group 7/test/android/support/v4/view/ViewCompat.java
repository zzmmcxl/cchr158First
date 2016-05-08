package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat$BaseViewCompatImpl;
import android.support.v4.view.ViewCompat$EclairMr1ViewCompatImpl;
import android.support.v4.view.ViewCompat$GBViewCompatImpl;
import android.support.v4.view.ViewCompat$HCViewCompatImpl;
import android.support.v4.view.ViewCompat$ICSMr1ViewCompatImpl;
import android.support.v4.view.ViewCompat$ICSViewCompatImpl;
import android.support.v4.view.ViewCompat$JBViewCompatImpl;
import android.support.v4.view.ViewCompat$JbMr1ViewCompatImpl;
import android.support.v4.view.ViewCompat$KitKatViewCompatImpl;
import android.support.v4.view.ViewCompat$LollipopViewCompatImpl;
import android.support.v4.view.ViewCompat$MarshmallowViewCompatImpl;
import android.support.v4.view.ViewCompat$ViewCompatImpl;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewCompat {
   public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
   public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
   public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
   private static final long FAKE_FRAME_TIME = 10L;
   static final ViewCompat$ViewCompatImpl IMPL;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS = 4;
   public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
   public static final int LAYER_TYPE_HARDWARE = 2;
   public static final int LAYER_TYPE_NONE = 0;
   public static final int LAYER_TYPE_SOFTWARE = 1;
   public static final int LAYOUT_DIRECTION_INHERIT = 2;
   public static final int LAYOUT_DIRECTION_LOCALE = 3;
   public static final int LAYOUT_DIRECTION_LTR = 0;
   public static final int LAYOUT_DIRECTION_RTL = 1;
   public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
   public static final int MEASURED_SIZE_MASK = 16777215;
   public static final int MEASURED_STATE_MASK = -16777216;
   public static final int MEASURED_STATE_TOO_SMALL = 16777216;
   public static final int OVER_SCROLL_ALWAYS = 0;
   public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
   public static final int OVER_SCROLL_NEVER = 2;
   public static final int SCROLL_AXIS_HORIZONTAL = 1;
   public static final int SCROLL_AXIS_NONE = 0;
   public static final int SCROLL_AXIS_VERTICAL = 2;
   public static final int SCROLL_INDICATOR_BOTTOM = 2;
   public static final int SCROLL_INDICATOR_END = 32;
   public static final int SCROLL_INDICATOR_LEFT = 4;
   public static final int SCROLL_INDICATOR_RIGHT = 8;
   public static final int SCROLL_INDICATOR_START = 16;
   public static final int SCROLL_INDICATOR_TOP = 1;
   private static final String TAG = "ViewCompat";

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 23) {
         IMPL = new ViewCompat$MarshmallowViewCompatImpl();
      } else if(var0 >= 21) {
         IMPL = new ViewCompat$LollipopViewCompatImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewCompat$KitKatViewCompatImpl();
      } else if(var0 >= 17) {
         IMPL = new ViewCompat$JbMr1ViewCompatImpl();
      } else if(var0 >= 16) {
         IMPL = new ViewCompat$JBViewCompatImpl();
      } else if(var0 >= 15) {
         IMPL = new ViewCompat$ICSMr1ViewCompatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewCompat$ICSViewCompatImpl();
      } else if(var0 >= 11) {
         IMPL = new ViewCompat$HCViewCompatImpl();
      } else if(var0 >= 9) {
         IMPL = new ViewCompat$GBViewCompatImpl();
      } else if(var0 >= 7) {
         IMPL = new ViewCompat$EclairMr1ViewCompatImpl();
      } else {
         IMPL = new ViewCompat$BaseViewCompatImpl();
      }
   }

   public static ViewPropertyAnimatorCompat animate(View var0) {
      return IMPL.animate(var0);
   }

   public static boolean canScrollHorizontally(View var0, int var1) {
      return IMPL.canScrollHorizontally(var0, var1);
   }

   public static boolean canScrollVertically(View var0, int var1) {
      return IMPL.canScrollVertically(var0, var1);
   }

   public static int combineMeasuredStates(int var0, int var1) {
      return IMPL.combineMeasuredStates(var0, var1);
   }

   public static WindowInsetsCompat dispatchApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      return IMPL.dispatchApplyWindowInsets(var0, var1);
   }

   public static void dispatchFinishTemporaryDetach(View var0) {
      IMPL.dispatchFinishTemporaryDetach(var0);
   }

   public static boolean dispatchNestedFling(View var0, float var1, float var2, boolean var3) {
      return IMPL.dispatchNestedFling(var0, var1, var2, var3);
   }

   public static boolean dispatchNestedPreFling(View var0, float var1, float var2) {
      return IMPL.dispatchNestedPreFling(var0, var1, var2);
   }

   public static boolean dispatchNestedPreScroll(View var0, int var1, int var2, int[] var3, int[] var4) {
      return IMPL.dispatchNestedPreScroll(var0, var1, var2, var3, var4);
   }

   public static boolean dispatchNestedScroll(View var0, int var1, int var2, int var3, int var4, int[] var5) {
      return IMPL.dispatchNestedScroll(var0, var1, var2, var3, var4, var5);
   }

   public static void dispatchStartTemporaryDetach(View var0) {
      IMPL.dispatchStartTemporaryDetach(var0);
   }

   public static int getAccessibilityLiveRegion(View var0) {
      return IMPL.getAccessibilityLiveRegion(var0);
   }

   public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var0) {
      return IMPL.getAccessibilityNodeProvider(var0);
   }

   public static float getAlpha(View var0) {
      return IMPL.getAlpha(var0);
   }

   public static ColorStateList getBackgroundTintList(View var0) {
      return IMPL.getBackgroundTintList(var0);
   }

   public static Mode getBackgroundTintMode(View var0) {
      return IMPL.getBackgroundTintMode(var0);
   }

   public static Rect getClipBounds(View var0) {
      return IMPL.getClipBounds(var0);
   }

   public static float getElevation(View var0) {
      return IMPL.getElevation(var0);
   }

   public static boolean getFitsSystemWindows(View var0) {
      return IMPL.getFitsSystemWindows(var0);
   }

   public static int getImportantForAccessibility(View var0) {
      return IMPL.getImportantForAccessibility(var0);
   }

   public static int getLabelFor(View var0) {
      return IMPL.getLabelFor(var0);
   }

   public static int getLayerType(View var0) {
      return IMPL.getLayerType(var0);
   }

   public static int getLayoutDirection(View var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static int getMeasuredHeightAndState(View var0) {
      return IMPL.getMeasuredHeightAndState(var0);
   }

   public static int getMeasuredState(View var0) {
      return IMPL.getMeasuredState(var0);
   }

   public static int getMeasuredWidthAndState(View var0) {
      return IMPL.getMeasuredWidthAndState(var0);
   }

   public static int getMinimumHeight(View var0) {
      return IMPL.getMinimumHeight(var0);
   }

   public static int getMinimumWidth(View var0) {
      return IMPL.getMinimumWidth(var0);
   }

   public static int getOverScrollMode(View var0) {
      return IMPL.getOverScrollMode(var0);
   }

   public static int getPaddingEnd(View var0) {
      return IMPL.getPaddingEnd(var0);
   }

   public static int getPaddingStart(View var0) {
      return IMPL.getPaddingStart(var0);
   }

   public static ViewParent getParentForAccessibility(View var0) {
      return IMPL.getParentForAccessibility(var0);
   }

   public static float getPivotX(View var0) {
      return IMPL.getPivotX(var0);
   }

   public static float getPivotY(View var0) {
      return IMPL.getPivotY(var0);
   }

   public static float getRotation(View var0) {
      return IMPL.getRotation(var0);
   }

   public static float getRotationX(View var0) {
      return IMPL.getRotationX(var0);
   }

   public static float getRotationY(View var0) {
      return IMPL.getRotationY(var0);
   }

   public static float getScaleX(View var0) {
      return IMPL.getScaleX(var0);
   }

   public static float getScaleY(View var0) {
      return IMPL.getScaleY(var0);
   }

   public static int getScrollIndicators(@NonNull View var0) {
      return IMPL.getScrollIndicators(var0);
   }

   public static String getTransitionName(View var0) {
      return IMPL.getTransitionName(var0);
   }

   public static float getTranslationX(View var0) {
      return IMPL.getTranslationX(var0);
   }

   public static float getTranslationY(View var0) {
      return IMPL.getTranslationY(var0);
   }

   public static float getTranslationZ(View var0) {
      return IMPL.getTranslationZ(var0);
   }

   public static int getWindowSystemUiVisibility(View var0) {
      return IMPL.getWindowSystemUiVisibility(var0);
   }

   public static float getX(View var0) {
      return IMPL.getX(var0);
   }

   public static float getY(View var0) {
      return IMPL.getY(var0);
   }

   public static float getZ(View var0) {
      return IMPL.getZ(var0);
   }

   public static boolean hasAccessibilityDelegate(View var0) {
      return IMPL.hasAccessibilityDelegate(var0);
   }

   public static boolean hasNestedScrollingParent(View var0) {
      return IMPL.hasNestedScrollingParent(var0);
   }

   public static boolean hasOnClickListeners(View var0) {
      return IMPL.hasOnClickListeners(var0);
   }

   public static boolean hasOverlappingRendering(View var0) {
      return IMPL.hasOverlappingRendering(var0);
   }

   public static boolean hasTransientState(View var0) {
      return IMPL.hasTransientState(var0);
   }

   public static boolean isAttachedToWindow(View var0) {
      return IMPL.isAttachedToWindow(var0);
   }

   public static boolean isLaidOut(View var0) {
      return IMPL.isLaidOut(var0);
   }

   public static boolean isNestedScrollingEnabled(View var0) {
      return IMPL.isNestedScrollingEnabled(var0);
   }

   public static boolean isOpaque(View var0) {
      return IMPL.isOpaque(var0);
   }

   public static boolean isPaddingRelative(View var0) {
      return IMPL.isPaddingRelative(var0);
   }

   public static void jumpDrawablesToCurrentState(View var0) {
      IMPL.jumpDrawablesToCurrentState(var0);
   }

   public static void offsetLeftAndRight(View var0, int var1) {
      IMPL.offsetLeftAndRight(var0, var1);
   }

   public static void offsetTopAndBottom(View var0, int var1) {
      IMPL.offsetTopAndBottom(var0, var1);
   }

   public static WindowInsetsCompat onApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      return IMPL.onApplyWindowInsets(var0, var1);
   }

   public static void onInitializeAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onInitializeAccessibilityEvent(var0, var1);
   }

   public static void onInitializeAccessibilityNodeInfo(View var0, AccessibilityNodeInfoCompat var1) {
      IMPL.onInitializeAccessibilityNodeInfo(var0, var1);
   }

   public static void onPopulateAccessibilityEvent(View var0, AccessibilityEvent var1) {
      IMPL.onPopulateAccessibilityEvent(var0, var1);
   }

   public static boolean performAccessibilityAction(View var0, int var1, Bundle var2) {
      return IMPL.performAccessibilityAction(var0, var1, var2);
   }

   public static void postInvalidateOnAnimation(View var0) {
      IMPL.postInvalidateOnAnimation(var0);
   }

   public static void postInvalidateOnAnimation(View var0, int var1, int var2, int var3, int var4) {
      IMPL.postInvalidateOnAnimation(var0, var1, var2, var3, var4);
   }

   public static void postOnAnimation(View var0, Runnable var1) {
      IMPL.postOnAnimation(var0, var1);
   }

   public static void postOnAnimationDelayed(View var0, Runnable var1, long var2) {
      IMPL.postOnAnimationDelayed(var0, var1, var2);
   }

   public static void requestApplyInsets(View var0) {
      IMPL.requestApplyInsets(var0);
   }

   public static int resolveSizeAndState(int var0, int var1, int var2) {
      return IMPL.resolveSizeAndState(var0, var1, var2);
   }

   public static void setAccessibilityDelegate(View var0, AccessibilityDelegateCompat var1) {
      IMPL.setAccessibilityDelegate(var0, var1);
   }

   public static void setAccessibilityLiveRegion(View var0, int var1) {
      IMPL.setAccessibilityLiveRegion(var0, var1);
   }

   public static void setActivated(View var0, boolean var1) {
      IMPL.setActivated(var0, var1);
   }

   public static void setAlpha(View var0, @FloatRange(
   from = 0.0D,
   to = 1.0D
) float var1) {
      IMPL.setAlpha(var0, var1);
   }

   public static void setBackgroundTintList(View var0, ColorStateList var1) {
      IMPL.setBackgroundTintList(var0, var1);
   }

   public static void setBackgroundTintMode(View var0, Mode var1) {
      IMPL.setBackgroundTintMode(var0, var1);
   }

   public static void setChildrenDrawingOrderEnabled(ViewGroup var0, boolean var1) {
      IMPL.setChildrenDrawingOrderEnabled(var0, var1);
   }

   public static void setClipBounds(View var0, Rect var1) {
      IMPL.setClipBounds(var0, var1);
   }

   public static void setElevation(View var0, float var1) {
      IMPL.setElevation(var0, var1);
   }

   public static void setFitsSystemWindows(View var0, boolean var1) {
      IMPL.setFitsSystemWindows(var0, var1);
   }

   public static void setHasTransientState(View var0, boolean var1) {
      IMPL.setHasTransientState(var0, var1);
   }

   public static void setImportantForAccessibility(View var0, int var1) {
      IMPL.setImportantForAccessibility(var0, var1);
   }

   public static void setLabelFor(View var0, @IdRes int var1) {
      IMPL.setLabelFor(var0, var1);
   }

   public static void setLayerPaint(View var0, Paint var1) {
      IMPL.setLayerPaint(var0, var1);
   }

   public static void setLayerType(View var0, int var1, Paint var2) {
      IMPL.setLayerType(var0, var1, var2);
   }

   public static void setLayoutDirection(View var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setNestedScrollingEnabled(View var0, boolean var1) {
      IMPL.setNestedScrollingEnabled(var0, var1);
   }

   public static void setOnApplyWindowInsetsListener(View var0, OnApplyWindowInsetsListener var1) {
      IMPL.setOnApplyWindowInsetsListener(var0, var1);
   }

   public static void setOverScrollMode(View var0, int var1) {
      IMPL.setOverScrollMode(var0, var1);
   }

   public static void setPaddingRelative(View var0, int var1, int var2, int var3, int var4) {
      IMPL.setPaddingRelative(var0, var1, var2, var3, var4);
   }

   public static void setPivotX(View var0, float var1) {
      IMPL.setPivotX(var0, var1);
   }

   public static void setPivotY(View var0, float var1) {
      IMPL.setPivotY(var0, var1);
   }

   public static void setRotation(View var0, float var1) {
      IMPL.setRotation(var0, var1);
   }

   public static void setRotationX(View var0, float var1) {
      IMPL.setRotationX(var0, var1);
   }

   public static void setRotationY(View var0, float var1) {
      IMPL.setRotationY(var0, var1);
   }

   public static void setSaveFromParentEnabled(View var0, boolean var1) {
      IMPL.setSaveFromParentEnabled(var0, var1);
   }

   public static void setScaleX(View var0, float var1) {
      IMPL.setScaleX(var0, var1);
   }

   public static void setScaleY(View var0, float var1) {
      IMPL.setScaleY(var0, var1);
   }

   public static void setScrollIndicators(@NonNull View var0, int var1) {
      IMPL.setScrollIndicators(var0, var1);
   }

   public static void setScrollIndicators(@NonNull View var0, int var1, int var2) {
      IMPL.setScrollIndicators(var0, var1, var2);
   }

   public static void setTransitionName(View var0, String var1) {
      IMPL.setTransitionName(var0, var1);
   }

   public static void setTranslationX(View var0, float var1) {
      IMPL.setTranslationX(var0, var1);
   }

   public static void setTranslationY(View var0, float var1) {
      IMPL.setTranslationY(var0, var1);
   }

   public static void setTranslationZ(View var0, float var1) {
      IMPL.setTranslationZ(var0, var1);
   }

   public static void setX(View var0, float var1) {
      IMPL.setX(var0, var1);
   }

   public static void setY(View var0, float var1) {
      IMPL.setY(var0, var1);
   }

   public static boolean startNestedScroll(View var0, int var1) {
      return IMPL.startNestedScroll(var0, var1);
   }

   public static void stopNestedScroll(View var0) {
      IMPL.stopNestedScroll(var0);
   }
}
