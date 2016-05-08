package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventIcsImpl;
import android.support.v4.view.accessibility.AccessibilityEventCompatKitKat;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompat$AccessibilityEventKitKatImpl extends AccessibilityEventCompat$AccessibilityEventIcsImpl {
   public int getContentChangeTypes(AccessibilityEvent var1) {
      return AccessibilityEventCompatKitKat.getContentChangeTypes(var1);
   }

   public void setContentChangeTypes(AccessibilityEvent var1, int var2) {
      AccessibilityEventCompatKitKat.setContentChangeTypes(var1, var2);
   }
}
