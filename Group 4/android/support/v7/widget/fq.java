/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.a.d;
import android.support.v7.widget.fn;
import android.support.v7.widget.fo;
import android.support.v7.widget.fr;
import android.view.View;

class fq
implements View.OnClickListener {
    final /* synthetic */ fn a;

    private fq(fn fn2) {
        this.a = fn2;
    }

    /* synthetic */ fq(fn fn2, fo fo2) {
        this(fn2);
    }

    public void onClick(View view) {
        ((fr)view).b().d();
        int n2 = fn.a(this.a).getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view2 = fn.a(this.a).getChildAt(n3);
            boolean bl2 = view2 == view;
            view2.setSelected(bl2);
            ++n3;
        }
    }
}

