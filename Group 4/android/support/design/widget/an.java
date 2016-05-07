/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.support.design.widget.am;
import android.view.ViewTreeObserver;

class an
implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ am a;

    an(am am2) {
        this.a = am2;
    }

    public boolean onPreDraw() {
        this.a.e();
        return true;
    }
}

