/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.ae;
import android.support.v4.app.ag;
import android.support.v4.app.aj;
import android.support.v4.app.at;
import android.support.v4.app.au;
import android.support.v4.app.az;
import android.support.v4.app.df;
import android.support.v4.app.o;
import android.support.v4.app.p;
import android.support.v4.app.q;
import android.support.v4.app.r;
import android.support.v4.app.s;
import android.support.v4.app.x;
import android.support.v4.g.a;
import android.support.v4.g.e;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class n
extends at
implements Runnable {
    static final boolean a;
    final aj b;
    r c;
    r d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    boolean m = true;
    String n;
    boolean o;
    int p = -1;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList u;
    ArrayList v;

    static {
        boolean bl2 = Build.VERSION.SDK_INT >= 21;
        a = bl2;
    }

    public n(aj aj2) {
        this.b = aj2;
    }

    private s a(SparseArray sparseArray, SparseArray sparseArray2, boolean bl2) {
        int n2;
        this.a(sparseArray2);
        s s2 = new s(this);
        s2.d = new View(this.b.o.g());
        int n3 = 0;
        boolean bl3 = false;
        do {
            int n4 = sparseArray.size();
            n2 = 0;
            if (n3 >= n4) break;
            boolean bl4 = this.a(sparseArray.keyAt(n3), s2, bl2, sparseArray, sparseArray2) ? true : bl3;
            ++n3;
            bl3 = bl4;
        } while (true);
        do {
            if (n2 >= sparseArray2.size()) {
                if (bl3) return s2;
                return null;
            }
            int n5 = sparseArray2.keyAt(n2);
            if (sparseArray.get(n5) == null && this.a(n5, s2, bl2, sparseArray, sparseArray2)) {
                bl3 = true;
            }
            ++n2;
        } while (true);
    }

    static /* synthetic */ a a(n n2, s s2, boolean bl2, x x2) {
        return n2.a(s2, bl2, x2);
    }

    private a a(s s2, x x2, boolean bl2) {
        a a2 = new a();
        if (this.u != null) {
            au.a(a2, x2.n());
            if (bl2) {
                a2.a(this.v);
            } else {
                a2 = n.a(this.u, this.v, a2);
            }
        }
        if (bl2) {
            if (x2.ag != null) {
                x2.ag.a(this.v, a2);
            }
            this.a(s2, a2, false);
            return a2;
        }
        if (x2.ah != null) {
            x2.ah.a(this.v, a2);
        }
        this.b(s2, a2, false);
        return a2;
    }

    private a a(s s2, boolean bl2, x x2) {
        a a2 = this.b(s2, x2, bl2);
        if (bl2) {
            if (x2.ah != null) {
                x2.ah.a(this.v, a2);
            }
            this.a(s2, a2, true);
            return a2;
        }
        if (x2.ag != null) {
            x2.ag.a(this.v, a2);
        }
        this.b(s2, a2, true);
        return a2;
    }

    private static a a(ArrayList arrayList, ArrayList arrayList2, a a2) {
        if (a2.isEmpty()) {
            return a2;
        }
        a a3 = new a();
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            View view = (View)a2.get(arrayList.get(n3));
            if (view != null) {
                a3.put(arrayList2.get(n3), (Object)view);
            }
            ++n3;
        }
        return a3;
    }

    private static Object a(x x2, x x3, boolean bl2) {
        Object object;
        if (x2 == null) return null;
        if (x3 == null) {
            return null;
        }
        if (bl2) {
            object = x3.y();
            return au.b(object);
        }
        object = x2.x();
        return au.b(object);
    }

    private static Object a(x x2, boolean bl2) {
        Object object;
        if (x2 == null) {
            return null;
        }
        if (bl2) {
            object = x2.w();
            return au.a(object);
        }
        object = x2.t();
        return au.a(object);
    }

    private static Object a(Object object, x x2, ArrayList arrayList, a a2, View view) {
        if (object == null) return object;
        return au.a(object, x2.n(), arrayList, a2, view);
    }

    private void a(int n2, x x2, String string, int n3) {
        x2.B = this.b;
        if (string != null) {
            if (x2.H != null && !string.equals(x2.H)) {
                throw new IllegalStateException("Can't change tag of fragment " + x2 + ": was " + x2.H + " now " + string);
            }
            x2.H = string;
        }
        if (n2 != 0) {
            if (x2.F != 0 && x2.F != n2) {
                throw new IllegalStateException("Can't change container ID of fragment " + x2 + ": was " + x2.F + " now " + n2);
            }
            x2.F = n2;
            x2.G = n2;
        }
        r r2 = new r();
        r2.c = n3;
        r2.d = x2;
        this.a(r2);
    }

    static /* synthetic */ void a(n n2, s s2, int n3, Object object) {
        n2.a(s2, n3, object);
    }

    static /* synthetic */ void a(n n2, s s2, x x2, x x3, boolean bl2, a a2) {
        n2.a(s2, x2, x3, bl2, a2);
    }

    static /* synthetic */ void a(n n2, a a2, s s2) {
        n2.a(a2, s2);
    }

    private void a(s s2, int n2, Object object) {
        if (this.b.g == null) return;
        int n3 = 0;
        while (n3 < this.b.g.size()) {
            x x2 = (x)this.b.g.get(n3);
            if (x2.R != null && x2.Q != null && x2.G == n2) {
                if (x2.I) {
                    if (!s2.b.contains((Object)x2.R)) {
                        au.a(object, x2.R, true);
                        s2.b.add(x2.R);
                    }
                } else {
                    au.a(object, x2.R, false);
                    s2.b.remove((Object)x2.R);
                }
            }
            ++n3;
        }
    }

    private void a(s s2, x x2, x x3, boolean bl2, a a2) {
        df df2 = bl2 ? x3.ag : x2.ag;
        if (df2 == null) return;
        df2.b(new ArrayList(a2.keySet()), new ArrayList(a2.values()), null);
    }

    private void a(s s2, a a2, boolean bl2) {
        int n2 = this.v == null ? 0 : this.v.size();
        int n3 = 0;
        while (n3 < n2) {
            String string = (String)this.u.get(n3);
            View view = (View)a2.get((String)this.v.get(n3));
            if (view != null) {
                String string2 = au.a(view);
                if (bl2) {
                    n.a(s2.a, string, string2);
                } else {
                    n.a(s2.a, string2, string);
                }
            }
            ++n3;
        }
    }

    private void a(s s2, View view, Object object, x x2, x x3, boolean bl2, ArrayList arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new p(this, view, object, arrayList, s2, bl2, x2, x3));
    }

    private static void a(s s2, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList == null) return;
        int n2 = 0;
        while (n2 < arrayList.size()) {
            String string = (String)arrayList.get(n2);
            String string2 = (String)arrayList2.get(n2);
            n.a(s2.a, string, string2);
            ++n2;
        }
    }

    private void a(a a2, s s2) {
        if (this.v == null) return;
        if (a2.isEmpty()) return;
        View view = (View)a2.get(this.v.get(0));
        if (view == null) return;
        s2.c.a = view;
    }

    private static void a(a a2, String string, String string2) {
        if (string == null) return;
        if (string2 == null) return;
        int n2 = 0;
        do {
            if (n2 >= a2.size()) {
                a2.put(string, string2);
                return;
            }
            if (string.equals(a2.c(n2))) {
                a2.a(n2, string2);
                return;
            }
            ++n2;
        } while (true);
    }

    private void a(SparseArray sparseArray) {
        int n2 = sparseArray.size();
        int n3 = 0;
        while (n3 < n2) {
            x x2 = (x)sparseArray.valueAt(n3);
            if (x2.k < 1) {
                this.b.c(x2);
                this.b.a(x2, 1, 0, 0, false);
            }
            ++n3;
        }
    }

    private static void a(SparseArray sparseArray, SparseArray sparseArray2, x x2) {
        if (x2 == null) return;
        int n2 = x2.G;
        if (n2 == 0) return;
        if (x2.m()) return;
        if (x2.k() && x2.n() != null && sparseArray.get(n2) == null) {
            sparseArray.put(n2, (Object)x2);
        }
        if (sparseArray2.get(n2) != x2) return;
        sparseArray2.remove(n2);
    }

    private void a(View view, s s2, int n2, Object object) {
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new q(this, view, s2, n2, object));
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(int var1_1, s var2_2, boolean var3_3, SparseArray var4_4, SparseArray var5_5) {
        var6_6 = (ViewGroup)this.b.p.a(var1_1);
        if (var6_6 == null) {
            return false;
        }
        var7_7 = (x)var5_5.get(var1_1);
        var8_8 = (x)var4_4.get(var1_1);
        var9_9 = n.a(var7_7, var3_3);
        var10_10 = n.a(var7_7, var8_8, var3_3);
        var11_11 = n.b(var8_8, var3_3);
        var12_12 = new ArrayList<E>();
        var13_13 = null;
        if (var10_10 == null) ** GOTO lbl21
        var13_13 = this.a(var2_2, var8_8, var3_3);
        if (var13_13.isEmpty()) {
            var13_13 = null;
            var14_14 = null;
        } else {
            var27_15 = var3_3 != false ? var8_8.ag : var7_7.ag;
            if (var27_15 != null) {
                var27_15.a(new ArrayList<E>(var13_13.keySet()), new ArrayList<E>(var13_13.values()), null);
            }
            this.a(var2_2, (View)var6_6, var10_10, var7_7, var8_8, var3_3, var12_12);
lbl21: // 2 sources:
            var14_14 = var10_10;
        }
        if (var9_9 == null && var14_14 == null && var11_11 == null) {
            return false;
        }
        var15_16 = new ArrayList<E>();
        var16_17 = var2_2.d;
        var17_18 = n.a(var11_11, var8_8, var15_16, var13_13, var16_17);
        if (this.v != null && var13_13 != null && (var26_20 = (View)var13_13.get(var25_19 = this.v.get(0))) != null) {
            if (var17_18 != null) {
                au.a(var17_18, var26_20);
            }
            if (var14_14 != null) {
                au.a(var14_14, var26_20);
            }
        }
        var18_21 = new o(this, var7_7);
        var19_22 = new ArrayList<E>();
        var20_23 = new a();
        var21_24 = true;
        if (var7_7 != null) {
            var21_24 = var3_3 != false ? var7_7.A() : var7_7.z();
        }
        if ((var22_25 = au.a(var9_9, var17_18, var14_14, var21_24)) != null) {
            au.a(var9_9, var14_14, (View)var6_6, var18_21, var2_2.d, var2_2.c, var2_2.a, var19_22, var13_13, var20_23, var12_12);
            this.a((View)var6_6, var2_2, var1_1, var22_25);
            au.a(var22_25, var2_2.d, true);
            this.a(var2_2, var1_1, var22_25);
            au.a(var6_6, var22_25);
            var23_26 = var2_2.d;
            var24_27 = var2_2.b;
            au.a((View)var6_6, var23_26, var9_9, var19_22, var17_18, var15_16, var14_14, var12_12, var22_25, var24_27, var20_23);
        }
        if (var22_25 == null) return false;
        return true;
    }

    private a b(s s2, x x2, boolean bl2) {
        a a2 = new a();
        View view = x2.n();
        if (view == null) return a2;
        if (this.u == null) return a2;
        au.a(a2, view);
        if (bl2) {
            return n.a(this.u, this.v, a2);
        }
        a2.a(this.v);
        return a2;
    }

    private static Object b(x x2, boolean bl2) {
        Object object;
        if (x2 == null) {
            return null;
        }
        if (bl2) {
            object = x2.u();
            return au.a(object);
        }
        object = x2.v();
        return au.a(object);
    }

    private void b(s s2, a a2, boolean bl2) {
        int n2 = a2.size();
        int n3 = 0;
        while (n3 < n2) {
            String string = (String)a2.b(n3);
            String string2 = au.a((View)a2.c(n3));
            if (bl2) {
                n.a(s2.a, string, string2);
            } else {
                n.a(s2.a, string2, string);
            }
            ++n3;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void b(SparseArray var1_1, SparseArray var2_2) {
        if (!this.b.p.a()) {
            return;
        }
        var3_3 = this.c;
        while (var3_3 != null) {
            switch (var3_3.c) {
                case 1: {
                    this.b(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 2: {
                    var4_4 = var3_3.d;
                    if (this.b.g != null) {
                        var5_5 = var4_4;
                        for (var6_6 = 0; var6_6 < this.b.g.size(); ++var6_6) {
                            var7_7 = (x)this.b.g.get(var6_6);
                            if (var5_5 != null && var7_7.G != var5_5.G) continue;
                            if (var7_7 == var5_5) {
                                var5_5 = null;
                                var2_2.remove(var7_7.G);
                                continue;
                            }
                            n.a(var1_1, var2_2, var7_7);
                        }
                    }
                    this.b(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 3: {
                    n.a(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 4: {
                    n.a(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 5: {
                    this.b(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 6: {
                    n.a(var1_1, var2_2, var3_3.d);
                }
lbl35: // 7 sources:
                default: {
                    ** GOTO lbl39
                }
                case 7: 
            }
            this.b(var1_1, var2_2, var3_3.d);
lbl39: // 2 sources:
            var3_3 = var3_3.a;
        }
    }

    private void b(SparseArray sparseArray, SparseArray sparseArray2, x x2) {
        if (x2 == null) return;
        int n2 = x2.G;
        if (n2 == 0) return;
        if (!x2.k()) {
            sparseArray2.put(n2, (Object)x2);
        }
        if (sparseArray.get(n2) != x2) return;
        sparseArray.remove(n2);
    }

    @Override
    public int a() {
        return this.a(false);
    }

    int a(boolean bl2) {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (aj.a) {
            Log.v((String)"FragmentManager", (String)("Commit: " + this));
            this.a("  ", null, new PrintWriter(new e("FragmentManager")), null);
        }
        this.o = true;
        this.p = this.l ? this.b.a(this) : -1;
        this.b.a(this, bl2);
        return this.p;
    }

    @Override
    public at a(x x2) {
        r r2 = new r();
        r2.c = 3;
        r2.d = x2;
        this.a(r2);
        return this;
    }

    @Override
    public at a(x x2, String string) {
        this.a(0, x2, string, 1);
        return this;
    }

    public s a(boolean bl2, s s2, SparseArray sparseArray, SparseArray sparseArray2) {
        if (aj.a) {
            Log.v((String)"FragmentManager", (String)("popFromBackStack: " + this));
            this.a("  ", null, new PrintWriter(new e("FragmentManager")), null);
        }
        if (a) {
            if (s2 == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    s2 = this.a(sparseArray, sparseArray2, true);
                }
            } else if (!bl2) {
                n.a(s2, this.v, this.u);
            }
        }
        this.a(-1);
        int n2 = s2 != null ? 0 : this.k;
        int n3 = s2 != null ? 0 : this.j;
        r r2 = this.d;
        while (r2 != null) {
            int n4 = s2 != null ? 0 : r2.g;
            int n5 = s2 != null ? 0 : r2.h;
            switch (r2.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + r2.c);
                }
                case 1: {
                    x x2 = r2.d;
                    x2.P = n5;
                    this.b.a(x2, aj.c(n3), n2);
                    break;
                }
                case 2: {
                    x x3 = r2.d;
                    if (x3 != null) {
                        x3.P = n5;
                        this.b.a(x3, aj.c(n3), n2);
                    }
                    if (r2.i == null) break;
                    for (int i2 = 0; i2 < r2.i.size(); ++i2) {
                        x x4 = (x)r2.i.get(i2);
                        x4.P = n4;
                        this.b.a(x4, false);
                    }
                    break;
                }
                case 3: {
                    x x5 = r2.d;
                    x5.P = n4;
                    this.b.a(x5, false);
                    break;
                }
                case 4: {
                    x x6 = r2.d;
                    x6.P = n4;
                    this.b.c(x6, aj.c(n3), n2);
                    break;
                }
                case 5: {
                    x x7 = r2.d;
                    x7.P = n5;
                    this.b.b(x7, aj.c(n3), n2);
                    break;
                }
                case 6: {
                    x x8 = r2.d;
                    x8.P = n4;
                    this.b.e(x8, aj.c(n3), n2);
                    break;
                }
                case 7: {
                    x x9 = r2.d;
                    x9.P = n4;
                    this.b.d(x9, aj.c(n3), n2);
                }
            }
            r2 = r2.b;
        }
        if (bl2) {
            this.b.a(this.b.n, aj.c(n3), n2, true);
            s2 = null;
        }
        if (this.p < 0) return s2;
        this.b.b(this.p);
        this.p = -1;
        return s2;
    }

    void a(int n2) {
        if (!this.l) {
            return;
        }
        if (aj.a) {
            Log.v((String)"FragmentManager", (String)("Bump nesting in " + this + " by " + n2));
        }
        r r2 = this.c;
        while (r2 != null) {
            if (r2.d != null) {
                x x2 = r2.d;
                x2.A = n2 + x2.A;
                if (aj.a) {
                    Log.v((String)"FragmentManager", (String)("Bump nesting of " + r2.d + " to " + r2.d.A));
                }
            }
            if (r2.i != null) {
                for (int i2 = -1 + r2.i.size(); i2 >= 0; --i2) {
                    x x3 = (x)r2.i.get(i2);
                    x3.A = n2 + x3.A;
                    if (!aj.a) continue;
                    Log.v((String)"FragmentManager", (String)("Bump nesting of " + x3 + " to " + x3.A));
                }
            }
            r2 = r2.a;
        }
    }

    void a(r r2) {
        if (this.c == null) {
            this.d = r2;
            this.c = r2;
        } else {
            r2.b = this.d;
            this.d.a = r2;
            this.d = r2;
        }
        r2.e = this.f;
        r2.f = this.g;
        r2.g = this.h;
        r2.h = this.i;
        this.e = 1 + this.e;
    }

    /*
     * Unable to fully structure code
     */
    public void a(SparseArray var1_1, SparseArray var2_2) {
        if (!this.b.p.a()) {
            return;
        }
        var3_3 = this.d;
        while (var3_3 != null) {
            switch (var3_3.c) {
                case 1: {
                    n.a(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 2: {
                    if (var3_3.i != null) {
                        for (var4_4 = -1 + var3_3.i.size(); var4_4 >= 0; --var4_4) {
                            this.b(var1_1, var2_2, (x)var3_3.i.get(var4_4));
                        }
                    }
                    n.a(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 3: {
                    this.b(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 4: {
                    this.b(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 5: {
                    n.a(var1_1, var2_2, var3_3.d);
                    ** break;
                }
                case 6: {
                    this.b(var1_1, var2_2, var3_3.d);
                }
lbl27: // 7 sources:
                default: {
                    ** GOTO lbl31
                }
                case 7: 
            }
            n.a(var1_1, var2_2, var3_3.d);
lbl31: // 2 sources:
            var3_3 = var3_3.b;
        }
    }

    public void a(String string, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.a(string, printWriter, true);
    }

    public void a(String string, PrintWriter printWriter, boolean bl2) {
        if (bl2) {
            printWriter.print(string);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(string);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(string);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.h != 0 || this.i != 0) {
                printWriter.print(string);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (this.q != 0 || this.r != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (this.s != 0 || this.t != null) {
                printWriter.print(string);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.c == null) return;
        printWriter.print(string);
        printWriter.println("Operations:");
        String string2 = string + "    ";
        r r2 = this.c;
        int n2 = 0;
        r r3 = r2;
        while (r3 != null) {
            String string3;
            switch (r3.c) {
                default: {
                    string3 = "cmd=" + r3.c;
                    break;
                }
                case 0: {
                    string3 = "NULL";
                    break;
                }
                case 1: {
                    string3 = "ADD";
                    break;
                }
                case 2: {
                    string3 = "REPLACE";
                    break;
                }
                case 3: {
                    string3 = "REMOVE";
                    break;
                }
                case 4: {
                    string3 = "HIDE";
                    break;
                }
                case 5: {
                    string3 = "SHOW";
                    break;
                }
                case 6: {
                    string3 = "DETACH";
                    break;
                }
                case 7: {
                    string3 = "ATTACH";
                }
            }
            printWriter.print(string);
            printWriter.print("  Op #");
            printWriter.print(n2);
            printWriter.print(": ");
            printWriter.print(string3);
            printWriter.print(" ");
            printWriter.println(r3.d);
            if (bl2) {
                if (r3.e != 0 || r3.f != 0) {
                    printWriter.print(string);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(r3.e));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(r3.f));
                }
                if (r3.g != 0 || r3.h != 0) {
                    printWriter.print(string);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(r3.g));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(r3.h));
                }
            }
            if (r3.i != null && r3.i.size() > 0) {
                for (int i2 = 0; i2 < r3.i.size(); ++i2) {
                    printWriter.print(string2);
                    if (r3.i.size() == 1) {
                        printWriter.print("Removed: ");
                    } else {
                        if (i2 == 0) {
                            printWriter.println("Removed:");
                        }
                        printWriter.print(string2);
                        printWriter.print("  #");
                        printWriter.print(i2);
                        printWriter.print(": ");
                    }
                    printWriter.println(r3.i.get(i2));
                }
            }
            r3 = r3.a;
            ++n2;
        }
    }

    @Override
    public int b() {
        return this.a(true);
    }

    public String c() {
        return this.n;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void run() {
        if (aj.a) {
            Log.v((String)"FragmentManager", (String)("Run: " + this));
        }
        if (this.l && this.p < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        this.a(1);
        if (n.a) {
            var1_1 = new SparseArray();
            var2_2 = new SparseArray();
            this.b(var1_1, var2_2);
            var3_3 = this.a(var1_1, var2_2, false);
        } else {
            var3_3 = null;
        }
        var4_4 = var3_3 != null ? 0 : this.k;
        var5_5 = var3_3 != null ? 0 : this.j;
        var6_6 = this.c;
        do {
            if (var6_6 == null) {
                this.b.a(this.b.n, var5_5, var4_4, true);
                if (this.l == false) return;
                this.b.b(this);
                return;
            }
            var7_7 = var3_3 != null ? 0 : var6_6.e;
            var8_8 = var3_3 != null ? 0 : var6_6.f;
            switch (var6_6.c) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + var6_6.c);
                }
                case 1: {
                    var22_19 = var6_6.d;
                    var22_19.P = var7_7;
                    this.b.a(var22_19, false);
                    break;
                }
                case 2: {
                    var14_14 = var6_6.d;
                    var15_15 = var14_14.G;
                    if (this.b.g == null) ** GOTO lbl57
                    for (var16_16 = -1 + this.b.g.size(); var16_16 >= 0; --var16_16) {
                        var17_17 = (x)this.b.g.get(var16_16);
                        if (aj.a) {
                            Log.v((String)"FragmentManager", (String)("OP_REPLACE: adding=" + var14_14 + " old=" + var17_17));
                        }
                        if (var17_17.G != var15_15) ** GOTO lbl54
                        if (var17_17 == var14_14) {
                            var18_18 = null;
                            var6_6.d = null;
                        } else {
                            if (var6_6.i == null) {
                                var6_6.i = new ArrayList<E>();
                            }
                            var6_6.i.add(var17_17);
                            var17_17.P = var8_8;
                            if (this.l) {
                                var17_17.A = 1 + var17_17.A;
                                if (aj.a) {
                                    Log.v((String)"FragmentManager", (String)("Bump nesting of " + var17_17 + " to " + var17_17.A));
                                }
                            }
                            this.b.a(var17_17, var5_5, var4_4);
lbl54: // 2 sources:
                            var18_18 = var14_14;
                        }
                        var14_14 = var18_18;
                    }
lbl57: // 2 sources:
                    if (var14_14 == null) break;
                    var14_14.P = var7_7;
                    this.b.a(var14_14, false);
                    break;
                }
                case 3: {
                    var13_13 = var6_6.d;
                    var13_13.P = var8_8;
                    this.b.a(var13_13, var5_5, var4_4);
                    break;
                }
                case 4: {
                    var12_12 = var6_6.d;
                    var12_12.P = var8_8;
                    this.b.b(var12_12, var5_5, var4_4);
                    break;
                }
                case 5: {
                    var11_11 = var6_6.d;
                    var11_11.P = var7_7;
                    this.b.c(var11_11, var5_5, var4_4);
                    break;
                }
                case 6: {
                    var10_10 = var6_6.d;
                    var10_10.P = var8_8;
                    this.b.d(var10_10, var5_5, var4_4);
                    break;
                }
                case 7: {
                    var9_9 = var6_6.d;
                    var9_9.P = var7_7;
                    this.b.e(var9_9, var5_5, var4_4);
                }
            }
            var6_6 = var6_6.a;
        } while (true);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.p);
        }
        if (this.n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

