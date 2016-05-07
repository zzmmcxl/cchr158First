/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.support.v4.app.ae;
import android.support.v4.app.x;
import android.view.View;

class y
extends ae {
    final /* synthetic */ x a;

    y(x x2) {
        this.a = x2;
    }

    @Override
    public View a(int n2) {
        if (this.a.R != null) return this.a.R.findViewById(n2);
        throw new IllegalStateException("Fragment does not have a view");
    }

    @Override
    public boolean a() {
        if (this.a.R == null) return false;
        return true;
    }
}

