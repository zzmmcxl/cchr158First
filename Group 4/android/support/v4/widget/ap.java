/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class ap {
    private static Method a;
    private static boolean b;

    static void a(PopupWindow popupWindow, int n2) {
        if (!b) {
            try {
                Class[] arrclass = new Class[]{Integer.TYPE};
                a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", arrclass);
                a.setAccessible(true);
            }
            catch (Exception var6_6) {}
            b = true;
        }
        if (a == null) return;
        try {
            Method method = a;
            Object[] arrobject = new Object[]{n2};
            method.invoke((Object)popupWindow, arrobject);
            return;
        }
        catch (Exception var2_5) {
            return;
        }
    }
}

