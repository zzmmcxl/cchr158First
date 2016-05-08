package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ViewParentCompat$ViewParentCompatICSImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatKitKatImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatLollipopImpl;
import android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class ViewParentCompat {
   static final ViewParentCompat$ViewParentCompatImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 21) {
         IMPL = new ViewParentCompat$ViewParentCompatLollipopImpl();
      } else if(var0 >= 19) {
         IMPL = new ViewParentCompat$ViewParentCompatKitKatImpl();
      } else if(var0 >= 14) {
         IMPL = new ViewParentCompat$ViewParentCompatICSImpl();
      } else {
         IMPL = new ViewParentCompat$ViewParentCompatStubImpl();
      }
   }

   public static void notifySubtreeAccessibilityStateChanged(ViewParent var0, View var1, View var2, int var3) {
      IMPL.notifySubtreeAccessibilityStateChanged(var0, var1, var2, var3);
   }

   public static boolean onNestedFling(ViewParent var0, View var1, float var2, float var3, boolean var4) {
      return IMPL.onNestedFling(var0, var1, var2, var3, var4);
   }

   public static boolean onNestedPreFling(ViewParent var0, View var1, float var2, float var3) {
      return IMPL.onNestedPreFling(var0, var1, var2, var3);
   }

   public static void onNestedPreScroll(ViewParent var0, View var1, int var2, int var3, int[] var4) {
      IMPL.onNestedPreScroll(var0, var1, var2, var3, var4);
   }

   public static void onNestedScroll(ViewParent var0, View var1, int var2, int var3, int var4, int var5) {
      IMPL.onNestedScroll(var0, var1, var2, var3, var4, var5);
   }

   public static void onNestedScrollAccepted(ViewParent var0, View var1, View var2, int var3) {
      IMPL.onNestedScrollAccepted(var0, var1, var2, var3);
   }

   public static boolean onStartNestedScroll(ViewParent var0, View var1, View var2, int var3) {
      return IMPL.onStartNestedScroll(var0, var1, var2, var3);
   }

   public static void onStopNestedScroll(ViewParent var0, View var1) {
      IMPL.onStopNestedScroll(var0, var1);
   }

   public static boolean requestSendAccessibilityEvent(ViewParent var0, View var1, AccessibilityEvent var2) {
      return IMPL.requestSendAccessibilityEvent(var0, var1, var2);
   }
}
