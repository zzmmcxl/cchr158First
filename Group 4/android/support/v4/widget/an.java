/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class an {
    private static Field a;

    static {
        try {
            a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            a.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException var0) {
            Log.i((String)"PopupWindowCompatApi21", (String)"Could not fetch mOverlapAnchor field from PopupWindow", (Throwable)var0);
            return;
        }
    }

    static void a(PopupWindow popupWindow, boolean bl2) {
        if (a == null) return;
        try {
            a.set((Object)popupWindow, bl2);
            return;
        }
        catch (IllegalAccessException var2_2) {
            Log.i((String)"PopupWindowCompatApi21", (String)"Could not set overlap anchor field in PopupWindow", (Throwable)var2_2);
            return;
        }
    }
}

