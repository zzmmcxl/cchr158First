/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.app.au;
import android.support.v4.app.az;
import android.transition.Transition;
import android.view.View;

final class ax
extends Transition.EpicenterCallback {
    final /* synthetic */ az a;
    private Rect b;

    ax(az az2) {
        this.a = az2;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.b != null) return this.b;
        if (this.a.a == null) return this.b;
        this.b = au.b(this.a.a);
        return this.b;
    }
}

