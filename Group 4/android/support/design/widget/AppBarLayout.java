/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.h;
import android.support.design.i;
import android.support.design.widget.bt;
import android.support.design.widget.c;
import android.support.design.widget.cn;
import android.support.design.widget.g;
import android.support.design.widget.r;
import android.support.v4.h.bo;
import android.support.v4.h.dw;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

@r(a="Landroid/support/design/widget/AppBarLayout$Behavior;")
public class AppBarLayout
extends LinearLayout {
    boolean a;
    private int b = -1;
    private int c = -1;
    private int d = -1;
    private float e;
    private int f = 0;
    private dw g;
    private final List h;

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setOrientation(1);
        bt.a(context);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.AppBarLayout, 0, h.Widget_Design_AppBarLayout);
        this.e = typedArray.getDimensionPixelSize(i.AppBarLayout_elevation, 0);
        this.setBackgroundDrawable(typedArray.getDrawable(i.AppBarLayout_android_background));
        if (typedArray.hasValue(i.AppBarLayout_expanded)) {
            this.setExpanded(typedArray.getBoolean(i.AppBarLayout_expanded, false));
        }
        typedArray.recycle();
        cn.a((View)this);
        this.h = new ArrayList();
        bo.d((View)this, this.e);
        bo.a((View)this, new c(this));
    }

    static /* synthetic */ dw a(AppBarLayout appBarLayout, dw dw2) {
        return appBarLayout.a(dw2);
    }

    private dw a(dw dw2) {
        this.b = -1;
        this.g = dw2;
        return dw2;
    }

    static /* synthetic */ boolean a(AppBarLayout appBarLayout) {
        return appBarLayout.d();
    }

    static /* synthetic */ int b(AppBarLayout appBarLayout) {
        return appBarLayout.getDownNestedPreScrollRange();
    }

    private void b() {
        this.b = -1;
        this.c = -1;
        this.d = -1;
    }

    static /* synthetic */ int c(AppBarLayout appBarLayout) {
        return appBarLayout.getUpNestedPreScrollRange();
    }

    private boolean c() {
        return this.a;
    }

    static /* synthetic */ int d(AppBarLayout appBarLayout) {
        return appBarLayout.getDownNestedScrollRange();
    }

    private boolean d() {
        if (this.getTotalScrollRange() == 0) return false;
        return true;
    }

    static /* synthetic */ int e(AppBarLayout appBarLayout) {
        return appBarLayout.getPendingAction();
    }

    private void e() {
        this.f = 0;
    }

    static /* synthetic */ void f(AppBarLayout appBarLayout) {
        appBarLayout.e();
    }

    static /* synthetic */ boolean g(AppBarLayout appBarLayout) {
        return appBarLayout.c();
    }

    private int getDownNestedPreScrollRange() {
        int n2;
        if (this.c != -1) {
            return this.c;
        }
        int n3 = 0;
        for (int i2 = -1 + this.getChildCount(); i2 >= 0; --i2) {
            int n4;
            View view = this.getChildAt(i2);
            g g2 = (g)view.getLayoutParams();
            int n5 = view.getMeasuredHeight();
            int n6 = g2.a;
            if ((n6 & 5) == 5) {
                int n7 = n3 + (g2.topMargin + g2.bottomMargin);
                n4 = (n6 & 8) != 0 ? n7 + bo.p(view) : ((n6 & 2) != 0 ? n7 + (n5 - bo.p(view)) : n7 + n5);
            } else {
                if (n3 > 0) break;
                n4 = n3;
            }
            n3 = n4;
        }
        this.c = n2 = Math.max(0, n3 - this.getTopInset());
        return n2;
    }

    private int getDownNestedScrollRange() {
        int n2;
        int n3;
        block2 : {
            int n4;
            if (this.d != -1) {
                return this.d;
            }
            int n5 = this.getChildCount();
            int n6 = 0;
            for (int i2 = 0; i2 < n5; n6 += n4, ++i2) {
                View view = this.getChildAt(i2);
                g g2 = (g)view.getLayoutParams();
                n4 = view.getMeasuredHeight() + (g2.topMargin + g2.bottomMargin);
                int n7 = g2.a;
                if ((n7 & 1) == 0) break;
                if ((n7 & 2) == 0) continue;
                n2 = n6 - (bo.p(view) + this.getTopInset());
                break block2;
            }
            n2 = n6;
        }
        this.d = n3 = Math.max(0, n2);
        return n3;
    }

    private int getPendingAction() {
        return this.f;
    }

    private int getTopInset() {
        if (this.g == null) return 0;
        return this.g.b();
    }

    private int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    static /* synthetic */ List h(AppBarLayout appBarLayout) {
        return appBarLayout.h;
    }

    static /* synthetic */ int i(AppBarLayout appBarLayout) {
        return appBarLayout.getTopInset();
    }

    protected g a() {
        return new g(-1, -2);
    }

    public g a(AttributeSet attributeSet) {
        return new g(this.getContext(), attributeSet);
    }

    protected g a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new g((LinearLayout.LayoutParams)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new g(layoutParams);
        return new g((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public void a(boolean bl2, boolean bl3) {
        int n2 = bl2 ? 1 : 2;
        int n3 = bl3 ? 4 : 0;
        this.f = n3 | n2;
        this.requestLayout();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g;
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    protected /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return this.a();
    }

    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    public /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return this.a(attributeSet);
    }

    protected /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return this.a(layoutParams);
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int n2 = this.getTopInset();
        int n3 = bo.p((View)this);
        if (n3 != 0) {
            return n2 + n3 * 2;
        }
        int n4 = this.getChildCount();
        if (n4 < 1) return 0;
        return n2 + 2 * bo.p(this.getChildAt(n4 - 1));
    }

    public float getTargetElevation() {
        return this.e;
    }

    public final int getTotalScrollRange() {
        int n2;
        int n3;
        block2 : {
            int n4;
            if (this.b != -1) {
                return this.b;
            }
            int n5 = this.getChildCount();
            int n6 = 0;
            for (int i2 = 0; i2 < n5; n6 += n4 + g2.topMargin + g2.bottomMargin, ++i2) {
                View view = this.getChildAt(i2);
                g g2 = (g)view.getLayoutParams();
                n4 = view.getMeasuredHeight();
                int n7 = g2.a;
                if ((n7 & 1) == 0) break;
                if ((n7 & 2) == 0) continue;
                n2 = n6 - bo.p(view);
                break block2;
            }
            n2 = n6;
        }
        this.b = n3 = Math.max(0, n2 - this.getTopInset());
        return n3;
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        super.onLayout(bl2, n2, n3, n4, n5);
        this.b();
        this.a = false;
        int n6 = this.getChildCount();
        int n7 = 0;
        while (n7 < n6) {
            if (((g)this.getChildAt(n7).getLayoutParams()).b() != null) {
                this.a = true;
                return;
            }
            ++n7;
        }
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        this.b();
    }

    public void setExpanded(boolean bl2) {
        this.a(bl2, bo.A((View)this));
    }

    public void setOrientation(int n2) {
        if (n2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(n2);
    }

    public void setTargetElevation(float f2) {
        this.e = f2;
    }
}

