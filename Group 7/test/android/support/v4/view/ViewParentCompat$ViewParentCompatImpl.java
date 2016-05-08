package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

interface ViewParentCompat$ViewParentCompatImpl {
   void notifySubtreeAccessibilityStateChanged(ViewParent var1, View var2, View var3, int var4);

   boolean onNestedFling(ViewParent var1, View var2, float var3, float var4, boolean var5);

   boolean onNestedPreFling(ViewParent var1, View var2, float var3, float var4);

   void onNestedPreScroll(ViewParent var1, View var2, int var3, int var4, int[] var5);

   void onNestedScroll(ViewParent var1, View var2, int var3, int var4, int var5, int var6);

   void onNestedScrollAccepted(ViewParent var1, View var2, View var3, int var4);

   boolean onStartNestedScroll(ViewParent var1, View var2, View var3, int var4);

   void onStopNestedScroll(ViewParent var1, View var2);

   boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3);
}
