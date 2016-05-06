package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

static class AccessibilityNodeProviderKitKatImpl extends AccessibilityNodeProviderStubImpl
{
    AccessibilityNodeProviderKitKatImpl() {
        super();
    }
    
    @Override
    public Object newAccessibilityNodeProviderBridge(final AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
        return AccessibilityNodeProviderCompatKitKat.newAccessibilityNodeProviderBridge((AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge)new AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge() {
            final /* synthetic */ AccessibilityNodeProviderKitKatImpl this$0;
            final /* synthetic */ AccessibilityNodeProviderCompat val$compat;
            
            AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1() {
                this$0 = this$0;
                super();
            }
            
            @Override
            public Object createAccessibilityNodeInfo(final int n) {
                final AccessibilityNodeInfoCompat accessibilityNodeInfo = accessibilityNodeProviderCompat.createAccessibilityNodeInfo(n);
                if (accessibilityNodeInfo == null) {
                    return null;
                }
                return accessibilityNodeInfo.getInfo();
            }
            
            @Override
            public List<Object> findAccessibilityNodeInfosByText(final String s, final int n) {
                final List<AccessibilityNodeInfoCompat> accessibilityNodeInfosByText = accessibilityNodeProviderCompat.findAccessibilityNodeInfosByText(s, n);
                final ArrayList<Object> list = new ArrayList<Object>();
                for (int size = accessibilityNodeInfosByText.size(), i = 0; i < size; ++i) {
                    list.add(((AccessibilityNodeInfoCompat)accessibilityNodeInfosByText.get(i)).getInfo());
                }
                return list;
            }
            
            @Override
            public Object findFocus(final int n) {
                final AccessibilityNodeInfoCompat focus = accessibilityNodeProviderCompat.findFocus(n);
                if (focus == null) {
                    return null;
                }
                return focus.getInfo();
            }
            
            @Override
            public boolean performAction(final int n, final int n2, final Bundle bundle) {
                return accessibilityNodeProviderCompat.performAction(n, n2, bundle);
            }
        });
    }
}
