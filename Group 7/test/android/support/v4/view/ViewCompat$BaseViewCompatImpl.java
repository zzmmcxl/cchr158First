package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat$ViewCompatImpl;
import android.support.v4.view.ViewCompatBase;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

class ViewCompat$BaseViewCompatImpl implements ViewCompat$ViewCompatImpl {
   private Method mDispatchFinishTemporaryDetach;
   private Method mDispatchStartTemporaryDetach;
   private boolean mTempDetachBound;
   WeakHashMap<View, ViewPropertyAnimatorCompat> mViewPropertyAnimatorCompatMap = null;

   private void bindTempDetach() {
      try {
         this.mDispatchStartTemporaryDetach = View.class.getDeclaredMethod("dispatchStartTemporaryDetach", new Class[0]);
         this.mDispatchFinishTemporaryDetach = View.class.getDeclaredMethod("dispatchFinishTemporaryDetach", new Class[0]);
      } catch (NoSuchMethodException var2) {
         Log.e("ViewCompat", "Couldn\'t find method", var2);
      }

      this.mTempDetachBound = true;
   }

   private boolean canScrollingViewScrollHorizontally(ScrollingView var1, int var2) {
      boolean var5 = true;
      int var3 = var1.computeHorizontalScrollOffset();
      int var4 = var1.computeHorizontalScrollRange() - var1.computeHorizontalScrollExtent();
      if(var4 == 0) {
         var5 = false;
      } else if(var2 < 0) {
         if(var3 <= 0) {
            return false;
         }
      } else if(var3 >= var4 - 1) {
         return false;
      }

      return var5;
   }

   private boolean canScrollingViewScrollVertically(ScrollingView var1, int var2) {
      boolean var5 = true;
      int var3 = var1.computeVerticalScrollOffset();
      int var4 = var1.computeVerticalScrollRange() - var1.computeVerticalScrollExtent();
      if(var4 == 0) {
         var5 = false;
      } else if(var2 < 0) {
         if(var3 <= 0) {
            return false;
         }
      } else if(var3 >= var4 - 1) {
         return false;
      }

      return var5;
   }

   public ViewPropertyAnimatorCompat animate(View var1) {
      return new ViewPropertyAnimatorCompat(var1);
   }

   public boolean canScrollHorizontally(View var1, int var2) {
      return var1 instanceof ScrollingView && this.canScrollingViewScrollHorizontally((ScrollingView)var1, var2);
   }

   public boolean canScrollVertically(View var1, int var2) {
      return var1 instanceof ScrollingView && this.canScrollingViewScrollVertically((ScrollingView)var1, var2);
   }

   public int combineMeasuredStates(int var1, int var2) {
      return var1 | var2;
   }

