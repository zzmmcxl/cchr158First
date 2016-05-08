package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;

interface AccessibilityNodeProviderCompatJellyBean$AccessibilityNodeInfoBridge {
   Object createAccessibilityNodeInfo(int var1);

   List<Object> findAccessibilityNodeInfosByText(String var1, int var2);

   boolean performAction(int var1, int var2, Bundle var3);
}
