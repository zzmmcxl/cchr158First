/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.d.a.a;

class dt
extends a {
    private boolean a = true;

    public dt(Drawable drawable) {
        super(drawable);
    }

    void a(boolean bl2) {
        this.a = bl2;
    }

    @Override
    public void draw(Canvas canvas) {
        if (!this.a) return;
        super.draw(canvas);
    }

    @Override
    public void setHotspot(float f2, float f3) {
        if (!this.a) return;
        super.setHotspot(f2, f3);
    }

    @Override
    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        if (!this.a) return;
        super.setHotspotBounds(n2, n3, n4, n5);
    }

    @Override
    public boolean setState(int[] arrn) {
        if (!this.a) return false;
        return super.setState(arrn);
    }

    @Override
    public boolean setVisible(boolean bl2, boolean bl3) {
        if (!this.a) return false;
        return super.setVisible(bl2, bl3);
    }
}

