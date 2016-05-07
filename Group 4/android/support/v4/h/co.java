/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.cs;
import android.view.ViewConfiguration;

class co
implements cs {
    co() {
    }

    @Override
    public int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledTouchSlop();
    }

    @Override
    public boolean b(ViewConfiguration viewConfiguration) {
        return true;
    }
}

