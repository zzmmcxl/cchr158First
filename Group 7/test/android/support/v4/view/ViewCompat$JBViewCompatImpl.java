package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.ViewCompat$ICSMr1ViewCompatImpl;
import android.support.v4.view.ViewCompatJB;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.ViewParent;

class ViewCompat$JBViewCompatImpl extends ViewCompat$ICSMr1ViewCompatImpl {
   public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View var1) {
      Object var2 = ViewCompatJB.getAccessibilityNodeProvider(var1);
      return var2 != null?new AccessibilityNodeProviderCompat(var2):null;
   }

   public boolean getFitsSystemWindows(View var1) {
      return ViewCompatJB.getFitsSystemWindows(var1);
   }

   public int getImportantForAccessibility(View var1) {
      return ViewCompatJB.getImportantForAccessibility(var1);
   }

   public int getMinimumHeight(View var1) {
      return ViewCompatJB.getMinimumHeight(var1);
   }

   public int getMinimumWidth(View var1) {
      return ViewCompatJB.getMinimumWidth(var1);
   }

   public ViewParent getParentForAccessibility(View var1) {
      return ViewCompatJB.getParentForAccessibility(var1);
   }

   public boolean hasOverlappingRendering(View var1) {
      return ViewCompatJB.hasOverlappingRendering(var1);
   }

   public boolean hasTransientState(View var1) {
      return ViewCompatJB.hasTransientState(var1);
   }

   public boolean performAccessibilityAction(View var1, int var2, Bundle var3) {
      return ViewCompatJB.performAccessibilityAction(var1, var2, var3);
   }

   public void postInvalidateOnAnimation(View var1) {
      ViewCompatJB.postInvalidateOnAnimation(var1);
   }

   public void postInvalidateOnAnimation(View var1, int var2, int var3, int var4, int var5) {
      ViewCompatJB.postInvalidateOnAnimation(var1, var2, var3, var4, var5);
   }

   public void postOnAnimation(View var1, Runnable var2) {
      ViewCompatJB.postOnAnimation(var1, var2);
   }

   public void postOnAnimationDelayed(View var1, Runnable var2, long var3) {
      ViewCompatJB.postOnAnimationDelayed(var1, var2, var3);
   }

   public void requestApplyInsets(View var1) {
      ViewCompatJB.requestApplyInsets(var1);
   }

   public void setHasTransientState(View var1, boolean var2) {
      ViewCompatJB.setHasTransientState(var1, var2);
   }

   public void setImportantForAccessibility(View var1, int var2) {
      int var3 = var2;
      if(var2 == 4) {
         var3 = 2;
      }

      ViewCompatJB.setImportantForAccessibility(var1, var3);
   }
}
