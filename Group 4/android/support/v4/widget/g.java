/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.h;
import android.support.v4.widget.k;
import android.widget.CompoundButton;

class g
implements h {
    g() {
    }

    @Override
    public Drawable a(CompoundButton compoundButton) {
        return k.a(compoundButton);
    }

    @Override
    public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        k.a(compoundButton, colorStateList);
    }

    @Override
    public void a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        k.a(compoundButton, mode);
    }
}

