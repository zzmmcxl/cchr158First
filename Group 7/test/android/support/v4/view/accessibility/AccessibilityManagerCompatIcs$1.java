package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;

final class AccessibilityManagerCompatIcs$1 implements AccessibilityStateChangeListener {
   AccessibilityManagerCompatIcs$1(AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge var1) {
      this.val$bridge = var1;
   }

   public void onAccessibilityStateChanged(boolean var1) {
      this.val$bridge.onAccessibilityStateChanged(var1);
   }
}
