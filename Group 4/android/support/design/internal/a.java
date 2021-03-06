/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.i;
import android.support.v7.widget.cz;
import android.util.AttributeSet;
import android.view.Gravity;

public class a
extends cz {
    protected boolean a = true;
    boolean b = false;
    private Drawable c;
    private final Rect d = new Rect();
    private final Rect e = new Rect();
    private int f = 119;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.ForegroundLinearLayout, n2, 0);
        this.f = typedArray.getInt(i.ForegroundLinearLayout_android_foregroundGravity, this.f);
        Drawable drawable = typedArray.getDrawable(i.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            this.setForeground(drawable);
        }
        this.a = typedArray.getBoolean(i.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArray.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.c == null) return;
        Drawable drawable = this.c;
        if (this.b) {
            this.b = false;
            Rect rect = this.d;
            Rect rect2 = this.e;
            int n2 = this.getRight() - this.getLeft();
            int n3 = this.getBottom() - this.getTop();
            if (this.a) {
                rect.set(0, 0, n2, n3);
            } else {
                rect.set(this.getPaddingLeft(), this.getPaddingTop(), n2 - this.getPaddingRight(), n3 - this.getPaddingBottom());
            }
            Gravity.apply((int)this.f, (int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Rect)rect, (Rect)rect2);
            drawable.setBounds(rect2);
        }
        drawable.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        if (this.c == null) return;
        this.c.setHotspot(f2, f3);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.c == null) return;
        if (!this.c.isStateful()) return;
        this.c.setState(this.getDrawableState());
    }

    public Drawable getForeground() {
        return this.c;
    }

    public int getForegroundGravity() {
        return this.f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.c == null) return;
        this.c.jumpToCurrentState();
    }

    @Override
    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.b = bl2 | this.b;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.c == drawable) return;
        if (this.c != null) {
            this.c.setCallback(null);
            this.unscheduleDrawable(this.c);
        }
        this.c = drawable;
        if (drawable != null) {
            this.setWillNotDraw(false);
            drawable.setCallback((Drawable.Callback)this);
            if (drawable.isStateful()) {
                drawable.setState(this.getDrawableState());
            }
            if (this.f == 119) {
                drawable.getPadding(new Rect());
            }
        } else {
            this.setWillNotDraw(true);
        }
        this.requestLayout();
        this.invalidate();
    }

    public void setForegroundGravity(int n2) {
        if (this.f == n2) return;
        int n3 = (8388615 & n2) == 0 ? 8388611 | n2 : n2;
        if ((n3 & 112) == 0) {
            n3 |= 48;
        }
        this.f = n3;
        if (this.f == 119 && this.c != null) {
            Rect rect = new Rect();
            this.c.getPadding(rect);
        }
        this.requestLayout();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable)) return true;
        if (drawable != this.c) return false;
        return true;
    }
}

