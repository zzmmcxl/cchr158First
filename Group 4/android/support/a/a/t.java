/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.support.a.a.l;
import android.support.a.a.m;

class t
extends Drawable.ConstantState {
    private final Drawable.ConstantState a;

    public t(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        l l2 = new l(null);
        l2.a = (VectorDrawable)this.a.newDrawable();
        return l2;
    }

    public Drawable newDrawable(Resources resources) {
        l l2 = new l(null);
        l2.a = (VectorDrawable)this.a.newDrawable(resources);
        return l2;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        l l2 = new l(null);
        l2.a = (VectorDrawable)this.a.newDrawable(resources, theme);
        return l2;
    }
}

