package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class AccessibilityNodeProviderCompatJellyBean$1 extends AccessibilityNodeProvider {
   AccessibilityNodeProviderCompatJellyBean$1(AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge var1) {
      this.val$bridge = var1;
   }

   public AccessibilityNodeInfo createAccessibilityNodeInfo(int var1) {
      return (AccessibilityNodeInfo)this.val$bridge.createAccessibilityNodeInfo(var1);
   }

   public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String var1, int var2) {
      return this.val$bridge.findAccessibilityNodeInfosByText(var1, var2);
   }

   public boolean performAction(int var1, int var2, Bundle var3) {
      return this.val$bridge.performAction(var1, var2, var3);
   }
}
