/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.h.a.a;
import android.support.v4.h.a.aj;
import android.support.v7.widget.LinearLayoutManager$SavedState;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.db;
import android.support.v7.widget.dc;
import android.support.v7.widget.dd;
import android.support.v7.widget.dw;
import android.support.v7.widget.ep;
import android.support.v7.widget.eq;
import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.support.v7.widget.fc;
import android.support.v7.widget.ff;
import android.support.v7.widget.fm;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
extends ep {
    private dd a;
    private boolean b;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f;
    int i;
    dw j;
    boolean k = false;
    int l = -1;
    int m = Integer.MIN_VALUE;
    LinearLayoutManager$SavedState n = null;
    final db o;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int n2, boolean bl2) {
        this.o = new db(this);
        this.b(n2);
        this.b(bl2);
        this.c(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int n2, int n3) {
        this.o = new db(this);
        eq eq2 = LinearLayoutManager.a(context, attributeSet, n2, n3);
        this.b(eq2.a);
        this.b(eq2.c);
        this.a(eq2.d);
        this.c(true);
    }

    private void H() {
        int n2 = 1;
        if (this.i == n2 || !this.g()) {
            this.k = this.c;
            return;
        }
        if (this.c) {
            n2 = 0;
        }
        this.k = n2;
    }

    private View I() {
        int n2;
        if (this.k) {
            n2 = -1 + this.s();
            return this.h(n2);
        }
        n2 = 0;
        return this.h(n2);
    }

    private View J() {
        int n2;
        if (this.k) {
            n2 = 0;
            return this.h(n2);
        }
        n2 = -1 + this.s();
        return this.h(n2);
    }

    private int a(int n2, ew ew2, fc fc2, boolean bl2) {
        int n3 = this.j.d() - n2;
        if (n3 <= 0) return 0;
        int n4 = - this.c(- n3, ew2, fc2);
        int n5 = n2 + n4;
        if (!bl2) return n4;
        int n6 = this.j.d() - n5;
        if (n6 <= 0) return n4;
        this.j.a(n6);
        n4 += n6;
        return n4;
    }

    private View a(boolean bl2, boolean bl3) {
        if (!this.k) return this.a(0, this.s(), bl2, bl3);
        return this.a(-1 + this.s(), -1, bl2, bl3);
    }

    private void a(int n2, int n3, boolean bl2, fc fc2) {
        int n4;
        int n5 = 1;
        dd dd2 = this.a;
        int n6 = this.j.h() == 0 ? n5 : 0;
        dd2.l = n6;
        this.a.h = this.a(fc2);
        this.a.f = n2;
        if (n2 == n5) {
            dd dd3 = this.a;
            dd3.h += this.j.g();
            View view = this.J();
            dd dd4 = this.a;
            if (this.k) {
                n5 = -1;
            }
            dd4.e = n5;
            this.a.d = this.d(view) + this.a.e;
            this.a.b = this.j.b(view);
            n4 = this.j.b(view) - this.j.d();
        } else {
            View view = this.I();
            dd dd5 = this.a;
            dd5.h += this.j.c();
            dd dd6 = this.a;
            if (!this.k) {
                n5 = -1;
            }
            dd6.e = n5;
            this.a.d = this.d(view) + this.a.e;
            this.a.b = this.j.a(view);
            n4 = - this.j.a(view) + this.j.c();
        }
        this.a.c = n3;
        if (bl2) {
            dd dd7 = this.a;
            dd7.c -= n4;
        }
        this.a.g = n4;
    }

    private void a(db db2) {
        this.e(db2.a, db2.b);
    }

    private void a(ew ew2, int n2) {
        if (n2 < 0) {
            return;
        }
        int n3 = this.s();
        if (this.k) {
            int n4 = n3 - 1;
            while (n4 >= 0) {
                View view = this.h(n4);
                if (this.j.b(view) > n2) {
                    this.a(ew2, n3 - 1, n4);
                    return;
                }
                --n4;
            }
            return;
        }
        int n5 = 0;
        while (n5 < n3) {
            View view = this.h(n5);
            if (this.j.b(view) > n2) {
                this.a(ew2, 0, n5);
                return;
            }
            ++n5;
        }
    }

    private void a(ew ew2, int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        if (n3 <= n2) {
            while (n2 > n3) {
                this.a(n2, ew2);
                --n2;
            }
            return;
        }
        int n4 = n3 - 1;
        while (n4 >= n2) {
            this.a(n4, ew2);
            --n4;
        }
    }

    private void a(ew ew2, dd dd2) {
        if (!dd2.a) return;
        if (dd2.l) {
            return;
        }
        if (dd2.f == -1) {
            this.b(ew2, dd2.g);
            return;
        }
        this.a(ew2, dd2.g);
    }

    private void a(ew ew2, fc fc2, db db2) {
        if (this.a(fc2, db2)) {
            return;
        }
        if (this.b(ew2, fc2, db2)) return;
        db2.b();
        int n2 = this.d ? -1 + fc2.e() : 0;
        db2.a = n2;
    }

    private boolean a(fc fc2, db db2) {
        if (fc2.a()) return false;
        if (this.l == -1) {
            return false;
        }
        if (this.l < 0 || this.l >= fc2.e()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            return false;
        }
        db2.a = this.l;
        if (this.n != null && this.n.a()) {
            db2.c = this.n.c;
            if (db2.c) {
                db2.b = this.j.d() - this.n.b;
                return true;
            }
            db2.b = this.j.c() + this.n.b;
            return true;
        }
        if (this.m == Integer.MIN_VALUE) {
            View view = this.c(this.l);
            if (view != null) {
                if (this.j.c(view) > this.j.f()) {
                    db2.b();
                    return true;
                }
                if (this.j.a(view) - this.j.c() < 0) {
                    db2.b = this.j.c();
                    db2.c = false;
                    return true;
                }
                if (this.j.d() - this.j.b(view) < 0) {
                    db2.b = this.j.d();
                    db2.c = true;
                    return true;
                }
                int n2 = db2.c ? this.j.b(view) + this.j.b() : this.j.a(view);
                db2.b = n2;
                return true;
            }
            if (this.s() > 0) {
                int n3 = this.d(this.h(0));
                boolean bl2 = this.l < n3;
                boolean bl3 = this.k;
                boolean bl4 = false;
                if (bl2 == bl3) {
                    bl4 = true;
                }
                db2.c = bl4;
            }
            db2.b();
            return true;
        }
        db2.c = this.k;
        if (this.k) {
            db2.b = this.j.d() - this.m;
            return true;
        }
        db2.b = this.j.c() + this.m;
        return true;
    }

    private int b(int n2, ew ew2, fc fc2, boolean bl2) {
        int n3 = n2 - this.j.c();
        if (n3 <= 0) return 0;
        int n4 = - this.c(n3, ew2, fc2);
        int n5 = n2 + n4;
        if (!bl2) return n4;
        int n6 = n5 - this.j.c();
        if (n6 <= 0) return n4;
        this.j.a(- n6);
        n4 -= n6;
        return n4;
    }

    private View b(boolean bl2, boolean bl3) {
        if (!this.k) return this.a(-1 + this.s(), -1, bl2, bl3);
        return this.a(0, this.s(), bl2, bl3);
    }

    private void b(db db2) {
        this.f(db2.a, db2.b);
    }

    private void b(ew ew2, int n2) {
        int n3 = this.s();
        if (n2 < 0) {
            return;
        }
        int n4 = this.j.e() - n2;
        if (this.k) {
            int n5 = 0;
            while (n5 < n3) {
                View view = this.h(n5);
                if (this.j.a(view) < n4) {
                    this.a(ew2, 0, n5);
                    return;
                }
                ++n5;
            }
            return;
        }
        int n6 = n3 - 1;
        while (n6 >= 0) {
            View view = this.h(n6);
            if (this.j.a(view) < n4) {
                this.a(ew2, n3 - 1, n6);
                return;
            }
            --n6;
        }
    }

    private void b(ew ew2, fc fc2, int n2, int n3) {
        if (!fc2.b()) return;
        if (this.s() == 0) return;
        if (fc2.a()) return;
        if (!this.b()) {
            return;
        }
        int n4 = 0;
        int n5 = 0;
        List list = ew2.b();
        int n6 = list.size();
        int n7 = this.d(this.h(0));
        for (int i2 = 0; i2 < n6; ++i2) {
            int n8;
            int n9;
            ff ff2 = (ff)list.get(i2);
            if (ff2.q()) {
                n9 = n5;
                n8 = n4;
            } else {
                boolean bl2 = ff2.d() < n7;
                int n10 = bl2 != this.k ? -1 : 1;
                if (n10 == -1) {
                    n8 = n4 + this.j.c(ff2.a);
                    n9 = n5;
                } else {
                    n9 = n5 + this.j.c(ff2.a);
                    n8 = n4;
                }
            }
            n4 = n8;
            n5 = n9;
        }
        this.a.k = list;
        if (n4 > 0) {
            this.f(this.d(this.I()), n2);
            this.a.h = n4;
            this.a.c = 0;
            this.a.a();
            this.a(ew2, this.a, fc2, false);
        }
        if (n5 > 0) {
            this.e(this.d(this.J()), n3);
            this.a.h = n5;
            this.a.c = 0;
            this.a.a();
            this.a(ew2, this.a, fc2, false);
        }
        this.a.k = null;
    }

    private boolean b(ew ew2, fc fc2, db db2) {
        boolean bl2;
        if (this.s() == 0) {
            return false;
        }
        View view = this.B();
        if (view != null && db.a(db2, view, fc2)) {
            db2.a(view);
            return true;
        }
        if (this.b != this.d) return false;
        View view2 = db2.c ? this.f(ew2, fc2) : this.g(ew2, fc2);
        if (view2 == null) return false;
        db2.b(view2);
        if (fc2.a()) return true;
        if (!this.b()) return true;
        if (this.j.a(view2) < this.j.d()) {
            int n2 = this.j.b(view2);
            int n3 = this.j.c();
            bl2 = false;
            if (n2 >= n3) return true;
        }
        bl2 = true;
        if (!bl2) return true;
        int n4 = db2.c ? this.j.d() : this.j.c();
        db2.b = n4;
        return true;
    }

    private void e(int n2, int n3) {
        this.a.c = this.j.d() - n3;
        dd dd2 = this.a;
        int n4 = this.k ? -1 : 1;
        dd2.e = n4;
        this.a.d = n2;
        this.a.f = 1;
        this.a.b = n3;
        this.a.g = Integer.MIN_VALUE;
    }

    private View f(ew ew2, fc fc2) {
        if (!this.k) return this.i(ew2, fc2);
        return this.h(ew2, fc2);
    }

    private void f(int n2, int n3) {
        this.a.c = n3 - this.j.c();
        this.a.d = n2;
        dd dd2 = this.a;
        int n4 = this.k ? 1 : -1;
        dd2.e = n4;
        this.a.f = -1;
        this.a.b = n3;
        this.a.g = Integer.MIN_VALUE;
    }

    private View g(ew ew2, fc fc2) {
        if (!this.k) return this.h(ew2, fc2);
        return this.i(ew2, fc2);
    }

    private int h(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.h();
        dw dw2 = this.j;
        boolean bl2 = !this.e;
        View view = this.a(bl2, true);
        boolean bl3 = this.e;
        boolean bl4 = false;
        if (bl3) return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.e, this.k);
        bl4 = true;
        return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.e, this.k);
    }

    private View h(ew ew2, fc fc2) {
        return this.a(ew2, fc2, 0, this.s(), fc2.e());
    }

    private int i(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.h();
        dw dw2 = this.j;
        boolean bl2 = !this.e;
        View view = this.a(bl2, true);
        boolean bl3 = this.e;
        boolean bl4 = false;
        if (bl3) return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.e);
        bl4 = true;
        return fm.a(fc2, dw2, view, this.b(bl4, true), this, this.e);
    }

    private View i(ew ew2, fc fc2) {
        return this.a(ew2, fc2, -1 + this.s(), -1, fc2.e());
    }

    private int j(fc fc2) {
        if (this.s() == 0) {
            return 0;
        }
        this.h();
        dw dw2 = this.j;
        boolean bl2 = !this.e;
        View view = this.a(bl2, true);
        boolean bl3 = this.e;
        boolean bl4 = false;
        if (bl3) return fm.b(fc2, dw2, view, this.b(bl4, true), this, this.e);
        bl4 = true;
        return fm.b(fc2, dw2, view, this.b(bl4, true), this, this.e);
    }

    @Override
    public int a(int n2, ew ew2, fc fc2) {
        if (this.i != 1) return this.c(n2, ew2, fc2);
        return 0;
    }

    int a(ew ew2, dd dd2, fc fc2, boolean bl2) {
        int n2 = dd2.c;
        if (dd2.g != Integer.MIN_VALUE) {
            if (dd2.c < 0) {
                dd2.g += dd2.c;
            }
            this.a(ew2, dd2);
        }
        int n3 = dd2.c + dd2.h;
        dc dc2 = new dc();
        do {
            if (!dd2.l) {
                if (n3 <= 0) return n2 - dd2.c;
            }
            if (!dd2.a(fc2)) return n2 - dd2.c;
            dc2.a();
            this.a(ew2, fc2, dd2, dc2);
            if (dc2.b) {
                return n2 - dd2.c;
            }
            dd2.b += dc2.a * dd2.f;
            if (!dc2.c || this.a.k != null || !fc2.a()) {
                dd2.c -= dc2.a;
                n3 -= dc2.a;
            }
            if (dd2.g == Integer.MIN_VALUE) continue;
            dd2.g += dc2.a;
            if (dd2.c < 0) {
                dd2.g += dd2.c;
            }
            this.a(ew2, dd2);
        } while (!bl2 || !dc2.d);
        return n2 - dd2.c;
    }

    protected int a(fc fc2) {
        if (!fc2.d()) return 0;
        return this.j.f();
    }

    @Override
    public er a() {
        return new er(-2, -2);
    }

    View a(int n2, int n3, boolean bl2, boolean bl3) {
        this.h();
        int n4 = this.j.c();
        int n5 = this.j.d();
        int n6 = n3 > n2 ? 1 : -1;
        View view = null;
        while (n2 != n3) {
            View view2;
            block4 : {
                view2 = this.h(n2);
                int n7 = this.j.a(view2);
                int n8 = this.j.b(view2);
                if (n7 < n5 && n8 > n4) {
                    if (!bl2) return view2;
                    if (n7 >= n4 && n8 <= n5) {
                        return view2;
                    }
                    if (bl3 && view == null) break block4;
                }
                view2 = view;
            }
            n2 += n6;
            view = view2;
        }
        return view;
    }

    /*
     * Unable to fully structure code
     */
    View a(ew var1_1, fc var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = null;
        this.h();
        var7_7 = this.j.c();
        var8_8 = this.j.d();
        var9_9 = var4_4 > var3_3 ? 1 : -1;
        var10_10 = null;
        while (var3_3 != var4_4) {
            var11_11 = this.h(var3_3);
            var12_12 = this.d(var11_11);
            if (var12_12 < 0 || var12_12 >= var5_5) ** GOTO lbl-1000
            if (!((er)var11_11.getLayoutParams()).c()) ** GOTO lbl15
            if (var10_10 != null) ** GOTO lbl-1000
            var13_13 = var6_6;
            ** GOTO lbl23
lbl15: // 1 sources:
            if (this.j.a(var11_11) < var8_8) {
                if (this.j.b(var11_11) >= var7_7) return var11_11;
            }
            if (var6_6 == null) {
                var13_13 = var11_11;
                var11_11 = var10_10;
            } else lbl-1000: // 3 sources:
            {
                var13_13 = var6_6;
                var11_11 = var10_10;
            }
lbl23: // 3 sources:
            var3_3 += var9_9;
            var6_6 = var13_13;
            var10_10 = var11_11;
        }
        if (var6_6 != null) return var6_6;
        var6_6 = var10_10;
        return var6_6;
    }

    @Override
    public View a(View view, int n2, ew ew2, fc fc2) {
        this.H();
        if (this.s() == 0) {
            return null;
        }
        int n3 = this.e(n2);
        if (n3 == Integer.MIN_VALUE) return null;
        this.h();
        View view2 = n3 == -1 ? this.g(ew2, fc2) : this.f(ew2, fc2);
        if (view2 == null) return null;
        this.h();
        this.a(n3, (int)(0.33333334f * (float)this.j.f()), false, fc2);
        this.a.g = Integer.MIN_VALUE;
        this.a.a = false;
        this.a(ew2, this.a, fc2, true);
        View view3 = n3 == -1 ? this.I() : this.J();
        if (view3 == view2) return null;
        if (!view3.isFocusable()) return null;
        return view3;
    }

    @Override
    public void a(Parcelable parcelable) {
        if (!(parcelable instanceof LinearLayoutManager$SavedState)) return;
        this.n = (LinearLayoutManager$SavedState)parcelable;
        this.m();
    }

    @Override
    public void a(RecyclerView recyclerView, ew ew2) {
        super.a(recyclerView, ew2);
        if (!this.f) return;
        this.c(ew2);
        ew2.a();
    }

    void a(ew ew2, fc fc2, db db2, int n2) {
    }

    void a(ew ew2, fc fc2, dd dd2, dc dc2) {
        int n2;
        int n3;
        int n4;
        int n5;
        View view = dd2.a(ew2);
        if (view == null) {
            dc2.b = true;
            return;
        }
        er er2 = (er)view.getLayoutParams();
        if (dd2.k == null) {
            boolean bl2 = this.k;
            boolean bl3 = dd2.f == -1;
            if (bl2 == bl3) {
                this.b(view);
            } else {
                this.b(view, 0);
            }
        } else {
            boolean bl4 = this.k;
            boolean bl5 = dd2.f == -1;
            if (bl4 == bl5) {
                this.a(view);
            } else {
                this.a(view, 0);
            }
        }
        this.a(view, 0, 0);
        dc2.a = this.j.c(view);
        if (this.i == 1) {
            int n6;
            if (this.g()) {
                n6 = this.v() - this.z();
                n5 = n6 - this.j.d(view);
            } else {
                n5 = this.x();
                n6 = n5 + this.j.d(view);
            }
            if (dd2.f == -1) {
                int n7 = dd2.b;
                n4 = dd2.b - dc2.a;
                n2 = n6;
                n3 = n7;
            } else {
                int n8 = dd2.b;
                int n9 = dd2.b + dc2.a;
                n4 = n8;
                n2 = n6;
                n3 = n9;
            }
        } else {
            n4 = this.y();
            n3 = n4 + this.j.d(view);
            if (dd2.f == -1) {
                int n10 = dd2.b;
                n5 = dd2.b - dc2.a;
                n2 = n10;
            } else {
                int n11 = dd2.b;
                int n12 = dd2.b + dc2.a;
                n5 = n11;
                n2 = n12;
            }
        }
        this.a(view, n5 + er2.leftMargin, n4 + er2.topMargin, n2 - er2.rightMargin, n3 - er2.bottomMargin);
        if (er2.c() || er2.d()) {
            dc2.c = true;
        }
        dc2.d = view.isFocusable();
    }

    @Override
    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (this.s() <= 0) return;
        aj aj2 = a.a(accessibilityEvent);
        aj2.b(this.k());
        aj2.c(this.l());
    }

    @Override
    public void a(String string) {
        if (this.n != null) return;
        super.a(string);
    }

    public void a(boolean bl2) {
        this.a((String)null);
        if (this.d == bl2) {
            return;
        }
        this.d = bl2;
        this.m();
    }

    @Override
    public int b(int n2, ew ew2, fc fc2) {
        if (this.i != 0) return this.c(n2, ew2, fc2);
        return 0;
    }

    @Override
    public int b(fc fc2) {
        return this.h(fc2);
    }

    public void b(int n2) {
        if (n2 != 0 && n2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + n2);
        }
        this.a((String)null);
        if (n2 == this.i) {
            return;
        }
        this.i = n2;
        this.j = null;
        this.m();
    }

    public void b(boolean bl2) {
        this.a((String)null);
        if (bl2 == this.c) {
            return;
        }
        this.c = bl2;
        this.m();
    }

    @Override
    public boolean b() {
        if (this.n != null) return false;
        if (this.b != this.d) return false;
        return true;
    }

    int c(int n2, ew ew2, fc fc2) {
        if (this.s() == 0) return 0;
        if (n2 == 0) {
            return 0;
        }
        this.a.a = true;
        this.h();
        int n3 = n2 > 0 ? 1 : -1;
        int n4 = Math.abs(n2);
        this.a(n3, n4, true, fc2);
        int n5 = this.a.g + this.a(ew2, this.a, fc2, false);
        if (n5 < 0) {
            return 0;
        }
        if (n4 > n5) {
            n2 = n3 * n5;
        }
        this.j.a(- n2);
        this.a.j = n2;
        return n2;
    }

    @Override
    public int c(fc fc2) {
        return this.h(fc2);
    }

    @Override
    public Parcelable c() {
        boolean bl2;
        if (this.n != null) {
            return new LinearLayoutManager$SavedState(this.n);
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (this.s() <= 0) {
            linearLayoutManager$SavedState.b();
            return linearLayoutManager$SavedState;
        }
        this.h();
        linearLayoutManager$SavedState.c = bl2 = this.b ^ this.k;
        if (bl2) {
            View view = this.J();
            linearLayoutManager$SavedState.b = this.j.d() - this.j.b(view);
            linearLayoutManager$SavedState.a = this.d(view);
            return linearLayoutManager$SavedState;
        }
        View view = this.I();
        linearLayoutManager$SavedState.a = this.d(view);
        linearLayoutManager$SavedState.b = this.j.a(view) - this.j.c();
        return linearLayoutManager$SavedState;
    }

    @Override
    public View c(int n2) {
        int n3 = this.s();
        if (n3 == 0) {
            return null;
        }
        int n4 = n2 - this.d(this.h(0));
        if (n4 < 0) return super.c(n2);
        if (n4 >= n3) return super.c(n2);
        View view = this.h(n4);
        if (this.d(view) == n2) return view;
        return super.c(n2);
    }

    @Override
    public void c(ew ew2, fc fc2) {
        int n2;
        View view;
        int n3;
        int n4;
        if ((this.n != null || this.l != -1) && fc2.e() == 0) {
            this.c(ew2);
            return;
        }
        if (this.n != null && this.n.a()) {
            this.l = this.n.a;
        }
        this.h();
        this.a.a = false;
        this.H();
        this.o.a();
        this.o.c = this.k ^ this.d;
        this.a(ew2, fc2, this.o);
        int n5 = this.a(fc2);
        if (this.a.j >= 0) {
            n3 = 0;
        } else {
            n3 = n5;
            n5 = 0;
        }
        int n6 = n3 + this.j.c();
        int n7 = n5 + this.j.g();
        if (fc2.a() && this.l != -1 && this.m != Integer.MIN_VALUE && (view = this.c(this.l)) != null) {
            int n8;
            if (this.k) {
                n8 = this.j.d() - this.j.b(view) - this.m;
            } else {
                int n9 = this.j.a(view) - this.j.c();
                n8 = this.m - n9;
            }
            if (n8 > 0) {
                n6 += n8;
            } else {
                n7 -= n8;
            }
        }
        int n10 = this.o.c ? (this.k ? 1 : -1) : (this.k ? -1 : 1);
        this.a(ew2, fc2, this.o, n10);
        this.a(ew2);
        dd dd2 = this.a;
        boolean bl2 = this.j.h() == 0;
        dd2.l = bl2;
        this.a.i = fc2.a();
        if (this.o.c) {
            int n11;
            this.b(this.o);
            this.a.h = n6;
            this.a(ew2, this.a, fc2, false);
            int n12 = this.a.b;
            int n13 = this.a.d;
            if (this.a.c > 0) {
                n7 += this.a.c;
            }
            this.a(this.o);
            this.a.h = n7;
            dd dd3 = this.a;
            dd3.d += this.a.e;
            this.a(ew2, this.a, fc2, false);
            int n14 = this.a.b;
            if (this.a.c > 0) {
                int n15 = this.a.c;
                this.f(n13, n12);
                this.a.h = n15;
                this.a(ew2, this.a, fc2, false);
                n11 = this.a.b;
            } else {
                n11 = n12;
            }
            n4 = n11;
            n2 = n14;
        } else {
            this.a(this.o);
            this.a.h = n7;
            this.a(ew2, this.a, fc2, false);
            n2 = this.a.b;
            int n16 = this.a.d;
            if (this.a.c > 0) {
                n6 += this.a.c;
            }
            this.b(this.o);
            this.a.h = n6;
            dd dd4 = this.a;
            dd4.d += this.a.e;
            this.a(ew2, this.a, fc2, false);
            n4 = this.a.b;
            if (this.a.c > 0) {
                int n17 = this.a.c;
                this.e(n16, n2);
                this.a.h = n17;
                this.a(ew2, this.a, fc2, false);
                n2 = this.a.b;
            }
        }
        if (this.s() > 0) {
            if (this.k ^ this.d) {
                int n18 = this.a(n2, ew2, fc2, true);
                int n19 = n4 + n18;
                int n20 = n2 + n18;
                int n21 = this.b(n19, ew2, fc2, false);
                n4 = n19 + n21;
                n2 = n20 + n21;
            } else {
                int n22 = this.b(n4, ew2, fc2, true);
                int n23 = n4 + n22;
                int n24 = n2 + n22;
                int n25 = this.a(n24, ew2, fc2, false);
                n4 = n23 + n25;
                n2 = n24 + n25;
            }
        }
        this.b(ew2, fc2, n4, n2);
        if (!fc2.a()) {
            this.l = -1;
            this.m = Integer.MIN_VALUE;
            this.j.a();
        }
        this.b = this.d;
        this.n = null;
    }

    @Override
    public int d(fc fc2) {
        return this.i(fc2);
    }

    @Override
    public void d(int n2) {
        this.l = n2;
        this.m = Integer.MIN_VALUE;
        if (this.n != null) {
            this.n.b();
        }
        this.m();
    }

    @Override
    public boolean d() {
        if (this.i != 0) return false;
        return true;
    }

    int e(int n2) {
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
    public int e(fc fc2) {
        return this.i(fc2);
    }

    @Override
    public boolean e() {
        if (this.i != 1) return false;
        return true;
    }

    public int f() {
        return this.i;
    }

    @Override
    public int f(fc fc2) {
        return this.j(fc2);
    }

    @Override
    public int g(fc fc2) {
        return this.j(fc2);
    }

    protected boolean g() {
        if (this.q() != 1) return false;
        return true;
    }

    void h() {
        if (this.a == null) {
            this.a = this.i();
        }
        if (this.j != null) return;
        this.j = dw.a(this, this.i);
    }

    dd i() {
        return new dd();
    }

    @Override
    boolean j() {
        if (this.u() == 1073741824) return false;
        if (this.t() == 1073741824) return false;
        if (!this.G()) return false;
        return true;
    }

    public int k() {
        View view = this.a(0, this.s(), false, true);
        if (view != null) return this.d(view);
        return -1;
    }

    public int l() {
        View view = this.a(-1 + this.s(), -1, false, true);
        if (view != null) return this.d(view);
        return -1;
    }
}

