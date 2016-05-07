/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.g.o;
import android.support.v4.g.p;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.support.v7.widget.du;
import android.support.v7.widget.dv;
import android.support.v7.widget.ff;
import java.util.ArrayList;
import java.util.List;

class ai
implements dv {
    final ArrayList a = new ArrayList();
    final ArrayList b = new ArrayList();
    final aj c;
    Runnable d;
    final boolean e;
    final du f;
    private o g = new p(30);
    private int h = 0;

    ai(aj aj2) {
        this(aj2, false);
    }

    ai(aj aj2, boolean bl2) {
        this.c = aj2;
        this.e = bl2;
        this.f = new du(this);
    }

    /*
     * Unable to fully structure code
     */
    private int b(int var1_1, int var2_2) {
        var4_4 = var1_1;
        for (var3_3 = -1 + this.b.size(); var3_3 >= 0; --var3_3) {
            var9_5 = (ak)this.b.get(var3_3);
            if (var9_5.a != 8) ** GOTO lbl39
            if (var9_5.b < var9_5.d) {
                var10_6 = var9_5.b;
                var11_7 = var9_5.d;
            } else {
                var10_6 = var9_5.d;
                var11_7 = var9_5.b;
            }
            if (var4_4 < var10_6 || var4_4 > var11_7) ** GOTO lbl27
            if (var10_6 == var9_5.b) {
                if (var2_2 == 1) {
                    var9_5.d = 1 + var9_5.d;
                } else if (var2_2 == 2) {
                    var9_5.d = -1 + var9_5.d;
                }
                var12_8 = var4_4 + 1;
            } else {
                if (var2_2 == 1) {
                    var9_5.b = 1 + var9_5.b;
                } else if (var2_2 == 2) {
                    var9_5.b = -1 + var9_5.b;
                }
                var12_8 = var4_4 - 1;
            }
            ** GOTO lbl37
lbl27: // 1 sources:
            if (var4_4 >= var9_5.b) ** GOTO lbl36
            if (var2_2 == 1) {
                var9_5.b = 1 + var9_5.b;
                var9_5.d = 1 + var9_5.d;
                var12_8 = var4_4;
            } else {
                if (var2_2 == 2) {
                    var9_5.b = -1 + var9_5.b;
                    var9_5.d = -1 + var9_5.d;
                }
lbl36: // 4 sources:
                var12_8 = var4_4;
            }
lbl37: // 4 sources:
            var4_4 = var12_8;
            continue;
lbl39: // 1 sources:
            if (var9_5.b <= var4_4) {
                if (var9_5.a == 1) {
                    var4_4 -= var9_5.d;
                    continue;
                }
                if (var9_5.a != 2) continue;
                var4_4 += var9_5.d;
                continue;
            }
            if (var2_2 == 1) {
                var9_5.b = 1 + var9_5.b;
                continue;
            }
            if (var2_2 != 2) continue;
            var9_5.b = -1 + var9_5.b;
        }
        var5_9 = -1 + this.b.size();
        while (var5_9 >= 0) {
            var6_10 = (ak)this.b.get(var5_9);
            if (var6_10.a == 8) {
                if (var6_10.d == var6_10.b || var6_10.d < 0) {
                    this.b.remove(var5_9);
                    this.a(var6_10);
                }
            } else if (var6_10.d <= 0) {
                this.b.remove(var5_9);
                this.a(var6_10);
            }
            --var5_9;
        }
        return var4_4;
    }

    private void b(ak ak2) {
        this.g(ak2);
    }

    private void c(ak ak2) {
        int n2 = ak2.b;
        int n3 = ak2.b + ak2.d;
        int n4 = -1;
        int n5 = ak2.b;
        int n6 = 0;
        while (n5 < n3) {
            int n7;
            int n8;
            boolean bl2;
            int n9;
            if (this.c.a(n5) != null || this.d(n5)) {
                if (n4 == 0) {
                    this.e(this.a(2, n2, n6, null));
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                n4 = 1;
            } else {
                if (n4 == 1) {
                    this.g(this.a(2, n2, n6, null));
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                n4 = 0;
            }
            if (bl2) {
                n7 = n5 - n6;
                n8 = n3 - n6;
                n9 = 1;
            } else {
                int n10 = n6 + 1;
                int n11 = n5;
                n8 = n3;
                n9 = n10;
                n7 = n11;
            }
            int n12 = n7 + 1;
            n6 = n9;
            n3 = n8;
            n5 = n12;
        }
        if (n6 != ak2.d) {
            this.a(ak2);
            ak2 = this.a(2, n2, n6, null);
        }
        if (n4 == 0) {
            this.e(ak2);
            return;
        }
        this.g(ak2);
    }

    private void d(ak ak2) {
        int n2 = ak2.b;
        int n3 = ak2.b + ak2.d;
        int n4 = -1;
        int n5 = 0;
        for (int i2 = ak2.b; i2 < n3; ++i2) {
            int n6;
            int n7;
            int n8;
            if (this.c.a(i2) != null || this.d(i2)) {
                if (n4 == 0) {
                    this.e(this.a(4, n2, n5, ak2.c));
                    n5 = 0;
                    n2 = i2;
                }
                n8 = n2;
                n7 = n5;
                n6 = 1;
            } else {
                if (n4 == 1) {
                    this.g(this.a(4, n2, n5, ak2.c));
                    n5 = 0;
                    n2 = i2;
                }
                n8 = n2;
                n7 = n5;
                n6 = 0;
            }
            int n9 = n7 + 1;
            int n10 = n6;
            n5 = n9;
            n2 = n8;
            n4 = n10;
        }
        if (n5 != ak2.d) {
            Object object = ak2.c;
            this.a(ak2);
            ak2 = this.a(4, n2, n5, object);
        }
        if (n4 == 0) {
            this.e(ak2);
            return;
        }
        this.g(ak2);
    }

    private boolean d(int n2) {
        int n3 = this.b.size();
        int n4 = 0;
        while (n4 < n3) {
            ak ak2 = (ak)this.b.get(n4);
            if (ak2.a == 8) {
                if (this.a(ak2.d, n4 + 1) == n2) {
                    return true;
                }
            } else if (ak2.a == 1) {
                int n5 = ak2.b + ak2.d;
                for (int i2 = ak2.b; i2 < n5; ++i2) {
                    if (this.a(i2, n4 + 1) != n2) continue;
                    return true;
                }
            }
            ++n4;
        }
        return false;
    }

    private void e(ak ak2) {
        int n2;
        if (ak2.a == 1) throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        if (ak2.a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int n3 = this.b(ak2.b, ak2.a);
        int n4 = ak2.b;
        switch (ak2.a) {
            default: {
                throw new IllegalArgumentException("op should be remove or update." + ak2);
            }
            case 4: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 0;
                break;
            }
        }
        int n5 = 1;
        int n6 = n3;
        int n7 = n4;
        for (int i2 = 1; i2 < ak2.d; ++i2) {
            boolean bl2;
            int n8 = this.b(ak2.b + n2 * i2, ak2.a);
            switch (ak2.a) {
                default: {
                    bl2 = false;
                    break;
                }
                case 4: {
                    if (n8 == n6 + 1) {
                        bl2 = true;
                        break;
                    }
                    bl2 = false;
                    break;
                }
                case 2: {
                    bl2 = n8 == n6;
                }
            }
            if (bl2) {
                ++n5;
                continue;
            }
            ak ak3 = this.a(ak2.a, n6, n5, ak2.c);
            this.a(ak3, n7);
            this.a(ak3);
            if (ak2.a == 4) {
                n7 += n5;
            }
            n5 = 1;
            n6 = n8;
        }
        Object object = ak2.c;
        this.a(ak2);
        if (n5 <= 0) return;
        ak ak4 = this.a(ak2.a, n6, n5, object);
        this.a(ak4, n7);
        this.a(ak4);
    }

    private void f(ak ak2) {
        this.g(ak2);
    }

    private void g(ak ak2) {
        this.b.add(ak2);
        switch (ak2.a) {
            default: {
                throw new IllegalArgumentException("Unknown update op type for " + ak2);
            }
            case 1: {
                this.c.c(ak2.b, ak2.d);
                return;
            }
            case 8: {
                this.c.d(ak2.b, ak2.d);
                return;
            }
            case 2: {
                this.c.b(ak2.b, ak2.d);
                return;
            }
            case 4: 
        }
        this.c.a(ak2.b, ak2.d, ak2.c);
    }

    int a(int n2, int n3) {
        int n4 = this.b.size();
        int n5 = n2;
        while (n3 < n4) {
            ak ak2 = (ak)this.b.get(n3);
            if (ak2.a == 8) {
                if (ak2.b == n5) {
                    n5 = ak2.d;
                } else {
                    if (ak2.b < n5) {
                        --n5;
                    }
                    if (ak2.d <= n5) {
                        ++n5;
                    }
                }
            } else if (ak2.b <= n5) {
                if (ak2.a == 2) {
                    if (n5 < ak2.b + ak2.d) {
                        return -1;
                    }
                    n5 -= ak2.d;
                } else if (ak2.a == 1) {
                    n5 += ak2.d;
                }
            }
            ++n3;
        }
        return n5;
    }

    @Override
    public ak a(int n2, int n3, int n4, Object object) {
        ak ak2 = (ak)this.g.a();
        if (ak2 == null) {
            return new ak(n2, n3, n4, object);
        }
        ak2.a = n2;
        ak2.b = n3;
        ak2.d = n4;
        ak2.c = object;
        return ak2;
    }

    void a() {
        this.a(this.a);
        this.a(this.b);
        this.h = 0;
    }

    @Override
    public void a(ak ak2) {
        if (this.e) return;
        ak2.c = null;
        this.g.a(ak2);
    }

    void a(ak ak2, int n2) {
        this.c.a(ak2);
        switch (ak2.a) {
            default: {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            case 2: {
                this.c.a(n2, ak2.d);
                return;
            }
            case 4: 
        }
        this.c.a(n2, ak2.d, ak2.c);
    }

    void a(List list) {
        int n2 = list.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                list.clear();
                return;
            }
            this.a((ak)list.get(n3));
            ++n3;
        } while (true);
    }

    boolean a(int n2) {
        if ((n2 & this.h) == 0) return false;
        return true;
    }

    int b(int n2) {
        return this.a(n2, 0);
    }

    /*
     * Unable to fully structure code
     */
    void b() {
        this.f.a(this.a);
        var1_1 = this.a.size();
        var2_2 = 0;
        do {
            if (var2_2 >= var1_1) {
                this.a.clear();
                return;
            }
            var3_3 = (ak)this.a.get(var2_2);
            switch (var3_3.a) {
                case 1: {
                    this.f(var3_3);
                    ** break;
                }
                case 2: {
                    this.c(var3_3);
                    ** break;
                }
                case 4: {
                    this.d(var3_3);
                }
lbl18: // 4 sources:
                default: {
                    ** GOTO lbl22
                }
                case 8: 
            }
            this.b(var3_3);
lbl22: // 2 sources:
            if (this.d != null) {
                this.d.run();
            }
            ++var2_2;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    public int c(int var1_1) {
        var2_2 = this.a.size();
        var3_3 = 0;
        var4_4 = var1_1;
        while (var3_3 < var2_2) {
            var5_5 = (ak)this.a.get(var3_3);
            switch (var5_5.a) {
                case 1: {
                    if (var5_5.b <= var4_4) {
                        var4_4 += var5_5.d;
                        ** break;
                    }
                    ** GOTO lbl17
                }
                case 2: {
                    if (var5_5.b <= var4_4) {
                        if (var5_5.b + var5_5.d > var4_4) {
                            return -1;
                        }
                        var4_4 -= var5_5.d;
                    }
                }
lbl17: // 6 sources:
                default: {
                    ** GOTO lbl27
                }
                case 8: 
            }
            if (var5_5.b == var4_4) {
                var4_4 = var5_5.d;
            } else {
                if (var5_5.b < var4_4) {
                    --var4_4;
                }
                if (var5_5.d <= var4_4) {
                    ++var4_4;
                }
            }
lbl27: // 5 sources:
            ++var3_3;
        }
        return var4_4;
    }

    void c() {
        int n2 = this.b.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.a(this.b);
                this.h = 0;
                return;
            }
            this.c.b((ak)this.b.get(n3));
            ++n3;
        } while (true);
    }

    boolean d() {
        if (this.a.size() <= 0) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    void e() {
        this.c();
        var1_1 = this.a.size();
        var2_2 = 0;
        do {
            if (var2_2 >= var1_1) {
                this.a(this.a);
                this.h = 0;
                return;
            }
            var3_3 = (ak)this.a.get(var2_2);
            switch (var3_3.a) {
                case 1: {
                    this.c.b(var3_3);
                    this.c.c(var3_3.b, var3_3.d);
                    ** break;
                }
                case 2: {
                    this.c.b(var3_3);
                    this.c.a(var3_3.b, var3_3.d);
                    ** break;
                }
                case 4: {
                    this.c.b(var3_3);
                    this.c.a(var3_3.b, var3_3.d, var3_3.c);
                }
lbl22: // 4 sources:
                default: {
                    ** GOTO lbl27
                }
                case 8: 
            }
            this.c.b(var3_3);
            this.c.d(var3_3.b, var3_3.d);
lbl27: // 2 sources:
            if (this.d != null) {
                this.d.run();
            }
            ++var2_2;
        } while (true);
    }

    boolean f() {
        if (this.b.isEmpty()) return false;
        if (this.a.isEmpty()) return false;
        return true;
    }
}

