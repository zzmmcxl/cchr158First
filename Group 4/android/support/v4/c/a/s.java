/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.r;

public abstract class s
extends Drawable.ConstantState {
    int a;
    Drawable.ConstantState b;
    ColorStateList c = null;
    PorterDuff.Mode d = r.a;

    s(s s2, Resources resources) {
        if (s2 == null) return;
        this.a = s2.a;
        this.b = s2.b;
        this.c = s2.c;
        this.d = s2.d;
    }

    boolean a() {
        if (this.b == null) return false;
        return true;
    }

    public int getChangingConfigurations() {
        int n2;
        int n3 = this.a;
        if (this.b != null) {
            n2 = this.b.getChangingConfigurations();
            return n2 | n3;
        }
        n2 = 0;
        return n2 | n3;
    }

    public Drawable newDrawable() {
        return this.newDrawable(null);
    }

    public abstract Drawable newDrawable(Resources var1);
}

