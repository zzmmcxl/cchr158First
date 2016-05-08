package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

interface ViewCompat$ViewCompatImpl {
   ViewPropertyAnimatorCompat animate(View var1);

   boolean canScrollHorizontally(View var1, int var2);

   boolean canScrollVertically(View var1, int var2);

   int combineMeasuredStates(int var1, int var2);

   WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2);

   void dispatchFinishTemporaryDetach(View var1);

   boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4);

   boolean dispatchNestedPreFling(View var1, float var2, float var3);

   boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5);

   boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6);

   void dispatchStartTemporaryDetach(View var1);

   int getAccessibilityLiveRegion(View var1);

   AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1);

   float getAlpha(View var1);

   ColorStateList getBackgroundTintList(View var1);

   Mode getBackgroundTintMode(View var1);

   Rect getClipBounds(View var1);

   float getElevation(View var1);

   boolean getFitsSystemWindows(View var1);

   int getImportantForAccessibility(View var1);

   int getLabelFor(View var1);

   int getLayerType(View var1);

   int getLayoutDirection(View var1);

   int getMeasuredHeightAndState(View var1);

   int getMeasuredState(View var1);

   int getMeasuredWidthAndState(View var1);

   int getMinimumHeight(View var1);

   int getMinimumWidth(View var1);

   int getOverScrollMode(View var1);

   int getPaddingEnd(View var1);

   int getPaddingStart(View var1);

   ViewParent getParentForAccessibility(View var1);

   float getPivotX(View var1);

   float getPivotY(View var1);

   float getRotation(View var1);

   float getRotationX(View var1);

   float getRotationY(View var1);

   float getScaleX(View var1);

   float getScaleY(View var1);

   int getScrollIndicators(View var1);

   String getTransitionName(View var1);

   float getTranslationX(View var1);

   float getTranslationY(View var1);

   float getTranslationZ(View var1);

   int getWindowSystemUiVisibility(View var1);

   float getX(View var1);

   float getY(View var1);

   float getZ(View var1);

   boolean hasAccessibilityDelegate(View var1);

   boolean hasNestedScrollingParent(View var1);

   boolean hasOnClickListeners(View var1);

   boolean hasOverlappingRendering(View var1);

   boolean hasTransientState(View var1);

   boolean isAttachedToWindow(View var1);

   boolean isImportantForAccessibility(View var1);

   boolean isLaidOut(View var1);

   boolean isNestedScrollingEnabled(View var1);

   boolean isOpaque(View var1);

   boolean isPaddingRelative(View var1);

   void jumpDrawablesToCurrentState(View var1);

   void offsetLeftAndRight(View var1, int var2);

   void offsetTopAndBottom(View var1, int var2);

   WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2);

   void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2);

   void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2);

   void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2);

   boolean performAccessibilityAction(View var1, int var2, Bundle var3);

   void postInvalidateOnAnimation(View var1);

   void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5);

   void postOnAnimation(View var1, Runnable var2);

   void postOnAnimationDelayed(View var1, Runnable var2, long var3);

   void requestApplyInsets(View var1);

   int resolveSizeAndState(int var1, int var2, int var3);

   void setAccessibilityDelegate(View var1, @Nullable AccessibilityDelegateCompat var2);

   void setAccessibilityLiveRegion(View var1, int var2);

   void setActivated(View var1, boolean var2);

   void setAlpha(View var1, float var2);

   void setBackgroundTintList(View var1, ColorStateList var2);

   void setBackgroundTintMode(View var1, Mode var2);

   void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2);

   void setClipBounds(View var1, Rect var2);

   void setElevation(View var1, float var2);

   void setFitsSystemWindows(View var1, boolean var2);

   void setHasTransientState(View var1, boolean var2);

   void setImportantForAccessibility(View var1, int var2);

   void setLabelFor(View var1, int var2);

   void setLayerPaint(View var1, Paint var2);

   void setLayerType(View var1, int var2, Paint var3);

   void setLayoutDirection(View var1, int var2);

   void setNestedScrollingEnabled(View var1, boolean var2);

   void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2);

   void setOverScrollMode(View var1, int var2);

   void setPaddingRelative(View var1, int var2, int var3, int var4, int var5);

   void setPivotX(View var1, float var2);

   void setPivotY(View var1, float var2);

   void setRotation(View var1, float var2);

   void setRotationX(View var1, float var2);

   void setRotationY(View var1, float var2);

   void setSaveFromParentEnabled(View var1, boolean var2);

   void setScaleX(View var1, float var2);

   void setScaleY(View var1, float var2);

   void setScrollIndicators(View var1, int var2);

   void setScrollIndicators(View var1, int var2, int var3);

   void setTransitionName(View var1, String var2);

   void setTranslationX(View var1, float var2);

   void setTranslationY(View var1, float var2);

   void setTranslationZ(View var1, float var2);

   void setX(View var1, float var2);

   void setY(View var1, float var2);

   boolean startNestedScroll(View var1, int var2);

   void stopNestedScroll(View var1);
}
