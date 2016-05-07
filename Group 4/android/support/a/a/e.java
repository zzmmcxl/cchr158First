/*
 * Decompiled with CFR 0_115.
 */
package android.support.a.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.a.a.b;
import android.support.a.a.c;

class e
extends Drawable.ConstantState {
    private final Drawable.ConstantState a;

    public e(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    public Drawable newDrawable() {
        b b2 = new b(null);
        b2.a = this.a.newDrawable();
        b2.a.setCallback(b.a(b2));
        return b2;
    }

    public Drawable newDrawable(Resources resources) {
        b b2 = new b(null);
        b2.a = this.a.newDrawable(resources);
        b2.a.setCallback(b.a(b2));
        return b2;
    }

    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        b b2 = new b(null);
        b2.a = this.a.newDrawable(resources, theme);
        b2.a.setCallback(b.a(b2));
        return b2;
    }
}

