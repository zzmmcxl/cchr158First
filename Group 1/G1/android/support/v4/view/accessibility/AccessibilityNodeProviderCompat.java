package android.support.v4.view.accessibility;

import java.util.ArrayList;
import android.os.Bundle;
import java.util.List;
import android.os.Build$VERSION;

public class AccessibilityNodeProviderCompat
{
    private static final AccessibilityNodeProviderImpl IMPL;
    private final Object mProvider;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            IMPL = (AccessibilityNodeProviderImpl)new AccessibilityNodeProviderKitKatImpl();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            IMPL = (AccessibilityNodeProviderImpl)new AccessibilityNodeProviderJellyBeanImpl();
            return;
        }
        IMPL = (AccessibilityNodeProviderImpl)new AccessibilityNodeProviderStubImpl();
    }
    
    public AccessibilityNodeProviderCompat() {
        super();
        mProvider = IMPL.newAccessibilityNodeProviderBridge(this);
    }
    
    public AccessibilityNodeProviderCompat(final Object mProvider) {
        super();
        mProvider = mProvider;
    }
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(final int n) {
        return null;
    }
    
    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(final String s, final int n) {
        return null;
    }
    
    public AccessibilityNodeInfoCompat findFocus(final int n) {
        return null;
    }
    
    public Object getProvider() {
        return mProvider;
    }
    
    public boolean performAction(final int n, final int n2, final Bundle bundle) {
        return false;
    }
}
