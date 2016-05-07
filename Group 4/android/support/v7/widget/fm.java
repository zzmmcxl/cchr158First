/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dw;
import android.support.v7.widget.ep;
import android.support.v7.widget.fc;
import android.view.View;

class fm {
    static int a(fc fc2, dw dw2, View view, View view2, ep ep2, boolean bl2) {
        if (ep2.s() == 0) return 0;
        if (fc2.e() == 0) return 0;
        if (view == null) return 0;
        if (view2 == null) {
            return 0;
        }
        if (!bl2) {
            return 1 + Math.abs(ep2.d(view) - ep2.d(view2));
        }
        int n2 = dw2.b(view2) - dw2.a(view);
        return Math.min(dw2.f(), n2);
    }

    static int a(fc fc2, dw dw2, View view, View view2, ep ep2, boolean bl2, boolean bl3) {
        int n2 = ep2.s();
        int n3 = 0;
        if (n2 == 0) return n3;
        int n4 = fc2.e();
        n3 = 0;
        if (n4 == 0) return n3;
        n3 = 0;
        if (view == null) return n3;
        n3 = 0;
        if (view2 == null) {
            return n3;
        }
        int n5 = Math.min(ep2.d(view), ep2.d(view2));
        int n6 = Math.max(ep2.d(view), ep2.d(view2));
        n3 = bl3 ? Math.max(0, -1 + (fc2.e() - n6)) : Math.max(0, n5);
        if (!bl2) return n3;
        int n7 = Math.abs(dw2.b(view2) - dw2.a(view));
        int n8 = 1 + Math.abs(ep2.d(view) - ep2.d(view2));
        return Math.round((float)n7 / (float)n8 * (float)n3 + (float)(dw2.c() - dw2.a(view)));
    }

    static int b(fc fc2, dw dw2, View view, View view2, ep ep2, boolean bl2) {
        if (ep2.s() == 0) return 0;
        if (fc2.e() == 0) return 0;
        if (view == null) return 0;
        if (view2 == null) {
            return 0;
        }
        if (!bl2) {
            return fc2.e();
        }
        int n2 = dw2.b(view2) - dw2.a(view);
        int n3 = 1 + Math.abs(ep2.d(view) - ep2.d(view2));
        return (int)((float)n2 / (float)n3 * (float)fc2.e());
    }
}

