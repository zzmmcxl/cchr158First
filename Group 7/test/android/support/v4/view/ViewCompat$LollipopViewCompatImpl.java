package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat$KitKatViewCompatImpl;
import android.support.v4.view.ViewCompatLollipop;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;

class ViewCompat$LollipopViewCompatImpl extends ViewCompat$KitKatViewCompatImpl {
   public WindowInsetsCompat dispatchApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return ViewCompatLollipop.dispatchApplyWindowInsets(var1, var2);
   }

   public boolean dispatchNestedFling(View var1, float var2, float var3, boolean var4) {
      return ViewCompatLollipop.dispatchNestedFling(var1, var2, var3, var4);
   }

   public boolean dispatchNestedPreFling(View var1, float var2, float var3) {
      return ViewCompatLollipop.dispatchNestedPreFling(var1, var2, var3);
   }

   public boolean dispatchNestedPreScroll(View var1, int var2, int var3, int[] var4, int[] var5) {
      return ViewCompatLollipop.dispatchNestedPreScroll(var1, var2, var3, var4, var5);
   }

   public boolean dispatchNestedScroll(View var1, int var2, int var3, int var4, int var5, int[] var6) {
      return ViewCompatLollipop.dispatchNestedScroll(var1, var2, var3, var4, var5, var6);
   }

   public ColorStateList getBackgroundTintList(View var1) {
      return ViewCompatLollipop.getBackgroundTintList(var1);
   }

   public Mode getBackgroundTintMode(View var1) {
      return ViewCompatLollipop.getBackgroundTintMode(var1);
   }

   public float getElevation(View var1) {
      return ViewCompatLollipop.getElevation(var1);
   }

   public String getTransitionName(View var1) {
      return ViewCompatLollipop.getTransitionName(var1);
   }

   public float getTranslationZ(View var1) {
      return ViewCompatLollipop.getTranslationZ(var1);
   }

   public float getZ(View var1) {
      return ViewCompatLollipop.getZ(var1);
   }

   public boolean hasNestedScrollingParent(View var1) {
      return ViewCompatLollipop.hasNestedScrollingParent(var1);
   }

   public boolean isImportantForAccessibility(View var1) {
      return ViewCompatLollipop.isImportantForAccessibility(var1);
   }

   public boolean isNestedScrollingEnabled(View var1) {
      return ViewCompatLollipop.isNestedScrollingEnabled(var1);
   }

   public WindowInsetsCompat onApplyWindowInsets(View var1, WindowInsetsCompat var2) {
      return ViewCompatLollipop.onApplyWindowInsets(var1, var2);
   }

   public void requestApplyInsets(View var1) {
      ViewCompatLollipop.requestApplyInsets(var1);
   }

   public void setBackgroundTintList(View var1, ColorStateList var2) {
      ViewCompatLollipop.setBackgroundTintList(var1, var2);
   }

   public void setBackgroundTintMode(View var1, Mode var2) {
      ViewCompatLollipop.setBackgroundTintMode(var1, var2);
   }

   public void setElevation(View var1, float var2) {
      ViewCompatLollipop.setElevation(var1, var2);
   }

   public void setNestedScrollingEnabled(View var1, boolean var2) {
      ViewCompatLollipop.setNestedScrollingEnabled(var1, var2);
   }

   public void setOnApplyWindowInsetsListener(View var1, OnApplyWindowInsetsListener var2) {
      ViewCompatLollipop.setOnApplyWindowInsetsListener(var1, var2);
   }

   public void setTransitionName(View var1, String var2) {
      ViewCompatLollipop.setTransitionName(var1, var2);
   }

   public void setTranslationZ(View var1, float var2) {
      ViewCompatLollipop.setTranslationZ(var1, var2);
   }

   public boolean startNestedScroll(View var1, int var2) {
      return ViewCompatLollipop.startNestedScroll(var1, var2);
   }

   public void stopNestedScroll(View var1) {
      ViewCompatLollipop.stopNestedScroll(var1);
   }
}
