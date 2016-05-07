/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.c.a.q;
import android.support.v4.c.a.s;
import android.support.v4.c.a.t;

class r
extends Drawable
implements Drawable.Callback,
q {
    static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    s b;
    Drawable c;
    private int d;
    private PorterDuff.Mode e;
    private boolean f;
    private boolean g;

    r(Drawable drawable) {
        this.b = this.b();
        this.c = drawable;
    }

    r(s s2, Resources resources) {
        this.b = s2;
        this.a(resources);
    }

    private void a(Resources resources) {
        if (this.b == null) return;
        if (this.b.b == null) return;
        this.a(this.a(this.b.b, resources));
    }

    private boolean a(int[] arrn) {
        if (!this.c()) {
            return false;
        }
        ColorStateList colorStateList = this.b.c;
        PorterDuff.Mode mode = this.b.d;
        if (colorStateList != null && mode != null) {
            int n2 = colorStateList.getColorForState(arrn, colorStateList.getDefaultColor());
            if (this.f && n2 == this.d) {
                if (mode == this.e) return false;
            }
            this.setColorFilter(n2, mode);
            this.d = n2;
            this.e = mode;
            this.f = true;
            return true;
        }
        this.f = false;
        this.clearColorFilter();
        return false;
    }

    @Override
    public Drawable a() {
        return this.c;
    }

    protected Drawable a(Drawable.ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    @Override
    public void a(int n2) {
        this.a(ColorStateList.valueOf((int)n2));
    }

    @Override
    public void a(ColorStateList colorStateList) {
        this.b.c = colorStateList;
        this.a(this.getState());
    }

    @Override
    public void a(PorterDuff.Mode mode) {
        this.b.d = mode;
        this.a(this.getState());
    }

    @Override
    public void a(Drawable drawable) {
        if (this.c != null) {
            this.c.setCallback(null);
        }
        this.c = drawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback)this);
            drawable.setVisible(this.isVisible(), true);
            drawable.setState(this.getState());
            drawable.setLevel(this.getLevel());
            drawable.setBounds(this.getBounds());
            if (this.b != null) {
                this.b.b = drawable.getConstantState();
            }
        }
        this.invalidateSelf();
    }

    s b() {
        return new t(this.b, null);
    }

    protected boolean c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.c.draw(canvas);
    }

    public int getChangingConfigurations() {
        int n2;
        int n3 = super.getChangingConfigurations();
        if (this.b != null) {
            n2 = this.b.getChangingConfigurations();
            return n2 | n3 | this.c.getChangingConfigurations();
        }
        n2 = 0;
        return n2 | n3 | this.c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.b == null) return null;
        if (!this.b.a()) return null;
        this.b.a = this.getChangingConfigurations();
        return this.b;
    }

    public Drawable getCurrent() {
        return this.c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.c.getPadding(rect);
    }

    public int[] getState() {
        return this.c.getState();
    }

    public Region getTransparentRegion() {
        return this.c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        this.invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.c() ? this.b.c : null;
        if (colorStateList != null) {
            if (colorStateList.isStateful()) return true;
        }
        if (!this.c.isStateful()) return false;
        return true;
    }

    public Drawable mutate() {
        if (this.g) return this;
        if (super.mutate() != this) return this;
        this.b = this.b();
        if (this.c != null) {
            this.c.mutate();
        }
        if (this.b != null) {
            s s2 = this.b;
            Drawable.ConstantState constantState = this.c != null ? this.c.getConstantState() : null;
            s2.b = constantState;
        }
        this.g = true;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.c == null) return;
        this.c.setBounds(rect);
    }

    protected boolean onLevelChange(int n2) {
        return this.c.setLevel(n2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long l2) {
        this.scheduleSelf(runnable, l2);
    }

    public void setAlpha(int n2) {
        this.c.setAlpha(n2);
    }

    public void setChangingConfigurations(int n2) {
        this.c.setChangingConfigurations(n2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.c.setColorFilter(colorFilter);
    }

    public void setDither(boolean bl2) {
        this.c.setDither(bl2);
    }

    public void setFilterBitmap(boolean bl2) {
        this.c.setFilterBitmap(bl2);
    }

    public boolean setState(int[] arrn) {
        boolean bl2 = this.c.setState(arrn);
        if (this.a(arrn)) return true;
        if (!bl2) return false;
        return true;
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        if (super.setVisible(bl2, bl3)) return true;
        if (!this.c.setVisible(bl2, bl3)) return false;
        return true;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.unscheduleSelf(runnable);
    }
}

