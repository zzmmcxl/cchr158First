/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.h.a.a;
import android.support.v4.h.a.aj;
import android.support.v4.h.a.g;
import android.support.v4.h.a.r;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.StaggeredGridLayoutManager$SavedState;
import android.support.v7.widget.cy;
import android.support.v7.widget.dw;
import android.support.v7.widget.ep;
import android.support.v7.widget.eq;
import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.support.v7.widget.fc;
import android.support.v7.widget.fm;
import android.support.v7.widget.fx;
import android.support.v7.widget.fy;
import android.support.v7.widget.fz;
import android.support.v7.widget.gc;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
extends ep {
    private final Runnable A;
    dw a;
    dw b;
    boolean c;
    int d;
    int e;
    StaggeredGridLayoutManager$LazySpanLookup f;
    private int g;
    private gc[] h;
    private int i;
    private int j;
    private cy k;
    private boolean l;
    private BitSet m;
    private int n;
    private boolean o;
    private boolean t;
    private StaggeredGridLayoutManager$SavedState u;
    private int v;
    private final Rect w;
    private final fy x;
    private boolean y;
    private boolean z;

    public StaggeredGridLayoutManager(int n2, int n3) {
        boolean bl2 = true;
        this.g = -1;
        this.l = false;
        this.c = false;
        this.d = -1;
        this.e = Integer.MIN_VALUE;
        this.f = new StaggeredGridLayoutManager$LazySpanLookup();
        this.n = 2;
        this.w = new Rect();
        this.x = new fy(this, null);
        this.y = false;
        this.z = bl2;
        this.A = new fx(this);
        this.i = n3;
        this.a(n2);
        if (this.n == 0) {
            bl2 = false;
        }
        this.c(bl2);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int n2, int n3) {
        boolean bl2 = true;
        this.g = -1;
        this.l = false;
        this.c = false;
        this.d = -1;
        this.e = Integer.MIN_VALUE;
        this.f = new StaggeredGridLayoutManager$LazySpanLookup();
        this.n = 2;
        this.w = new Rect();
        this.x = new fy(this, null);
        this.y = false;
        this.z = bl2;
        this.A = new fx(this);
        eq eq2 = StaggeredGridLayoutManager.a(context, attributeSet, n2, n3);
        this.b(eq2.a);
        this.a(eq2.b);
        this.a(eq2.c);
        if (this.n == 0) {
            bl2 = false;
        }
        this.c(bl2);
    }

    private boolean H() {
        int n2;
        int n3;
        if (this.s() == 0) return false;
        if (this.n == 0) return false;
        if (!this.n()) {
            return false;
        }
        if (this.c) {
            int n4 = this.L();
            int n5 = this.M();
            n3 = n4;
            n2 = n5;
        } else {
            int n6 = this.M();
            int n7 = this.L();
            n3 = n6;
            n2 = n7;
        }
        if (n3 == 0 && this.f() != null) {
            this.f.a();
            this.F();
            this.m();
            return true;
        }
        if (!this.y) {
            return false;
        }
        int n8 = this.c ? -1 : 1;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.f.a(n3, n2 + 1, n8, true);
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem == null) {
            this.y = false;
            this.f.a(n2 + 1);
            return false;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = this.f.a(n3, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a, n8 * -1, true);
        if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 == null) {
            this.f.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a);
        } else {
            this.f.a(1 + staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.a);
        }
        this.F();
        this.m();
        return true;
    }

    private void I() {
        if (this.a != null) return;
        this.a = dw.a(this, this.i);
        this.b = dw.a(this, 1 - this.i);
        this.k = new cy();
    }

    private void J() {
        int n2 = 1;
        if (this.i == n2 || !this.h()) {
            this.c = this.l;
            return;
        }
        if (this.l) {
            n2 = 0;
        }
        this.c = n2;
    }

    private void K() {
        if (this.b.h() == 1073741824) {
            return;
        }
        float f2 = 0.0f;
        int n2 = this.s();
        for (int i2 = 0; i2 < n2; ++i2) {
            float f3;
            View view = this.h(i2);
            float f4 = this.b.c(view);
            if (f4 < f2) {
                f3 = f2;
            } else {
                float f5 = ((fz)view.getLayoutParams()).a() ? 1.0f * f4 / (float)this.g : f4;
                f3 = Math.max(f2, f5);
            }
            f2 = f3;
        }
        int n3 = this.j;
        int n4 = Math.round(f2 * (float)this.g);
        if (this.b.h() == Integer.MIN_VALUE) {
            n4 = Math.min(n4, this.b.f());
        }
        this.e(n4);
        if (this.j == n3) return;
        int n5 = 0;
        while (n5 < n2) {
            View view = this.h(n5);
            fz fz2 = (fz)view.getLayoutParams();
            if (!fz2.f) {
                if (this.h() && this.i == 1) {
                    view.offsetLeftAndRight((- -1 + this.g - fz2.e.d) * this.j - n3 * (- -1 + this.g - fz2.e.d));
                } else {
                    int n6 = fz2.e.d * this.j;
                    int n7 = n3 * fz2.e.d;
                    if (this.i == 1) {
                        view.offsetLeftAndRight(n6 - n7);
                    } else {
                        view.offsetTopAndBottom(n6 - n7);
                    }
                }
            }
            ++n5;
        }
    }

    private int L() {
        int n2 = this.s();
        if (n2 != 0) return this.d(this.h(n2 - 1));
        return 0;
    }

    private int M() {
        if (this.s() != 0) return this.d(this.h(0));
        return 0;
    }

    private int a(ew ew2, cy cy2, fc fc2) {
        int n2;
        block27 : {
            this.m.set(0, this.g, true);
            int n3 = this.k.i ? (cy2.e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE) : (cy2.e == 1 ? cy2.g + cy2.b : cy2.f - cy2.b);
            this.e(cy2.e, n3);
            int n4 = this.c ? this.a.d() : this.a.c();
            boolean bl2 = false;
            while (cy2.a(fc2)) {
                if (this.k.i || !this.m.isEmpty()) {
                    int n5;
                    int n6;
                    int n7;
                    int n8;
                    gc gc2;
                    View view = cy2.a(ew2);
                    fz fz2 = (fz)view.getLayoutParams();
                    int n9 = fz2.e();
                    int n10 = this.f.c(n9);
                    boolean bl3 = n10 == -1;
                    if (bl3) {
                        gc gc3 = fz2.f ? this.h[0] : this.a(cy2);
                        this.f.a(n9, gc3);
                        gc2 = gc3;
                    } else {
                        gc2 = this.h[n10];
                    }
                    fz2.e = gc2;
                    if (cy2.e == 1) {
                        this.b(view);
                    } else {
                        this.b(view, 0);
                    }
                    this.a(view, fz2, false);
                    if (cy2.e == 1) {
                        int n11 = fz2.f ? this.q(n4) : gc2.b(n4);
                        n8 = n11 + this.a.c(view);
                        if (bl3 && fz2.f) {
                            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.m(n11);
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.b = -1;
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a = n9;
                            this.f.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                            n6 = n11;
                        } else {
                            n6 = n11;
                        }
                    } else {
                        int n12 = fz2.f ? this.p(n4) : gc2.a(n4);
                        n6 = n12 - this.a.c(view);
                        if (bl3 && fz2.f) {
                            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.n(n12);
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.b = 1;
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.a = n9;
                            this.f.a(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                        }
                        n8 = n12;
                    }
                    if (fz2.f && cy2.d == -1) {
                        if (bl3) {
                            this.y = true;
                        } else {
                            boolean bl4 = cy2.e == 1 ? !this.k() : !this.l();
                            if (bl4) {
                                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = this.f.f(n9);
                                if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem != null) {
                                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.d = true;
                                }
                                this.y = true;
                            }
                        }
                    }
                    this.a(view, fz2, cy2);
                    if (this.h() && this.i == 1) {
                        int n13 = fz2.f ? this.b.d() : this.b.d() - (-1 + this.g - gc2.d) * this.j;
                        n7 = n13 - this.b.c(view);
                        n5 = n13;
                    } else {
                        int n14 = fz2.f ? this.b.c() : gc2.d * this.j + this.b.c();
                        n5 = n14 + this.b.c(view);
                        n7 = n14;
                    }
                    if (this.i == 1) {
                        this.b(view, n7, n6, n5, n8);
                    } else {
                        this.b(view, n6, n7, n8, n5);
                    }
                    if (fz2.f) {
                        this.e(this.k.e, n3);
                    } else {
                        int n15 = this.k.e;
                        this.a(gc2, n15, n3);
                    }
                    this.a(ew2, this.k);
                    if (this.k.h && view.isFocusable()) {
                        if (fz2.f) {
                            this.m.clear();
                        } else {
                            this.m.set(gc2.d, false);
                        }
                    }
                    bl2 = true;
                    continue;
                }
                if (bl2) break block27;
            }
            this.a(ew2, this.k);
        }
        if (this.k.e == -1) {
            int n16 = this.p(this.a.c());
            n2 = this.a.c() - n16;
        } else {
            n2 = this.q(this.a.d()) - this.a.d();
        }
        if (n2 <= 0) return 0;
        return Math.min(cy2.b, n2);
    }

    private int a(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.I();
        dw dw2 = this.a;
        boolean bl2 = !this.z;
        View view = this.a(bl2, true);
        boolean bl3 = this.z;
        boolean bl4 = false;
        if (bl3) return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.z, this.c);
        bl4 = true;
        return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.z, this.c);
    }

    private gc a(cy cy2) {
        int n2;
        int n3;
        gc gc2 = null;
        int n4 = -1;
        if (this.s(cy2.e)) {
            n2 = -1 + this.g;
            n3 = n4;
        } else {
            n3 = this.g;
            n4 = 1;
            n2 = 0;
        }
        if (cy2.e == 1) {
            int n5 = this.a.c();
            int n6 = n2;
            int n7 = Integer.MAX_VALUE;
            while (n6 != n3) {
                gc gc3;
                gc gc4 = this.h[n6];
                int n8 = gc4.b(n5);
                if (n8 < n7) {
                    gc3 = gc4;
                } else {
                    n8 = n7;
                    gc3 = gc2;
                }
                n6 += n4;
                gc2 = gc3;
                n7 = n8;
            }
            return gc2;
        }
        int n9 = this.a.d();
        int n10 = n2;
        int n11 = Integer.MIN_VALUE;
        while (n10 != n3) {
            gc gc5;
            gc gc6 = this.h[n10];
            int n12 = gc6.a(n9);
            if (n12 > n11) {
                gc5 = gc6;
            } else {
                n12 = n11;
                gc5 = gc2;
            }
            n10 += n4;
            gc2 = gc5;
            n11 = n12;
        }
        return gc2;
    }

    private void a(int n2, fc fc2) {
        int n3;
        int n4;
        int n5;
        this.k.b = 0;
        this.k.c = n2;
        if (this.p() && (n4 = fc2.c()) != -1) {
            boolean bl2 = this.c;
            boolean bl3 = n4 < n2;
            if (bl2 == bl3) {
                n3 = this.a.f();
                n5 = 0;
            } else {
                n5 = this.a.f();
                n3 = 0;
            }
        } else {
            n3 = 0;
            n5 = 0;
        }
        if (this.o()) {
            this.k.f = this.a.c() - n5;
            this.k.g = n3 + this.a.d();
        } else {
            this.k.g = n3 + this.a.e();
            this.k.f = - n5;
        }
        this.k.h = false;
        this.k.a = true;
        cy cy2 = this.k;
        int n6 = this.a.h();
        boolean bl4 = false;
        if (n6 == 0) {
            bl4 = true;
        }
        cy2.i = bl4;
    }

    private void a(ew ew2, int n2) {
        while (this.s() > 0) {
            View view = this.h(0);
            if (this.a.b(view) > n2) return;
            fz fz2 = (fz)view.getLayoutParams();
            if (!fz2.f) {
                if (gc.a(fz2.e).size() == 1) return;
                fz2.e.h();
            } else {
                for (int i2 = 0; i2 < this.g; ++i2) {
                    if (gc.a(this.h[i2]).size() != 1) continue;
                    return;
                }
                for (int i3 = 0; i3 < this.g; ++i3) {
                    this.h[i3].h();
                }
            }
            this.a(view, ew2);
        }
    }

    private void a(ew ew2, cy cy2) {
        if (!cy2.a) return;
        if (cy2.i) {
            return;
        }
        if (cy2.b == 0) {
            if (cy2.e == -1) {
                this.b(ew2, cy2.g);
                return;
            }
            this.a(ew2, cy2.f);
            return;
        }
        if (cy2.e == -1) {
            int n2 = cy2.f - this.o(cy2.f);
            int n3 = n2 < 0 ? cy2.g : cy2.g - Math.min(n2, cy2.b);
            this.b(ew2, n3);
            return;
        }
        int n4 = this.r(cy2.g) - cy2.g;
        int n5 = n4 < 0 ? cy2.f : cy2.f + Math.min(n4, cy2.b);
        this.a(ew2, n5);
    }

    /*
     * Unable to fully structure code
     */
    private void a(ew var1_1, fc var2_2, boolean var3_3) {
        this.I();
        var4_4 = this.x;
        var4_4.a();
        if ((this.u != null || this.d != -1) && var2_2.e() == 0) {
            this.c(var1_1);
            return;
        }
        if (this.u != null) {
            this.a(var4_4);
        } else {
            this.J();
            var4_4.c = this.c;
        }
        this.a(var2_2, var4_4);
        if (this.u == null && (var4_4.c != this.o || this.h() != this.t)) {
            this.f.a();
            var4_4.d = true;
        }
        if (this.s() > 0 && (this.u == null || this.u.c < 1)) {
            if (var4_4.d) {
                for (var13_5 = 0; var13_5 < this.g; ++var13_5) {
                    this.h[var13_5].e();
                    if (var4_4.b == Integer.MIN_VALUE) continue;
                    this.h[var13_5].c(var4_4.b);
                }
            } else {
                for (var12_6 = 0; var12_6 < this.g; ++var12_6) {
                    this.h[var12_6].a(this.c, var4_4.b);
                }
            }
        }
        this.a(var1_1);
        this.k.a = false;
        this.y = false;
        this.e(this.b.f());
        this.a(var4_4.a, var2_2);
        if (var4_4.c) {
            this.l(-1);
            this.a(var1_1, this.k, var2_2);
            this.l(1);
            this.k.c = var4_4.a + this.k.d;
            this.a(var1_1, this.k, var2_2);
        } else {
            this.l(1);
            this.a(var1_1, this.k, var2_2);
            this.l(-1);
            this.k.c = var4_4.a + this.k.d;
            this.a(var1_1, this.k, var2_2);
        }
        this.K();
        if (this.s() > 0) {
            if (this.c) {
                this.b(var1_1, var2_2, true);
                this.c(var1_1, var2_2, false);
            } else {
                this.c(var1_1, var2_2, true);
                this.b(var1_1, var2_2, false);
            }
        }
        if (!var3_3 || var2_2.a()) ** GOTO lbl63
        var8_7 = this.n != 0 && this.s() > 0 && (this.y != false || this.f() != null);
        if (!var8_7) ** GOTO lbl-1000
        this.a(this.A);
        if (this.H()) {
            var7_8 = true;
        } else lbl-1000: // 2 sources:
        {
            var7_8 = false;
        }
        this.d = -1;
        this.e = Integer.MIN_VALUE;
        ** GOTO lbl64
lbl63: // 1 sources:
        var7_8 = false;
lbl64: // 2 sources:
        this.o = var4_4.c;
        this.t = this.h();
        this.u = null;
        if (var7_8 == false) return;
        this.a(var1_1, var2_2, false);
    }

    private void a(fy fy2) {
        if (this.u.c > 0) {
            if (this.u.c != this.g) {
                this.u.a();
                this.u.a = this.u.b;
            } else {
                for (int i2 = 0; i2 < this.g; ++i2) {
                    this.h[i2].e();
                    int n2 = this.u.d[i2];
                    if (n2 != Integer.MIN_VALUE) {
                        n2 = this.u.i ? (n2 += this.a.d()) : (n2 += this.a.c());
                    }
                    this.h[i2].c(n2);
                }
            }
        }
        this.t = this.u.j;
        this.a(this.u.h);
        this.J();
        if (this.u.a != -1) {
            this.d = this.u.a;
            fy2.c = this.u.i;
        } else {
            fy2.c = this.c;
        }
        if (this.u.e <= 1) return;
        this.f.a = this.u.f;
        this.f.b = this.u.g;
    }

    private void a(gc gc2, int n2, int n3) {
        int n4 = gc2.i();
        if (n2 == -1) {
            if (n4 + gc2.b() > n3) return;
            this.m.set(gc2.d, false);
            return;
        }
        if (gc2.d() - n4 < n3) return;
        this.m.set(gc2.d, false);
    }

    private void a(View view, int n2, int n3, boolean bl2) {
        this.a(view, this.w);
        fz fz2 = (fz)view.getLayoutParams();
        int n4 = this.b(n2, fz2.leftMargin + this.w.left, fz2.rightMargin + this.w.right);
        int n5 = this.b(n3, fz2.topMargin + this.w.top, fz2.bottomMargin + this.w.bottom);
        boolean bl3 = bl2 ? this.a(view, n4, n5, fz2) : this.b(view, n4, n5, fz2);
        if (!bl3) return;
        view.measure(n4, n5);
    }

    private void a(View view, fz fz2, cy cy2) {
        if (cy2.e == 1) {
            if (fz2.f) {
                this.p(view);
                return;
            }
            fz2.e.b(view);
            return;
        }
        if (fz2.f) {
            this.q(view);
            return;
        }
        fz2.e.a(view);
    }

    private void a(View view, fz fz2, boolean bl2) {
        if (fz2.f) {
            if (this.i == 1) {
                this.a(view, this.v, StaggeredGridLayoutManager.a(this.w(), this.u(), 0, fz2.height, true), bl2);
                return;
            }
            this.a(view, StaggeredGridLayoutManager.a(this.v(), this.t(), 0, fz2.width, true), this.v, bl2);
            return;
        }
        if (this.i == 1) {
            this.a(view, StaggeredGridLayoutManager.a(this.j, this.t(), 0, fz2.width, false), StaggeredGridLayoutManager.a(this.w(), this.u(), 0, fz2.height, true), bl2);
            return;
        }
        this.a(view, StaggeredGridLayoutManager.a(this.v(), this.t(), 0, fz2.width, true), StaggeredGridLayoutManager.a(this.j, this.u(), 0, fz2.height, false), bl2);
    }

    static /* synthetic */ boolean a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        return staggeredGridLayoutManager.H();
    }

    private boolean a(gc gc2) {
        boolean bl2 = true;
        if (this.c) {
            if (gc2.d() >= this.a.d()) return false;
            if (gc2.c((View)((View)gc.a((gc)gc2).get((int)(-1 + gc.a((gc)gc2).size())))).f) return false;
            return bl2;
        }
        if (gc2.b() <= this.a.c()) return false;
        if (gc2.c((View)((View)gc.a((gc)gc2).get((int)0))).f) return false;
        return bl2;
    }

    private int b(int n2, int n3, int n4) {
        if (n3 == 0 && n4 == 0) {
            return n2;
        }
        int n5 = View.MeasureSpec.getMode((int)n2);
        if (n5 == Integer.MIN_VALUE) return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, View.MeasureSpec.getSize((int)n2) - n3 - n4), (int)n5);
        if (n5 != 1073741824) return n2;
        return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, View.MeasureSpec.getSize((int)n2) - n3 - n4), (int)n5);
    }

    private void b(ew ew2, int n2) {
        int n3 = -1 + this.s();
        while (n3 >= 0) {
            View view = this.h(n3);
            if (this.a.a(view) < n2) return;
            fz fz2 = (fz)view.getLayoutParams();
            if (!fz2.f) {
                if (gc.a(fz2.e).size() == 1) return;
                fz2.e.g();
            } else {
                for (int i2 = 0; i2 < this.g; ++i2) {
                    if (gc.a(this.h[i2]).size() != 1) continue;
                    return;
                }
                for (int i3 = 0; i3 < this.g; ++i3) {
                    this.h[i3].g();
                }
            }
            this.a(view, ew2);
            --n3;
        }
    }

    private void b(ew ew2, fc fc2, boolean bl2) {
        int n2 = this.q(Integer.MIN_VALUE);
        if (n2 == Integer.MIN_VALUE) {
            return;
        }
        int n3 = this.a.d() - n2;
        if (n3 <= 0) return;
        int n4 = n3 - (- this.c(- n3, ew2, fc2));
        if (!bl2) return;
        if (n4 <= 0) return;
        this.a.a(n4);
    }

    private void b(View view, int n2, int n3, int n4, int n5) {
        fz fz2 = (fz)view.getLayoutParams();
        this.a(view, n2 + fz2.leftMargin, n3 + fz2.topMargin, n4 - fz2.rightMargin, n5 - fz2.bottomMargin);
    }

    static /* synthetic */ boolean b(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        return staggeredGridLayoutManager.l;
    }

    private void c(int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7 = this.c ? this.L() : this.M();
        if (n4 == 8) {
            if (n2 < n3) {
                n6 = n3 + 1;
                n5 = n2;
            } else {
                n6 = n2 + 1;
                n5 = n3;
            }
        } else {
            n6 = n2 + n3;
            n5 = n2;
        }
        this.f.b(n5);
        switch (n4) {
            case 1: {
                this.f.b(n2, n3);
                break;
            }
            case 2: {
                this.f.a(n2, n3);
                break;
            }
            case 8: {
                this.f.a(n2, 1);
                this.f.b(n3, 1);
            }
        }
        if (n6 <= n7) {
            return;
        }
        int n8 = this.c ? this.M() : this.L();
        if (n5 > n8) return;
        this.m();
    }

    private void c(ew ew2, fc fc2, boolean bl2) {
        int n2 = this.p(Integer.MAX_VALUE);
        if (n2 == Integer.MAX_VALUE) {
            return;
        }
        int n3 = n2 - this.a.c();
        if (n3 <= 0) return;
        int n4 = n3 - this.c(n3, ew2, fc2);
        if (!bl2) return;
        if (n4 <= 0) return;
        this.a.a(- n4);
    }

    private boolean c(fc fc2, fy fy2) {
        int n2 = this.o ? this.v(fc2.e()) : this.u(fc2.e());
        fy2.a = n2;
        fy2.b = Integer.MIN_VALUE;
        return true;
    }

    private void e(int n2, int n3) {
        int n4 = 0;
        while (n4 < this.g) {
            if (!gc.a(this.h[n4]).isEmpty()) {
                this.a(this.h[n4], n2, n3);
            }
            ++n4;
        }
    }

    private int h(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.I();
        dw dw2 = this.a;
        boolean bl2 = !this.z;
        View view = this.a(bl2, true);
        boolean bl3 = this.z;
        boolean bl4 = false;
        if (bl3) return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.z);
        bl4 = true;
        return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.z);
    }

    private int i(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.I();
        dw dw2 = this.a;
        boolean bl2 = !this.z;
        View view = this.a(bl2, true);
        boolean bl3 = this.z;
        boolean bl4 = false;
        if (bl3) return fm.b(fc2, dw2, view, this.b(bl4, true), this, this.z);
        bl4 = true;
        return fm.b(fc2, dw2, view, this.b(bl4, true), this, this.z);
    }

    private void l(int n2) {
        int n3 = 1;
        this.k.e = n2;
        cy cy2 = this.k;
        int n4 = this.c;
        int n5 = n2 == -1 ? n3 : 0;
        if (n4 != n5) {
            n3 = -1;
        }
        cy2.d = n3;
    }

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem m(int n2) {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.c = new int[this.g];
        int n3 = 0;
        while (n3 < this.g) {
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.c[n3] = n2 - this.h[n3].b(n2);
            ++n3;
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem n(int n2) {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.c = new int[this.g];
        int n3 = 0;
        while (n3 < this.g) {
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.c[n3] = this.h[n3].a(n2) - n2;
            ++n3;
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private int o(int n2) {
        int n3 = this.h[0].a(n2);
        int n4 = 1;
        while (n4 < this.g) {
            int n5 = this.h[n4].a(n2);
            if (n5 > n3) {
                n3 = n5;
            }
            ++n4;
        }
        return n3;
    }

    private int p(int n2) {
        int n3 = this.h[0].a(n2);
        int n4 = 1;
        while (n4 < this.g) {
            int n5 = this.h[n4].a(n2);
            if (n5 < n3) {
                n3 = n5;
            }
            ++n4;
        }
        return n3;
    }

    private void p(View view) {
        int n2 = -1 + this.g;
        while (n2 >= 0) {
            this.h[n2].b(view);
            --n2;
        }
    }

    private int q(int n2) {
        int n3 = this.h[0].b(n2);
        int n4 = 1;
        while (n4 < this.g) {
            int n5 = this.h[n4].b(n2);
            if (n5 > n3) {
                n3 = n5;
            }
            ++n4;
        }
        return n3;
    }

    private void q(View view) {
        int n2 = -1 + this.g;
        while (n2 >= 0) {
            this.h[n2].a(view);
            --n2;
        }
    }

    private int r(int n2) {
        int n3 = this.h[0].b(n2);
        int n4 = 1;
        while (n4 < this.g) {
            int n5 = this.h[n4].b(n2);
            if (n5 < n3) {
                n3 = n5;
            }
            ++n4;
        }
        return n3;
    }

    private boolean s(int n2) {
        if (this.i == 0) {
            boolean bl2 = n2 == -1;
            if (bl2 == this.c) return false;
            return true;
        }
        boolean bl3 = n2 == -1;
        boolean bl4 = bl3 == this.c;
        if (bl4 == this.h()) return true;
        return false;
    }

    private int t(int n2) {
        int n3 = -1;
        if (this.s() == 0) {
            if (!this.c) return n3;
            return 1;
        }
        boolean bl2 = n2 < this.M();
        if (bl2 == this.c) return 1;
        return n3;
    }

    private int u(int n2) {
        int n3 = this.s();
        int n4 = 0;
        while (n4 < n3) {
            int n5 = this.d(this.h(n4));
            if (n5 >= 0 && n5 < n2) {
                return n5;
            }
            ++n4;
        }
        return 0;
    }

    private int v(int n2) {
        int n3 = -1 + this.s();
        while (n3 >= 0) {
            int n4 = this.d(this.h(n3));
            if (n4 >= 0 && n4 < n2) {
                return n4;
            }
            --n3;
        }
        return 0;
    }

    private int w(int n2) {
        int n3 = -1;
        int n4 = 1;
        int n5 = Integer.MIN_VALUE;
        switch (n2) {
            default: {
                n3 = n5;
            }
            case 1: {
                return n3;
            }
            case 2: {
                return n4;
            }
            case 33: {
                if (this.i == n4) return n3;
                return n5;
            }
            case 130: {
                if (this.i != n4) return n5;
                return n4;
            }
            case 17: {
                if (this.i == 0) return n3;
                return n5;
            }
            case 66: 
        }
        if (this.i != 0) return n5;
        return n4;
    }

    @Override
    public int a(int n2, ew ew2, fc fc2) {
        return this.c(n2, ew2, fc2);
    }

    @Override
    public int a(ew ew2, fc fc2) {
        if (this.i != 0) return super.a(ew2, fc2);
        return this.g;
    }

    @Override
    public er a() {
        if (this.i != 0) return new fz(-1, -2);
        return new fz(-2, -1);
    }

    @Override
    public er a(Context context, AttributeSet attributeSet) {
        return new fz(context, attributeSet);
    }

    @Override
    public er a(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new fz(layoutParams);
        return new fz((ViewGroup.MarginLayoutParams)layoutParams);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public View a(View var1_1, int var2_2, ew var3_3, fc var4_4) {
        if (this.s() == 0) {
            return null;
        }
        if (this.e(var1_1) == null) {
            return null;
        }
        this.I();
        this.J();
        var5_5 = this.w(var2_2);
        if (var5_5 == Integer.MIN_VALUE) {
            return null;
        }
        var6_6 = (fz)var1_1.getLayoutParams();
        var7_7 = var6_6.f;
        var8_8 = var6_6.e;
        var9_9 = var5_5 == 1 ? this.L() : this.M();
        this.a(var9_9, var4_4);
        this.l(var5_5);
        this.k.c = var9_9 + this.k.d;
        this.k.b = (int)(0.33333334f * (float)this.a.f());
        this.k.h = true;
        this.k.a = false;
        this.a(var3_3, this.k, var4_4);
        this.o = this.c;
        if (!var7_7 && (var16_10 = var8_8.a(var9_9, var5_5)) != null && var16_10 != var1_1) {
            return var16_10;
        }
        var11_11 = this.s(var5_5);
        var12_12 = 0;
        if (!var11_11) ** GOTO lbl36
        var14_13 = -1 + this.g;
        while (var14_13 >= 0) {
            var15_14 = this.h[var14_13].a(var9_9, var5_5);
            if (var15_14 != null && var15_14 != var1_1) {
                return var15_14;
            }
            --var14_13;
        }
        return null;
lbl-1000: // 1 sources:
        {
            ++var12_12;
lbl36: // 2 sources:
            if (var12_12 >= this.g) return null;
            ** while ((var13_15 = this.h[var12_12].a((int)var9_9, (int)var5_5)) == null || var13_15 == var1_1)
        }
lbl38: // 1 sources:
        return var13_15;
    }

    View a(boolean bl2, boolean bl3) {
        this.I();
        int n2 = this.a.c();
        int n3 = this.a.d();
        int n4 = this.s();
        int n5 = 0;
        View view = null;
        while (n5 < n4) {
            View view2 = this.h(n5);
            int n6 = this.a.a(view2);
            if (this.a.b(view2) > n2 && n6 < n3) {
                if (n6 >= n2) return view2;
                if (!bl2) {
                    return view2;
                }
                if (bl3 && view == null) {
                    view = view2;
                }
            }
            ++n5;
        }
        return view;
    }

    public void a(int n2) {
        this.a((String)null);
        if (n2 == this.g) return;
        this.g();
        this.g = n2;
        this.m = new BitSet(this.g);
        this.h = new gc[this.g];
        int n3 = 0;
        do {
            if (n3 >= this.g) {
                this.m();
                return;
            }
            this.h[n3] = new gc(this, n3, null);
            ++n3;
        } while (true);
    }

    @Override
    public void a(Rect rect, int n2, int n3) {
        int n4;
        int n5;
        int n6 = this.x() + this.z();
        int n7 = this.y() + this.A();
        if (this.i == 1) {
            n5 = StaggeredGridLayoutManager.a(n3, n7 + rect.height(), this.D());
            n4 = StaggeredGridLayoutManager.a(n2, n6 + this.j * this.g, this.C());
        } else {
            n4 = StaggeredGridLayoutManager.a(n2, n6 + rect.width(), this.C());
            n5 = StaggeredGridLayoutManager.a(n3, n7 + this.j * this.g, this.D());
        }
        this.d(n4, n5);
    }

    @Override
    public void a(Parcelable parcelable) {
        if (!(parcelable instanceof StaggeredGridLayoutManager$SavedState)) return;
        this.u = (StaggeredGridLayoutManager$SavedState)parcelable;
        this.m();
    }

    @Override
    public void a(RecyclerView recyclerView) {
        this.f.a();
        this.m();
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3) {
        this.c(n2, n3, 1);
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
        this.c(n2, n3, 8);
    }

    @Override
    public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
        this.c(n2, n3, 4);
    }

    @Override
    public void a(RecyclerView recyclerView, ew ew2) {
        this.a(this.A);
        int n2 = 0;
        while (n2 < this.g) {
            this.h[n2].e();
            ++n2;
        }
    }

    @Override
    public void a(ew ew2, fc fc2, View view, g g2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof fz)) {
            super.a(view, g2);
            return;
        }
        fz fz2 = (fz)layoutParams;
        if (this.i == 0) {
            int n2 = fz2.b();
            int n3 = fz2.f ? this.g : 1;
            g2.b(r.a(n2, n3, -1, -1, fz2.f, false));
            return;
        }
        int n4 = fz2.b();
        int n5 = fz2.f ? this.g : 1;
        g2.b(r.a(-1, -1, n4, n5, fz2.f, false));
    }

    void a(fc fc2, fy fy2) {
        if (this.b(fc2, fy2)) {
            return;
        }
        if (this.c(fc2, fy2)) return;
        fy2.b();
        fy2.a = 0;
    }

    @Override
    public void a(AccessibilityEvent accessibilityEvent) {
        int n2;
        super.a(accessibilityEvent);
        if (this.s() <= 0) return;
        aj aj2 = a.a(accessibilityEvent);
        View view = this.a(false, true);
        View view2 = this.b(false, true);
        if (view == null) return;
        if (view2 == null) {
            return;
        }
        int n3 = this.d(view);
        if (n3 < (n2 = this.d(view2))) {
            aj2.b(n3);
            aj2.c(n2);
            return;
        }
        aj2.b(n2);
        aj2.c(n3);
    }

    @Override
    public void a(String string) {
        if (this.u != null) return;
        super.a(string);
    }

    public void a(boolean bl2) {
        this.a((String)null);
        if (this.u != null && this.u.h != bl2) {
            this.u.h = bl2;
        }
        this.l = bl2;
        this.m();
    }

    @Override
    public boolean a(er er2) {
        return er2 instanceof fz;
    }

    @Override
    public int b(int n2, ew ew2, fc fc2) {
        return this.c(n2, ew2, fc2);
    }

    @Override
    public int b(ew ew2, fc fc2) {
        if (this.i != 1) return super.b(ew2, fc2);
        return this.g;
    }

    @Override
    public int b(fc fc2) {
        return this.a(fc2);
    }

    View b(boolean bl2, boolean bl3) {
        this.I();
        int n2 = this.a.c();
        int n3 = this.a.d();
        int n4 = -1 + this.s();
        View view = null;
        while (n4 >= 0) {
            View view2 = this.h(n4);
            int n5 = this.a.a(view2);
            int n6 = this.a.b(view2);
            if (n6 > n2 && n5 < n3) {
                if (n6 <= n3) return view2;
                if (!bl2) {
                    return view2;
                }
                if (bl3 && view == null) {
                    view = view2;
                }
            }
            --n4;
        }
        return view;
    }

    public void b(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        this.a((String)null);
        if (n2 == this.i) {
            return;
        }
        this.i = n2;
        if (this.a != null && this.b != null) {
            dw dw2 = this.a;
            this.a = this.b;
            this.b = dw2;
        }
        this.m();
    }

    @Override
    public void b(RecyclerView recyclerView, int n2, int n3) {
        this.c(n2, n3, 2);
    }

    @Override
    public boolean b() {
        if (this.u != null) return false;
        return true;
    }

    boolean b(fc fc2, fy fy2) {
        if (fc2.a()) return false;
        if (this.d == -1) {
            return false;
        }
        if (this.d < 0 || this.d >= fc2.e()) {
            this.d = -1;
            this.e = Integer.MIN_VALUE;
            return false;
        }
        if (this.u != null && this.u.a != -1 && this.u.c >= 1) {
            fy2.b = Integer.MIN_VALUE;
            fy2.a = this.d;
            return true;
        }
        View view = this.c(this.d);
        if (view != null) {
            int n2 = this.c ? this.L() : this.M();
            fy2.a = n2;
            if (this.e != Integer.MIN_VALUE) {
                if (fy2.c) {
                    fy2.b = this.a.d() - this.e - this.a.b(view);
                    return true;
                }
                fy2.b = this.a.c() + this.e - this.a.a(view);
                return true;
            }
            if (this.a.c(view) > this.a.f()) {
                int n3 = fy2.c ? this.a.d() : this.a.c();
                fy2.b = n3;
                return true;
            }
            int n4 = this.a.a(view) - this.a.c();
            if (n4 < 0) {
                fy2.b = - n4;
                return true;
            }
            int n5 = this.a.d() - this.a.b(view);
            if (n5 < 0) {
                fy2.b = n5;
                return true;
            }
            fy2.b = Integer.MIN_VALUE;
            return true;
        }
        fy2.a = this.d;
        if (this.e == Integer.MIN_VALUE) {
            int n6 = this.t(fy2.a);
            boolean bl2 = false;
            if (n6 == 1) {
                bl2 = true;
            }
            fy2.c = bl2;
            fy2.b();
        } else {
            fy2.a(this.e);
        }
        fy2.d = true;
        return true;
    }

    int c(int n2, ew ew2, fc fc2) {
        int n3;
        int n4;
        int n5;
        this.I();
        if (n2 > 0) {
            n3 = this.L();
            n5 = 1;
        } else {
            n5 = -1;
            n3 = this.M();
        }
        this.k.a = true;
        this.a(n3, fc2);
        this.l(n5);
        this.k.c = n3 + this.k.d;
        this.k.b = n4 = Math.abs(n2);
        int n6 = this.a(ew2, this.k, fc2);
        if (n4 >= n6) {
            n2 = n2 < 0 ? - n6 : n6;
        }
        this.a.a(- n2);
        this.o = this.c;
        return n2;
    }

    @Override
    public int c(fc fc2) {
        return this.a(fc2);
    }

    @Override
    public Parcelable c() {
        if (this.u != null) {
            return new StaggeredGridLayoutManager$SavedState(this.u);
        }
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = new StaggeredGridLayoutManager$SavedState();
        staggeredGridLayoutManager$SavedState.h = this.l;
        staggeredGridLayoutManager$SavedState.i = this.o;
        staggeredGridLayoutManager$SavedState.j = this.t;
        if (this.f != null && this.f.a != null) {
            staggeredGridLayoutManager$SavedState.f = this.f.a;
            staggeredGridLayoutManager$SavedState.e = staggeredGridLayoutManager$SavedState.f.length;
            staggeredGridLayoutManager$SavedState.g = this.f.b;
        } else {
            staggeredGridLayoutManager$SavedState.e = 0;
        }
        if (this.s() <= 0) {
            staggeredGridLayoutManager$SavedState.a = -1;
            staggeredGridLayoutManager$SavedState.b = -1;
            staggeredGridLayoutManager$SavedState.c = 0;
            return staggeredGridLayoutManager$SavedState;
        }
        this.I();
        int n2 = this.o ? this.L() : this.M();
        staggeredGridLayoutManager$SavedState.a = n2;
        staggeredGridLayoutManager$SavedState.b = this.i();
        staggeredGridLayoutManager$SavedState.c = this.g;
        staggeredGridLayoutManager$SavedState.d = new int[this.g];
        int n3 = 0;
        while (n3 < this.g) {
            int n4;
            if (this.o) {
                n4 = this.h[n3].b(Integer.MIN_VALUE);
                if (n4 != Integer.MIN_VALUE) {
                    n4 -= this.a.d();
                }
            } else {
                n4 = this.h[n3].a(Integer.MIN_VALUE);
                if (n4 != Integer.MIN_VALUE) {
                    n4 -= this.a.c();
                }
            }
            staggeredGridLayoutManager$SavedState.d[n3] = n4;
            ++n3;
        }
        return staggeredGridLayoutManager$SavedState;
    }

    @Override
    public void c(ew ew2, fc fc2) {
        this.a(ew2, fc2, true);
    }

    @Override
    public int d(fc fc2) {
        return this.h(fc2);
    }

    @Override
    public void d(int n2) {
        if (this.u != null && this.u.a != n2) {
            this.u.b();
        }
        this.d = n2;
        this.e = Integer.MIN_VALUE;
        this.m();
    }

    @Override
    public boolean d() {
        if (this.i != 0) return false;
        return true;
    }

    @Override
    public int e(fc fc2) {
        return this.h(fc2);
    }

    void e(int n2) {
        this.j = n2 / this.g;
        this.v = View.MeasureSpec.makeMeasureSpec((int)n2, (int)this.b.h());
    }

    @Override
    public boolean e() {
        if (this.i != 1) return false;
        return true;
    }

    @Override
    public int f(fc fc2) {
        return this.i(fc2);
    }

    /*
     * Unable to fully structure code
     */
    View f() {
        var1_1 = -1 + this.s();
        var2_2 = new BitSet(this.g);
        var2_2.set(0, this.g, true);
        var3_3 = this.i == 1 && this.h() != false ? 1 : -1;
        if (this.c) {
            var4_4 = -1;
        } else {
            var4_4 = var1_1 + 1;
            var1_1 = 0;
        }
        var5_5 = var1_1 < var4_4 ? 1 : -1;
        var6_6 = var1_1;
        while (var6_6 != var4_4) {
            var7_7 = this.h(var6_6);
            var8_8 = (fz)var7_7.getLayoutParams();
            if (var2_2.get(var8_8.e.d)) {
                if (this.a(var8_8.e)) {
                    return var7_7;
                }
                var2_2.clear(var8_8.e.d);
            }
            if (var8_8.f || var6_6 + var5_5 == var4_4) ** GOTO lbl42
            var9_9 = this.h(var6_6 + var5_5);
            if (!this.c) ** GOTO lbl28
            var16_16 = this.a.b(var7_7);
            if (var16_16 < (var17_17 = this.a.b(var9_9))) {
                return var7_7;
            }
            if (var16_16 != var17_17) ** GOTO lbl-1000
            var12_12 = true;
            ** GOTO lbl35
lbl28: // 1 sources:
            var10_10 = this.a.a(var7_7);
            if (var10_10 > (var11_11 = this.a.a(var9_9))) {
                return var7_7;
            }
            if (var10_10 == var11_11) {
                var12_12 = true;
            } else lbl-1000: // 2 sources:
            {
                var12_12 = false;
            }
lbl35: // 3 sources:
            if (var12_12) {
                var13_13 = (fz)var9_9.getLayoutParams();
                var14_14 = var8_8.e.d - var13_13.e.d < 0;
                if (var3_3 >= 0) return var7_7;
                var15_15 = true;
                if (var14_14 != var15_15) {
                    return var7_7;
                }
            }
lbl42: // 5 sources:
            var6_6 += var5_5;
        }
        return null;
    }

    @Override
    public int g(fc fc2) {
        return this.i(fc2);
    }

    public void g() {
        this.f.a();
        this.m();
    }

    boolean h() {
        if (this.q() != 1) return false;
        return true;
    }

    int i() {
        View view = this.c ? this.b(true, true) : this.a(true, true);
        if (view != null) return this.d(view);
        return -1;
    }

    @Override
    public void i(int n2) {
        super.i(n2);
        int n3 = 0;
        while (n3 < this.g) {
            this.h[n3].d(n2);
            ++n3;
        }
    }

    @Override
    public void j(int n2) {
        super.j(n2);
        int n3 = 0;
        while (n3 < this.g) {
            this.h[n3].d(n2);
            ++n3;
        }
    }

    @Override
    public void k(int n2) {
        if (n2 != 0) return;
        this.H();
    }

    boolean k() {
        int n2 = 1;
        int n3 = this.h[0].b(Integer.MIN_VALUE);
        int n4 = n2;
        while (n4 < this.g) {
            if (this.h[n4].b(Integer.MIN_VALUE) != n3) {
                return (boolean)0;
            }
            ++n4;
        }
        return (boolean)n2;
    }

    boolean l() {
        int n2 = 1;
        int n3 = this.h[0].a(Integer.MIN_VALUE);
        int n4 = n2;
        while (n4 < this.g) {
            if (this.h[n4].a(Integer.MIN_VALUE) != n3) {
                return (boolean)0;
            }
            ++n4;
        }
        return (boolean)n2;
    }
}

