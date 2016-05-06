package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

static class AccessibilityEventKitKatImpl extends AccessibilityEventIcsImpl
{
    AccessibilityEventKitKatImpl() {
        super();
    }
    
    @Override
    public int getContentChangeTypes(final AccessibilityEvent accessibilityEvent) {
        return AccessibilityEventCompatKitKat.getContentChangeTypes(accessibilityEvent);
    }
    
    @Override
    public void setContentChangeTypes(final AccessibilityEvent accessibilityEvent, final int n) {
        AccessibilityEventCompatKitKat.setContentChangeTypes(accessibilityEvent, n);
    }
}
