package android.support.v4.view;

import android.support.annotation.Nullable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat$HCViewCompatImpl;
import android.support.v4.view.ViewCompatICS;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ViewCompat$ICSViewCompatImpl extends ViewCompat$HCViewCompatImpl {
   static boolean accessibilityDelegateCheckFailed = false;
   static Field mAccessibilityDelegateField;

   public ViewPropertyAnimatorCompat animate(View var1) {
      if(this.mViewPropertyAnimatorCompatMap == null) {
         this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
      }

      ViewPropertyAnimatorCompat var3 = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(var1);
      ViewPropertyAnimatorCompat var2 = var3;
      if(var3 == null) {
         var2 = new ViewPropertyAnimatorCompat(var1);
         this.mViewPropertyAnimatorCompatMap.put(var1, var2);
      }

      return var2;
   }

   public boolean canScrollHorizontally(View var1, int var2) {
      return ViewCompatICS.canScrollHorizontally(var1, var2);
   }

   public boolean canScrollVertically(View var1, int var2) {
      return ViewCompatICS.canScrollVertically(var1, var2);
   }

   public boolean hasAccessibilityDelegate(View var1) {
      boolean var2 = true;
      if(accessibilityDelegateCheckFailed) {
         return false;
      } else {
         if(mAccessibilityDelegateField == null) {
            try {
               mAccessibilityDelegateField = View.class.getDeclaredField("mAccessibilityDelegate");
               mAccessibilityDelegateField.setAccessible(true);
            } catch (Throwable var4) {
               accessibilityDelegateCheckFailed = true;
               return false;
            }
         }

         Object var5;
         try {
            var5 = mAccessibilityDelegateField.get(var1);
         } catch (Throwable var3) {
            accessibilityDelegateCheckFailed = true;
            return false;
         }

         if(var5 == null) {
            var2 = false;
         }

         return var2;
      }
   }

   public void onInitializeAccessibilityEvent(View var1, AccessibilityEvent var2) {
      ViewCompatICS.onInitializeAccessibilityEvent(var1, var2);
   }

   public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
      ViewCompatICS.onInitializeAccessibilityNodeInfo(var1, var2.getInfo());
   }

   public void onPopulateAccessibilityEvent(View var1, AccessibilityEvent var2) {
      ViewCompatICS.onPopulateAccessibilityEvent(var1, var2);
   }

   public void setAccessibilityDelegate(View var1, @Nullable AccessibilityDelegateCompat var2) {
      Object var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = var2.getBridge();
      }

      ViewCompatICS.setAccessibilityDelegate(var1, var3);
   }

   public void setFitsSystemWindows(View var1, boolean var2) {
      ViewCompatICS.setFitsSystemWindows(var1, var2);
   }
}
