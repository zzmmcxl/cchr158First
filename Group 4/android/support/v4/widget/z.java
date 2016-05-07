/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.support.v4.widget.a;
import android.support.v4.widget.aa;
import android.view.View;
import android.widget.ListView;

public class z
extends a {
    private final ListView a;

    public z(ListView listView) {
        super((View)listView);
        this.a = listView;
    }

    @Override
    public void a(int n2, int n3) {
        aa.a(this.a, n3);
    }

    @Override
    public boolean e(int n2) {
        return false;
    }

    @Override
    public boolean f(int n2) {
        ListView listView = this.a;
        int n3 = listView.getCount();
        if (n3 == 0) {
            return false;
        }
        int n4 = listView.getChildCount();
        int n5 = listView.getFirstVisiblePosition();
        int n6 = n5 + n4;
        if (n2 > 0) {
            if (n6 < n3) return true;
            if (listView.getChildAt(n4 - 1).getBottom() <= listView.getHeight()) return false;
            return true;
        }
        if (n2 >= 0) return false;
        if (n5 > 0) return true;
        if (listView.getChildAt(0).getTop() < 0) return true;
        return false;
    }
}

