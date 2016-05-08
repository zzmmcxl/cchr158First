package android.support.v4.view;

import android.support.v4.view.ViewGroupCompat$ViewGroupCompatHCImpl;
import android.support.v4.view.ViewGroupCompatIcs;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ViewGroupCompat$ViewGroupCompatIcsImpl extends ViewGroupCompat$ViewGroupCompatHCImpl {
   public boolean onRequestSendAccessibilityEvent(ViewGroup var1, View var2, AccessibilityEvent var3) {
      return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(var1, var2, var3);
   }
}
