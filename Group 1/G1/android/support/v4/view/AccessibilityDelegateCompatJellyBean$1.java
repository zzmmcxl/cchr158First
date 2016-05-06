package android.support.v4.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.View$AccessibilityDelegate;

static final class AccessibilityDelegateCompatJellyBean$1 extends View$AccessibilityDelegate {
    final /* synthetic */ AccessibilityDelegateBridgeJellyBean val$bridge;
    
    AccessibilityDelegateCompatJellyBean$1(final AccessibilityDelegateBridgeJellyBean val$bridge) {
        this.val$bridge = val$bridge;
        super();
    }
    
    public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        return val$bridge.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public AccessibilityNodeProvider getAccessibilityNodeProvider(final View view) {
        return (AccessibilityNodeProvider)val$bridge.getAccessibilityNodeProvider(view);
    }
    
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        val$bridge.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfo accessibilityNodeInfo) {
        val$bridge.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
    }
    
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        val$bridge.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return val$bridge.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
        return val$bridge.performAccessibilityAction(view, n, bundle);
    }
    
    public void sendAccessibilityEvent(final View view, final int n) {
        val$bridge.sendAccessibilityEvent(view, n);
    }
    
    public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
        val$bridge.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}