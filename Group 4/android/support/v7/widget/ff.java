/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.support.v4.h.bo;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ff {
    private static final List m = Collections.EMPTY_LIST;
    public final View a;
    int b;
    int c;
    long d;
    int e;
    int f;
    ff g;
    ff h;
    List i;
    List j;
    RecyclerView k;
    private int l;
    private int n;
    private ew o;
    private boolean p;
    private int q;

    private void A() {
        bo.c(this.a, this.q);
        this.q = 0;
    }

    private boolean B() {
        if ((16 & this.l) == 0) return false;
        return true;
    }

    private boolean C() {
        if ((16 & this.l) != 0) return false;
        if (!bo.c(this.a)) return false;
        return true;
    }

    static /* synthetic */ ew a(ff ff2, ew ew2) {
        ff2.o = ew2;
        return ew2;
    }

    static /* synthetic */ void a(ff ff2) {
        ff2.z();
    }

    static /* synthetic */ boolean a(ff ff2, boolean bl2) {
        ff2.p = bl2;
        return bl2;
    }

    static /* synthetic */ void b(ff ff2) {
        ff2.A();
    }

    static /* synthetic */ boolean c(ff ff2) {
        return ff2.C();
    }

    static /* synthetic */ boolean d(ff ff2) {
        return ff2.p;
    }

    static /* synthetic */ boolean e(ff ff2) {
        return ff2.B();
    }

    static /* synthetic */ int f(ff ff2) {
        return ff2.l;
    }

    private void y() {
        if (this.i != null) return;
        this.i = new ArrayList();
        this.j = Collections.unmodifiableList(this.i);
    }

    private void z() {
        this.q = bo.e(this.a);
        bo.c(this.a, 4);
    }

    void a() {
        this.c = -1;
        this.f = -1;
    }

    void a(int n2, int n3) {
        this.l = this.l & ~ n3 | n2 & n3;
    }

    void a(int n2, int n3, boolean bl2) {
        this.b(8);
        this.a(n3, bl2);
        this.b = n2;
    }

    void a(int n2, boolean bl2) {
        if (this.c == -1) {
            this.c = this.b;
        }
        if (this.f == -1) {
            this.f = this.b;
        }
        if (bl2) {
            this.f = n2 + this.f;
        }
        this.b = n2 + this.b;
        if (this.a.getLayoutParams() == null) return;
        ((er)this.a.getLayoutParams()).c = true;
    }

    void a(ew ew2, boolean bl2) {
        this.o = ew2;
        this.p = bl2;
    }

    void a(Object object) {
        if (object == null) {
            this.b(1024);
            return;
        }
        if ((1024 & this.l) != 0) return;
        this.y();
        this.i.add(object);
    }

    public final void a(boolean bl2) {
        int n2 = bl2 ? -1 + this.n : 1 + this.n;
        this.n = n2;
        if (this.n < 0) {
            this.n = 0;
            Log.e((String)"View", (String)("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this));
            return;
        }
        if (!bl2 && this.n == 1) {
            this.l = 16 | this.l;
            return;
        }
        if (!bl2) return;
        if (this.n != 0) return;
        this.l = -17 & this.l;
    }

    boolean a(int n2) {
        if ((n2 & this.l) == 0) return false;
        return true;
    }

    void b() {
        if (this.c != -1) return;
        this.c = this.b;
    }

    void b(int n2) {
        this.l = n2 | this.l;
    }

    boolean c() {
        if ((128 & this.l) == 0) return false;
        return true;
    }

    public final int d() {
        if (this.f != -1) return this.f;
        return this.b;
    }

    public final int e() {
        if (this.k != null) return RecyclerView.b(this.k, this);
        return -1;
    }

    public final int f() {
        return this.c;
    }

    public final long g() {
        return this.d;
    }

    public final int h() {
        return this.e;
    }

    boolean i() {
        if (this.o == null) return false;
        return true;
    }

    void j() {
        this.o.d(this);
    }

    boolean k() {
        if ((32 & this.l) == 0) return false;
        return true;
    }

    void l() {
        this.l = -33 & this.l;
    }

    void m() {
        this.l = -257 & this.l;
    }

    boolean n() {
        if ((4 & this.l) == 0) return false;
        return true;
    }

    boolean o() {
        if ((2 & this.l) == 0) return false;
        return true;
    }

    boolean p() {
        if ((1 & this.l) == 0) return false;
        return true;
    }

    boolean q() {
        if ((8 & this.l) == 0) return false;
        return true;
    }

    boolean r() {
        if ((256 & this.l) == 0) return false;
        return true;
    }

    boolean s() {
        if ((512 & this.l) != 0) return true;
        if (!this.n()) return false;
        return true;
    }

    void t() {
        if (this.i != null) {
            this.i.clear();
        }
        this.l = -1025 & this.l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ViewHolder{" + Integer.toHexString(this.hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
        if (this.i()) {
            StringBuilder stringBuilder2 = stringBuilder.append(" scrap ");
            String string = this.p ? "[changeScrap]" : "[attachedScrap]";
            stringBuilder2.append(string);
        }
        if (this.n()) {
            stringBuilder.append(" invalid");
        }
        if (!this.p()) {
            stringBuilder.append(" unbound");
        }
        if (this.o()) {
            stringBuilder.append(" update");
        }
        if (this.q()) {
            stringBuilder.append(" removed");
        }
        if (this.c()) {
            stringBuilder.append(" ignored");
        }
        if (this.r()) {
            stringBuilder.append(" tmpDetached");
        }
        if (!this.w()) {
            stringBuilder.append(" not recyclable(" + this.n + ")");
        }
        if (this.s()) {
            stringBuilder.append(" undefined adapter position");
        }
        if (this.a.getParent() == null) {
            stringBuilder.append(" no parent");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    List u() {
        if ((1024 & this.l) != 0) return m;
        if (this.i == null) return m;
        if (this.i.size() != 0) return this.j;
        return m;
    }

    void v() {
        this.l = 0;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = -1;
        this.n = 0;
        this.g = null;
        this.h = null;
        this.t();
        this.q = 0;
    }

    public final boolean w() {
        if ((16 & this.l) != 0) return false;
        if (bo.c(this.a)) return false;
        return true;
    }

    boolean x() {
        if ((2 & this.l) == 0) return false;
        return true;
    }
}

