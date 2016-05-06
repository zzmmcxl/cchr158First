package android.support.v4.view;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupCompatIcs
{
    ViewGroupCompatIcs() {
        super();
    }
    
    public static boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
