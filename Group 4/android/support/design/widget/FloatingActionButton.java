/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.e;
import android.support.design.h;
import android.support.design.i;
import android.support.design.widget.ab;
import android.support.design.widget.ac;
import android.support.design.widget.ad;
import android.support.design.widget.aj;
import android.support.design.widget.am;
import android.support.design.widget.ao;
import android.support.design.widget.ap;
import android.support.design.widget.av;
import android.support.design.widget.bt;
import android.support.design.widget.ct;
import android.support.design.widget.r;
import android.support.design.widget.z;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

@r(a="Landroid/support/design/widget/FloatingActionButton$Behavior;")
public class FloatingActionButton
extends ct {
    private ColorStateList a;
    private PorterDuff.Mode b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private final Rect h = new Rect();
    private am i;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        bt.a(context);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.FloatingActionButton, n2, h.Widget_Design_FloatingActionButton);
        this.a = typedArray.getColorStateList(i.FloatingActionButton_backgroundTint);
        this.b = FloatingActionButton.a(typedArray.getInt(i.FloatingActionButton_backgroundTintMode, -1), null);
        this.d = typedArray.getColor(i.FloatingActionButton_rippleColor, 0);
        this.e = typedArray.getInt(i.FloatingActionButton_fabSize, 0);
        this.c = typedArray.getDimensionPixelSize(i.FloatingActionButton_borderWidth, 0);
        float f2 = typedArray.getDimension(i.FloatingActionButton_elevation, 0.0f);
        float f3 = typedArray.getDimension(i.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.g = typedArray.getBoolean(i.FloatingActionButton_useCompatPadding, false);
        typedArray.recycle();
        int n3 = (int)this.getResources().getDimension(e.design_fab_image_size);
        this.f = (this.getSizeDimension() - n3) / 2;
        this.getImpl().a(this.a, this.b, this.d, this.c);
        this.getImpl().c(f2);
        this.getImpl().d(f3);
        this.getImpl().g();
    }

    private static int a(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n3);
        int n5 = View.MeasureSpec.getSize((int)n3);
        switch (n4) {
            default: {
                return n2;
            }
            case Integer.MIN_VALUE: {
                return Math.min(n2, n5);
            }
            case 1073741824: 
        }
        return n5;
    }

    static PorterDuff.Mode a(int n2, PorterDuff.Mode mode) {
        switch (n2) {
            default: {
                return mode;
            }
            case 3: {
                return PorterDuff.Mode.SRC_OVER;
            }
            case 5: {
                return PorterDuff.Mode.SRC_IN;
            }
            case 9: {
                return PorterDuff.Mode.SRC_ATOP;
            }
            case 14: {
                return PorterDuff.Mode.MULTIPLY;
            }
            case 15: 
        }
        return PorterDuff.Mode.SCREEN;
    }

    static /* synthetic */ Rect a(FloatingActionButton floatingActionButton) {
        return floatingActionButton.h;
    }

    private am a() {
        int n2 = Build.VERSION.SDK_INT;
        if (n2 >= 21) {
            return new ap(this, new ac(this, null));
        }
        if (n2 < 14) return new ad(this, new ac(this, null));
        return new aj(this, new ac(this, null));
    }

    private ao a(ab ab2) {
        if (ab2 != null) return new z(this, ab2);
        return null;
    }

    static /* synthetic */ void a(FloatingActionButton floatingActionButton, Drawable drawable) {
        floatingActionButton.setBackgroundDrawable(drawable);
    }

    static /* synthetic */ void a(FloatingActionButton floatingActionButton, ab ab2, boolean bl2) {
        floatingActionButton.b(ab2, bl2);
    }

    private void a(ab ab2, boolean bl2) {
        this.getImpl().b(this.a(ab2), bl2);
    }

    static /* synthetic */ int b(FloatingActionButton floatingActionButton) {
        return floatingActionButton.f;
    }

    static /* synthetic */ void b(FloatingActionButton floatingActionButton, ab ab2, boolean bl2) {
        floatingActionButton.a(ab2, bl2);
    }

    private void b(ab ab2, boolean bl2) {
        this.getImpl().a(this.a(ab2), bl2);
    }

    static /* synthetic */ boolean c(FloatingActionButton floatingActionButton) {
        return floatingActionButton.g;
    }

    private am getImpl() {
        if (this.i != null) return this.i;
        this.i = this.a();
        return this.i;
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.getImpl().a(this.getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.a;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.b;
    }

    public float getCompatElevation() {
        return this.getImpl().a();
    }

    public Drawable getContentBackground() {
        return this.getImpl().f();
    }

    final int getSizeDimension() {
        switch (this.e) {
            default: {
                return this.getResources().getDimensionPixelSize(e.design_fab_size_normal);
            }
            case 1: 
        }
        return this.getResources().getDimensionPixelSize(e.design_fab_size_mini);
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    @TargetApi(value=11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().h();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().i();
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = this.getSizeDimension();
        int n5 = Math.min(FloatingActionButton.a(n4, n2), FloatingActionButton.a(n4, n3));
        this.setMeasuredDimension(n5 + this.h.left + this.h.right, n5 + this.h.top + this.h.bottom);
    }

    public void setBackgroundColor(int n2) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    @Override
    public void setBackgroundResource(int n2) {
        Log.i((String)"FloatingActionButton", (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.a == colorStateList) return;
        this.a = colorStateList;
        this.getImpl().a(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.b == mode) return;
        this.b = mode;
        this.getImpl().a(mode);
    }

    public void setCompatElevation(float f2) {
        this.getImpl().c(f2);
    }

    public void setRippleColor(int n2) {
        if (this.d == n2) return;
        this.d = n2;
        this.getImpl().a(n2);
    }

    public void setUseCompatPadding(boolean bl2) {
        if (this.g == bl2) return;
        this.g = bl2;
        this.getImpl().c();
    }
}

