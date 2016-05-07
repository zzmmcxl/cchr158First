/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.v4.h.bo;
import android.view.View;
import java.util.Comparator;

class w
implements Comparator {
    w() {
    }

    public int a(View view, View view2) {
        float f2;
        float f3 = bo.B(view);
        if (f3 > (f2 = bo.B(view2))) {
            return -1;
        }
        if (f3 >= f2) return 0;
        return 1;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((View)object, (View)object2);
    }
}

