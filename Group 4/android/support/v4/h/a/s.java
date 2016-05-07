/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.view.accessibility.AccessibilityNodeInfo;

class s {
    public static Object a(int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        return AccessibilityNodeInfo.CollectionItemInfo.obtain((int)n2, (int)n3, (int)n4, (int)n5, (boolean)bl2, (boolean)bl3);
    }

    public static Object a(int n2, int n3, boolean bl2, int n4) {
        return AccessibilityNodeInfo.CollectionInfo.obtain((int)n2, (int)n3, (boolean)bl2, (int)n4);
    }
}

