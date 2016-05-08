package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

interface AccessibilityEventCompat$AccessibilityEventVersionImpl {
   void appendRecord(AccessibilityEvent var1, Object var2);

   int getContentChangeTypes(AccessibilityEvent var1);

   Object getRecord(AccessibilityEvent var1, int var2);

   int getRecordCount(AccessibilityEvent var1);

   void setContentChangeTypes(AccessibilityEvent var1, int var2);
}
