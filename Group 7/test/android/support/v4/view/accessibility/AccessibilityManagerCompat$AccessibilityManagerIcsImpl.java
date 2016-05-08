package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityManagerStubImpl;
import android.support.v4.view.accessibility.AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompatIcs;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

class AccessibilityManagerCompat$AccessibilityManagerIcsImpl extends AccessibilityManagerCompat$AccessibilityManagerStubImpl {
   public boolean addAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2) {
      return AccessibilityManagerCompatIcs.addAccessibilityStateChangeListener(var1, var2.mListener);
   }

   public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager var1, int var2) {
      return AccessibilityManagerCompatIcs.getEnabledAccessibilityServiceList(var1, var2);
   }

   public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager var1) {
      return AccessibilityManagerCompatIcs.getInstalledAccessibilityServiceList(var1);
   }

   public boolean isTouchExplorationEnabled(AccessibilityManager var1) {
      return AccessibilityManagerCompatIcs.isTouchExplorationEnabled(var1);
   }

   public Object newAccessiblityStateChangeListener(AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var1) {
      return AccessibilityManagerCompatIcs.newAccessibilityStateChangeListener(new AccessibilityManagerCompat$AccessibilityManagerIcsImpl$1(this, var1));
   }

   public boolean removeAccessibilityStateChangeListener(AccessibilityManager var1, AccessibilityManagerCompat$AccessibilityStateChangeListenerCompat var2) {
      return AccessibilityManagerCompatIcs.removeAccessibilityStateChangeListener(var1, var2.mListener);
   }
}
