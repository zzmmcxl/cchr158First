package android.support.v4.view;

import android.support.v4.view.ViewCompat$JbMr2ViewCompatImpl;
import android.support.v4.view.ViewCompatJB;
import android.support.v4.view.ViewCompatKitKat;
import android.view.View;

class ViewCompat$KitKatViewCompatImpl extends ViewCompat$JbMr2ViewCompatImpl {
   public int getAccessibilityLiveRegion(View var1) {
      return ViewCompatKitKat.getAccessibilityLiveRegion(var1);
   }

   public boolean isAttachedToWindow(View var1) {
      return ViewCompatKitKat.isAttachedToWindow(var1);
   }

   public boolean isLaidOut(View var1) {
      return ViewCompatKitKat.isLaidOut(var1);
   }

   public void setAccessibilityLiveRegion(View var1, int var2) {
      ViewCompatKitKat.setAccessibilityLiveRegion(var1, var2);
   }

   public void setImportantForAccessibility(View var1, int var2) {
      ViewCompatJB.setImportantForAccessibility(var1, var2);
   }
}
