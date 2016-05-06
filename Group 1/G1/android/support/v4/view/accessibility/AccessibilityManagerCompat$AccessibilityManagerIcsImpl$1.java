package android.support.v4.view.accessibility;

class AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1 implements AccessibilityStateChangeListenerBridge {
    final /* synthetic */ AccessibilityManagerIcsImpl this$0;
    final /* synthetic */ AccessibilityStateChangeListenerCompat val$listener;
    
    AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(final AccessibilityManagerIcsImpl this$0, final AccessibilityStateChangeListenerCompat val$listener) {
        this$0 = this$0;
        val$listener = val$listener;
        super();
    }
    
    @Override
    public void onAccessibilityStateChanged(final boolean b) {
        val$listener.onAccessibilityStateChanged(b);
    }
}