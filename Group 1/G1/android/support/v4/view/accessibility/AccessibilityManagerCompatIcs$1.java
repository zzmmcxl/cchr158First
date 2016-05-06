package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager$AccessibilityStateChangeListener;

static final class AccessibilityManagerCompatIcs$1 implements AccessibilityManager$AccessibilityStateChangeListener {
    final /* synthetic */ AccessibilityStateChangeListenerBridge val$bridge;
    
    AccessibilityManagerCompatIcs$1(final AccessibilityStateChangeListenerBridge val$bridge) {
        this.val$bridge = val$bridge;
        super();
    }
    
    public void onAccessibilityStateChanged(final boolean b) {
        val$bridge.onAccessibilityStateChanged(b);
    }
}