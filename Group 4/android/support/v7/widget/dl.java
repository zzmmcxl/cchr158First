/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v7.widget.dg;
import android.support.v7.widget.dk;
import android.view.ViewParent;

class dl
implements Runnable {
    final /* synthetic */ dk a;

    private dl(dk dk2) {
        this.a = dk2;
    }

    /* synthetic */ dl(dk dk2, dg dg2) {
        this(dk2);
    }

    @Override
    public void run() {
        dk.a(this.a).getParent().requestDisallowInterceptTouchEvent(true);
    }
}

