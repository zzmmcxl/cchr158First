/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.support.v7.widget.fc;
import android.support.v7.widget.ff;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

class dd {
    boolean a = true;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h = 0;
    boolean i = false;
    int j;
    List k = null;
    boolean l;

    dd() {
    }

    private View b() {
        int n2 = this.k.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = ((ff)this.k.get((int)n3)).a;
            er er2 = (er)view.getLayoutParams();
            if (!er2.c() && this.d == er2.e()) {
                this.a(view);
                return view;
            }
            ++n3;
        }
        return null;
    }

    View a(ew ew2) {
        if (this.k != null) {
            return this.b();
        }
        View view = ew2.c(this.d);
        this.d += this.e;
        return view;
    }

    public void a() {
        this.a((View)null);
    }

    public void a(View view) {
        View view2 = this.b(view);
        if (view2 == null) {
            this.d = -1;
            return;
        }
        this.d = ((er)view2.getLayoutParams()).e();
    }

    boolean a(fc fc2) {
        if (this.d < 0) return false;
        if (this.d >= fc2.e()) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public View b(View var1_1) {
        var2_2 = this.k.size();
        var3_3 = null;
        var4_4 = Integer.MAX_VALUE;
        var5_5 = 0;
        while (var5_5 < var2_2) {
            var6_6 = ((ff)this.k.get((int)var5_5)).a;
            var7_7 = (er)var6_6.getLayoutParams();
            if (var6_6 == var1_1) ** GOTO lbl-1000
            if (var7_7.c()) {
                var8_8 = var4_4;
                var9_9 = var3_3;
            } else {
                var8_8 = (var7_7.e() - this.d) * this.e;
                if (var8_8 < 0) {
                    var8_8 = var4_4;
                    var9_9 = var3_3;
                } else if (var8_8 < var4_4) {
                    if (var8_8 == 0) {
                        return var6_6;
                    }
                    var9_9 = var6_6;
                } else lbl-1000: // 2 sources:
                {
                    var8_8 = var4_4;
                    var9_9 = var3_3;
                }
            }
            ++var5_5;
            var3_3 = var9_9;
            var4_4 = var8_8;
        }
        return var3_3;
    }
}

