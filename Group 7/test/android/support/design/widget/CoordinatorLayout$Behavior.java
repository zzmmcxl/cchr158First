package android.support.design.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout$LayoutParams;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;

public abstract class CoordinatorLayout$Behavior<V extends View> {
   public CoordinatorLayout$Behavior() {
   }

   public CoordinatorLayout$Behavior(Context var1, AttributeSet var2) {
   }

   public static Object getTag(View var0) {
      return ((CoordinatorLayout$LayoutParams)var0.getLayoutParams()).mBehaviorTag;
   }

   public static void setTag(View var0, Object var1) {
      ((CoordinatorLayout$LayoutParams)var0.getLayoutParams()).mBehaviorTag = var1;
   }

   public boolean blocksInteractionBelow(CoordinatorLayout var1, V var2) {
      return this.getScrimOpacity(var1, var2) > 0.0F;
   }

   public int getScrimColor(CoordinatorLayout var1, V var2) {
      return -16777216;
   }

   public float getScrimOpacity(CoordinatorLayout var1, V var2) {
      return 0.0F;
   }

   public boolean isDirty(CoordinatorLayout var1, V var2) {
      return false;
   }

   public boolean layoutDependsOn(CoordinatorLayout var1, V var2, View var3) {
      return false;
   }

   public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout var1, V var2, WindowInsetsCompat var3) {
      return var3;
   }

   public boolean onDependentViewChanged(CoordinatorLayout var1, V var2, View var3) {
      return false;
   }

   public void onDependentViewRemoved(CoordinatorLayout var1, V var2, View var3) {
   }

   public boolean onInterceptTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      return false;
   }

   public boolean onLayoutChild(CoordinatorLayout var1, V var2, int var3) {
      return false;
   }

   public boolean onMeasureChild(CoordinatorLayout var1, V var2, int var3, int var4, int var5, int var6) {
      return false;
   }

   public boolean onNestedFling(CoordinatorLayout var1, V var2, View var3, float var4, float var5, boolean var6) {
      return false;
   }

   public boolean onNestedPreFling(CoordinatorLayout var1, V var2, View var3, float var4, float var5) {
      return false;
   }

   public void onNestedPreScroll(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6) {
   }

   public void onNestedScroll(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int var6, int var7) {
   }

   public void onNestedScrollAccepted(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
   }

   public void onRestoreInstanceState(CoordinatorLayout var1, V var2, Parcelable var3) {
   }

   public Parcelable onSaveInstanceState(CoordinatorLayout var1, V var2) {
      return BaseSavedState.EMPTY_STATE;
   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
      return false;
   }

   public void onStopNestedScroll(CoordinatorLayout var1, V var2, View var3) {
   }

   public boolean onTouchEvent(CoordinatorLayout var1, V var2, MotionEvent var3) {
      return false;
   }
}
