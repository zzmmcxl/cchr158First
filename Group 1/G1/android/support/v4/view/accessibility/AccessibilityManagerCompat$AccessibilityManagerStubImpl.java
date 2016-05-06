package android.support.v4.view.accessibility;

import java.util.Collections;
import android.accessibilityservice.AccessibilityServiceInfo;
import java.util.List;
import android.view.accessibility.AccessibilityManager;

static class AccessibilityManagerStubImpl implements AccessibilityManagerVersionImpl
{
    AccessibilityManagerStubImpl() {
        super();
    }
    
    @Override
    public boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return false;
    }
    
    @Override
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return Collections.<AccessibilityServiceInfo>emptyList();
    }
    
    @Override
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return Collections.<AccessibilityServiceInfo>emptyList();
    }
    
    @Override
    public boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return false;
    }
    
    @Override
    public Object newAccessiblityStateChangeListener(final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return null;
    }
    
    @Override
    public boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return false;
    }
}
