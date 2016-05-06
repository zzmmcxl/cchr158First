package android.support.v4.view;

import android.view.ViewGroup;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

class AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1 implements AccessibilityDelegateBridge {
    final /* synthetic */ AccessibilityDelegateIcsImpl this$0;
    final /* synthetic */ AccessibilityDelegateCompat val$compat;
    
    AccessibilityDelegateCompat$AccessibilityDelegateIcsImpl$1(final AccessibilityDelegateIcsImpl this$0, final AccessibilityDelegateCompat val$compat) {
        this$0 = this$0;
        val$compat = val$compat;
        super();
    }
    
    @Override
    public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        return val$compat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        val$compat.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final View view, final Object o) {
        val$compat.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(o));
    }
    
    @Override
    public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        val$compat.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }
    
    @Override
    public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return val$compat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
    
    @Override
    public void sendAccessibilityEvent(final View view, final int n) {
        val$compat.sendAccessibilityEvent(view, n);
    }
    
    @Override
    public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
        val$compat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}