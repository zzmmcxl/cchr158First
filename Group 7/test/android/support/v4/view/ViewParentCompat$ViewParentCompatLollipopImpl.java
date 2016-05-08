package android.support.v4.view;

import android.support.v4.view.ViewParentCompat$ViewParentCompatKitKatImpl;
import android.support.v4.view.ViewParentCompatLollipop;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompat$ViewParentCompatLollipopImpl extends ViewParentCompat$ViewParentCompatKitKatImpl {
   public boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5) {
      return ViewParentCompatLollipop.onNestedFling(var1, var2, var3, var4, var5);
   }

   public boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4) {
      return ViewParentCompatLollipop.onNestedPreFling(var1, var2, var3, var4);
   }

   public void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5) {
      ViewParentCompatLollipop.onNestedPreScroll(var1, var2, var3, var4, var5);
   }

   public void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6) {
      ViewParentCompatLollipop.onNestedScroll(var1, var2, var3, var4, var5, var6);
   }

   public void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4) {
      ViewParentCompatLollipop.onNestedScrollAccepted(var1, var2, var3, var4);
   }

   public boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4) {
      return ViewParentCompatLollipop.onStartNestedScroll(var1, var2, var3, var4);
   }

   public void onStopNestedScroll(ViewParent var1, View var2) {
      ViewParentCompatLollipop.onStopNestedScroll(var1, var2);
   }
}
