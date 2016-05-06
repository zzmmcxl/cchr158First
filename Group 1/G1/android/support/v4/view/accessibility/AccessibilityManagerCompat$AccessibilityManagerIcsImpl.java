package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import java.util.List;
import android.view.accessibility.AccessibilityManager;

static class AccessibilityManagerIcsImpl extends AccessibilityManagerStubImpl
{
    AccessibilityManagerIcsImpl() {
        super();
    }
    
    @Override
    public boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
    }
    
    @Override
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(accessibilityManager, n);
    }
    
    @Override
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(accessibilityManager);
    }
    
    @Override
    public boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(accessibilityManager);
    }
    
    @Override
    public Object newAccessiblityStateChangeListener(final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener((AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge)new AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge() {
            final /* synthetic */ AccessibilityManagerIcsImpl this$0;
            final /* synthetic */ AccessibilityStateChangeListenerCompat val$listener;
            
            AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public void onAccessibilityStateChanged(final boolean b) {
                accessibilityStateChangeListenerCompat.onAccessibilityStateChanged(b);
            }
        });
    }
    
    @Override
    public boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat.mListener);
    }
}
