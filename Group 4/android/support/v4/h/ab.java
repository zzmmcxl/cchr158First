/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.Context;
import android.support.v4.h.af;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

class ab
implements LayoutInflater.Factory {
    final af a;

    ab(af af2) {
        this.a = af2;
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        return this.a.a(null, string, context, attributeSet);
    }

    public String toString() {
        return this.getClass().getName() + "{" + this.a + "}";
    }
}

