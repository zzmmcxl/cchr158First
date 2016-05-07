/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.b.h;
import android.support.v7.b.i;
import android.support.v7.view.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.support.v7.view.menu.c;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.l;
import android.support.v7.widget.m;
import android.support.v7.widget.n;
import android.support.v7.widget.o;
import android.support.v7.widget.p;
import android.support.v7.widget.r;
import android.support.v7.widget.s;
import android.support.v7.widget.w;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;

class k
extends d
implements android.support.v4.h.o {
    private n A;
    final s g;
    int h;
    private p i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private final SparseBooleanArray v = new SparseBooleanArray();
    private View w;
    private r x;
    private m y;
    private o z;

    public k(Context context) {
        super(context, i.abc_action_menu_layout, i.abc_action_menu_item_layout);
        this.g = new s(this, null);
    }

    static /* synthetic */ m a(k k2, m m2) {
        k2.y = m2;
        return m2;
    }

    static /* synthetic */ o a(k k2, o o2) {
        k2.z = o2;
        return o2;
    }

    static /* synthetic */ r a(k k2) {
        return k2.x;
    }

    static /* synthetic */ r a(k k2, r r2) {
        k2.x = r2;
        return r2;
    }

    private View a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup)this.f;
        if (viewGroup == null) {
            return null;
        }
        int n2 = viewGroup.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view = viewGroup.getChildAt(n3);
            if (view instanceof aa) {
                if (((aa)view).getItemData() == menuItem) return view;
            }
            ++n3;
        }
        return null;
    }

    static /* synthetic */ o b(k k2) {
        return k2.z;
    }

    static /* synthetic */ android.support.v7.view.menu.i c(k k2) {
        return k2.c;
    }

    static /* synthetic */ android.support.v7.view.menu.i d(k k2) {
        return k2.c;
    }

    static /* synthetic */ p e(k k2) {
        return k2.i;
    }

    static /* synthetic */ z f(k k2) {
        return k2.f;
    }

    static /* synthetic */ android.support.v7.view.menu.i g(k k2) {
        return k2.c;
    }

    static /* synthetic */ z h(k k2) {
        return k2.f;
    }

    static /* synthetic */ m i(k k2) {
        return k2.y;
    }

    @Override
    public z a(ViewGroup viewGroup) {
        z z2 = super.a(viewGroup);
        ((ActionMenuView)z2).setPresenter(this);
        return z2;
    }

    @Override
    public View a(android.support.v7.view.menu.m m2, View view, ViewGroup viewGroup) {
        View view2 = m2.getActionView();
        if (view2 == null || m2.n()) {
            view2 = super.a(m2, view, viewGroup);
        }
        int n2 = m2.isActionViewExpanded() ? 8 : 0;
        view2.setVisibility(n2);
        ActionMenuView actionMenuView = (ActionMenuView)viewGroup;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (actionMenuView.checkLayoutParams(layoutParams)) return view2;
        view2.setLayoutParams((ViewGroup.LayoutParams)actionMenuView.a(layoutParams));
        return view2;
    }

    @Override
    public void a(Context context, android.support.v7.view.menu.i i2) {
        super.a(context, i2);
        Resources resources = context.getResources();
        a a2 = a.a(context);
        if (!this.m) {
            this.l = a2.b();
        }
        if (!this.s) {
            this.n = a2.c();
        }
        if (!this.q) {
            this.p = a2.a();
        }
        int n2 = this.n;
        if (this.l) {
            if (this.i == null) {
                this.i = new p(this, this.a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.i.measure(n3, n3);
            }
            n2 -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.o = n2;
        this.u = (int)(56.0f * resources.getDisplayMetrics().density);
        this.w = null;
    }

    public void a(Configuration configuration) {
        if (!this.q) {
            this.p = this.b.getResources().getInteger(h.abc_max_action_buttons);
        }
        if (this.c == null) return;
        this.c.b(true);
    }

    public void a(Drawable drawable) {
        if (this.i != null) {
            this.i.setImageDrawable(drawable);
            return;
        }
        this.k = true;
        this.j = drawable;
    }

    @Override
    public void a(android.support.v7.view.menu.i i2, boolean bl2) {
        this.f();
        super.a(i2, bl2);
    }

    @Override
    public void a(android.support.v7.view.menu.m m2, aa aa2) {
        aa2.a(m2, 0);
        ActionMenuView actionMenuView = (ActionMenuView)this.f;
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView)aa2;
        actionMenuItemView.setItemInvoker(actionMenuView);
        if (this.A == null) {
            this.A = new n(this, null);
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    public void a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.a(this.c);
    }

    @Override
    public void a(boolean bl2) {
        if (bl2) {
            super.a((ad)null);
            return;
        }
        this.c.a(false);
    }

    @Override
    public boolean a(int n2, android.support.v7.view.menu.m m2) {
        return m2.j();
    }

    @Override
    public boolean a(ad ad2) {
        if (!ad2.hasVisibleItems()) {
            return false;
        }
        ad ad3 = ad2;
        while (ad3.s() != this.c) {
            ad3 = (ad)ad3.s();
        }
        Object object = this.a(ad3.getItem());
        if (object == null) {
            if (this.i == null) {
                return false;
            }
            object = this.i;
        }
        this.h = ad2.getItem().getItemId();
        this.y = new m(this, this.b, ad2);
        this.y.a((View)object);
        this.y.a();
        super.a(ad2);
        return true;
    }

    @Override
    public boolean a(ViewGroup viewGroup, int n2) {
        if (viewGroup.getChildAt(n2) != this.i) return super.a(viewGroup, n2);
        return false;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(boolean var1_1) {
        var2_2 = 1;
        var3_3 = (ViewGroup)((View)this.f).getParent();
        if (var3_3 != null) {
            android.support.v7.g.a.a(var3_3);
        }
        super.b(var1_1);
        ((View)this.f).requestLayout();
        if (this.c != null) {
            var11_4 = this.c.k();
            var12_5 = var11_4.size();
            for (var13_6 = 0; var13_6 < var12_5; ++var13_6) {
                var14_7 = ((android.support.v7.view.menu.m)var11_4.get(var13_6)).a();
                if (var14_7 == null) continue;
                var14_7.a(this);
            }
        }
        var4_8 = this.c != null ? this.c.l() : null;
        var5_9 = this.l;
        var6_10 = 0;
        if (!var5_9) ** GOTO lbl-1000
        var6_10 = 0;
        if (var4_8 == null) ** GOTO lbl-1000
        var9_11 = var4_8.size();
        if (var9_11 == var2_2) {
            var10_12 = ((android.support.v7.view.menu.m)var4_8.get(0)).isActionViewExpanded() == false ? var2_2 : 0;
            var6_10 = var10_12;
        } else {
            if (var9_11 <= 0) {
                var2_2 = 0;
            }
            var6_10 = var2_2;
        }
        if (var6_10 != 0) {
            if (this.i == null) {
                this.i = new p(this, this.a);
            }
            if ((var7_13 = (ViewGroup)this.i.getParent()) != this.f) {
                if (var7_13 != null) {
                    var7_13.removeView((View)this.i);
                }
                var8_14 = (ActionMenuView)this.f;
                var8_14.addView((View)this.i, (ViewGroup.LayoutParams)var8_14.c());
            }
        } else if (this.i != null && this.i.getParent() == this.f) {
            ((ViewGroup)this.f).removeView((View)this.i);
        }
        ((ActionMenuView)this.f).setOverflowReserved(this.l);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean b() {
        var1_1 = this.c.i();
        var2_2 = var1_1.size();
        var3_3 = this.p;
        var4_4 = this.o;
        var5_5 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        var6_6 = (ViewGroup)this.f;
        var7_7 = 0;
        var8_8 = 0;
        var9_9 = false;
        for (var10_10 = 0; var10_10 < var2_2; ++var10_10) {
            var46_11 = (android.support.v7.view.menu.m)var1_1.get(var10_10);
            if (var46_11.l()) {
                ++var7_7;
            } else if (var46_11.k()) {
                ++var8_8;
            } else {
                var9_9 = true;
            }
            var47_12 = this.t != false && var46_11.isActionViewExpanded() != false ? 0 : var3_3;
            var3_3 = var47_12;
        }
        if (this.l && (var9_9 || var7_7 + var8_8 > var3_3)) {
            --var3_3;
        }
        var11_13 = var3_3 - var7_7;
        var12_14 = this.v;
        var12_14.clear();
        if (this.r) {
            var13_15 = var4_4 / this.u;
            var45_16 = var4_4 % this.u;
            var14_17 = this.u + var45_16 / var13_15;
        } else {
            var13_15 = 0;
            var14_17 = 0;
        }
        var15_18 = 0;
        var16_19 = 0;
        var17_20 = var13_15;
        while (var15_18 < var2_2) {
            var18_21 = (android.support.v7.view.menu.m)var1_1.get(var15_18);
            if (!var18_21.l()) ** GOTO lbl51
            var42_45 = this.a(var18_21, this.w, var6_6);
            if (this.w == null) {
                this.w = var42_45;
            }
            if (this.r) {
                var17_20 -= ActionMenuView.a(var42_45, var14_17, var17_20, var5_5, 0);
            } else {
                var42_45.measure(var5_5, var5_5);
            }
            var19_22 = var42_45.getMeasuredWidth();
            var43_46 = var4_4 - var19_22;
            if (var16_19 != 0) ** GOTO lbl118
            ** GOTO lbl119
lbl51: // 1 sources:
            if (!var18_21.k()) ** GOTO lbl84
            var22_25 = var18_21.getGroupId();
            var23_26 = var12_14.get(var22_25);
            var24_27 = !(var11_13 <= 0 && var23_26 == false || var4_4 <= 0 || this.r != false && var17_20 <= 0);
            if (!var24_27) ** GOTO lbl89
            var33_36 = this.a(var18_21, this.w, var6_6);
            if (this.w == null) {
                this.w = var33_36;
            }
            if (this.r) {
                var40_43 = ActionMenuView.a(var33_36, var14_17, var17_20, var5_5, 0);
                var41_44 = var17_20 - var40_43;
                var36_39 = var40_43 == 0 ? false : var24_27;
                var35_38 = var41_44;
            } else {
                var33_36.measure(var5_5, var5_5);
                var34_37 = var24_27;
                var35_38 = var17_20;
                var36_39 = var34_37;
            }
            var37_40 = var33_36.getMeasuredWidth();
            var4_4 -= var37_40;
            if (var16_19 == 0) {
                var16_19 = var37_40;
            }
            if (this.r) {
                var39_42 = var4_4 >= 0;
                var25_28 = var36_39 & var39_42;
                var26_29 = var16_19;
                var27_30 = var35_38;
            } else {
                var38_41 = var4_4 + var16_19 > 0;
                var25_28 = var36_39 & var38_41;
                var26_29 = var16_19;
                var27_30 = var35_38;
            }
            ** GOTO lbl92
lbl84: // 1 sources:
            var18_21.d(false);
            var19_22 = var16_19;
            var20_23 = var4_4;
            var21_24 = var11_13;
            ** GOTO lbl124
lbl89: // 1 sources:
            var25_28 = var24_27;
            var26_29 = var16_19;
            var27_30 = var17_20;
lbl92: // 3 sources:
            if (var25_28 && var22_25 != 0) {
                var12_14.put(var22_25, true);
                var28_31 = var11_13;
            } else if (var23_26) {
                var12_14.put(var22_25, false);
                var30_33 = var11_13;
                for (var31_34 = 0; var31_34 < var15_18; ++var31_34) {
                    var32_35 = (android.support.v7.view.menu.m)var1_1.get(var31_34);
                    if (var32_35.getGroupId() != var22_25) continue;
                    if (var32_35.j()) {
                        ++var30_33;
                    }
                    var32_35.d(false);
                }
                var28_31 = var30_33;
            } else {
                var28_31 = var11_13;
            }
            if (var25_28) {
                --var28_31;
            }
            var18_21.d(var25_28);
            var19_22 = var26_29;
            var20_23 = var4_4;
            var29_32 = var27_30;
            var21_24 = var28_31;
            var17_20 = var29_32;
            ** GOTO lbl124
lbl118: // 1 sources:
            var19_22 = var16_19;
lbl119: // 2 sources:
            if ((var44_47 = var18_21.getGroupId()) != 0) {
                var12_14.put(var44_47, true);
            }
            var18_21.d(true);
            var20_23 = var43_46;
            var21_24 = var11_13;
lbl124: // 3 sources:
            ++var15_18;
            var4_4 = var20_23;
            var11_13 = var21_24;
            var16_19 = var19_22;
        }
        return true;
    }

    public Drawable c() {
        if (this.i != null) {
            return this.i.getDrawable();
        }
        if (!this.k) return null;
        return this.j;
    }

    public void c(boolean bl2) {
        this.l = bl2;
        this.m = true;
    }

    public void d(boolean bl2) {
        this.t = bl2;
    }

    public boolean d() {
        if (!this.l) return false;
        if (this.h()) return false;
        if (this.c == null) return false;
        if (this.f == null) return false;
        if (this.z != null) return false;
        if (this.c.l().isEmpty()) return false;
        this.z = new o(this, new r(this, this.b, this.c, (View)this.i, true));
        ((View)this.f).post((Runnable)this.z);
        super.a((ad)null);
        return true;
    }

    public boolean e() {
        if (this.z != null && this.f != null) {
            ((View)this.f).removeCallbacks((Runnable)this.z);
            this.z = null;
            return true;
        }
        r r2 = this.x;
        if (r2 == null) return false;
        r2.e();
        return true;
    }

    public boolean f() {
        return this.e() | this.g();
    }

    public boolean g() {
        if (this.y == null) return false;
        this.y.e();
        return true;
    }

    public boolean h() {
        if (this.x == null) return false;
        if (!this.x.f()) return false;
        return true;
    }

    public boolean i() {
        if (this.z != null) return true;
        if (!this.h()) return false;
        return true;
    }
}

