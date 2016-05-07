/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.a;
import android.support.v4.h.bo;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ai;
import android.support.v7.widget.ca;
import android.support.v7.widget.ef;
import android.support.v7.widget.ej;
import android.support.v7.widget.em;
import android.support.v7.widget.er;
import android.support.v7.widget.ev;
import android.support.v7.widget.fc;
import android.support.v7.widget.fd;
import android.support.v7.widget.ff;
import android.support.v7.widget.gv;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ew {
    final ArrayList a;
    final ArrayList b;
    final /* synthetic */ RecyclerView c;
    private ArrayList d;
    private final List e;
    private int f;
    private ev g;
    private fd h;

    public ew(RecyclerView recyclerView) {
        this.c = recyclerView;
        this.a = new ArrayList();
        this.d = null;
        this.b = new ArrayList();
        this.e = Collections.unmodifiableList(this.a);
        this.f = 2;
    }

    static /* synthetic */ ArrayList a(ew ew2) {
        return ew2.d;
    }

    private void a(ViewGroup viewGroup, boolean bl2) {
        for (int i2 = -1 + viewGroup.getChildCount(); i2 >= 0; --i2) {
            View view = viewGroup.getChildAt(i2);
            if (!(view instanceof ViewGroup)) continue;
            this.a((ViewGroup)view, true);
        }
        if (!bl2) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
            return;
        }
        int n2 = viewGroup.getVisibility();
        viewGroup.setVisibility(4);
        viewGroup.setVisibility(n2);
    }

    private void d(View view) {
        if (!this.c.i()) return;
        if (bo.e(view) == 0) {
            bo.c(view, 1);
        }
        if (bo.b(view)) return;
        bo.a(view, RecyclerView.l(this.c).b());
    }

    private void f(ff ff2) {
        if (!(ff2.a instanceof ViewGroup)) return;
        this.a((ViewGroup)ff2.a, false);
    }

    /*
     * Unable to fully structure code
     */
    ff a(int var1_1, int var2_2, boolean var3_3) {
        block6 : {
            block5 : {
                var4_4 = 0;
                var5_5 = this.a.size();
                var6_6 = 0;
                do {
                    if (var6_6 >= var5_5) ** GOTO lbl10
                    var8_7 = (ff)this.a.get(var6_6);
                    if (!(var8_7.k() || var8_7.d() != var1_1 || var8_7.n() || !fc.f(this.c.g) && var8_7.q())) {
                        if (var2_2 == -1 || var8_7.h() == var2_2) break block5;
                        Log.e((String)"RecyclerView", (String)("Scrap view for position " + var1_1 + " isn't dirty but has" + " wrong view type! (found " + var8_7.h() + " but expected " + var2_2 + ")"));
lbl10: // 2 sources:
                        if (!var3_3 && (var10_8 = this.c.c.a(var1_1, var2_2)) != null) {
                            var11_9 = RecyclerView.c(var10_8);
                            this.c.c.e(var10_8);
                            var12_10 = this.c.c.b(var10_8);
                            if (var12_10 != -1) break;
                            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + var11_9);
                        }
                        break block6;
                    }
                    ++var6_6;
                } while (true);
                this.c.c.d(var12_10);
                this.c(var10_8);
                var11_9.b(8224);
                return var11_9;
            }
            var8_7.b(32);
            return var8_7;
        }
        var7_11 = this.b.size();
        while (var4_4 < var7_11) {
            var8_7 = (ff)this.b.get(var4_4);
            if (!var8_7.n() && var8_7.d() == var1_1) {
                if (var3_3 != false) return var8_7;
                this.b.remove(var4_4);
                return var8_7;
            }
            ++var4_4;
        }
        return null;
    }

    ff a(long l2, int n2, boolean bl2) {
        ff ff2;
        for (int i2 = -1 + this.a.size(); i2 >= 0; --i2) {
            ff2 = (ff)this.a.get(i2);
            if (ff2.g() != l2 || ff2.k()) continue;
            if (n2 == ff2.h()) {
                ff2.b(32);
                if (!ff2.q()) return ff2;
                if (this.c.g.a()) return ff2;
                ff2.a(2, 14);
                return ff2;
            }
            if (bl2) continue;
            this.a.remove(i2);
            this.c.removeDetachedView(ff2.a, false);
            this.b(ff2.a);
        }
        int n3 = -1 + this.b.size();
        while (n3 >= 0) {
            ff2 = (ff)this.b.get(n3);
            if (ff2.g() == l2) {
                if (n2 == ff2.h()) {
                    if (bl2) return ff2;
                    this.b.remove(n3);
                    return ff2;
                }
                if (!bl2) {
                    this.d(n3);
                }
            }
            --n3;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     */
    View a(int var1_1, boolean var2_2) {
        var3_3 = true;
        if (var1_1 < 0) throw new IndexOutOfBoundsException("Invalid item position " + var1_1 + "(" + var1_1 + "). Item count:" + this.c.g.e());
        if (var1_1 >= this.c.g.e()) {
            throw new IndexOutOfBoundsException("Invalid item position " + var1_1 + "(" + var1_1 + "). Item count:" + this.c.g.e());
        }
        if (this.c.g.a()) {
            var18_4 = this.f(var1_1);
            var19_5 = var18_4 != null ? var3_3 : false;
            var5_6 = var19_5;
            var4_7 = var18_4;
        } else {
            var4_7 = null;
            var5_6 = false;
        }
        if (var4_7 == null && (var4_7 = this.a(var1_1, -1, var2_2)) != null) {
            if (!this.a(var4_7)) {
                if (!var2_2) {
                    var4_7.b(4);
                    if (var4_7.i()) {
                        this.c.removeDetachedView(var4_7.a, false);
                        var4_7.j();
                    } else if (var4_7.k()) {
                        var4_7.l();
                    }
                    this.b(var4_7);
                }
                var4_7 = null;
                var6_8 = var5_6;
            } else {
                var6_8 = var3_3;
            }
        } else {
            var6_8 = var5_6;
        }
        if (var4_7 != null) ** GOTO lbl-1000
        var15_9 = this.c.b.b(var1_1);
        if (var15_9 < 0) throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var1_1 + "(offset:" + var15_9 + ")." + "state:" + this.c.g.e());
        if (var15_9 >= RecyclerView.f(this.c).a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + var1_1 + "(offset:" + var15_9 + ")." + "state:" + this.c.g.e());
        }
        var16_10 = RecyclerView.f(this.c).a(var15_9);
        if (RecyclerView.f(this.c).b() && (var4_7 = this.a(RecyclerView.f(this.c).b(var15_9), var16_10, var2_2)) != null) {
            var4_7.b = var15_9;
            var6_8 = var3_3;
        }
        if (var4_7 == null && this.h != null && (var17_11 = this.h.a(this, var1_1, var16_10)) != null) {
            var4_7 = this.c.a(var17_11);
            if (var4_7 == null) {
                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
            }
            if (var4_7.c()) {
                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
            }
        }
        if (var4_7 == null && (var4_7 = this.f().a(var16_10)) != null) {
            var4_7.v();
            if (RecyclerView.r()) {
                this.f(var4_7);
            }
        }
        if (var4_7 == null) {
            var7_12 = RecyclerView.f(this.c).b(this.c, var16_10);
            var8_13 = var6_8;
        } else lbl-1000: // 2 sources:
        {
            var7_12 = var4_7;
            var8_13 = var6_8;
        }
        if (var8_13 && !this.c.g.a() && var7_12.a(8192)) {
            var7_12.a(0, 8192);
            if (fc.c(this.c.g)) {
                var13_14 = 4096 | ej.d(var7_12);
                var14_15 = this.c.f.a(this.c.g, var7_12, var13_14, var7_12.u());
                RecyclerView.a(this.c, var7_12, var14_15);
            }
        }
        if (this.c.g.a() && var7_12.p()) {
            var7_12.f = var1_1;
            var10_16 = false;
        } else if (!var7_12.p() || var7_12.o() || var7_12.n()) {
            var9_19 = this.c.b.b(var1_1);
            var7_12.k = this.c;
            RecyclerView.f(this.c).b(var7_12, var9_19);
            this.d(var7_12.a);
            if (this.c.g.a()) {
                var7_12.f = var1_1;
            }
            var10_16 = var3_3;
        } else {
            var10_16 = false;
        }
        if ((var11_17 = var7_12.a.getLayoutParams()) == null) {
            var12_18 = (er)this.c.generateDefaultLayoutParams();
            var7_12.a.setLayoutParams((ViewGroup.LayoutParams)var12_18);
        } else if (!this.c.checkLayoutParams(var11_17)) {
            var12_18 = (er)this.c.generateLayoutParams(var11_17);
            var7_12.a.setLayoutParams((ViewGroup.LayoutParams)var12_18);
        } else {
            var12_18 = (er)var11_17;
        }
        var12_18.a = var7_12;
        if (!var8_13 || !var10_16) {
            var3_3 = false;
        }
        var12_18.d = var3_3;
        return var7_12.a;
    }

    public void a() {
        this.a.clear();
        this.c();
    }

    public void a(int n2) {
        this.f = n2;
        int n3 = -1 + this.b.size();
        while (n3 >= 0) {
            if (this.b.size() <= n2) return;
            this.d(n3);
            --n3;
        }
    }

    void a(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        if (n2 < n3) {
            n5 = -1;
            n4 = n3;
            n6 = n2;
        } else {
            n5 = 1;
            n4 = n2;
            n6 = n3;
        }
        int n7 = this.b.size();
        int n8 = 0;
        while (n8 < n7) {
            ff ff2 = (ff)this.b.get(n8);
            if (ff2 != null && ff2.b >= n6 && ff2.b <= n4) {
                if (ff2.b == n2) {
                    ff2.a(n3 - n2, false);
                } else {
                    ff2.a(n5, false);
                }
            }
            ++n8;
        }
    }

    void a(ef ef2, ef ef3, boolean bl2) {
        this.a();
        this.f().a(ef2, ef3, bl2);
    }

    void a(ev ev2) {
        if (this.g != null) {
            this.g.b();
        }
        this.g = ev2;
        if (ev2 == null) return;
        this.g.a(this.c.getAdapter());
    }

    void a(fd fd2) {
        this.h = fd2;
    }

    public void a(View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2.r()) {
            this.c.removeDetachedView(view, false);
        }
        if (ff2.i()) {
            ff2.j();
        } else if (ff2.k()) {
            ff2.l();
        }
        this.b(ff2);
    }

    boolean a(ff ff2) {
        boolean bl2 = true;
        if (ff2.q()) {
            return this.c.g.a();
        }
        if (ff2.b < 0) throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + ff2);
        if (ff2.b >= RecyclerView.f(this.c).a()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + ff2);
        }
        if (!this.c.g.a() && RecyclerView.f(this.c).a(ff2.b) != ff2.h()) {
            return false;
        }
        if (!RecyclerView.f(this.c).b()) return bl2;
        if (ff2.g() == RecyclerView.f(this.c).b(ff2.b)) return bl2;
        return false;
    }

    public int b(int n2) {
        if (n2 < 0) throw new IndexOutOfBoundsException("invalid position " + n2 + ". State " + "item count is " + this.c.g.e());
        if (n2 >= this.c.g.e()) {
            throw new IndexOutOfBoundsException("invalid position " + n2 + ". State " + "item count is " + this.c.g.e());
        }
        if (this.c.g.a()) return this.c.b.b(n2);
        return n2;
    }

    public List b() {
        return this.e;
    }

    void b(int n2, int n3) {
        int n4 = this.b.size();
        int n5 = 0;
        while (n5 < n4) {
            ff ff2 = (ff)this.b.get(n5);
            if (ff2 != null && ff2.b >= n2) {
                ff2.a(n3, true);
            }
            ++n5;
        }
    }

    void b(int n2, int n3, boolean bl2) {
        int n4 = n2 + n3;
        int n5 = -1 + this.b.size();
        while (n5 >= 0) {
            ff ff2 = (ff)this.b.get(n5);
            if (ff2 != null) {
                if (ff2.b >= n4) {
                    ff2.a(- n3, bl2);
                } else if (ff2.b >= n2) {
                    ff2.b(8);
                    this.d(n5);
                }
            }
            --n5;
        }
    }

    /*
     * Unable to fully structure code
     */
    void b(ff var1_1) {
        var2_2 = true;
        if (var1_1.i() || var1_1.a.getParent() != null) {
            var3_3 = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(var1_1.i()).append(" isAttached:");
            if (var1_1.a.getParent() != null) {
                throw new IllegalArgumentException(var3_3.append(var2_2).toString());
            }
            var2_2 = false;
            throw new IllegalArgumentException(var3_3.append(var2_2).toString());
        }
        if (var1_1.r()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + var1_1);
        }
        if (var1_1.c()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        }
        var4_4 = ff.c(var1_1);
        var5_5 = RecyclerView.f(this.c) != null && var4_4 != false && RecyclerView.f(this.c).b(var1_1) != false ? var2_2 : false;
        if (!var5_5 && !var1_1.w()) ** GOTO lbl32
        if (var1_1.a(14)) ** GOTO lbl-1000
        var9_6 = this.b.size();
        if (var9_6 == this.f && var9_6 > 0) {
            this.d(0);
        }
        if (var9_6 < this.f) {
            this.b.add(var1_1);
            var6_7 = var2_2;
        } else lbl-1000: // 2 sources:
        {
            var6_7 = false;
        }
        if (!var6_7) {
            this.c(var1_1);
            var8_8 = var2_2;
            var7_9 = var6_7;
        } else {
            var7_9 = var6_7;
            var8_8 = false;
        }
        ** GOTO lbl34
