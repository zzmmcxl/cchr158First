package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

static final class AccessibilityNodeProviderCompatJellyBean$1 extends AccessibilityNodeProvider {
    final /* synthetic */ AccessibilityNodeInfoBridge val$bridge;
    
    AccessibilityNodeProviderCompatJellyBean$1(final AccessibilityNodeInfoBridge val$bridge) {
        this.val$bridge = val$bridge;
        super();
    }
    
    public AccessibilityNodeInfo createAccessibilityNodeInfo(final int n) {
        return (AccessibilityNodeInfo)val$bridge.createAccessibilityNodeInfo(n);
    }
    
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(final String s, final int n) {
        return (List<AccessibilityNodeInfo>)val$bridge.findAccessibilityNodeInfosByText(s, n);
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return val$bridge.performAction(n, n2, bundle);
    }
}