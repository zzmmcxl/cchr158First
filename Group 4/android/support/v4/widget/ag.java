/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.os.Build;
import android.support.v4.widget.ah;
import android.support.v4.widget.ai;
import android.support.v4.widget.aj;
import android.support.v4.widget.ak;
import android.support.v4.widget.al;
import android.support.v4.widget.am;
import android.view.View;
import android.widget.PopupWindow;

public final class ag {
    static final am a;

    static {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 23) {
            a = new ai();
            return;
        }
        if (n2 >= 21) {
            a = new ah();
            return;
        }
        if (n2 >= 19) {
            a = new al();
            return;
        }
        if (n2 >= 9) {
            a = new ak();
            return;
        }
        a = new aj();
    }

    public static void a(PopupWindow popupWindow, int n2) {
        a.a(popupWindow, n2);
    }

    public static void a(PopupWindow popupWindow, View view, int n2, int n3, int n4) {
        a.a(popupWindow, view, n2, n3, n4);
    }

    public static void a(PopupWindow popupWindow, boolean bl2) {
        a.a(popupWindow, bl2);
    }
}

