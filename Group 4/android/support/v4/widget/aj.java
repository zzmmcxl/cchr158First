/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.support.v4.widget.am;
import android.view.View;
import android.widget.PopupWindow;

class aj
implements am {
    aj() {
    }

    @Override
    public void a(PopupWindow popupWindow, int n2) {
    }

    @Override
    public void a(PopupWindow popupWindow, View view, int n2, int n3, int n4) {
        popupWindow.showAsDropDown(view, n2, n3);
    }

    @Override
    public void a(PopupWindow popupWindow, boolean bl2) {
    }
}

