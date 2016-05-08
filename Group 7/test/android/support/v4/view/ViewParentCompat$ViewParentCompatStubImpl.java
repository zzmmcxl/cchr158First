package android.support.v4.view;

import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewParentCompat$ViewParentCompatImpl;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

class ViewParentCompat$ViewParentCompatStubImpl implements ViewParentCompat$ViewParentCompatImpl {
   public void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4) {
   }

   public boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5) {
      return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onNestedFling(var2, var3, var4, var5):false;
   }

   public boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4) {
      return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onNestedPreFling(var2, var3, var4):false;
   }

   public void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5) {
      if(var1 instanceof NestedScrollingParent) {
         ((NestedScrollingParent)var1).onNestedPreScroll(var2, var3, var4, var5);
      }

   }

   public void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
      if(var1 instanceof NestedScrollingParent) {
         ((NestedScrollingParent)var1).onNestedScroll(var2, var3, var4, var5, var6);
      }

   }

   public void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4) {
      if(var1 instanceof NestedScrollingParent) {
         ((NestedScrollingParent)var1).onNestedScrollAccepted(var2, var3, var4);
      }

   }

   public boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4) {
      return var1 instanceof NestedScrollingParent?((NestedScrollingParent)var1).onStartNestedScroll(var2, var3, var4):false;
   }

   public void onStopNestedScroll(ViewParent var1, View var2) {
      if(var1 instanceof NestedScrollingParent) {
         ((NestedScrollingParent)var1).onStopNestedScroll(var2);
      }

   }

   public boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3) {
      if(var2 == null) {
         return false;
      } else {
         ((AccessibilityManager)var2.getContext().getSystemService("accessibility")).sendAccessibilityEvent(var3);
         return true;
      }
   }
}
