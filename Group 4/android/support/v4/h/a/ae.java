/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.os.Bundle;
import android.support.v4.h.a.af;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class ae
extends AccessibilityNodeProvider {
    final /* synthetic */ af a;

    ae(af af2) {
        this.a = af2;
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int n2) {
        return (AccessibilityNodeInfo)this.a.a(n2);
    }

    public List findAccessibilityNodeInfosByText(String string, int n2) {
        return this.a.a(string, n2);
    }

    public boolean performAction(int n2, int n3, Bundle bundle) {
        return this.a.a(n2, n3, bundle);
    }
}