lbl32: // 1 sources:
        var7_9 = false;
        var8_8 = false;
lbl34: // 3 sources:
        this.c.d.g(var1_1);
        if (var7_9 != false) return;
        if (var8_8 != false) return;
        if (var4_4 == false) return;
        var1_1.k = null;
    }

    void b(View view) {
        ff ff2 = RecyclerView.c(view);
        ff.a(ff2, null);
        ff.a(ff2, false);
        ff2.l();
        this.b(ff2);
    }

    public View c(int n2) {
        return this.a(n2, false);
    }

    void c() {
        int n2 = -1 + this.b.size();
        do {
            if (n2 < 0) {
                this.b.clear();
                return;
            }
            this.d(n2);
            --n2;
        } while (true);
    }

    void c(int n2, int n3) {
        int n4 = n2 + n3;
        int n5 = -1 + this.b.size();
        while (n5 >= 0) {
            int n6;
            ff ff2 = (ff)this.b.get(n5);
            if (ff2 != null && (n6 = ff2.d()) >= n2 && n6 < n4) {
                ff2.b(2);
                this.d(n5);
            }
            --n5;
        }
    }

    void c(ff ff2) {
        bo.a(ff2.a, null);
        this.e(ff2);
        ff2.k = null;
        this.f().a(ff2);
    }

    void c(View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2.a(12) || !ff2.x() || RecyclerView.a(this.c, ff2)) {
            if (ff2.n() && !ff2.q() && !RecyclerView.f(this.c).b()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
            }
            ff2.a(this, false);
            this.a.add(ff2);
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        ff2.a(this, true);
        this.d.add(ff2);
    }

    int d() {
        return this.a.size();
    }

    void d(int n2) {
        this.c((ff)this.b.get(n2));
        this.b.remove(n2);
    }

    void d(ff ff2) {
        if (ff.d(ff2)) {
            this.d.remove(ff2);
        } else {
            this.a.remove(ff2);
        }
        ff.a(ff2, null);
        ff.a(ff2, false);
        ff2.l();
    }

    View e(int n2) {
        return ((ff)this.a.get((int)n2)).a;
    }

    void e() {
        this.a.clear();
        if (this.d == null) return;
        this.d.clear();
    }

    void e(ff ff2) {
        if (RecyclerView.m(this.c) != null) {
            RecyclerView.m(this.c).a(ff2);
        }
        if (RecyclerView.f(this.c) != null) {
            RecyclerView.f(this.c).a(ff2);
        }
        if (this.c.g == null) return;
        this.c.d.g(ff2);
    }

    ev f() {
        if (this.g != null) return this.g;
        this.g = new ev();
        return this.g;
    }

    ff f(int n2) {
        int n3 = 0;
        if (this.d == null) return null;
        int n4 = this.d.size();
        if (n4 == 0) {
            return null;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            ff ff2 = (ff)this.d.get(i2);
            if (ff2.k() || ff2.d() != n2) continue;
            ff2.b(32);
            return ff2;
        }
        if (!RecyclerView.f(this.c).b()) return null;
        int n5 = this.c.b.b(n2);
        if (n5 <= 0) return null;
        if (n5 >= RecyclerView.f(this.c).a()) return null;
        long l2 = RecyclerView.f(this.c).b(n5);
        while (n3 < n4) {
            ff ff3 = (ff)this.d.get(n3);
            if (!ff3.k() && ff3.g() == l2) {
                ff3.b(32);
                return ff3;
            }
            ++n3;
        }
        return null;
    }

    void g() {
        if (RecyclerView.f(this.c) != null && RecyclerView.f(this.c).b()) {
            int n2 = this.b.size();
            int n3 = 0;
            while (n3 < n2) {
                ff ff2 = (ff)this.b.get(n3);
                if (ff2 != null) {
                    ff2.b(6);
                    ff2.a(null);
                }
                ++n3;
            }
            return;
        }
        this.c();
    }

    void h() {
        int n2 = 0;
        int n3 = this.b.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            ((ff)this.b.get(i2)).a();
        }
        int n4 = this.a.size();
        for (int i3 = 0; i3 < n4; ++i3) {
            ((ff)this.a.get(i3)).a();
        }
        if (this.d == null) return;
        int n5 = this.d.size();
        while (n2 < n5) {
            ((ff)this.d.get(n2)).a();
            ++n2;
        }
    }

    void i() {
        int n2 = this.b.size();
        int n3 = 0;
        while (n3 < n2) {
            er er2 = (er)((ff)this.b.get((int)n3)).a.getLayoutParams();
            if (er2 != null) {
                er2.c = true;
            }
            ++n3;
        }
    }
}

