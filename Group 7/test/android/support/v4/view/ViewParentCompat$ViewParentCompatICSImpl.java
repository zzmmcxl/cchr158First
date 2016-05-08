package android.support.v4.view;

import android.support.v4.view.ViewParentCompat$ViewParentCompatStubImpl;
import android.support.v4.view.ViewParentCompatICS;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

class ViewParentCompat$ViewParentCompatICSImpl extends ViewParentCompat$ViewParentCompatStubImpl {
   public boolean requestSendAccessibilityEvent(ViewParent var1, View var2, AccessibilityEvent var3) {
      return ViewParentCompatICS.requestSendAccessibilityEvent(var1, var2, var3);
   }
}
