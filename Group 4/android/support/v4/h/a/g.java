/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h.a;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.h.a.h;
import android.support.v4.h.a.i;
import android.support.v4.h.a.j;
import android.support.v4.h.a.k;
import android.support.v4.h.a.l;
import android.support.v4.h.a.m;
import android.support.v4.h.a.n;
import android.support.v4.h.a.o;
import android.support.v4.h.a.p;
import android.support.v4.h.a.q;
import android.support.v4.h.a.r;

public class g {
    private static final k a;
    private final Object b;

    static {
        if (Build.VERSION.SDK_INT >= 22) {
            a = new i();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a = new h();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            a = new o();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            a = new n();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            a = new m();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            a = new l();
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            a = new j();
            return;
        }
        a = new p();
    }

    public g(Object object) {
        this.b = object;
    }

    private static String b(int n2) {
        switch (n2) {
            default: {
                return "ACTION_UNKNOWN";
            }
            case 1: {
                return "ACTION_FOCUS";
            }
            case 2: {
                return "ACTION_CLEAR_FOCUS";
            }
            case 4: {
                return "ACTION_SELECT";
            }
            case 8: {
                return "ACTION_CLEAR_SELECTION";
            }
            case 16: {
                return "ACTION_CLICK";
            }
            case 32: {
                return "ACTION_LONG_CLICK";
            }
            case 64: {
                return "ACTION_ACCESSIBILITY_FOCUS";
            }
            case 128: {
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            }
            case 256: {
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            }
            case 512: {
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            }
            case 1024: {
                return "ACTION_NEXT_HTML_ELEMENT";
            }
            case 2048: {
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            }
            case 4096: {
                return "ACTION_SCROLL_FORWARD";
            }
            case 8192: {
                return "ACTION_SCROLL_BACKWARD";
            }
            case 65536: {
                return "ACTION_CUT";
            }
            case 16384: {
                return "ACTION_COPY";
            }
            case 32768: {
                return "ACTION_PASTE";
            }
            case 131072: 
        }
        return "ACTION_SET_SELECTION";
    }

    static /* synthetic */ k r() {
        return a;
    }

    public Object a() {
        return this.b;
    }

    public void a(int n2) {
        a.a(this.b, n2);
    }

    public void a(Rect rect) {
        a.a(this.b, rect);
    }

    public void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public void a(Object object) {
        a.a(this.b, ((q)object).a);
    }

    public void a(boolean bl2) {
        a.a(this.b, bl2);
    }

    public int b() {
        return a.a(this.b);
    }

    public void b(Rect rect) {
        a.b(this.b, rect);
    }

    public void b(Object object) {
        a.b(this.b, r.a((r)object));
    }

    public boolean c() {
        return a.f(this.b);
    }

    public boolean d() {
        return a.g(this.b);
    }

    public boolean e() {
        return a.j(this.b);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        g g2 = (g)object;
        if (this.b == null) {
            if (g2.b == null) return true;
            return false;
        }
        if (this.b.equals(g2.b)) return true;
        return false;
    }

    public boolean f() {
        return a.k(this.b);
    }

    public boolean g() {
        return a.o(this.b);
    }

    public boolean h() {
        return a.h(this.b);
    }

    public int hashCode() {
        if (this.b != null) return this.b.hashCode();
        return 0;
    }

    public boolean i() {
        return a.l(this.b);
    }

    public boolean j() {
        return a.i(this.b);
    }

    public boolean k() {
        return a.m(this.b);
    }

    public boolean l() {
        return a.n(this.b);
    }

    public CharSequence m() {
        return a.d(this.b);
    }

    public CharSequence n() {
        return a.b(this.b);
    }

    public CharSequence o() {
        return a.e(this.b);
    }

    public CharSequence p() {
        return a.c(this.b);
    }

    public String q() {
        return a.p(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        this.a(rect);
        stringBuilder.append("; boundsInParent: " + (Object)rect);
        this.b(rect);
        stringBuilder.append("; boundsInScreen: " + (Object)rect);
        stringBuilder.append("; packageName: ").append(this.m());
        stringBuilder.append("; className: ").append(this.n());
        stringBuilder.append("; text: ").append(this.o());
        stringBuilder.append("; contentDescription: ").append(this.p());
        stringBuilder.append("; viewId: ").append(this.q());
        stringBuilder.append("; checkable: ").append(this.c());
        stringBuilder.append("; checked: ").append(this.d());
        stringBuilder.append("; focusable: ").append(this.e());
        stringBuilder.append("; focused: ").append(this.f());
        stringBuilder.append("; selected: ").append(this.g());
        stringBuilder.append("; clickable: ").append(this.h());
        stringBuilder.append("; longClickable: ").append(this.i());
        stringBuilder.append("; enabled: ").append(this.j());
        stringBuilder.append("; password: ").append(this.k());
        stringBuilder.append("; scrollable: " + this.l());
        stringBuilder.append("; [");
        int n2 = this.b();
        do {
            if (n2 == 0) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            int n3 = 1 << Integer.numberOfTrailingZeros(n2);
            stringBuilder.append(g.b(n3));
            if ((n2 &= ~ n3) == 0) continue;
            stringBuilder.append(", ");
        } while (true);
    }
}

