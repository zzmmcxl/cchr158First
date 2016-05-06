package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;

interface AccessibilityNodeInfoBridge
{
    Object createAccessibilityNodeInfo(final int p0);
    
    List<Object> findAccessibilityNodeInfosByText(final String p0, final int p1);
    
    Object findFocus(final int p0);
    
    boolean performAction(final int p0, final int p1, final Bundle p2);
}
