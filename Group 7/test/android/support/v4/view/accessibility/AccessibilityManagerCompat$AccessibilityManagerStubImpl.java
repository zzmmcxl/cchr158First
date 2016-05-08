package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerVersionImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.List;

class AccessibilityManagerCompat$AccessibilityManagerStubImpl implements AccessibilityManagerCompat$AccessibilityManagerVersionImpl {
   public boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2) {
      return false;
   }

   public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2) {
      return Collections.emptyList();
   }

   public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var1) {
      return Collections.emptyList();
   }

   public boolean isTouchExplorationEnabled(AccessibilityManager var1) {
      return false;
   }

   public Object newAccessiblityStateChangeListener(AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var1) {
      return null;
   }

   public boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2) {
      return false;
   }
}
