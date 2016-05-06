package android.support.v4.view.accessibility;

import java.util.Collections;
import android.accessibilityservice.AccessibilityServiceInfo;
import java.util.List;
import android.view.accessibility.AccessibilityManager;
import android.os.Build$VERSION;

public final class AccessibilityManagerCompat
{
    private static final AccessibilityManagerVersionImpl IMPL;
    
    static {
        if (Build$VERSION.SDK_INT >= 14) {
            IMPL = (AccessibilityManagerVersionImpl)new AccessibilityManagerIcsImpl();
            return;
        }
        IMPL = (AccessibilityManagerVersionImpl)new AccessibilityManagerStubImpl();
    }
    
    private AccessibilityManagerCompat() {
        super();
    }
    
    static /* synthetic */ AccessibilityManagerVersionImpl access$000() {
        return IMPL;
    }
    
    public static boolean addAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.addAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }
    
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(final AccessibilityManager accessibilityManager, final int n) {
        return IMPL.getEnabledAccessibilityServiceList(accessibilityManager, n);
    }
    
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(final AccessibilityManager accessibilityManager) {
        return IMPL.getInstalledAccessibilityServiceList(accessibilityManager);
    }
    
    public static boolean isTouchExplorationEnabled(final AccessibilityManager accessibilityManager) {
        return IMPL.isTouchExplorationEnabled(accessibilityManager);
    }
    
    public static boolean removeAccessibilityStateChangeListener(final AccessibilityManager accessibilityManager, final AccessibilityStateChangeListenerCompat accessibilityStateChangeListenerCompat) {
        return IMPL.removeAccessibilityStateChangeListener(accessibilityManager, accessibilityStateChangeListenerCompat);
    }
}