   public WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return var2;
   }

   public void dispatchFinishTemporaryDetach(View var1) {
      if(!this.mTempDetachBound) {
         this.bindTempDetach();
      }

      if(this.mDispatchFinishTemporaryDetach != null) {
         try {
            this.mDispatchFinishTemporaryDetach.invoke(var1, new Object[0]);
         } catch (Exception var2) {
            Log.d("ViewCompat", "Error calling dispatchFinishTemporaryDetach", var2);
         }
      } else {
         var1.onFinishTemporaryDetach();
      }
   }

   public boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedFling(var2, var3, var4):false;
   }

   public boolean dispatchNestedPreFling(View var1, float var2, float var3) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedPreFling(var2, var3):false;
   }

   public boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedPreScroll(var2, var3, var4, var5):false;
   }

   public boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).dispatchNestedScroll(var2, var3, var4, var5, var6):false;
   }

   public void dispatchStartTemporaryDetach(View var1) {
      if(!this.mTempDetachBound) {
         this.bindTempDetach();
      }

      if(this.mDispatchStartTemporaryDetach != null) {
         try {
            this.mDispatchStartTemporaryDetach.invoke(var1, new Object[0]);
         } catch (Exception var2) {
            Log.d("ViewCompat", "Error calling dispatchStartTemporaryDetach", var2);
         }
      } else {
         var1.onStartTemporaryDetach();
      }
   }

   public int getAccessibilityLiveRegion(View var1) {
      return 0;
   }

   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      return null;
   }

   public float getAlpha(View var1) {
      return 1.0F;
   }

   public ColorStateList getBackgroundTintList(View var1) {
      return ViewCompatBase.getBackgroundTintList(var1);
   }

   public Mode getBackgroundTintMode(View var1) {
      return ViewCompatBase.getBackgroundTintMode(var1);
   }

   public Rect getClipBounds(View var1) {
      return null;
   }

   public float getElevation(View var1) {
      return 0.0F;
   }

   public boolean getFitsSystemWindows(View var1) {
      return false;
   }

   long getFrameTime() {
      return 10L;
   }

   public int getImportantForAccessibility(View var1) {
      return 0;
   }

   public int getLabelFor(View var1) {
      return 0;
   }

   public int getLayerType(View var1) {
      return 0;
   }

   public int getLayoutDirection(View var1) {
      return 0;
   }

   public int getMeasuredHeightAndState(View var1) {
      return var1.getMeasuredHeight();
   }

   public int getMeasuredState(View var1) {
      return 0;
   }

   public int getMeasuredWidthAndState(View var1) {
      return var1.getMeasuredWidth();
   }

   public int getMinimumHeight(View var1) {
      return ViewCompatBase.getMinimumHeight(var1);
   }

   public int getMinimumWidth(View var1) {
      return ViewCompatBase.getMinimumWidth(var1);
   }

   public int getOverScrollMode(View var1) {
      return 2;
   }

   public int getPaddingEnd(View var1) {
      return var1.getPaddingRight();
   }

   public int getPaddingStart(View var1) {
      return var1.getPaddingLeft();
   }

   public ViewParent getParentForAccessibility(View var1) {
      return var1.getParent();
   }

   public float getPivotX(View var1) {
      return 0.0F;
   }

   public float getPivotY(View var1) {
      return 0.0F;
   }

   public float getRotation(View var1) {
      return 0.0F;
   }

   public float getRotationX(View var1) {
      return 0.0F;
   }

   public float getRotationY(View var1) {
      return 0.0F;
   }

   public float getScaleX(View var1) {
      return 0.0F;
   }

   public float getScaleY(View var1) {
      return 0.0F;
   }

   public int getScrollIndicators(View var1) {
      return 0;
   }

   public String getTransitionName(View var1) {
      return null;
   }

   public float getTranslationX(View var1) {
      return 0.0F;
   }

   public float getTranslationY(View var1) {
      return 0.0F;
   }

   public float getTranslationZ(View var1) {
      return 0.0F;
   }

   public int getWindowSystemUiVisibility(View var1) {
      return 0;
   }

   public float getX(View var1) {
      return 0.0F;
   }

   public float getY(View var1) {
      return 0.0F;
   }

   public float getZ(View var1) {
      return this.getTranslationZ(var1) + this.getElevation(var1);
   }

   public boolean hasAccessibilityDelegate(View var1) {
      return false;
   }

   public boolean hasNestedScrollingParent(View var1) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).hasNestedScrollingParent():false;
   }

   public boolean hasOnClickListeners(View var1) {
      return false;
   }

   public boolean hasOverlappingRendering(View var1) {
      return true;
   }

   public boolean hasTransientState(View var1) {
      return false;
   }

   public boolean isAttachedToWindow(View var1) {
      return ViewCompatBase.isAttachedToWindow(var1);
   }

   public boolean isImportantForAccessibility(View var1) {
      return true;
   }

   public boolean isLaidOut(View var1) {
      return ViewCompatBase.isLaidOut(var1);
   }

   public boolean isNestedScrollingEnabled(View var1) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).isNestedScrollingEnabled():false;
   }

   public boolean isOpaque(View var1) {
      boolean var3 = false;
      Drawable var4 = var1.getBackground();
      boolean var2 = var3;
      if(var4 != null) {
         var2 = var3;
         if(var4.getOpacity() == -1) {
            var2 = true;
         }
      }

      return var2;
   }

   public boolean isPaddingRelative(View var1) {
      return false;
   }

   public void jumpDrawablesToCurrentState(View var1) {
   }

   public void offsetLeftAndRight(View var1, int var2) {
      ViewCompatBase.offsetLeftAndRight(var1, var2);
   }

   public void offsetTopAndBottom(View var1, int var2) {
      ViewCompatBase.offsetTopAndBottom(var1, var2);
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return var2;
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return false;
   }

   public void postInvalidateOnAnimation(View var1) {
      var1.invalidate();
   }

   public void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5) {
      var1.invalidate(var2, var3, var4, var5);
   }

   public void postOnAnimation(View var1, Runnable var2) {
      var1.postDelayed(var2, this.getFrameTime());
   }

   public void postOnAnimationDelayed(View var1, Runnable var2, long var3) {
      var1.postDelayed(var2, this.getFrameTime() + var3);
   }

   public void requestApplyInsets(View var1) {
   }

   public int resolveSizeAndState(int var1, int var2, int var3) {
      return View.resolveSize(var1, var2);
   }

   public void setAccessibilityDelegate(View var1, AccessibilityDelegateCompat var2) {
   }

   public void setAccessibilityLiveRegion(View var1, int var2) {
   }

   public void setActivated(View var1, boolean var2) {
   }

   public void setAlpha(View var1, float var2) {
   }

   public void setBackgroundTintList(View var1, ColorStateList var2) {
      ViewCompatBase.setBackgroundTintList(var1, var2);
   }

   public void setBackgroundTintMode(View var1, Mode var2) {
      ViewCompatBase.setBackgroundTintMode(var1, var2);
   }

   public void setChildrenDrawingOrderEnabled(ViewGroup var1, boolean var2) {
   }

   public void setClipBounds(View var1, Rect var2) {
   }

   public void setElevation(View var1, float var2) {
   }

   public void setFitsSystemWindows(View var1, boolean var2) {
   }

   public void setHasTransientState(View var1, boolean var2) {
   }

   public void setImportantForAccessibility(View var1, int var2) {
   }

   public void setLabelFor(View var1, int var2) {
   }

   public void setLayerPaint(View var1, Paint var2) {
   }

   public void setLayerType(View var1, int var2, Paint var3) {
   }

   public void setLayoutDirection(View var1, int var2) {
   }

   public void setNestedScrollingEnabled(View var1, boolean var2) {
      if(var1 instanceof NestedScrollingChild) {
         ((NestedScrollingChild)var1).setNestedScrollingEnabled(var2);
      }

   }

   public void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2) {
   }

   public void setOverScrollMode(View var1, int var2) {
   }

   public void setPaddingRelative(View var1, int var2, int var3, int var4, int var5) {
      var1.setPadding(var2, var3, var4, var5);
   }

   public void setPivotX(View var1, float var2) {
   }

   public void setPivotY(View var1, float var2) {
   }

   public void setRotation(View var1, float var2) {
   }

   public void setRotationX(View var1, float var2) {
   }

   public void setRotationY(View var1, float var2) {
   }

   public void setSaveFromParentEnabled(View var1, boolean var2) {
   }

   public void setScaleX(View var1, float var2) {
   }

   public void setScaleY(View var1, float var2) {
   }

   public void setScrollIndicators(View var1, int var2) {
   }

   public void setScrollIndicators(View var1, int var2, int var3) {
   }

   public void setTransitionName(View var1, String var2) {
   }

   public void setTranslationX(View var1, float var2) {
   }

   public void setTranslationY(View var1, float var2) {
   }

   public void setTranslationZ(View var1, float var2) {
   }

   public void setX(View var1, float var2) {
   }

   public void setY(View var1, float var2) {
   }

   public boolean startNestedScroll(View var1, int var2) {
      return var1 instanceof NestedScrollingChild?((NestedScrollingChild)var1).startNestedScroll(var2):false;
   }

   public void stopNestedScroll(View var1) {
      if(var1 instanceof NestedScrollingChild) {
         ((NestedScrollingChild)var1).stopNestedScroll();
      }

   }
}
