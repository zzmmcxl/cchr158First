package android.support.v4.view;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityEvent;
import android.view.View$AccessibilityDelegate;
import android.view.View;

class AccessibilityDelegateCompatJellyBean
{
    AccessibilityDelegateCompatJellyBean() {
        super();
    }
    
    public static Object getAccessibilityNodeProvider(final Object o, final View view) {
        return ((View$AccessibilityDelegate)o).getAccessibilityNodeProvider(view);
    }
    
    public static Object newAccessibilityDelegateBridge(final AccessibilityDelegateBridgeJellyBean accessibilityDelegateBridgeJellyBean) {
        return new View$AccessibilityDelegate() {
            final /* synthetic */ AccessibilityDelegateBridgeJellyBean val$bridge;
            
            AccessibilityDelegateCompatJellyBean$1() {
                super();
            }
            
            public boolean dispatchPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            
            public AccessibilityNodeProvider getAccessibilityNodeProvider(final View view) {
                return (AccessibilityNodeProvider)accessibilityDelegateBridgeJellyBean.getAccessibilityNodeProvider(view);
            }
            
            public void onInitializeAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
            
            public void onInitializeAccessibilityNodeInfo(final View view, final AccessibilityNodeInfo accessibilityNodeInfo) {
                accessibilityDelegateBridgeJellyBean.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
            
            public void onPopulateAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            
            public boolean onRequestSendAccessibilityEvent(final ViewGroup viewGroup, final View view, final AccessibilityEvent accessibilityEvent) {
                return accessibilityDelegateBridgeJellyBean.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            
            public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
                return accessibilityDelegateBridgeJellyBean.performAccessibilityAction(view, n, bundle);
            }
            
            public void sendAccessibilityEvent(final View view, final int n) {
                accessibilityDelegateBridgeJellyBean.sendAccessibilityEvent(view, n);
            }
            
            public void sendAccessibilityEventUnchecked(final View view, final AccessibilityEvent accessibilityEvent) {
                accessibilityDelegateBridgeJellyBean.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        };
    }
    
    public static boolean performAccessibilityAction(final Object o, final View view, final int n, final Bundle bundle) {
        return ((View$AccessibilityDelegate)o).performAccessibilityAction(view, n, bundle);
    }
}
