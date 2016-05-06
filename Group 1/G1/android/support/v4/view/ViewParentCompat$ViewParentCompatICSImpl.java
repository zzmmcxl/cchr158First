package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewParent;

static class ViewParentCompatICSImpl extends ViewParentCompatStubImpl
{
    ViewParentCompatICSImpl() {
        super();
    }
    
    @Override
    public boolean requestSendAccessibilityEvent(final ViewParent viewParent, final View view, final AccessibilityEvent accessibilityEvent) {
        return ViewParentCompatICS.requestSendAccessibilityEvent(viewParent, view, accessibilityEvent);
    }
}
