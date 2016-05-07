/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.Context;
import android.support.v4.h.ab;
import android.support.v4.h.af;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

class ad
extends ab
implements LayoutInflater.Factory2 {
    ad(af af2) {
        super(af2);
    }

    public View onCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        return this.a.a(view, string, context, attributeSet);
    }
}

