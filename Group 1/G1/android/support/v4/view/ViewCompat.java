package android.support.v4.view;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.Nullable;
import java.lang.reflect.Field;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.WeakHashMap;
import java.lang.reflect.Method;
import android.graphics.Paint;
import android.support.annotation.IdRes;
import android.view.ViewGroup;
import android.support.annotation.FloatRange;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.support.annotation.NonNull;
import android.view.ViewParent;
import android.graphics.Rect;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.os.Build$VERSION;

public final class ViewCompat
{
    public static final int ACCESSIBILITY_LIVE_REGION_ASSERTIVE = 2;
    public static final int ACCESSIBILITY_LIVE_REGION_NONE = 0;
    public static final int ACCESSIBILITY_LIVE_REGION_POLITE = 1;
    private static final long FAKE_FRAME_TIME = 10L;
    static final ViewCompatImpl IMPL;
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
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 23) {
            IMPL = (ViewCompatImpl)new MarshmallowViewCompatImpl();
            return;
        }
        if (sdk_INT >= 21) {
            IMPL = (ViewCompatImpl)new LollipopViewCompatImpl();
            return;
        }
        if (sdk_INT >= 19) {
            IMPL = (ViewCompatImpl)new KitKatViewCompatImpl();
            return;
        }
        if (sdk_INT >= 17) {
            IMPL = (ViewCompatImpl)new JbMr1ViewCompatImpl();
            return;
        }
        if (sdk_INT >= 16) {
            IMPL = (ViewCompatImpl)new JBViewCompatImpl();
            return;
        }
        if (sdk_INT >= 15) {
            IMPL = (ViewCompatImpl)new ICSMr1ViewCompatImpl();
            return;
        }
        if (sdk_INT >= 14) {
            IMPL = (ViewCompatImpl)new ICSViewCompatImpl();
            return;
        }
        if (sdk_INT >= 11) {
            IMPL = (ViewCompatImpl)new HCViewCompatImpl();
            return;
        }
        if (sdk_INT >= 9) {
            IMPL = (ViewCompatImpl)new GBViewCompatImpl();
            return;
        }
        if (sdk_INT >= 7) {
            IMPL = (ViewCompatImpl)new EclairMr1ViewCompatImpl();
            return;
        }
        IMPL = (ViewCompatImpl)new BaseViewCompatImpl();
    }
    
    private ViewCompat() {
        super();
    }
    
    public static ViewPropertyAnimatorCompat animate(final View view) {
        return IMPL.animate(view);
    }
    
    public static boolean canScrollHorizontally(final View view, final int n) {
        return IMPL.canScrollHorizontally(view, n);
    }
    
    public static boolean canScrollVertically(final View view, final int n) {
        return IMPL.canScrollVertically(view, n);
    }
    
    public static int combineMeasuredStates(final int n, final int n2) {
        return IMPL.combineMeasuredStates(n, n2);
    }
    
    public static WindowInsetsCompat dispatchApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return IMPL.dispatchApplyWindowInsets(view, windowInsetsCompat);
    }
    
    public static void dispatchFinishTemporaryDetach(final View view) {
        IMPL.dispatchFinishTemporaryDetach(view);
    }
    
    public static boolean dispatchNestedFling(final View view, final float n, final float n2, final boolean b) {
        return IMPL.dispatchNestedFling(view, n, n2, b);
    }
    
    public static boolean dispatchNestedPreFling(final View view, final float n, final float n2) {
        return IMPL.dispatchNestedPreFling(view, n, n2);
    }
    
    public static boolean dispatchNestedPreScroll(final View view, final int n, final int n2, final int[] array, final int[] array2) {
        return IMPL.dispatchNestedPreScroll(view, n, n2, array, array2);
    }
    
    public static boolean dispatchNestedScroll(final View view, final int n, final int n2, final int n3, final int n4, final int[] array) {
        return IMPL.dispatchNestedScroll(view, n, n2, n3, n4, array);
    }
    
    public static void dispatchStartTemporaryDetach(final View view) {
        IMPL.dispatchStartTemporaryDetach(view);
    }
    
    public static int getAccessibilityLiveRegion(final View view) {
        return IMPL.getAccessibilityLiveRegion(view);
    }
    
    public static AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final View view) {
        return IMPL.getAccessibilityNodeProvider(view);
    }
    
    public static float getAlpha(final View view) {
        return IMPL.getAlpha(view);
    }
    
    public static ColorStateList getBackgroundTintList(final View view) {
        return IMPL.getBackgroundTintList(view);
    }
    
    public static PorterDuff$Mode getBackgroundTintMode(final View view) {
        return IMPL.getBackgroundTintMode(view);
    }
    
    public static Rect getClipBounds(final View view) {
        return IMPL.getClipBounds(view);
    }
    
    public static float getElevation(final View view) {
        return IMPL.getElevation(view);
    }
    
    public static boolean getFitsSystemWindows(final View view) {
        return IMPL.getFitsSystemWindows(view);
    }
    
    public static int getImportantForAccessibility(final View view) {
        return IMPL.getImportantForAccessibility(view);
    }
    
    public static int getLabelFor(final View view) {
        return IMPL.getLabelFor(view);
    }
    
    public static int getLayerType(final View view) {
        return IMPL.getLayerType(view);
    }
    
    public static int getLayoutDirection(final View view) {
        return IMPL.getLayoutDirection(view);
    }
    
    public static int getMeasuredHeightAndState(final View view) {
        return IMPL.getMeasuredHeightAndState(view);
    }
    
    public static int getMeasuredState(final View view) {
        return IMPL.getMeasuredState(view);
    }
    
    public static int getMeasuredWidthAndState(final View view) {
        return IMPL.getMeasuredWidthAndState(view);
    }
    
    public static int getMinimumHeight(final View view) {
        return IMPL.getMinimumHeight(view);
    }
    
    public static int getMinimumWidth(final View view) {
        return IMPL.getMinimumWidth(view);
    }
    
    public static int getOverScrollMode(final View view) {
        return IMPL.getOverScrollMode(view);
    }
    
    public static int getPaddingEnd(final View view) {
        return IMPL.getPaddingEnd(view);
    }
    
    public static int getPaddingStart(final View view) {
        return IMPL.getPaddingStart(view);
    }
    
    public static ViewParent getParentForAccessibility(final View view) {
        return IMPL.getParentForAccessibility(view);
    }
    
    public static float getPivotX(final View view) {
        return IMPL.getPivotX(view);
    }
    
    public static float getPivotY(final View view) {
        return IMPL.getPivotY(view);
    }
    
    public static float getRotation(final View view) {
        return IMPL.getRotation(view);
    }
    
    public static float getRotationX(final View view) {
        return IMPL.getRotationX(view);
    }
    
    public static float getRotationY(final View view) {
        return IMPL.getRotationY(view);
    }
    
    public static float getScaleX(final View view) {
        return IMPL.getScaleX(view);
    }
    
    public static float getScaleY(final View view) {
        return IMPL.getScaleY(view);
    }
    
    public static int getScrollIndicators(@NonNull final View view) {
        return IMPL.getScrollIndicators(view);
    }
    
    public static String getTransitionName(final View view) {
        return IMPL.getTransitionName(view);
    }
    
    public static float getTranslationX(final View view) {
        return IMPL.getTranslationX(view);
    }
    
    public static float getTranslationY(final View view) {
        return IMPL.getTranslationY(view);
    }
    
    public static float getTranslationZ(final View view) {
        return IMPL.getTranslationZ(view);
    }
    
    public static int getWindowSystemUiVisibility(final View view) {
        return IMPL.getWindowSystemUiVisibility(view);
    }
    
    public static float getX(final View view) {
        return IMPL.getX(view);
    }
    
    public static float getY(final View view) {
        return IMPL.getY(view);
    }
    
    public static float getZ(final View view) {
        return IMPL.getZ(view);
    }
    
    public static boolean hasAccessibilityDelegate(final View view) {
        return IMPL.hasAccessibilityDelegate(view);
    }
    
    public static boolean hasNestedScrollingParent(final View view) {
        return IMPL.hasNestedScrollingParent(view);
    }
    
    public static boolean hasOnClickListeners(final View view) {
        return IMPL.hasOnClickListeners(view);
    }
    
    public static boolean hasOverlappingRendering(final View view) {
        return IMPL.hasOverlappingRendering(view);
    }
    
    public static boolean hasTransientState(final View view) {
        return IMPL.hasTransientState(view);
    }
    
    public static boolean isAttachedToWindow(final View view) {
        return IMPL.isAttachedToWindow(view);
    }
    
    public static boolean isLaidOut(final View view) {
        return IMPL.isLaidOut(view);
    }
    
    public static boolean isNestedScrollingEnabled(final View view) {
        return IMPL.isNestedScrollingEnabled(view);
    }
    
    public static boolean isOpaque(final View view) {
        return IMPL.isOpaque(view);
    }
    
    public static boolean isPaddingRelative(final View view) {
        return IMPL.isPaddingRelative(view);
    }
    
    public static void jumpDrawablesToCurrentState(final View view) {
        IMPL.jumpDrawablesToCurrentState(view);
    }
    
    public static void offsetLeftAndRight(final View view, final int n) {
        IMPL.offsetLeftAndRight(view, n);
    }
    
    public static void offsetTopAndBottom(final View view, final int n) {
        IMPL.offsetTopAndBottom(view, n);
    }
    
    public static WindowInsetsCompat onApplyWindowInsets(final View view, final WindowInsetsCompat windowInsetsCompat) {
        return IMPL.onApplyWindowInsets(view, windowInsetsCompat);
    }
    
    public static void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        IMPL.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        IMPL.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
    }
    
    public static void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        IMPL.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public static boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return IMPL.performAccessibilityAction(view, n, bundle);
    }
    
    public static void postInvalidateOnAnimation(final View view) {
        IMPL.postInvalidateOnAnimation(view);
    }
    
    public static void postInvalidateOnAnimation(final View view, final int n, final int n2, final int n3, final int n4) {
        IMPL.postInvalidateOnAnimation(view, n, n2, n3, n4);
    }
    
    public static void postOnAnimation(final View view, final Runnable runnable) {
        IMPL.postOnAnimation(view, runnable);
    }
    
    public static void postOnAnimationDelayed(final View view, final Runnable runnable, final long n) {
        IMPL.postOnAnimationDelayed(view, runnable, n);
    }
    
    public static void requestApplyInsets(final View view) {
        IMPL.requestApplyInsets(view);
    }
    
    public static int resolveSizeAndState(final int n, final int n2, final int n3) {
        return IMPL.resolveSizeAndState(n, n2, n3);
    }
    
    public static void setAccessibilityDelegate(final View view, final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        IMPL.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }
    
    public static void setAccessibilityLiveRegion(final View view, final int n) {
        IMPL.setAccessibilityLiveRegion(view, n);
    }
    
    public static void setActivated(final View view, final boolean b) {
        IMPL.setActivated(view, b);
    }
    
    public static void setAlpha(final View view, @FloatRange(from = 0.0, to = 1.0) final float n) {
        IMPL.setAlpha(view, n);
    }
    
    public static void setBackgroundTintList(final View view, final ColorStateList list) {
        IMPL.setBackgroundTintList(view, list);
    }
    
    public static void setBackgroundTintMode(final View view, final PorterDuff$Mode porterDuff$Mode) {
        IMPL.setBackgroundTintMode(view, porterDuff$Mode);
    }
    
    public static void setChildrenDrawingOrderEnabled(final ViewGroup viewGroup, final boolean b) {
        IMPL.setChildrenDrawingOrderEnabled(viewGroup, b);
    }
    
    public static void setClipBounds(final View view, final Rect rect) {
        IMPL.setClipBounds(view, rect);
    }
    
    public static void setElevation(final View view, final float n) {
        IMPL.setElevation(view, n);
    }
    
    public static void setFitsSystemWindows(final View view, final boolean b) {
        IMPL.setFitsSystemWindows(view, b);
    }
    
    public static void setHasTransientState(final View view, final boolean b) {
        IMPL.setHasTransientState(view, b);
    }
    
    public static void setImportantForAccessibility(final View view, final int n) {
        IMPL.setImportantForAccessibility(view, n);
    }
    
    public static void setLabelFor(final View view, @IdRes final int n) {
        IMPL.setLabelFor(view, n);
    }
    
    public static void setLayerPaint(final View view, final Paint paint) {
        IMPL.setLayerPaint(view, paint);
    }
    
    public static void setLayerType(final View view, final int n, final Paint paint) {
        IMPL.setLayerType(view, n, paint);
    }
    
    public static void setLayoutDirection(final View view, final int n) {
        IMPL.setLayoutDirection(view, n);
    }
    
    public static void setNestedScrollingEnabled(final View view, final boolean b) {
        IMPL.setNestedScrollingEnabled(view, b);
    }
    
    public static void setOnApplyWindowInsetsListener(final View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        IMPL.setOnApplyWindowInsetsListener(view, onApplyWindowInsetsListener);
    }
    
    public static void setOverScrollMode(final View view, final int n) {
        IMPL.setOverScrollMode(view, n);
    }
    
    public static void setPaddingRelative(final View view, final int n, final int n2, final int n3, final int n4) {
        IMPL.setPaddingRelative(view, n, n2, n3, n4);
    }
    
    public static void setPivotX(final View view, final float n) {
        IMPL.setPivotX(view, n);
    }
    
    public static void setPivotY(final View view, final float n) {
        IMPL.setPivotY(view, n);
    }
    
    public static void setRotation(final View view, final float n) {
        IMPL.setRotation(view, n);
    }
    
    public static void setRotationX(final View view, final float n) {
        IMPL.setRotationX(view, n);
    }
    
    public static void setRotationY(final View view, final float n) {
        IMPL.setRotationY(view, n);
    }
    
    public static void setSaveFromParentEnabled(final View view, final boolean b) {
        IMPL.setSaveFromParentEnabled(view, b);
    }
    
    public static void setScaleX(final View view, final float n) {
        IMPL.setScaleX(view, n);
    }
    
    public static void setScaleY(final View view, final float n) {
        IMPL.setScaleY(view, n);
    }
    
    public static void setScrollIndicators(@NonNull final View view, final int n) {
        IMPL.setScrollIndicators(view, n);
    }
    
    public static void setScrollIndicators(@NonNull final View view, final int n, final int n2) {
        IMPL.setScrollIndicators(view, n, n2);
    }
    
    public static void setTransitionName(final View view, final String s) {
        IMPL.setTransitionName(view, s);
    }
    
    public static void setTranslationX(final View view, final float n) {
        IMPL.setTranslationX(view, n);
    }
    
    public static void setTranslationY(final View view, final float n) {
        IMPL.setTranslationY(view, n);
    }
    
    public static void setTranslationZ(final View view, final float n) {
        IMPL.setTranslationZ(view, n);
    }
    
    public static void setX(final View view, final float n) {
        IMPL.setX(view, n);
    }
    
    public static void setY(final View view, final float n) {
        IMPL.setY(view, n);
    }
    
    public static boolean startNestedScroll(final View view, final int n) {
        return IMPL.startNestedScroll(view, n);
    }
    
    public static void stopNestedScroll(final View view) {
        IMPL.stopNestedScroll(view);
    }
}
