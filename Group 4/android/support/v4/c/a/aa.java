/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.c.a.ab;
import android.support.v4.c.a.s;
import android.support.v4.c.a.y;

class aa
extends y {
    aa(Drawable drawable) {
        super(drawable);
    }

    aa(s s2, Resources resources) {
        super(s2, resources);
    }

    @Override
    s b() {
        return new ab(this.b, null);
    }

    @Override
    protected boolean c() {
        int n2 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        if (n2 != 21) return bl2;
        Drawable drawable = this.c;
        if (drawable instanceof GradientDrawable) return true;
        if (drawable instanceof DrawableContainer) return true;
        boolean bl3 = drawable instanceof InsetDrawable;
        bl2 = false;
        if (!bl3) return bl2;
        return true;
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f2, float f3) {
        this.c.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        this.c.setHotspotBounds(n2, n3, n4, n5);
    }

    @Override
    public boolean setState(int[] arrn) {
        if (!super.setState(arrn)) return false;
        this.invalidateSelf();
        return true;
    }

    public void setTint(int n2) {
        if (this.c()) {
            this.a(n2);
            return;
        }
        this.c.setTint(n2);
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.c()) {
            this.a(colorStateList);
            return;
        }
        this.c.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.c()) {
            this.a(mode);
            return;
        }
        this.c.setTintMode(mode);
    }
}

