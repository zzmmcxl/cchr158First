package android.support.v4.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;

static class AccessibilityDelegateStubImpl implements AccessibilityDelegateImpl
{
    AccessibilityDelegateStubImpl() {
        super();
    }
    
    @Override
    public boolean dispatchPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
        return false;
    }
    
    @Override
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(final Object o, final View view) {
        return null;
    }
    
    @Override
    public Object newAccessiblityDelegateBridge(final AccessibilityDelegateCompat accessibilityDelegateCompat) {
        return null;
    }
    
    @Override
    public Object newAccessiblityDelegateDefaultImpl() {
        return null;
    }
    
    @Override
    public void onInitializeAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    @Override
    public void onInitializeAccessibilityNodeInfo(final Object o, final View view, final AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }
    
    @Override
    public void onPopulateAccessibilityEvent(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
    
    @Override
    public boolean onRequestSendAccessibilityEvent(final Object o, final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return true;
    }
    
    @Override
    public boolean performAccessibilityAction(final Object o, final View view, final int n, final Bundle bundle) {
        return false;
    }
    
    @Override
    public void sendAccessibilityEvent(final Object o, final View view, final int n) {
    }
    
    @Override
    public void sendAccessibilityEventUnchecked(final Object o, final View view, final AccessibilityEvent accessibilityEvent) {
    }
}
