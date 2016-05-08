package android.support.v4.view.accessibility;

import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge;

class AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1 implements AccessibilityManagerCompatIcs$AccessibilityStateChangeListenerBridge {
   AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(AccessibilityManagerCompat$AccessibilityManagerIcsImpl var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2) {
      this.this$0 = var1;
      this.val$listener = var2;
   }

   public void onAccessibilityStateChanged(boolean var1) {
      this.val$listener.onAccessibilityStateChanged(var1);
   }
}
