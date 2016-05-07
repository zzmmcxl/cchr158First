/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.h.bo;
import android.support.v4.h.dc;
import android.support.v4.h.dt;
import android.support.v7.widget.ch;
import android.support.v7.widget.ci;
import android.support.v7.widget.cj;
import android.support.v7.widget.ck;
import android.support.v7.widget.cl;
import android.support.v7.widget.cm;
import android.support.v7.widget.cn;
import android.support.v7.widget.co;
import android.support.v7.widget.cp;
import android.support.v7.widget.cq;
import android.support.v7.widget.ff;
import android.support.v7.widget.fw;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class cg
extends fw {
    private ArrayList b = new ArrayList();
    private ArrayList c = new ArrayList();
    private ArrayList d = new ArrayList();
    private ArrayList e = new ArrayList();
    private ArrayList f = new ArrayList();
    private ArrayList g = new ArrayList();
    private ArrayList h = new ArrayList();
    private ArrayList i = new ArrayList();
    private ArrayList j = new ArrayList();
    private ArrayList k = new ArrayList();
    private ArrayList l = new ArrayList();

    static /* synthetic */ ArrayList a(cg cg2) {
        return cg2.g;
    }

    static /* synthetic */ void a(cg cg2, cp cp2) {
        cg2.a(cp2);
    }

    static /* synthetic */ void a(cg cg2, ff ff2) {
        cg2.u(ff2);
    }

    static /* synthetic */ void a(cg cg2, ff ff2, int n2, int n3, int n4, int n5) {
        cg2.b(ff2, n2, n3, n4, n5);
    }

    private void a(cp cp2) {
        ff ff2 = cp2.a;
        View view = ff2 == null ? null : ff2.a;
        ff ff3 = cp2.b;
        View view2 = null;
        if (ff3 != null) {
            view2 = ff3.a;
        }
        if (view != null) {
            dc dc2 = bo.q(view).a(this.g());
            this.l.add(cp2.a);
            dc2.b((float)(cp2.e - cp2.c));
            dc2.c(cp2.f - cp2.d);
            dc2.a(0.0f).a(new cn(this, cp2, dc2)).c();
        }
        if (view2 == null) return;
        dc dc3 = bo.q(view2);
        this.l.add(cp2.b);
        dc3.b(0.0f).c(0.0f).a(this.g()).a(1.0f).a(new co(this, cp2, dc3, view2)).c();
    }

    private void a(List list, ff ff2) {
        int n2 = -1 + list.size();
        while (n2 >= 0) {
            cp cp2 = (cp)list.get(n2);
            if (this.a(cp2, ff2) && cp2.a == null && cp2.b == null) {
                list.remove(cp2);
            }
            --n2;
        }
    }

    private boolean a(cp cp2, ff ff2) {
        boolean bl2 = false;
        if (cp2.b == ff2) {
            cp2.b = null;
        } else {
            ff ff3 = cp2.a;
            boolean bl3 = false;
            if (ff3 != ff2) return bl3;
            cp2.a = null;
            bl2 = true;
        }
        bo.c(ff2.a, 1.0f);
        bo.a(ff2.a, 0.0f);
        bo.b(ff2.a, 0.0f);
        this.a(ff2, bl2);
        return true;
    }

    static /* synthetic */ ArrayList b(cg cg2) {
        return cg2.h;
    }

    private void b(cp cp2) {
        if (cp2.a != null) {
            this.a(cp2, cp2.a);
        }
        if (cp2.b == null) return;
        this.a(cp2, cp2.b);
    }

    private void b(ff ff2, int n2, int n3, int n4, int n5) {
        View view = ff2.a;
        int n6 = n4 - n2;
        int n7 = n5 - n3;
        if (n6 != 0) {
            bo.q(view).b(0.0f);
        }
        if (n7 != 0) {
            bo.q(view).c(0.0f);
        }
        dc dc2 = bo.q(view);
        this.j.add(ff2);
        dc2.a(this.d()).a(new cm(this, ff2, n6, n7, dc2)).c();
    }

    static /* synthetic */ ArrayList c(cg cg2) {
        return cg2.f;
    }

    static /* synthetic */ ArrayList d(cg cg2) {
        return cg2.k;
    }

    static /* synthetic */ void e(cg cg2) {
        cg2.j();
    }

    static /* synthetic */ ArrayList f(cg cg2) {
        return cg2.i;
    }

    static /* synthetic */ ArrayList g(cg cg2) {
        return cg2.j;
    }

    static /* synthetic */ ArrayList h(cg cg2) {
        return cg2.l;
    }

    private void j() {
        if (this.b()) return;
        this.h();
    }

    private void t(ff ff2) {
        dc dc2 = bo.q(ff2.a);
        this.k.add(ff2);
        dc2.a(this.f()).a(0.0f).a(new ck(this, ff2, dc2)).c();
    }

    private void u(ff ff2) {
        dc dc2 = bo.q(ff2.a);
        this.i.add(ff2);
        dc2.a(1.0f).a(this.e()).a(new cl(this, ff2, dc2)).c();
    }

    private void v(ff ff2) {
        a.a(ff2.a);
        this.c(ff2);
    }

    @Override
    public void a() {
        boolean bl2 = !this.b.isEmpty();
        boolean bl3 = !this.d.isEmpty();
        boolean bl4 = !this.e.isEmpty();
        boolean bl5 = !this.c.isEmpty();
        if (!(bl2 || bl3 || bl5 || bl4)) {
            return;
        }
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            this.t((ff)iterator.next());
        }
        this.b.clear();
        if (bl3) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.d);
            this.g.add(arrayList);
            this.d.clear();
            ch ch2 = new ch(this, arrayList);
            if (bl2) {
                bo.a(((cq)arrayList.get((int)0)).a.a, ch2, this.f());
            } else {
                ch2.run();
            }
        }
        if (bl4) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.e);
            this.h.add(arrayList);
            this.e.clear();
            ci ci2 = new ci(this, arrayList);
            if (bl2) {
                bo.a(((cp)arrayList.get((int)0)).a.a, ci2, this.f());
            } else {
                ci2.run();
            }
        }
        if (!bl5) return;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.c);
        this.f.add(arrayList);
        this.c.clear();
        cj cj2 = new cj(this, arrayList);
        if (!(bl2 || bl3 || bl4)) {
            cj2.run();
            return;
        }
        long l2 = bl2 ? this.f() : 0;
        long l3 = bl3 ? this.d() : 0;
        long l4 = bl4 ? this.g() : 0;
        long l5 = l2 + Math.max(l3, l4);
        bo.a(((ff)arrayList.get((int)0)).a, cj2, l5);
    }

    void a(List list) {
        int n2 = -1 + list.size();
        while (n2 >= 0) {
            bo.q(((ff)list.get((int)n2)).a).b();
            --n2;
        }
    }

    @Override
    public boolean a(ff ff2) {
        this.v(ff2);
        this.b.add(ff2);
        return true;
    }

    @Override
    public boolean a(ff ff2, int n2, int n3, int n4, int n5) {
        View view = ff2.a;
        int n6 = (int)((float)n2 + bo.m(ff2.a));
        int n7 = (int)((float)n3 + bo.n(ff2.a));
        this.v(ff2);
        int n8 = n4 - n6;
        int n9 = n5 - n7;
        if (n8 == 0 && n9 == 0) {
            this.i(ff2);
            return false;
        }
        if (n8 != 0) {
            bo.a(view, (float)(- n8));
        }
        if (n9 != 0) {
            bo.b(view, (float)(- n9));
        }
        this.d.add(new cq(ff2, n6, n7, n4, n5, null));
        return true;
    }

    @Override
    public boolean a(ff ff2, ff ff3, int n2, int n3, int n4, int n5) {
        if (ff2 == ff3) {
            return this.a(ff2, n2, n3, n4, n5);
        }
        float f2 = bo.m(ff2.a);
        float f3 = bo.n(ff2.a);
        float f4 = bo.f(ff2.a);
        this.v(ff2);
        int n6 = (int)((float)(n4 - n2) - f2);
        int n7 = (int)((float)(n5 - n3) - f3);
        bo.a(ff2.a, f2);
        bo.b(ff2.a, f3);
        bo.c(ff2.a, f4);
        if (ff3 != null) {
            this.v(ff3);
            bo.a(ff3.a, (float)(- n6));
            bo.b(ff3.a, (float)(- n7));
            bo.c(ff3.a, 0.0f);
        }
        this.e.add(new cp(ff2, ff3, n2, n3, n4, n5, null));
        return true;
    }

    @Override
    public boolean a(ff ff2, List list) {
        if (!list.isEmpty()) return true;
        if (!super.a(ff2, list)) return false;
        return true;
    }

    @Override
    public boolean b() {
        if (!this.c.isEmpty()) return true;
        if (!this.e.isEmpty()) return true;
        if (!this.d.isEmpty()) return true;
        if (!this.b.isEmpty()) return true;
        if (!this.j.isEmpty()) return true;
        if (!this.k.isEmpty()) return true;
        if (!this.i.isEmpty()) return true;
        if (!this.l.isEmpty()) return true;
        if (!this.g.isEmpty()) return true;
        if (!this.f.isEmpty()) return true;
        if (this.h.isEmpty()) return false;
        return true;
    }

    @Override
    public boolean b(ff ff2) {
        this.v(ff2);
        bo.c(ff2.a, 0.0f);
        this.c.add(ff2);
        return true;
    }

    @Override
    public void c() {
        for (int i2 = -1 + this.d.size(); i2 >= 0; --i2) {
            cq cq2 = (cq)this.d.get(i2);
            View view = cq2.a.a;
            bo.b(view, 0.0f);
            bo.a(view, 0.0f);
            this.i(cq2.a);
            this.d.remove(i2);
        }
        for (int i3 = -1 + this.b.size(); i3 >= 0; --i3) {
            this.h((ff)this.b.get(i3));
            this.b.remove(i3);
        }
        for (int i4 = -1 + this.c.size(); i4 >= 0; --i4) {
            ff ff2 = (ff)this.c.get(i4);
            bo.c(ff2.a, 1.0f);
            this.j(ff2);
            this.c.remove(i4);
        }
        for (int i5 = -1 + this.e.size(); i5 >= 0; --i5) {
            this.b((cp)this.e.get(i5));
        }
        this.e.clear();
        if (!this.b()) {
            return;
        }
        for (int i6 = -1 + this.g.size(); i6 >= 0; --i6) {
            ArrayList arrayList = (ArrayList)this.g.get(i6);
            for (int i7 = -1 + arrayList.size(); i7 >= 0; --i7) {
                cq cq3 = (cq)arrayList.get(i7);
                View view = cq3.a.a;
                bo.b(view, 0.0f);
                bo.a(view, 0.0f);
                this.i(cq3.a);
                arrayList.remove(i7);
                if (!arrayList.isEmpty()) continue;
                this.g.remove(arrayList);
            }
        }
        for (int i8 = -1 + this.f.size(); i8 >= 0; --i8) {
            ArrayList arrayList = (ArrayList)this.f.get(i8);
            for (int i9 = -1 + arrayList.size(); i9 >= 0; --i9) {
                ff ff3 = (ff)arrayList.get(i9);
                bo.c(ff3.a, 1.0f);
                this.j(ff3);
                arrayList.remove(i9);
                if (!arrayList.isEmpty()) continue;
                this.f.remove(arrayList);
            }
        }
        int n2 = -1 + this.h.size();
        do {
            if (n2 < 0) {
                this.a(this.k);
                this.a(this.j);
                this.a(this.i);
                this.a(this.l);
                this.h();
                return;
            }
            ArrayList arrayList = (ArrayList)this.h.get(n2);
            for (int i10 = -1 + arrayList.size(); i10 >= 0; --i10) {
                this.b((cp)arrayList.get(i10));
                if (!arrayList.isEmpty()) continue;
                this.h.remove(arrayList);
            }
            --n2;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void c(ff var1_1) {
        var2_2 = var1_1.a;
        bo.q(var2_2).b();
        for (var3_3 = -1 + this.d.size(); var3_3 >= 0; --var3_3) {
            if (((cq)this.d.get((int)var3_3)).a != var1_1) continue;
            bo.b(var2_2, 0.0f);
            bo.a(var2_2, 0.0f);
            this.i(var1_1);
            this.d.remove(var3_3);
        }
        this.a(this.e, var1_1);
        if (this.b.remove(var1_1)) {
            bo.c(var2_2, 1.0f);
            this.h(var1_1);
        }
        if (this.c.remove(var1_1)) {
            bo.c(var2_2, 1.0f);
            this.j(var1_1);
        }
        for (var4_4 = -1 + this.h.size(); var4_4 >= 0; --var4_4) {
            var13_5 = (ArrayList)this.h.get(var4_4);
            this.a(var13_5, var1_1);
            if (!var13_5.isEmpty()) continue;
            this.h.remove(var4_4);
        }
        var5_6 = -1 + this.g.size();
        block2 : do {
            if (var5_6 < 0) {
                for (var6_9 = -1 + this.f.size(); var6_9 >= 0; --var6_9) {
                    var7_10 = (ArrayList)this.f.get(var6_9);
                    if (!var7_10.remove(var1_1)) continue;
                    bo.c(var2_2, 1.0f);
                    this.j(var1_1);
                    if (!var7_10.isEmpty()) continue;
                    this.f.remove(var6_9);
                }
                if (this.k.remove(var1_1)) {
                    // empty if block
                }
                if (this.i.remove(var1_1)) {
                    // empty if block
                }
                if (this.l.remove(var1_1)) {
                    // empty if block
                }
                if (this.j.remove(var1_1)) {
                    // empty if block
                }
                this.j();
                return;
            }
            var9_7 = (ArrayList)this.g.get(var5_6);
            var10_8 = -1 + var9_7.size();
            do {
                if (var10_8 < 0) ** GOTO lbl55
                if (((cq)var9_7.get((int)var10_8)).a == var1_1) {
                    bo.b(var2_2, 0.0f);
                    bo.a(var2_2, 0.0f);
                    this.i(var1_1);
                    var9_7.remove(var10_8);
                    if (var9_7.isEmpty()) {
                        this.g.remove(var5_6);
                    }
lbl55: // 4 sources:
                    --var5_6;
                    continue block2;
                }
                --var10_8;
            } while (true);
            break;
        } while (true);
    }
}

