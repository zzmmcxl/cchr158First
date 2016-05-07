/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.g.a;
import android.support.v4.g.f;
import android.support.v7.widget.em;
import android.support.v7.widget.ff;
import android.support.v7.widget.gw;
import android.support.v7.widget.gx;

class gv {
    final a a = new a();
    final f b = new f();

    gv() {
    }

    private em a(ff ff2, int n2) {
        int n3 = this.a.a(ff2);
        em em2 = null;
        if (n3 < 0) {
            return em2;
        }
        gw gw2 = (gw)this.a.c(n3);
        em2 = null;
        if (gw2 == null) return em2;
        int n4 = n2 & gw2.a;
        em2 = null;
        if (n4 == 0) return em2;
        gw2.a &= ~ n2;
        if (n2 == 4) {
            em2 = gw2.b;
        } else {
            if (n2 != 8) throw new IllegalArgumentException("Must provide flag PRE or POST");
            em2 = gw2.c;
        }
        if ((12 & gw2.a) != 0) return em2;
        this.a.d(n3);
        gw.a(gw2);
        return em2;
    }

    ff a(long l2) {
        return (ff)this.b.a(l2);
    }

    void a() {
        this.a.clear();
        this.b.c();
    }

    void a(long l2, ff ff2) {
        this.b.b(l2, ff2);
    }

    void a(ff ff2, em em2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) {
            gw2 = gw.a();
            this.a.put(ff2, gw2);
        }
        gw2.b = em2;
        gw2.a = 4 | gw2.a;
    }

    void a(gx gx2) {
        int n2 = -1 + this.a.size();
        while (n2 >= 0) {
            ff ff2 = (ff)this.a.b(n2);
            gw gw2 = (gw)this.a.d(n2);
            if ((3 & gw2.a) == 3) {
                gx2.a(ff2);
            } else if ((1 & gw2.a) != 0) {
                gx2.a(ff2, gw2.b, gw2.c);
            } else if ((14 & gw2.a) == 14) {
                gx2.b(ff2, gw2.b, gw2.c);
            } else if ((12 & gw2.a) == 12) {
                gx2.c(ff2, gw2.b, gw2.c);
            } else if ((4 & gw2.a) != 0) {
                gx2.a(ff2, gw2.b, null);
            } else if ((8 & gw2.a) != 0) {
                gx2.b(ff2, gw2.b, gw2.c);
            } else if ((2 & gw2.a) != 0) {
                // empty if block
            }
            gw.a(gw2);
            --n2;
        }
    }

    boolean a(ff ff2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) return false;
        if ((1 & gw2.a) == 0) return false;
        return true;
    }

    em b(ff ff2) {
        return this.a(ff2, 4);
    }

    void b() {
        gw.b();
    }

    void b(ff ff2, em em2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) {
            gw2 = gw.a();
            this.a.put(ff2, gw2);
        }
        gw2.a = 2 | gw2.a;
        gw2.b = em2;
    }

    em c(ff ff2) {
        return this.a(ff2, 8);
    }

    void c(ff ff2, em em2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) {
            gw2 = gw.a();
            this.a.put(ff2, gw2);
        }
        gw2.c = em2;
        gw2.a = 8 | gw2.a;
    }

    boolean d(ff ff2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) return false;
        if ((4 & gw2.a) == 0) return false;
        return true;
    }

    void e(ff ff2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) {
            gw2 = gw.a();
            this.a.put(ff2, gw2);
        }
        gw2.a = 1 | gw2.a;
    }

    void f(ff ff2) {
        gw gw2 = (gw)this.a.get(ff2);
        if (gw2 == null) {
            return;
        }
        gw2.a = -2 & gw2.a;
    }

    /*
     * Unable to fully structure code
     */
    void g(ff var1_1) {
        var2_2 = -1 + this.b.b();
        do {
            if (var2_2 < 0) ** GOTO lbl6
            if (var1_1 == this.b.c(var2_2)) {
                this.b.a(var2_2);
lbl6: // 2 sources:
                if ((var3_3 = (gw)this.a.remove(var1_1)) == null) return;
                gw.a(var3_3);
                return;
            }
            --var2_2;
        } while (true);
    }

    public void h(ff ff2) {
        this.f(ff2);
    }
}

