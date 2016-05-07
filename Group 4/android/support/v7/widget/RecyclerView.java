/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.e.i;
import android.support.v4.h.a.a;
import android.support.v4.h.at;
import android.support.v4.h.bc;
import android.support.v4.h.bd;
import android.support.v4.h.bh;
import android.support.v4.h.bo;
import android.support.v4.h.cn;
import android.support.v4.widget.s;
import android.support.v7.e.b;
import android.support.v7.widget.RecyclerView$SavedState;
import android.support.v7.widget.ai;
import android.support.v7.widget.aj;
import android.support.v7.widget.ca;
import android.support.v7.widget.cc;
import android.support.v7.widget.cg;
import android.support.v7.widget.dz;
import android.support.v7.widget.ea;
import android.support.v7.widget.eb;
import android.support.v7.widget.ec;
import android.support.v7.widget.ed;
import android.support.v7.widget.ee;
import android.support.v7.widget.ef;
import android.support.v7.widget.eh;
import android.support.v7.widget.ei;
import android.support.v7.widget.ej;
import android.support.v7.widget.el;
import android.support.v7.widget.em;
import android.support.v7.widget.en;
import android.support.v7.widget.eo;
import android.support.v7.widget.ep;
import android.support.v7.widget.er;
import android.support.v7.widget.es;
import android.support.v7.widget.et;
import android.support.v7.widget.eu;
import android.support.v7.widget.ev;
import android.support.v7.widget.ew;
import android.support.v7.widget.ex;
import android.support.v7.widget.ey;
import android.support.v7.widget.fc;
import android.support.v7.widget.fd;
import android.support.v7.widget.fe;
import android.support.v7.widget.ff;
import android.support.v7.widget.fg;
import android.support.v7.widget.gv;
import android.support.v7.widget.gx;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
extends ViewGroup
implements bc,
bh {
    private static final Interpolator ao;
    private static final boolean j;
    private static final Class[] k;
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private final boolean E;
    private final AccessibilityManager F;
    private List G;
    private boolean H;
    private int I;
    private s J;
    private s K;
    private s L;
    private s M;
    private int N;
    private int O;
    private VelocityTracker P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private final int V;
    private final int W;
    final ew a;
    private float aa;
    private final fe ab;
    private eu ac;
    private List ad;
    private el ae;
    private boolean af;
    private fg ag;
    private ei ah;
    private final int[] ai;
    private final bd aj;
    private final int[] ak;
    private final int[] al;
    private final int[] am;
    private Runnable an;
    private final gx ap;
    ai b;
    ca c;
    final gv d;
    ep e;
    ej f;
    final fc g;
    boolean h;
    boolean i;
    private final ey l;
    private RecyclerView$SavedState m;
    private boolean n;
    private final Runnable o;
    private final Rect p;
    private ef q;
    private ex r;
    private final ArrayList s;
    private final ArrayList t;
    private et u;
    private boolean v;
    private boolean w;
    private boolean x;
    private int y;
    private boolean z;

    static {
        boolean bl2 = Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20;
        j = bl2;
        Class[] arrclass = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        k = arrclass;
        ao = new eb();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.l = new ey(this, null);
        this.a = new ew(this);
        this.d = new gv();
        this.o = new dz(this);
        this.p = new Rect();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.y = 0;
        this.H = false;
        this.I = 0;
        this.f = new cg();
        this.N = 0;
        this.O = -1;
        this.aa = Float.MIN_VALUE;
        this.ab = new fe(this);
        this.g = new fc();
        this.h = false;
        this.i = false;
        this.ae = new en(this, null);
        this.af = false;
        this.ai = new int[2];
        this.ak = new int[2];
        this.al = new int[2];
        this.am = new int[2];
        this.an = new ea(this);
        this.ap = new ec(this);
        this.setScrollContainer(true);
        this.setFocusableInTouchMode(true);
        boolean bl2 = Build.VERSION.SDK_INT >= 16;
        this.E = bl2;
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.W = viewConfiguration.getScaledMaximumFlingVelocity();
        boolean bl3 = bo.a((View)this) == 2;
        this.setWillNotDraw(bl3);
        this.f.a(this.ae);
        this.a();
        this.s();
        if (bo.e((View)this) == 0) {
            bo.c((View)this, 1);
        }
        this.F = (AccessibilityManager)this.getContext().getSystemService("accessibility");
        this.setAccessibilityDelegateCompat(new fg(this));
        if (attributeSet != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b.RecyclerView, n2, 0);
            String string = typedArray.getString(b.RecyclerView_layoutManager);
            typedArray.recycle();
            this.a(context, string, attributeSet, n2, 0);
        }
        this.aj = new bd((View)this);
        this.setNestedScrollingEnabled(true);
    }

    private void A() {
        this.I = -1 + this.I;
        if (this.I >= 1) return;
        this.I = 0;
        this.B();
    }

    private void B() {
        int n2 = this.C;
        this.C = 0;
        if (n2 == 0) return;
        if (!this.i()) return;
        AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
        accessibilityEvent.setEventType(2048);
        a.a(accessibilityEvent, n2);
        this.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    private void C() {
        if (this.af) return;
        if (!this.v) return;
        bo.a((View)this, this.an);
        this.af = true;
    }

    private boolean D() {
        if (this.f == null) return false;
        if (!this.e.b()) return false;
        return true;
    }

    private void E() {
        boolean bl2 = true;
        if (this.H) {
            this.b.a();
            this.o();
            this.e.a(this);
        }
        if (this.D()) {
            this.b.b();
        } else {
            this.b.e();
        }
        boolean bl3 = this.h || this.i ? bl2 : false;
        fc fc2 = this.g;
        boolean bl4 = !(!this.x || this.f == null || !this.H && !bl3 && !ep.b(this.e) || this.H && !this.q.b()) ? bl2 : false;
        fc.d(fc2, bl4);
        fc fc3 = this.g;
        if (!fc.c(this.g) || !bl3 || this.H || !this.D()) {
            bl2 = false;
        }
        fc.e(fc3, bl2);
    }

    private void F() {
        boolean bl2 = true;
        this.g.a((int)bl2 ? 1 : 0);
        fc.b(this.g, false);
        this.b();
        this.d.a();
        this.z();
        this.E();
        fc fc2 = this.g;
        if (!fc.c(this.g) || !this.i) {
            bl2 = false;
        }
        fc.f(fc2, bl2);
        this.i = false;
        this.h = false;
        fc.c(this.g, fc.b(this.g));
        this.g.a = this.q.a();
        this.a(this.ai);
        if (fc.c(this.g)) {
            int n2 = this.c.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                ff ff2 = RecyclerView.c(this.c.b(i2));
                if (ff2.c() || ff2.n() && !this.q.b()) continue;
                em em2 = this.f.a(this.g, ff2, ej.d(ff2), ff2.u());
                this.d.a(ff2, em2);
                if (!fc.d(this.g) || !ff2.x() || ff2.q() || ff2.c() || ff2.n()) continue;
                long l2 = this.a(ff2);
                this.d.a(l2, ff2);
            }
        }
        if (!fc.b(this.g)) {
            this.n();
        } else {
            this.m();
            boolean bl3 = fc.e(this.g);
            fc.a(this.g, false);
            this.e.c(this.a, this.g);
            fc.a(this.g, bl3);
            for (int i3 = 0; i3 < this.c.b(); ++i3) {
                ff ff3 = RecyclerView.c(this.c.b(i3));
                if (ff3.c() || this.d.d(ff3)) continue;
                int n3 = ej.d(ff3);
                boolean bl4 = ff3.a(8192);
                if (!bl4) {
                    n3 |= 4096;
                }
                em em3 = this.f.a(this.g, ff3, n3, ff3.u());
                if (bl4) {
                    this.a(ff3, em3);
                    continue;
                }
                this.d.b(ff3, em3);
            }
            this.n();
        }
        this.A();
        this.a(false);
        fc.b(this.g, 2);
    }

    private void G() {
        this.b();
        this.z();
        this.g.a(6);
        this.b.e();
        this.g.a = this.q.a();
        fc.c(this.g, 0);
        fc.c(this.g, false);
        this.e.c(this.a, this.g);
        fc.a(this.g, false);
        this.m = null;
        fc fc2 = this.g;
        boolean bl2 = fc.c(this.g) && this.f != null;
        fc.d(fc2, bl2);
        fc.b(this.g, 4);
        this.A();
        this.a(false);
    }

    private void H() {
        this.g.a(4);
        this.b();
        fc.b(this.g, 1);
        if (fc.c(this.g)) {
            int n2 = this.c.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                ff ff2 = RecyclerView.c(this.c.b(i2));
                if (ff2.c()) continue;
                long l2 = this.a(ff2);
                em em2 = this.f.a(this.g, ff2);
                ff ff3 = this.d.a(l2);
                if (ff3 != null && !ff3.c()) {
                    boolean bl2 = this.d.a(ff3);
                    boolean bl3 = this.d.a(ff2);
                    em em3 = this.d.b(ff3);
                    this.d.c(ff2, em2);
                    em em4 = this.d.c(ff2);
                    if (em3 == null) {
                        this.a(l2, ff2, ff3);
                        continue;
                    }
                    this.a(ff3, ff2, em3, em4, bl2, bl3);
                    continue;
                }
                this.d.c(ff2, em2);
            }
            this.d.a(this.ap);
        }
        this.e.b(this.a);
        fc.d(this.g, this.g.a);
        this.H = false;
        fc.d(this.g, false);
        fc.e(this.g, false);
        ep.a(this.e, false);
        if (ew.a(this.a) != null) {
            ew.a(this.a).clear();
        }
        this.a(false);
        this.d.a();
        if (!this.j(this.ai[0], this.ai[1])) return;
        this.g(0, 0);
    }

    private void I() {
        int n2 = this.c.b();
        int n3 = 0;
        while (n3 < n2) {
            View view = this.c.b(n3);
            ff ff2 = this.a(view);
            if (ff2 != null && ff2.h != null) {
                View view2 = ff2.h.a;
                int n4 = view.getLeft();
                int n5 = view.getTop();
                if (n4 != view2.getLeft() || n5 != view2.getTop()) {
                    view2.layout(n4, n5, n4 + view2.getWidth(), n5 + view2.getHeight());
                }
            }
            ++n3;
        }
    }

    private String a(Context context, String string) {
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        if (string.contains(".")) return string;
        return RecyclerView.class.getPackage().getName() + '.' + string;
    }

    /*
     * Unable to fully structure code
     */
    private void a(float var1_1, float var2_2, float var3_3, float var4_4) {
        var5_5 = true;
        if (var2_2 < 0.0f) {
            this.d();
            var9_6 = this.J.a((- var2_2) / (float)this.getWidth(), 1.0f - var3_3 / (float)this.getHeight());
            var7_7 = false;
            if (var9_6) {
                var7_7 = var5_5;
            }
        } else {
            var6_8 = var2_2 FCMPL 0.0f;
            var7_7 = false;
            if (var6_8 > 0) {
                this.e();
                var8_9 = this.L.a(var2_2 / (float)this.getWidth(), var3_3 / (float)this.getHeight());
                var7_7 = false;
                if (var8_9) {
                    var7_7 = var5_5;
                }
            }
        }
        if (var4_4 >= 0.0f) ** GOTO lbl21
        this.f();
        if (!this.K.a((- var4_4) / (float)this.getHeight(), var1_1 / (float)this.getWidth())) ** GOTO lbl-1000
        ** GOTO lbl25
lbl21: // 1 sources:
        if (var4_4 <= 0.0f) ** GOTO lbl-1000
        this.g();
        if (!this.M.a(var4_4 / (float)this.getHeight(), 1.0f - var1_1 / (float)this.getWidth())) lbl-1000: // 3 sources:
        {
            var5_5 = var7_7;
        }
lbl25: // 4 sources:
        if (!var5_5 && var2_2 == 0.0f) {
            if (var4_4 == 0.0f) return;
        }
        bo.d((View)this);
    }

    private void a(long l2, ff ff2, ff ff3) {
        int n2 = this.c.b();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                Log.e((String)"RecyclerView", (String)("Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + ff3 + " cannot be found but it is necessary for " + ff2));
                return;
            }
            ff ff4 = RecyclerView.c(this.c.b(n3));
            if (ff4 != ff2 && this.a(ff4) == l2) {
                if (this.q == null) throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + ff4 + " \n View Holder 2:" + ff2);
                if (!this.q.b()) throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + ff4 + " \n View Holder 2:" + ff2);
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + ff4 + " \n View Holder 2:" + ff2);
            }
            ++n3;
        } while (true);
    }

    private void a(Context context, String string, AttributeSet attributeSet, int n2, int n3) {
        if (string == null) return;
        String string2 = string.trim();
        if (string2.length() == 0) return;
        String string3 = this.a(context, string2);
        try {
            Constructor constructor;
            ClassLoader classLoader;
            Object[] arrobject;
            ClassLoader classLoader2 = this.isInEditMode() ? this.getClass().getClassLoader() : (classLoader = context.getClassLoader());
            Class class_ = classLoader2.loadClass(string3).asSubclass(ep.class);
            try {
                Constructor constructor2 = class_.getConstructor(k);
                arrobject = new Object[]{context, attributeSet, n2, n3};
                constructor = constructor2;
            }
            catch (NoSuchMethodException var16_14) {
                try {
                    Constructor constructor3;
                    constructor = constructor3 = class_.getConstructor(new Class[0]);
                    arrobject = null;
                }
                catch (NoSuchMethodException var17_16) {
                    var17_16.initCause(var16_14);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + string3, var17_16);
                }
            }
            constructor.setAccessible(true);
            this.setLayoutManager((ep)constructor.newInstance(arrobject));
            return;
        }
        catch (ClassNotFoundException var12_17) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + string3, var12_17);
        }
        catch (InvocationTargetException var11_18) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string3, var11_18);
        }
        catch (InstantiationException var10_19) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + string3, var10_19);
        }
        catch (IllegalAccessException var9_20) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + string3, var9_20);
        }
        catch (ClassCastException var8_21) {
            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + string3, var8_21);
        }
    }

    static /* synthetic */ void a(RecyclerView recyclerView, int n2) {
        recyclerView.detachViewFromParent(n2);
    }

    static /* synthetic */ void a(RecyclerView recyclerView, int n2, int n3) {
        recyclerView.h(n2, n3);
    }

    static /* synthetic */ void a(RecyclerView recyclerView, ff ff2, em em2) {
        recyclerView.a(ff2, em2);
    }

    static /* synthetic */ void a(RecyclerView recyclerView, ff ff2, em em2, em em3) {
        recyclerView.b(ff2, em2, em3);
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view) {
        recyclerView.j(view);
    }

    static /* synthetic */ void a(RecyclerView recyclerView, View view, int n2, ViewGroup.LayoutParams layoutParams) {
        recyclerView.attachViewToParent(view, n2, layoutParams);
    }

    private void a(ef ef2, boolean bl2, boolean bl3) {
        if (this.q != null) {
            this.q.b(this.l);
            this.q.b(this);
        }
        if (!bl2 || bl3) {
            if (this.f != null) {
                this.f.c();
            }
            if (this.e != null) {
                this.e.c(this.a);
                this.e.b(this.a);
            }
            this.a.a();
        }
        this.b.a();
        ef ef3 = this.q;
        this.q = ef2;
        if (ef2 != null) {
            ef2.a(this.l);
            ef2.a(this);
        }
        if (this.e != null) {
            this.e.a(ef3, this.q);
        }
        this.a.a(ef3, this.q, bl2);
        fc.a(this.g, true);
        this.o();
    }

    private void a(ff ff2, em em2) {
        ff2.a(0, 8192);
        if (fc.d(this.g) && ff2.x() && !ff2.q() && !ff2.c()) {
            long l2 = this.a(ff2);
            this.d.a(l2, ff2);
        }
        this.d.a(ff2, em2);
    }

    private void a(ff ff2, em em2, em em3) {
        ff2.a(false);
        if (!this.f.b(ff2, em2, em3)) return;
        this.C();
    }

    private void a(ff ff2, ff ff3, em em2, em em3, boolean bl2, boolean bl3) {
        ff2.a(false);
        if (bl2) {
            this.b(ff2);
        }
        if (ff2 != ff3) {
            if (bl3) {
                this.b(ff3);
            }
            ff2.g = ff3;
            this.b(ff2);
            this.a.d(ff2);
            ff3.a(false);
            ff3.h = ff2;
        }
        if (!this.f.a(ff2, ff3, em2, em3)) return;
        this.C();
    }

    private void a(int[] arrn) {
        int n2 = this.c.b();
        if (n2 == 0) {
            arrn[0] = 0;
            arrn[1] = 0;
            return;
        }
        int n3 = Integer.MAX_VALUE;
        int n4 = Integer.MIN_VALUE;
        int n5 = 0;
        do {
            int n6;
            if (n5 >= n2) {
                arrn[0] = n3;
                arrn[1] = n4;
                return;
            }
            ff ff2 = RecyclerView.c(this.c.b(n5));
            if (ff2.c()) {
                n6 = n3;
            } else {
                int n7 = ff2.d();
                if (n7 < n3) {
                    n3 = n7;
                }
                if (n7 > n4) {
                    n4 = n7;
                    n6 = n3;
                } else {
                    n6 = n3;
                }
            }
            ++n5;
            n3 = n6;
        } while (true);
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView) {
        return recyclerView.x;
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, ff ff2) {
        return recyclerView.c(ff2);
    }

    static /* synthetic */ boolean a(RecyclerView recyclerView, boolean bl2) {
        recyclerView.z = bl2;
        return bl2;
    }

    private boolean a(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 == 3 || n2 == 0) {
            this.u = null;
        }
        int n3 = this.t.size();
        int n4 = 0;
        while (n4 < n3) {
            et et2 = (et)this.t.get(n4);
            if (et2.a(this, motionEvent) && n2 != 3) {
                this.u = et2;
                return true;
            }
            ++n4;
        }
        return false;
    }

    static /* synthetic */ int b(RecyclerView recyclerView, ff ff2) {
        return recyclerView.d(ff2);
    }

    static /* synthetic */ void b(RecyclerView recyclerView, int n2) {
        recyclerView.setScrollState(n2);
    }

    static /* synthetic */ void b(RecyclerView recyclerView, int n2, int n3) {
        recyclerView.i(n2, n3);
    }

    static /* synthetic */ void b(RecyclerView recyclerView, ff ff2, em em2, em em3) {
        recyclerView.a(ff2, em2, em3);
    }

    static /* synthetic */ void b(RecyclerView recyclerView, View view) {
        recyclerView.i(view);
    }

    private void b(ff ff2) {
        View view = ff2.a;
        boolean bl2 = view.getParent() == this;
        this.a.d(this.a(view));
        if (ff2.r()) {
            this.c.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!bl2) {
            this.c.a(view, true);
            return;
        }
        this.c.d(view);
    }

    private void b(ff ff2, em em2, em em3) {
        this.b(ff2);
        ff2.a(false);
        if (!this.f.a(ff2, em2, em3)) return;
        this.C();
    }

    static /* synthetic */ boolean b(RecyclerView recyclerView) {
        return recyclerView.A;
    }

    static /* synthetic */ boolean b(RecyclerView recyclerView, boolean bl2) {
        recyclerView.af = bl2;
        return bl2;
    }

    private boolean b(MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (this.u != null) {
            if (n2 == 0) {
                this.u = null;
            } else {
                this.u.b(this, motionEvent);
                if (n2 != 3) {
                    if (n2 != 1) return true;
                }
                this.u = null;
                return true;
            }
        }
        if (n2 == 0) return false;
        int n3 = this.t.size();
        int n4 = 0;
        while (n4 < n3) {
            et et2 = (et)this.t.get(n4);
            if (et2.a(this, motionEvent)) {
                this.u = et2;
                return true;
            }
            ++n4;
        }
        return false;
    }

    static ff c(View view) {
        if (view != null) return ((er)view.getLayoutParams()).a;
        return null;
    }

    static /* synthetic */ void c(RecyclerView recyclerView) {
        recyclerView.t();
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int n2) {
        recyclerView.e(n2);
    }

    static /* synthetic */ void c(RecyclerView recyclerView, int n2, int n3) {
        recyclerView.setMeasuredDimension(n2, n3);
    }

    private void c(MotionEvent motionEvent) {
        int n2;
        int n3;
        int n4 = at.b(motionEvent);
        if (at.b(motionEvent, n4) != this.O) return;
        int n5 = n4 == 0 ? 1 : 0;
        this.O = at.b(motionEvent, n5);
        this.S = n2 = (int)(0.5f + at.c(motionEvent, n5));
        this.Q = n2;
        this.T = n3 = (int)(0.5f + at.d(motionEvent, n5));
        this.R = n3;
    }

    static /* synthetic */ boolean c(RecyclerView recyclerView, View view) {
        return recyclerView.h(view);
    }

    private boolean c(ff ff2) {
        if (this.f == null) return true;
        if (!this.f.a(ff2, ff2.u())) return false;
        return true;
    }

    private int d(ff ff2) {
        if (ff2.a(524)) return -1;
        if (ff2.p()) return this.b.c(ff2.b);
        return -1;
    }

    static /* synthetic */ boolean d(RecyclerView recyclerView) {
        return recyclerView.H;
    }

    private void e(int n2) {
        if (this.e == null) {
            return;
        }
        this.e.d(n2);
        this.awakenScrollBars();
    }

    static /* synthetic */ void e(RecyclerView recyclerView) {
        recyclerView.C();
    }

    static /* synthetic */ ef f(RecyclerView recyclerView) {
        return recyclerView.q;
    }

    static /* synthetic */ void g(RecyclerView recyclerView) {
        recyclerView.z();
    }

    private float getScrollFactor() {
        if (this.aa != Float.MIN_VALUE) return this.aa;
        TypedValue typedValue = new TypedValue();
        if (!this.getContext().getTheme().resolveAttribute(16842829, typedValue, true)) return 0.0f;
        this.aa = typedValue.getDimension(this.getContext().getResources().getDisplayMetrics());
        return this.aa;
    }

    private void h(int n2, int n3) {
        s s2 = this.J;
        boolean bl2 = false;
        if (s2 != null) {
            boolean bl3 = this.J.a();
            bl2 = false;
            if (!bl3) {
                bl2 = false;
                if (n2 > 0) {
                    bl2 = this.J.b();
                }
            }
        }
        if (this.L != null && !this.L.a() && n2 < 0) {
            bl2 |= this.L.b();
        }
        if (this.K != null && !this.K.a() && n3 > 0) {
            bl2 |= this.K.b();
        }
        if (this.M != null && !this.M.a() && n3 < 0) {
            bl2 |= this.M.b();
        }
        if (!bl2) return;
        bo.d((View)this);
    }

    static /* synthetic */ void h(RecyclerView recyclerView) {
        recyclerView.I();
    }

    private boolean h(View view) {
        this.b();
        boolean bl2 = this.c.f(view);
        if (bl2) {
            ff ff2 = RecyclerView.c(view);
            this.a.d(ff2);
            this.a.b(ff2);
        }
        boolean bl3 = !bl2;
        this.a(bl3);
        return bl2;
    }

    private void i(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getMode((int)n3);
        int n6 = View.MeasureSpec.getSize((int)n2);
        int n7 = View.MeasureSpec.getSize((int)n3);
        switch (n4) {
            default: {
                n6 = bo.o((View)this);
            }
            case Integer.MIN_VALUE: 
            case 1073741824: 
        }
        switch (n5) {
            default: {
                n7 = bo.p((View)this);
            }
            case Integer.MIN_VALUE: 
            case 1073741824: 
        }
        this.setMeasuredDimension(n6, n7);
    }

    static /* synthetic */ void i(RecyclerView recyclerView) {
        recyclerView.A();
    }

    private void i(View view) {
        ff ff2 = RecyclerView.c(view);
        this.f(view);
        if (this.q != null && ff2 != null) {
            this.q.d(ff2);
        }
        if (this.G == null) return;
        int n2 = -1 + this.G.size();
        while (n2 >= 0) {
            ((es)this.G.get(n2)).b(view);
            --n2;
        }
    }

    static /* synthetic */ ArrayList j(RecyclerView recyclerView) {
        return recyclerView.s;
    }

    private void j(View view) {
        ff ff2 = RecyclerView.c(view);
        this.e(view);
        if (this.q != null && ff2 != null) {
            this.q.c(ff2);
        }
        if (this.G == null) return;
        int n2 = -1 + this.G.size();
        while (n2 >= 0) {
            ((es)this.G.get(n2)).a(view);
            --n2;
        }
    }

    private boolean j(int n2, int n3) {
        boolean bl2;
        int n4 = this.c.b();
        if (n4 == 0) {
            if (n2 != 0) return true;
            bl2 = false;
            if (n3 == 0) return bl2;
            return true;
        }
        int n5 = 0;
        do {
            bl2 = false;
            if (n5 >= n4) return bl2;
            ff ff2 = RecyclerView.c(this.c.b(n5));
            if (!ff2.c()) {
                int n6 = ff2.d();
                if (n6 < n2) return true;
                if (n6 > n3) {
                    return true;
                }
            }
            ++n5;
        } while (true);
    }

    static /* synthetic */ boolean k(RecyclerView recyclerView) {
        return recyclerView.awakenScrollBars();
    }

    static /* synthetic */ fg l(RecyclerView recyclerView) {
        return recyclerView.ag;
    }

    static /* synthetic */ ex m(RecyclerView recyclerView) {
        return recyclerView.r;
    }

    static /* synthetic */ Rect n(RecyclerView recyclerView) {
        return recyclerView.p;
    }

    static /* synthetic */ boolean o(RecyclerView recyclerView) {
        return recyclerView.n;
    }

    static /* synthetic */ fe p(RecyclerView recyclerView) {
        return recyclerView.ab;
    }

    static /* synthetic */ Interpolator q() {
        return ao;
    }

    static /* synthetic */ boolean r() {
        return j;
    }

    private void s() {
        this.c = new ca(new ed(this));
    }

    private void setScrollState(int n2) {
        if (n2 == this.N) {
            return;
        }
        this.N = n2;
        if (n2 != 2) {
            this.v();
        }
        this.d(n2);
    }

    private void t() {
        if (!this.x) {
            return;
        }
        if (this.H) {
            i.a("RV FullInvalidate");
            this.k();
            i.a();
            return;
        }
        if (!this.b.d()) return;
        if (this.b.a(4) && !this.b.a(11)) {
            i.a("RV PartialInvalidate");
            this.b();
            this.b.b();
            if (!this.z) {
                if (this.u()) {
                    this.k();
                } else {
                    this.b.c();
                }
            }
            this.a(true);
            i.a();
            return;
        }
        if (!this.b.d()) return;
        i.a("RV FullInvalidate");
        this.k();
        i.a();
    }

    private boolean u() {
        int n2 = this.c.b();
        int n3 = 0;
        do {
            boolean bl2 = false;
            if (n3 >= n2) return bl2;
            ff ff2 = RecyclerView.c(this.c.b(n3));
            if (ff2 != null && !ff2.c() && ff2.x()) {
                return true;
            }
            ++n3;
        } while (true);
    }

    private void v() {
        this.ab.b();
        if (this.e == null) return;
        this.e.E();
    }

    private void w() {
        s s2 = this.J;
        boolean bl2 = false;
        if (s2 != null) {
            bl2 = this.J.b();
        }
        if (this.K != null) {
            bl2 |= this.K.b();
        }
        if (this.L != null) {
            bl2 |= this.L.b();
        }
        if (this.M != null) {
            bl2 |= this.M.b();
        }
        if (!bl2) return;
        bo.d((View)this);
    }

    private void x() {
        if (this.P != null) {
            this.P.clear();
        }
        this.stopNestedScroll();
        this.w();
    }

    private void y() {
        this.x();
        this.setScrollState(0);
    }

    private void z() {
        this.I = 1 + this.I;
    }

    long a(ff ff2) {
        if (!this.q.b()) return ff2.b;
        return ff2.g();
    }

    ff a(int n2, boolean bl2) {
        int n3 = this.c.c();
        int n4 = 0;
        while (n4 < n3) {
            ff ff2 = RecyclerView.c(this.c.c(n4));
            if (ff2 != null && !ff2.q()) {
                if (bl2) {
                    if (ff2.b == n2) {
                        return ff2;
                    }
                } else if (ff2.d() == n2) return ff2;
            }
            ++n4;
        }
        return null;
    }

    public ff a(View view) {
        ViewParent viewParent = view.getParent();
        if (viewParent == null) return RecyclerView.c(view);
        if (viewParent == this) return RecyclerView.c(view);
        throw new IllegalArgumentException("View " + (Object)view + " is not a direct child of " + this);
    }

    void a() {
        this.b = new ai(new ee(this));
    }

    public void a(int n2) {
        int n3 = this.c.b();
        int n4 = 0;
        while (n4 < n3) {
            this.c.b(n4).offsetTopAndBottom(n2);
            ++n4;
        }
    }

    public void a(int n2, int n3) {
        if (this.e == null) {
            Log.e((String)"RecyclerView", (String)"Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) return;
        if (!this.e.d()) {
            n2 = 0;
        }
        boolean bl2 = this.e.e();
        int n4 = 0;
        if (bl2) {
            n4 = n3;
        }
        if (n2 == 0) {
            if (n4 == 0) return;
        }
        this.ab.b(n2, n4);
    }

    void a(int n2, int n3, Object object) {
        int n4 = this.c.c();
        int n5 = n2 + n3;
        int n6 = 0;
        do {
            if (n6 >= n4) {
                this.a.c(n2, n3);
                return;
            }
            View view = this.c.c(n6);
            ff ff2 = RecyclerView.c(view);
            if (ff2 != null && !ff2.c() && ff2.b >= n2 && ff2.b < n5) {
                ff2.b(2);
                ff2.a(object);
                ((er)view.getLayoutParams()).c = true;
            }
            ++n6;
        } while (true);
    }

    void a(int n2, int n3, boolean bl2) {
        int n4 = n2 + n3;
        int n5 = this.c.c();
        int n6 = 0;
        do {
            if (n6 >= n5) {
                this.a.b(n2, n3, bl2);
                this.requestLayout();
                return;
            }
            ff ff2 = RecyclerView.c(this.c.c(n6));
            if (ff2 != null && !ff2.c()) {
                if (ff2.b >= n4) {
                    ff2.a(- n3, bl2);
                    fc.a(this.g, true);
                } else if (ff2.b >= n2) {
                    ff2.a(n2 - 1, - n3, bl2);
                    fc.a(this.g, true);
                }
            }
            ++n6;
        } while (true);
    }

    void a(String string) {
        if (!this.j()) return;
        if (string != null) throw new IllegalStateException(string);
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
    }

    void a(boolean bl2) {
        if (this.y < 1) {
            this.y = 1;
        }
        if (!bl2) {
            this.z = false;
        }
        if (this.y == 1) {
            if (bl2 && this.z && !this.A && this.e != null && this.q != null) {
                this.k();
            }
            if (!this.A) {
                this.z = false;
            }
        }
        this.y = -1 + this.y;
    }

    boolean a(int n2, int n3, MotionEvent motionEvent) {
        int n4;
        int n5;
        int n6;
        int n7;
        this.t();
        if (this.q != null) {
            int n8;
            int n9;
            int n10;
            this.b();
            this.z();
            i.a("RV Scroll");
            if (n2 != 0) {
                n10 = this.e.a(n2, this.a, this.g);
                n4 = n2 - n10;
            } else {
                n10 = 0;
                n4 = 0;
            }
            if (n3 != 0) {
                n9 = this.e.b(n3, this.a, this.g);
                n8 = n3 - n9;
            } else {
                n9 = 0;
                n8 = 0;
            }
            i.a();
            this.I();
            this.A();
            this.a(false);
            n7 = n8;
            n5 = n10;
            n6 = n9;
        } else {
            n5 = 0;
            n6 = 0;
            n4 = 0;
            n7 = 0;
        }
        if (!this.s.isEmpty()) {
            this.invalidate();
        }
        if (this.dispatchNestedScroll(n5, n6, n4, n7, this.ak)) {
            this.S -= this.ak[0];
            this.T -= this.ak[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float)this.ak[0], (float)this.ak[1]);
            }
            int[] arrn = this.am;
            arrn[0] = arrn[0] + this.ak[0];
            int[] arrn2 = this.am;
            arrn2[1] = arrn2[1] + this.ak[1];
        } else if (bo.a((View)this) != 2) {
            if (motionEvent != null) {
                this.a(motionEvent.getX(), n4, motionEvent.getY(), n7);
            }
            this.h(n2, n3);
        }
        if (n5 != 0 || n6 != 0) {
            this.g(n5, n6);
        }
        if (!this.awakenScrollBars()) {
            this.invalidate();
        }
        if (n5 != 0) return true;
        boolean bl2 = false;
        if (n6 == 0) return bl2;
        return true;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        boolean bl2 = this.j();
        boolean bl3 = false;
        if (!bl2) return bl3;
        int n2 = accessibilityEvent != null ? a.b(accessibilityEvent) : 0;
        int n3 = 0;
        if (n2 != 0) {
            n3 = n2;
        }
        this.C = n3 | this.C;
        return true;
    }

    public void addFocusables(ArrayList arrayList, int n2, int n3) {
        if (this.e != null) {
            if (this.e.a(this, arrayList, n2, n3)) return;
        }
        super.addFocusables(arrayList, n2, n3);
    }

    public View b(View view) {
        ViewParent viewParent = view.getParent();
        View view2 = view;
        while (viewParent != null && viewParent != this && viewParent instanceof View) {
            View view3 = (View)viewParent;
            ViewParent viewParent2 = view3.getParent();
            view2 = view3;
            viewParent = viewParent2;
        }
        if (viewParent != this) return null;
        return view2;
    }

    void b() {
        this.y = 1 + this.y;
        if (this.y != 1) return;
        if (this.A) return;
        this.z = false;
    }

    public void b(int n2) {
        int n3 = this.c.b();
        int n4 = 0;
        while (n4 < n3) {
            this.c.b(n4).offsetLeftAndRight(n2);
            ++n4;
        }
    }

    public boolean b(int n2, int n3) {
        if (this.e == null) {
            Log.e((String)"RecyclerView", (String)"Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.A) return false;
        boolean bl2 = this.e.d();
        boolean bl3 = this.e.e();
        if (!bl2 || Math.abs(n2) < this.V) {
            n2 = 0;
        }
        if (!bl3) return false;
        if (Math.abs(n3) < this.V) {
            n3 = 0;
        }
        if (n2 == 0) {
            if (n3 == 0) return false;
        }
        if (this.dispatchNestedPreFling(n2, n3)) return false;
        boolean bl4 = bl2 || bl3;
        this.dispatchNestedFling(n2, n3, bl4);
        if (!bl4) return false;
        int n4 = Math.max(- this.W, Math.min(n2, this.W));
        int n5 = Math.max(- this.W, Math.min(n3, this.W));
        this.ab.a(n4, n5);
        return true;
    }

    public void c() {
        this.setScrollState(0);
        this.v();
    }

    public void c(int n2) {
    }

    void c(int n2, int n3) {
        if (n2 < 0) {
            this.d();
            this.J.a(- n2);
        } else if (n2 > 0) {
            this.e();
            this.L.a(n2);
        }
        if (n3 < 0) {
            this.f();
            this.K.a(- n3);
        } else if (n3 > 0) {
            this.g();
            this.M.a(n3);
        }
        if (n2 == 0) {
            if (n3 == 0) return;
        }
        bo.d((View)this);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof er)) return false;
        if (!this.e.a((er)layoutParams)) return false;
        return true;
    }

    @Override
    public int computeHorizontalScrollExtent() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.d()) return 0;
        return this.e.d(this.g);
    }

    @Override
    public int computeHorizontalScrollOffset() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.d()) return 0;
        return this.e.b(this.g);
    }

    @Override
    public int computeHorizontalScrollRange() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.d()) return 0;
        return this.e.f(this.g);
    }

    @Override
    public int computeVerticalScrollExtent() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.e()) return 0;
        return this.e.e(this.g);
    }

    @Override
    public int computeVerticalScrollOffset() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.e()) return 0;
        return this.e.c(this.g);
    }

    @Override
    public int computeVerticalScrollRange() {
        if (this.e == null) {
            return 0;
        }
        if (!this.e.e()) return 0;
        return this.e.g(this.g);
    }

    public int d(View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 == null) return -1;
        return ff2.d();
    }

    void d() {
        if (this.J != null) {
            return;
        }
        this.J = new s(this.getContext());
        if (this.n) {
            this.J.a(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        this.J.a(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    void d(int n2) {
        if (this.e != null) {
            this.e.k(n2);
        }
        this.c(n2);
        if (this.ac != null) {
            this.ac.a(this, n2);
        }
        if (this.ad == null) return;
        int n3 = -1 + this.ad.size();
        while (n3 >= 0) {
            ((eu)this.ad.get(n3)).a(this, n2);
            --n3;
        }
    }

    void d(int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = this.c.c();
        if (n2 < n3) {
            n5 = -1;
            n6 = n3;
            n4 = n2;
        } else {
            n5 = 1;
            n6 = n2;
            n4 = n3;
        }
        int n8 = 0;
        do {
            if (n8 >= n7) {
                this.a.a(n2, n3);
                this.requestLayout();
                return;
            }
            ff ff2 = RecyclerView.c(this.c.c(n8));
            if (ff2 != null && ff2.b >= n4 && ff2.b <= n6) {
                if (ff2.b == n2) {
                    ff2.a(n3 - n2, false);
                } else {
                    ff2.a(n5, false);
                }
                fc.a(this.g, true);
            }
            ++n8;
        } while (true);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean bl2) {
        return this.aj.a(f2, f3, bl2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.aj.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.aj.a(n2, n3, arrn, arrn2);
    }

    public boolean dispatchNestedScroll(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.aj.a(n2, n3, n4, n5, arrn);
    }

    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparseArray) {
        this.dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean bl2;
        boolean bl3 = true;
        super.draw(canvas);
        int n2 = this.s.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((eo)this.s.get(i2)).b(canvas, this, this.g);
        }
        if (this.J != null && !this.J.a()) {
            int n3 = canvas.save();
            int n4 = this.n ? this.getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float)(n4 + (- this.getHeight())), 0.0f);
            bl2 = this.J != null && this.J.a(canvas) ? bl3 : false;
            canvas.restoreToCount(n3);
        } else {
            bl2 = false;
        }
        if (this.K != null && !this.K.a()) {
            int n5 = canvas.save();
            if (this.n) {
                canvas.translate((float)this.getPaddingLeft(), (float)this.getPaddingTop());
            }
            boolean bl4 = this.K != null && this.K.a(canvas) ? bl3 : false;
            bl2 |= bl4;
            canvas.restoreToCount(n5);
        }
        if (this.L != null && !this.L.a()) {
            int n6 = canvas.save();
            int n7 = this.getWidth();
            int n8 = this.n ? this.getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float)(- n8), (float)(- n7));
            boolean bl5 = this.L != null && this.L.a(canvas) ? bl3 : false;
            bl2 |= bl5;
            canvas.restoreToCount(n6);
        }
        if (this.M != null && !this.M.a()) {
            int n9 = canvas.save();
            canvas.rotate(180.0f);
            if (this.n) {
                canvas.translate((float)(- this.getWidth() + this.getPaddingRight()), (float)(- this.getHeight() + this.getPaddingBottom()));
            } else {
                canvas.translate((float)(- this.getWidth()), (float)(- this.getHeight()));
            }
            s s2 = this.M;
            boolean bl6 = false;
            if (s2 != null) {
                boolean bl7 = this.M.a(canvas);
                bl6 = false;
                if (bl7) {
                    bl6 = bl3;
                }
            }
            bl2 |= bl6;
            canvas.restoreToCount(n9);
        }
        if (bl2 || this.f == null || this.s.size() <= 0 || !this.f.b()) {
            bl3 = bl2;
        }
        if (!bl3) return;
        bo.d((View)this);
    }

    public boolean drawChild(Canvas canvas, View view, long l2) {
        return super.drawChild(canvas, view, l2);
    }

    void e() {
        if (this.L != null) {
            return;
        }
        this.L = new s(this.getContext());
        if (this.n) {
            this.L.a(this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom(), this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
            return;
        }
        this.L.a(this.getMeasuredHeight(), this.getMeasuredWidth());
    }

    void e(int n2, int n3) {
        int n4 = this.c.c();
        int n5 = 0;
        do {
            if (n5 >= n4) {
                this.a.b(n2, n3);
                this.requestLayout();
                return;
            }
            ff ff2 = RecyclerView.c(this.c.c(n5));
            if (ff2 != null && !ff2.c() && ff2.b >= n2) {
                ff2.a(n3, false);
                fc.a(this.g, true);
            }
            ++n5;
        } while (true);
    }

    public void e(View view) {
    }

    void f() {
        if (this.K != null) {
            return;
        }
        this.K = new s(this.getContext());
        if (this.n) {
            this.K.a(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        this.K.a(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public void f(int n2, int n3) {
    }

    public void f(View view) {
    }

    public View focusSearch(View view, int n2) {
        View view2 = this.e.d(view, n2);
        if (view2 != null) {
            return view2;
        }
        view2 = FocusFinder.getInstance().findNextFocus((ViewGroup)this, view, n2);
        if (view2 == null && this.q != null && this.e != null && !this.j() && !this.A) {
            this.b();
            view2 = this.e.a(view, n2, this.a, this.g);
            this.a(false);
        }
        if (view2 != null) return view2;
        return super.focusSearch(view, n2);
    }

    Rect g(View view) {
        er er2 = (er)view.getLayoutParams();
        if (!er2.c) {
            return er2.b;
        }
        Rect rect = er2.b;
        rect.set(0, 0, 0, 0);
        int n2 = this.s.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                er2.c = false;
                return rect;
            }
            this.p.set(0, 0, 0, 0);
            ((eo)this.s.get(n3)).a(this.p, view, this, this.g);
            rect.left += this.p.left;
            rect.top += this.p.top;
            rect.right += this.p.right;
            rect.bottom += this.p.bottom;
            ++n3;
        } while (true);
    }

    void g() {
        if (this.M != null) {
            return;
        }
        this.M = new s(this.getContext());
        if (this.n) {
            this.M.a(this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight(), this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom());
            return;
        }
        this.M.a(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    void g(int n2, int n3) {
        int n4 = this.getScrollX();
        int n5 = this.getScrollY();
        this.onScrollChanged(n4, n5, n4, n5);
        this.f(n2, n3);
        if (this.ac != null) {
            this.ac.a(this, n2, n3);
        }
        if (this.ad == null) return;
        int n6 = -1 + this.ad.size();
        while (n6 >= 0) {
            ((eu)this.ad.get(n6)).a(this, n2, n3);
            --n6;
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.e != null) return this.e.a();
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.e != null) return this.e.a(this.getContext(), attributeSet);
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (this.e != null) return this.e.a(layoutParams);
        throw new IllegalStateException("RecyclerView has no LayoutManager");
    }

    public ef getAdapter() {
        return this.q;
    }

    public int getBaseline() {
        if (this.e == null) return super.getBaseline();
        return this.e.r();
    }

    protected int getChildDrawingOrder(int n2, int n3) {
        if (this.ah != null) return this.ah.a(n2, n3);
        return super.getChildDrawingOrder(n2, n3);
    }

    public fg getCompatAccessibilityDelegate() {
        return this.ag;
    }

    public ej getItemAnimator() {
        return this.f;
    }

    public ep getLayoutManager() {
        return this.e;
    }

    public int getMaxFlingVelocity() {
        return this.W;
    }

    public int getMinFlingVelocity() {
        return this.V;
    }

    public ev getRecycledViewPool() {
        return this.a.f();
    }

    public int getScrollState() {
        return this.N;
    }

    void h() {
        this.M = null;
        this.K = null;
        this.L = null;
        this.J = null;
    }

    public boolean hasNestedScrollingParent() {
        return this.aj.b();
    }

    boolean i() {
        if (this.F == null) return false;
        if (!this.F.isEnabled()) return false;
        return true;
    }

    public boolean isAttachedToWindow() {
        return this.v;
    }

    public boolean isNestedScrollingEnabled() {
        return this.aj.a();
    }

    public boolean j() {
        if (this.I <= 0) return false;
        return true;
    }

    void k() {
        if (this.q == null) {
            Log.e((String)"RecyclerView", (String)"No adapter attached; skipping layout");
            return;
        }
        if (this.e == null) {
            Log.e((String)"RecyclerView", (String)"No layout manager attached; skipping layout");
            return;
        }
        fc.b(this.g, false);
        this.z();
        if (fc.a(this.g) == 1) {
            this.F();
            this.e.f(this);
            this.G();
        } else if (this.b.f() || this.e.v() != this.getWidth() || this.e.w() != this.getHeight()) {
            this.e.f(this);
            this.G();
        } else {
            this.e.f(this);
        }
        this.H();
        this.A();
    }

    void l() {
        int n2 = this.c.c();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.a.i();
                return;
            }
            ((er)this.c.c((int)n3).getLayoutParams()).c = true;
            ++n3;
        } while (true);
    }

    void m() {
        int n2 = this.c.c();
        int n3 = 0;
        while (n3 < n2) {
            ff ff2 = RecyclerView.c(this.c.c(n3));
            if (!ff2.c()) {
                ff2.b();
            }
            ++n3;
        }
    }

    void n() {
        int n2 = this.c.c();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.a.h();
                return;
            }
            ff ff2 = RecyclerView.c(this.c.c(n3));
            if (!ff2.c()) {
                ff2.a();
            }
            ++n3;
        } while (true);
    }

    void o() {
        int n2 = this.c.c();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.l();
                this.a.g();
                return;
            }
            ff ff2 = RecyclerView.c(this.c.c(n3));
            if (ff2 != null && !ff2.c()) {
                ff2.b(6);
            }
            ++n3;
        } while (true);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.I = 0;
        this.v = true;
        this.x = false;
        if (this.e != null) {
            this.e.c(this);
        }
        this.af = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f != null) {
            this.f.c();
        }
        this.x = false;
        this.c();
        this.v = false;
        if (this.e != null) {
            this.e.b(this, this.a);
        }
        this.removeCallbacks(this.an);
        this.d.b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n2 = this.s.size();
        int n3 = 0;
        while (n3 < n2) {
            ((eo)this.s.get(n3)).a(canvas, this, this.g);
            ++n3;
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (this.e == null) {
            return false;
        }
        if (this.A) return false;
        if ((2 & at.d(motionEvent)) == 0) return false;
        if (motionEvent.getAction() != 8) return false;
        float f2 = this.e.e() ? - at.e(motionEvent, 9) : 0.0f;
        if (!this.e.d()) return false;
        float f3 = at.e(motionEvent, 10);
        if (f2 == 0.0f) {
            if (f3 == 0.0f) return false;
        }
        float f4 = this.getScrollFactor();
        this.a((int)(f3 * f4), (int)(f2 * f4), motionEvent);
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:334)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        i.a("RV OnLayout");
        this.k();
        i.a();
        this.x = true;
    }

    protected void onMeasure(int n2, int n3) {
        if (this.e == null) {
            this.i(n2, n3);
            return;
        }
        if (ep.a(this.e)) {
            int n4 = View.MeasureSpec.getMode((int)n2);
            int n5 = View.MeasureSpec.getMode((int)n3);
            boolean bl2 = false;
            if (n4 == 1073741824) {
                bl2 = false;
                if (n5 == 1073741824) {
                    bl2 = true;
                }
            }
            this.e.a(this.a, this.g, n2, n3);
            if (bl2) return;
            if (this.q == null) return;
            if (fc.a(this.g) == 1) {
                this.F();
            }
            this.e.a(n2, n3);
            fc.b(this.g, true);
            this.G();
            this.e.b(n2, n3);
            if (!this.e.j()) return;
            this.e.a(View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)1073741824));
            fc.b(this.g, true);
            this.G();
            this.e.b(n2, n3);
            return;
        }
        if (this.w) {
            this.e.a(this.a, this.g, n2, n3);
            return;
        }
        if (this.D) {
            this.b();
            this.E();
            if (fc.b(this.g)) {
                fc.c(this.g, true);
            } else {
                this.b.e();
                fc.c(this.g, false);
            }
            this.D = false;
            this.a(false);
        }
        this.g.a = this.q != null ? this.q.a() : 0;
        this.b();
        this.e.a(this.a, this.g, n2, n3);
        this.a(false);
        fc.c(this.g, false);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        this.m = (RecyclerView$SavedState)parcelable;
        super.onRestoreInstanceState(this.m.getSuperState());
        if (this.e == null) return;
        if (this.m.a == null) return;
        this.e.a(this.m.a);
    }

    protected Parcelable onSaveInstanceState() {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(super.onSaveInstanceState());
        if (this.m != null) {
            RecyclerView$SavedState.a(recyclerView$SavedState, this.m);
            return recyclerView$SavedState;
        }
        if (this.e != null) {
            recyclerView$SavedState.a = this.e.c();
            return recyclerView$SavedState;
        }
        recyclerView$SavedState.a = null;
        return recyclerView$SavedState;
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        if (n2 == n4) {
            if (n3 == n5) return;
        }
        this.h();
    }

    /*
     * Exception decompiling
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.CannotPerformDecode: reachable test BLOCK was exited and re-entered.
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.getFarthestReachableInRange(Misc.java:143)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:385)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.rebuildSwitches(SwitchReplacer.java:334)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:539)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean p() {
        if (!this.x) return true;
        if (this.H) return true;
        if (!this.b.d()) return false;
        return true;
    }

    protected void removeDetachedView(View view, boolean bl2) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 != null) {
            if (ff2.r()) {
                ff2.m();
            } else if (!ff2.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + ff2);
            }
        }
        this.i(view);
        super.removeDetachedView(view, bl2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.e.a(this, this.g, view, view2) && view2 != null) {
            this.p.set(0, 0, view2.getWidth(), view2.getHeight());
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof er) {
                er er2 = (er)layoutParams;
                if (!er2.c) {
                    Rect rect = er2.b;
                    Rect rect2 = this.p;
                    rect2.left -= rect.left;
                    Rect rect3 = this.p;
                    rect3.right += rect.right;
                    Rect rect4 = this.p;
                    rect4.top -= rect.top;
                    Rect rect5 = this.p;
                    rect5.bottom += rect.bottom;
                }
            }
            this.offsetDescendantRectToMyCoords(view2, this.p);
            this.offsetRectIntoDescendantCoords(view, this.p);
            Rect rect = this.p;
            boolean bl2 = !this.x;
            this.requestChildRectangleOnScreen(view, rect, bl2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        return this.e.a(this, view, rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        int n2 = this.t.size();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                super.requestDisallowInterceptTouchEvent(bl2);
                return;
            }
            ((et)this.t.get(n3)).a(bl2);
            ++n3;
        } while (true);
    }

    public void requestLayout() {
        if (this.y == 0 && !this.A) {
            super.requestLayout();
            return;
        }
        this.z = true;
    }

    public void scrollBy(int n2, int n3) {
        if (this.e == null) {
            Log.e((String)"RecyclerView", (String)"Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.A) return;
        boolean bl2 = this.e.d();
        boolean bl3 = this.e.e();
        if (!bl2) {
            if (!bl3) return;
        }
        if (!bl2) {
            n2 = 0;
        }
        if (!bl3) {
            n3 = 0;
        }
        this.a(n2, n3, null);
    }

    public void scrollTo(int n2, int n3) {
        Log.w((String)"RecyclerView", (String)"RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (this.a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(fg fg2) {
        this.ag = fg2;
        bo.a((View)this, this.ag);
    }

    public void setAdapter(ef ef2) {
        this.setLayoutFrozen(false);
        this.a(ef2, false, true);
        this.requestLayout();
    }

    public void setChildDrawingOrderCallback(ei ei2) {
        if (ei2 == this.ah) {
            return;
        }
        this.ah = ei2;
        boolean bl2 = this.ah != null;
        this.setChildrenDrawingOrderEnabled(bl2);
    }

    public void setClipToPadding(boolean bl2) {
        if (bl2 != this.n) {
            this.h();
        }
        this.n = bl2;
        super.setClipToPadding(bl2);
        if (!this.x) return;
        this.requestLayout();
    }

    public void setHasFixedSize(boolean bl2) {
        this.w = bl2;
    }

    public void setItemAnimator(ej ej2) {
        if (this.f != null) {
            this.f.c();
            this.f.a(null);
        }
        this.f = ej2;
        if (this.f == null) return;
        this.f.a(this.ae);
    }

    public void setItemViewCacheSize(int n2) {
        this.a.a(n2);
    }

    public void setLayoutFrozen(boolean bl2) {
        if (bl2 == this.A) return;
        this.a("Do not setLayoutFrozen in layout or scroll");
        if (bl2) {
            long l2 = SystemClock.uptimeMillis();
            this.onTouchEvent(MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0));
            this.A = true;
            this.B = true;
            this.c();
            return;
        }
        this.A = false;
        if (this.z && this.e != null && this.q != null) {
            this.requestLayout();
        }
        this.z = false;
    }

    public void setLayoutManager(ep ep2) {
        if (ep2 == this.e) {
            return;
        }
        this.c();
        if (this.e != null) {
            if (this.v) {
                this.e.b(this, this.a);
            }
            this.e.b((RecyclerView)null);
        }
        this.a.a();
        this.c.a();
        this.e = ep2;
        if (ep2 != null) {
            if (ep2.q != null) {
                throw new IllegalArgumentException("LayoutManager " + ep2 + " is already attached to a RecyclerView: " + ep2.q);
            }
            this.e.b(this);
            if (this.v) {
                this.e.c(this);
            }
        }
        this.requestLayout();
    }

    public void setNestedScrollingEnabled(boolean bl2) {
        this.aj.a(bl2);
    }

    @Deprecated
    public void setOnScrollListener(eu eu2) {
        this.ac = eu2;
    }

    public void setRecycledViewPool(ev ev2) {
        this.a.a(ev2);
    }

    public void setRecyclerListener(ex ex2) {
        this.r = ex2;
    }

    public void setScrollingTouchSlop(int n2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get((Context)this.getContext());
        switch (n2) {
            default: {
                Log.w((String)"RecyclerView", (String)("setScrollingTouchSlop(): bad argument constant " + n2 + "; using default value"));
            }
            case 0: {
                this.U = viewConfiguration.getScaledTouchSlop();
                return;
            }
            case 1: 
        }
        this.U = cn.a(viewConfiguration);
    }

    public void setViewCacheExtension(fd fd2) {
        this.a.a(fd2);
    }

    public boolean startNestedScroll(int n2) {
        return this.aj.a(n2);
    }

    @Override
    public void stopNestedScroll() {
        this.aj.c();
    }
}

