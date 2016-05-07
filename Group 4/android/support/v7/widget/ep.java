/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.h.a.a;
import android.support.v4.h.a.aj;
import android.support.v4.h.a.g;
import android.support.v4.h.a.q;
import android.support.v4.h.a.r;
import android.support.v4.h.bo;
import android.support.v7.e.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ca;
import android.support.v7.widget.ef;
import android.support.v7.widget.ej;
import android.support.v7.widget.eq;
import android.support.v7.widget.er;
import android.support.v7.widget.ew;
import android.support.v7.widget.fa;
import android.support.v7.widget.fc;
import android.support.v7.widget.ff;
import android.support.v7.widget.gv;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class ep {
    private boolean a = false;
    private boolean b = false;
    private boolean c = true;
    private int d;
    private int e;
    ca p;
    RecyclerView q;
    fa r;
    boolean s = false;

    /*
     * Unable to fully structure code
     */
    public static int a(int var0, int var1_1, int var2_2) {
        var3_3 = View.MeasureSpec.getMode((int)var0);
        var4_4 = View.MeasureSpec.getSize((int)var0);
        switch (var3_3) {
            default: {
                ** GOTO lbl8
            }
            case Integer.MIN_VALUE: {
                var1_1 = Math.min(var4_4, var1_1);
lbl8: // 2 sources:
                var4_4 = Math.max(var1_1, var2_2);
            }
            case 1073741824: 
        }
        return var4_4;
    }

    public static int a(int n2, int n3, int n4, int n5, boolean bl2) {
        int n6;
        int n7 = 0;
        int n8 = Math.max(0, n2 - n4);
        if (bl2) {
            if (n5 >= 0) {
                n6 = 1073741824;
                n8 = n5;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
            if (n5 == -1) {
                switch (n3) {
                    default: {
                        n3 = 0;
                        break;
                    }
                    case Integer.MIN_VALUE: 
                    case 1073741824: {
                        n7 = n8;
                        break;
                    }
                    case 0: {
                        n7 = 0;
                        n3 = 0;
                    }
                }
                n8 = n7;
                n6 = n3;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
            if (n5 == -2) {
                n6 = 0;
                n8 = 0;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
        } else {
            if (n5 >= 0) {
                n6 = 1073741824;
                n8 = n5;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
            if (n5 == -1) {
                n6 = n3;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
            if (n5 == -2) {
                if (n3 != Integer.MIN_VALUE) {
                    n6 = 0;
                    if (n3 != 1073741824) return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
                }
                n6 = Integer.MIN_VALUE;
                return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
            }
        }
        n6 = 0;
        n8 = 0;
        return View.MeasureSpec.makeMeasureSpec((int)n8, (int)n6);
    }

    public static eq a(Context context, AttributeSet attributeSet, int n2, int n3) {
        eq eq2 = new eq();
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, b.RecyclerView, n2, n3);
        eq2.a = typedArray.getInt(b.RecyclerView_android_orientation, 1);
        eq2.b = typedArray.getInt(b.RecyclerView_spanCount, 1);
        eq2.c = typedArray.getBoolean(b.RecyclerView_reverseLayout, false);
        eq2.d = typedArray.getBoolean(b.RecyclerView_stackFromEnd, false);
        typedArray.recycle();
        return eq2;
    }

    private void a(int n2, View view) {
        this.p.d(n2);
    }

    static /* synthetic */ void a(ep ep2, fa fa2) {
        ep2.a(fa2);
    }

    private void a(ew ew2, int n2, View view) {
        ff ff2 = RecyclerView.c(view);
        if (ff2.c()) {
            return;
        }
        if (ff2.n() && !ff2.q() && !RecyclerView.f(this.q).b()) {
            this.f(n2);
            ew2.b(ff2);
            return;
        }
        this.g(n2);
        ew2.c(view);
        this.q.d.h(ff2);
    }

    private void a(fa fa2) {
        if (this.r != fa2) return;
        this.r = null;
    }

    private void a(View view, int n2, boolean bl2) {
        ff ff2 = RecyclerView.c(view);
        if (bl2 || ff2.q()) {
            this.q.d.e(ff2);
        } else {
            this.q.d.f(ff2);
        }
        er er2 = (er)view.getLayoutParams();
        if (ff2.k() || ff2.i()) {
            if (ff2.i()) {
                ff2.j();
            } else {
                ff2.l();
            }
            this.p.a(view, n2, view.getLayoutParams(), false);
        } else if (view.getParent() == this.q) {
            int n3 = this.p.b(view);
            if (n2 == -1) {
                n2 = this.p.b();
            }
            if (n3 == -1) {
                throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view));
            }
            if (n3 != n2) {
                this.q.e.c(n3, n2);
            }
        } else {
            this.p.a(view, n2, false);
            er2.c = true;
            if (this.r != null && this.r.c()) {
                this.r.b(view);
            }
        }
        if (!er2.d) return;
        ff2.a.invalidate();
        er2.d = false;
    }

    static /* synthetic */ boolean a(ep ep2) {
        return ep2.b;
    }

    static /* synthetic */ boolean a(ep ep2, boolean bl2) {
        ep2.a = bl2;
        return bl2;
    }

    private static boolean b(int n2, int n3, int n4) {
        boolean bl2 = true;
        int n5 = View.MeasureSpec.getMode((int)n3);
        int n6 = View.MeasureSpec.getSize((int)n3);
        if (n4 > 0 && n2 != n4) {
            return false;
        }
        switch (n5) {
            case 0: {
                return bl2;
            }
            default: {
                return false;
            }
            case Integer.MIN_VALUE: {
                if (n6 >= n2) return bl2;
                return false;
            }
            case 1073741824: 
        }
        if (n6 == n2) return bl2;
        return false;
    }

    static /* synthetic */ boolean b(ep ep2) {
        return ep2.a;
    }

    public int A() {
        if (this.q == null) return 0;
        return this.q.getPaddingBottom();
    }

    public View B() {
        if (this.q == null) {
            return null;
        }
        View view = this.q.getFocusedChild();
        if (view == null) return null;
        if (this.p.c(view)) return null;
        return view;
    }

    public int C() {
        return bo.o((View)this.q);
    }

    public int D() {
        return bo.p((View)this.q);
    }

    void E() {
        if (this.r == null) return;
        this.r.a();
    }

    public void F() {
        this.a = true;
    }

    boolean G() {
        int n2 = this.s();
        int n3 = 0;
        do {
            boolean bl2 = false;
            if (n3 >= n2) return bl2;
            ViewGroup.LayoutParams layoutParams = this.h(n3).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
            ++n3;
        } while (true);
    }

    public int a(int n2, ew ew2, fc fc2) {
        return 0;
    }

    public int a(ew ew2, fc fc2) {
        if (this.q == null) return 1;
        if (RecyclerView.f(this.q) == null) {
            return 1;
        }
        if (!this.e()) return 1;
        return RecyclerView.f(this.q).a();
    }

    public abstract er a();

    public er a(Context context, AttributeSet attributeSet) {
        return new er(context, attributeSet);
    }

    public er a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof er) {
            return new er((er)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new er(layoutParams);
        return new er((ViewGroup.MarginLayoutParams)layoutParams);
    }

    public View a(View view, int n2, ew ew2, fc fc2) {
        return null;
    }

    void a(int n2, int n3) {
        this.d = n2;
        this.e = n3;
    }

    public void a(int n2, ew ew2) {
        View view = this.h(n2);
        this.f(n2);
        ew2.a(view);
    }

    public void a(Rect rect, int n2, int n3) {
        int n4 = rect.width() + this.x() + this.z();
        int n5 = rect.height() + this.y() + this.A();
        this.d(ep.a(n2, n4, this.C()), ep.a(n3, n5, this.D()));
    }

    public void a(Parcelable parcelable) {
    }

    void a(g g2) {
        this.a(this.q.a, this.q.g, g2);
    }

    public void a(RecyclerView recyclerView) {
    }

    public void a(RecyclerView recyclerView, int n2, int n3) {
    }

    public void a(RecyclerView recyclerView, int n2, int n3, int n4) {
    }

    public void a(RecyclerView recyclerView, int n2, int n3, Object object) {
        this.c(recyclerView, n2, n3);
    }

    public void a(RecyclerView recyclerView, ew ew2) {
        this.e(recyclerView);
    }

    public void a(ef ef2, ef ef3) {
    }

    public void a(ew ew2) {
        int n2 = -1 + this.s();
        while (n2 >= 0) {
            this.a(ew2, n2, this.h(n2));
            --n2;
        }
    }

    public void a(ew ew2, fc fc2, int n2, int n3) {
        RecyclerView.b(this.q, n2, n3);
    }

    public void a(ew ew2, fc fc2, g g2) {
        if (bo.b((View)this.q, -1) || bo.a((View)this.q, -1)) {
            g2.a(8192);
            g2.a(true);
        }
        if (bo.b((View)this.q, 1) || bo.a((View)this.q, 1)) {
            g2.a(4096);
            g2.a(true);
        }
        g2.a(q.a(this.a(ew2, fc2), this.b(ew2, fc2), this.e(ew2, fc2), this.d(ew2, fc2)));
    }

    public void a(ew ew2, fc fc2, View view, g g2) {
        int n2 = this.e() ? this.d(view) : 0;
        int n3 = this.d() ? this.d(view) : 0;
        g2.b(r.a(n2, 1, n3, 1, false, false));
    }

    public void a(ew ew2, fc fc2, AccessibilityEvent accessibilityEvent) {
        int n2 = 1;
        aj aj2 = a.a(accessibilityEvent);
        if (this.q == null) return;
        if (aj2 == null) {
            return;
        }
        if (!(bo.b((View)this.q, n2) || bo.b((View)this.q, -1) || bo.a((View)this.q, -1) || bo.a((View)this.q, n2))) {
            n2 = 0;
        }
        aj2.a((boolean)n2);
        if (RecyclerView.f(this.q) == null) return;
        aj2.a(RecyclerView.f(this.q).a());
    }

    public void a(View view) {
        this.a(view, -1);
    }

    public void a(View view, int n2) {
        this.a(view, n2, true);
    }

    public void a(View view, int n2, int n3) {
        int n4;
        er er2 = (er)view.getLayoutParams();
        Rect rect = this.q.g(view);
        int n5 = n2 + (rect.left + rect.right);
        int n6 = n3 + (rect.top + rect.bottom);
        int n7 = ep.a(this.v(), this.t(), n5 + (this.x() + this.z() + er2.leftMargin + er2.rightMargin), er2.width, this.d());
        if (!this.b(view, n7, n4 = ep.a(this.w(), this.u(), n6 + (this.y() + this.A() + er2.topMargin + er2.bottomMargin), er2.height, this.e()), er2)) return;
        view.measure(n7, n4);
    }

    public void a(View view, int n2, int n3, int n4, int n5) {
        Rect rect = ((er)view.getLayoutParams()).b;
        view.layout(n2 + rect.left, n3 + rect.top, n4 - rect.right, n5 - rect.bottom);
    }

    public void a(View view, int n2, er er2) {
        ff ff2 = RecyclerView.c(view);
        if (ff2.q()) {
            this.q.d.e(ff2);
        } else {
            this.q.d.f(ff2);
        }
        this.p.a(view, n2, (ViewGroup.LayoutParams)er2, ff2.q());
    }

    public void a(View view, Rect rect) {
        if (this.q == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        rect.set(this.q.g(view));
    }

    void a(View view, g g2) {
        ff ff2 = RecyclerView.c(view);
        if (ff2 == null) return;
        if (ff2.q()) return;
        if (this.p.c(ff2.a)) return;
        this.a(this.q.a, this.q.g, view, g2);
    }

    public void a(View view, ew ew2) {
        this.c(view);
        ew2.a(view);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        this.a(this.q.a, this.q.g, accessibilityEvent);
    }

    public void a(String string) {
        if (this.q == null) return;
        this.q.a(string);
    }

    boolean a(int n2, Bundle bundle) {
        return this.a(this.q.a, this.q.g, n2, bundle);
    }

    public boolean a(RecyclerView recyclerView, fc fc2, View view, View view2) {
        return this.a(recyclerView, view, view2);
    }

    public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean bl2) {
        int n2;
        int n3 = this.x();
        int n4 = this.y();
        int n5 = this.v() - this.z();
        int n6 = this.w() - this.A();
        int n7 = view.getLeft() + rect.left - view.getScrollX();
        int n8 = view.getTop() + rect.top - view.getScrollY();
        int n9 = n7 + rect.width();
        int n10 = n8 + rect.height();
        int n11 = Math.min(0, n7 - n3);
        int n12 = Math.min(0, n8 - n4);
        int n13 = Math.max(0, n9 - n5);
        int n14 = Math.max(0, n10 - n6);
        if (this.q() == 1) {
            if (n13 == 0) {
                n13 = Math.max(n11, n9 - n5);
            }
            n2 = n13;
        } else {
            int n15 = n11 != 0 ? n11 : Math.min(n7 - n3, n13);
            n2 = n15;
        }
        int n16 = n12 != 0 ? n12 : Math.min(n8 - n4, n14);
        if (n2 == 0) {
            if (n16 == 0) return false;
        }
        if (bl2) {
            recyclerView.scrollBy(n2, n16);
            return true;
        }
        recyclerView.a(n2, n16);
        return true;
    }

    @Deprecated
    public boolean a(RecyclerView recyclerView, View view, View view2) {
        if (this.p()) return true;
        if (!recyclerView.j()) return false;
        return true;
    }

    public boolean a(RecyclerView recyclerView, ArrayList arrayList, int n2, int n3) {
        return false;
    }

    public boolean a(er er2) {
        if (er2 == null) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean a(ew var1_1, fc var2_2, int var3_3, Bundle var4_4) {
        if (this.q == null) {
            return false;
        }
        switch (var3_3) {
            default: {
                return false;
            }
            case 8192: {
                var5_7 = bo.b((View)this.q, -1) != false ? - this.w() - this.y() - this.A() : 0;
            }
            case 4096: {
                var5_7 = bo.b((View)this.q, 1) != false ? this.w() - this.y() - this.A() : 0;
                if (!bo.a((View)this.q, 1)) ** GOTO lbl-1000
                var8_9 = this.v() - this.x() - this.z();
                var6_6 = var5_7;
                var7_5 = var8_9;
                ** GOTO lbl22
            }
        }
        if (bo.a((View)this.q, -1)) {
            var9_8 = - this.v() - this.x() - this.z();
            var6_6 = var5_7;
            var7_5 = var9_8;
        } else lbl-1000: // 2 sources:
        {
            var6_6 = var5_7;
            var7_5 = 0;
        }
lbl22: // 3 sources:
        if (var6_6 == 0) {
            if (var7_5 == 0) return false;
        }
        this.q.scrollBy(var7_5, var6_6);
        return true;
    }

    public boolean a(ew ew2, fc fc2, View view, int n2, Bundle bundle) {
        return false;
    }

    boolean a(View view, int n2, int n3, er er2) {
        if (!this.c) return true;
        if (!ep.b(view.getMeasuredWidth(), n2, er2.width)) return true;
        if (ep.b(view.getMeasuredHeight(), n3, er2.height)) return false;
        return true;
    }

    boolean a(View view, int n2, Bundle bundle) {
        return this.a(this.q.a, this.q.g, view, n2, bundle);
    }

    public boolean a(Runnable runnable) {
        if (this.q == null) return false;
        return this.q.removeCallbacks(runnable);
    }

    public int b(int n2, ew ew2, fc fc2) {
        return 0;
    }

    public int b(ew ew2, fc fc2) {
        if (this.q == null) return 1;
        if (RecyclerView.f(this.q) == null) {
            return 1;
        }
        if (!this.d()) return 1;
        return RecyclerView.f(this.q).a();
    }

    public int b(fc fc2) {
        return 0;
    }

    void b(int n2, int n3) {
        int n4 = Integer.MAX_VALUE;
        int n5 = Integer.MIN_VALUE;
        int n6 = this.s();
        if (n6 == 0) {
            RecyclerView.b(this.q, n2, n3);
            return;
        }
        int n7 = 0;
        int n8 = n5;
        int n9 = n4;
        do {
            if (n7 >= n6) {
                RecyclerView.n(this.q).set(n9, n4, n8, n5);
                this.a(RecyclerView.n(this.q), n2, n3);
                return;
            }
            View view = this.h(n7);
            er er2 = (er)view.getLayoutParams();
            int n10 = this.h(view) - er2.leftMargin;
            int n11 = this.j(view) + er2.rightMargin;
            int n12 = this.i(view) - er2.topMargin;
            int n13 = this.k(view) + er2.bottomMargin;
            if (n10 >= n9) {
                n10 = n9;
            }
            if (n11 <= n8) {
                n11 = n8;
            }
            if (n12 >= n4) {
                n12 = n4;
            }
            if (n13 <= n5) {
                n13 = n5;
            }
            ++n7;
            n8 = n11;
            n4 = n12;
            n9 = n10;
            n5 = n13;
        } while (true);
    }

    void b(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.q = null;
            this.p = null;
            this.d = View.MeasureSpec.makeMeasureSpec((int)0, (int)1073741824);
            this.e = View.MeasureSpec.makeMeasureSpec((int)0, (int)1073741824);
            return;
        }
        this.q = recyclerView;
        this.p = recyclerView.c;
        this.d = View.MeasureSpec.makeMeasureSpec((int)recyclerView.getWidth(), (int)1073741824);
        this.e = View.MeasureSpec.makeMeasureSpec((int)recyclerView.getHeight(), (int)1073741824);
    }

    public void b(RecyclerView recyclerView, int n2, int n3) {
    }

    void b(RecyclerView recyclerView, ew ew2) {
        this.s = false;
        this.a(recyclerView, ew2);
    }

    void b(ew ew2) {
        int n2 = ew2.d();
        int n3 = n2 - 1;
        do {
            if (n3 < 0) {
                ew2.e();
                if (n2 <= 0) return;
                this.q.invalidate();
                return;
            }
            View view = ew2.e(n3);
            ff ff2 = RecyclerView.c(view);
            if (!ff2.c()) {
                ff2.a(false);
                if (ff2.r()) {
                    this.q.removeDetachedView(view, false);
                }
                if (this.q.f != null) {
                    this.q.f.c(ff2);
                }
                ff2.a(true);
                ew2.b(view);
            }
            --n3;
        } while (true);
    }

    public void b(View view) {
        this.b(view, -1);
    }

    public void b(View view, int n2) {
        this.a(view, n2, false);
    }

    public boolean b() {
        return false;
    }

    boolean b(View view, int n2, int n3, er er2) {
        if (view.isLayoutRequested()) return true;
        if (!this.c) return true;
        if (!ep.b(view.getWidth(), n2, er2.width)) return true;
        if (ep.b(view.getHeight(), n3, er2.height)) return false;
        return true;
    }

    public int c(fc fc2) {
        return 0;
    }

    public Parcelable c() {
        return null;
    }

    public View c(int n2) {
        int n3 = this.s();
        int n4 = 0;
        while (n4 < n3) {
            View view = this.h(n4);
            ff ff2 = RecyclerView.c(view);
            if (ff2 != null && ff2.d() == n2 && !ff2.c()) {
                if (this.q.g.a()) return view;
                if (!ff2.q()) {
                    return view;
                }
            }
            ++n4;
        }
        return null;
    }

    public void c(int n2, int n3) {
        View view = this.h(n2);
        if (view == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + n2);
        }
        this.g(n2);
        this.c(view, n3);
    }

    void c(RecyclerView recyclerView) {
        this.s = true;
        this.d(recyclerView);
    }

    public void c(RecyclerView recyclerView, int n2, int n3) {
    }

    public void c(ew ew2) {
        int n2 = -1 + this.s();
        while (n2 >= 0) {
            if (!RecyclerView.c(this.h(n2)).c()) {
                this.a(n2, ew2);
            }
            --n2;
        }
    }

    public void c(ew ew2, fc fc2) {
        Log.e((String)"RecyclerView", (String)"You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void c(View view) {
        this.p.a(view);
    }

    public void c(View view, int n2) {
        this.a(view, n2, (er)view.getLayoutParams());
    }

    public void c(boolean bl2) {
        this.b = bl2;
    }

    public int d(ew ew2, fc fc2) {
        return 0;
    }

    public int d(fc fc2) {
        return 0;
    }

    public int d(View view) {
        return ((er)view.getLayoutParams()).e();
    }

    public View d(View view, int n2) {
        return null;
    }

    public void d(int n2) {
    }

    public void d(int n2, int n3) {
        RecyclerView.c(this.q, n2, n3);
    }

    public void d(RecyclerView recyclerView) {
    }

    public boolean d() {
        return false;
    }

    public int e(fc fc2) {
        return 0;
    }

    public View e(View view) {
        if (this.q == null) {
            return null;
        }
        View view2 = this.q.b(view);
        if (view2 == null) return null;
        if (this.p.c(view2)) return null;
        return view2;
    }

    @Deprecated
    public void e(RecyclerView recyclerView) {
    }

    public boolean e() {
        return false;
    }

    public boolean e(ew ew2, fc fc2) {
        return false;
    }

    public int f(fc fc2) {
        return 0;
    }

    public int f(View view) {
        Rect rect = ((er)view.getLayoutParams()).b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public void f(int n2) {
        if (this.h(n2) == null) return;
        this.p.a(n2);
    }

    void f(RecyclerView recyclerView) {
        this.a(View.MeasureSpec.makeMeasureSpec((int)recyclerView.getWidth(), (int)1073741824), View.MeasureSpec.makeMeasureSpec((int)recyclerView.getHeight(), (int)1073741824));
    }

    public int g(fc fc2) {
        return 0;
    }

    public int g(View view) {
        Rect rect = ((er)view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public void g(int n2) {
        this.a(n2, this.h(n2));
    }

    public int h(View view) {
        return view.getLeft() - this.n(view);
    }

    public View h(int n2) {
        if (this.p == null) return null;
        return this.p.b(n2);
    }

    public int i(View view) {
        return view.getTop() - this.l(view);
    }

    public void i(int n2) {
        if (this.q == null) return;
        this.q.b(n2);
    }

    public int j(View view) {
        return view.getRight() + this.o(view);
    }

    public void j(int n2) {
        if (this.q == null) return;
        this.q.a(n2);
    }

    boolean j() {
        return false;
    }

    public int k(View view) {
        return view.getBottom() + this.m(view);
    }

    public void k(int n2) {
    }

    public int l(View view) {
        return ((er)view.getLayoutParams()).b.top;
    }

    public int m(View view) {
        return ((er)view.getLayoutParams()).b.bottom;
    }

    public void m() {
        if (this.q == null) return;
        this.q.requestLayout();
    }

    public int n(View view) {
        return ((er)view.getLayoutParams()).b.left;
    }

    public boolean n() {
        return this.s;
    }

    public int o(View view) {
        return ((er)view.getLayoutParams()).b.right;
    }

    public boolean o() {
        if (this.q == null) return false;
        if (!RecyclerView.o(this.q)) return false;
        return true;
    }

    public boolean p() {
        if (this.r == null) return false;
        if (!this.r.c()) return false;
        return true;
    }

    public int q() {
        return bo.h((View)this.q);
    }

    public int r() {
        return -1;
    }

    public int s() {
        if (this.p == null) return 0;
        return this.p.b();
    }

    public int t() {
        return View.MeasureSpec.getMode((int)this.d);
    }

    public int u() {
        return View.MeasureSpec.getMode((int)this.e);
    }

    public int v() {
        return View.MeasureSpec.getSize((int)this.d);
    }

    public int w() {
        return View.MeasureSpec.getSize((int)this.e);
    }

    public int x() {
        if (this.q == null) return 0;
        return this.q.getPaddingLeft();
    }

    public int y() {
        if (this.q == null) return 0;
        return this.q.getPaddingTop();
    }

    public int z() {
        if (this.q == null) return 0;
        return this.q.getPaddingRight();
    }
}

