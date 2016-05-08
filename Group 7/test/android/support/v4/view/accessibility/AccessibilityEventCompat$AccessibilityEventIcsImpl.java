package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityEventCompat$AccessibilityEventStubImpl;
import android.support.v4.view.accessibility.AccessibilityEventCompatIcs;
import android.view.accessibility.AccessibilityEvent;

class AccessibilityEventCompat$AccessibilityEventIcsImpl extends AccessibilityEventCompat$AccessibilityEventStubImpl {
   public void appendRecord(AccessibilityEvent var1, Object var2) {
      AccessibilityEventCompatIcs.appendRecord(var1, var2);
   }

   public Object getRecord(AccessibilityEvent var1, int var2) {
      return AccessibilityEventCompatIcs.getRecord(var1, var2);
   }

   public int getRecordCount(AccessibilityEvent var1) {
      return AccessibilityEventCompatIcs.getRecordCount(var1);
   }
}
