/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

class ab {
    static void a(ListView listView, int n2) {
        int n3 = listView.getFirstVisiblePosition();
        if (n3 == -1) {
            return;
        }
        View view = listView.getChildAt(0);
        if (view == null) return;
        listView.setSelectionFromTop(n3, view.getTop() - n2);
    }
}

