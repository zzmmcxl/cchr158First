/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.design.i;
import android.support.design.widget.BottomSheetBehavior$SavedState;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.j;
import android.support.design.widget.l;
import android.support.design.widget.q;
import android.support.v4.h.at;
import android.support.v4.h.bc;
import android.support.v4.h.bj;
import android.support.v4.h.bo;
import android.support.v4.widget.bm;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior
extends q {
    private float a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f = 4;
    private android.support.v4.widget.bj g;
    private boolean h;
    private int i;
    private boolean j;
    private int k;
    private WeakReference l;
    private WeakReference m;
    private j n;
    private VelocityTracker o;
    private int p;
    private int q;
    private boolean r;
    private final bm s;

    public BottomSheetBehavior() {
        this.s = new android.support.design.widget.i(this);
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.s = new android.support.design.widget.i(this);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, i.BottomSheetBehavior_Params);
        this.a(typedArray.getDimensionPixelSize(i.BottomSheetBehavior_Params_behavior_peekHeight, 0));
        this.a(typedArray.getBoolean(i.BottomSheetBehavior_Params_behavior_hideable, false));
        typedArray.recycle();
        this.a = ViewConfiguration.get((Context)context).getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ int a(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.f;
    }

    private View a(View view) {
        if (view instanceof bc) {
            return view;
        }
        if (!(view instanceof ViewGroup)) return null;
        ViewGroup viewGroup = (ViewGroup)view;
        int n2 = viewGroup.getChildCount();
        int n3 = 0;
        while (n3 < n2) {
            View view2 = this.a(viewGroup.getChildAt(n3));
            if (view2 != null) {
                return view2;
            }
            ++n3;
        }
        return null;
    }

    private void a() {
        this.p = -1;
        if (this.o == null) return;
        this.o.recycle();
        this.o = null;
    }

    static /* synthetic */ void a(BottomSheetBehavior bottomSheetBehavior, int n2) {
        bottomSheetBehavior.c(n2);
    }

    static /* synthetic */ boolean a(BottomSheetBehavior bottomSheetBehavior, View view, float f2) {
        return bottomSheetBehavior.a(view, f2);
    }

    private boolean a(View view, float f2) {
        if (view.getTop() < this.d) {
            return false;
        }
        if (Math.abs((float)view.getTop() + 0.1f * f2 - (float)this.d) / (float)this.b <= 0.5f) return false;
        return true;
    }

    private float b() {
        this.o.computeCurrentVelocity(1000, this.a);
        return bj.b(this.o, this.p);
    }

    private void b(int n2) {
        if (this.f == n2) {
            return;
        }
        this.f = n2;
        View view = (View)this.l.get();
        if (view == null) return;
        if (this.n == null) return;
        this.n.a(view, n2);
    }

    static /* synthetic */ void b(BottomSheetBehavior bottomSheetBehavior, int n2) {
        bottomSheetBehavior.b(n2);
    }

    static /* synthetic */ boolean b(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.r;
    }

    static /* synthetic */ int c(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.p;
    }

    private void c(int n2) {
        View view = (View)this.l.get();
        if (view == null) return;
        if (this.n == null) return;
        if (n2 > this.d) {
            this.n.a(view, (float)(this.d - n2) / (float)this.b);
            return;
        }
        this.n.a(view, (float)(this.d - n2) / (float)(this.d - this.c));
    }

    static /* synthetic */ WeakReference d(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.m;
    }

    static /* synthetic */ WeakReference e(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.l;
    }

    static /* synthetic */ int f(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.c;
    }

    static /* synthetic */ boolean g(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.e;
    }

    static /* synthetic */ int h(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.k;
    }

    static /* synthetic */ int i(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.d;
    }

    static /* synthetic */ android.support.v4.widget.bj j(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.g;
    }

    public final void a(int n2) {
        this.b = Math.max(0, n2);
        this.d = this.k - n2;
    }

    @Override
    public void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        BottomSheetBehavior$SavedState bottomSheetBehavior$SavedState = (BottomSheetBehavior$SavedState)parcelable;
        super.a(coordinatorLayout, view, bottomSheetBehavior$SavedState.getSuperState());
        if (bottomSheetBehavior$SavedState.a != 1 && bottomSheetBehavior$SavedState.a != 2) {
            this.f = bottomSheetBehavior$SavedState.a;
            return;
        }
        this.f = 4;
    }

    @Override
    public void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int n2;
        int n3 = 3;
        if (view.getTop() == this.c) {
            this.b(n3);
            return;
        }
        if (view2 != this.m.get()) return;
        if (!this.j) return;
        if (this.i > 0) {
            n2 = this.c;
        } else if (this.e && this.a(view, this.b())) {
            n2 = this.k;
            n3 = 5;
        } else if (this.i == 0) {
            int n4 = view.getTop();
            if (Math.abs(n4 - this.c) < Math.abs(n4 - this.d)) {
                n2 = this.c;
            } else {
                n2 = this.d;
                n3 = 4;
            }
        } else {
            n2 = this.d;
            n3 = 4;
        }
        if (this.g.a(view, view.getLeft(), n2)) {
            this.b(2);
            bo.a(view, new l(this, view, n3));
        } else {
            this.b(n3);
        }
        this.j = false;
    }

    @Override
    public void a(CoordinatorLayout coordinatorLayout, View view, View view2, int n2, int n3, int[] arrn) {
        if (view2 != (View)this.m.get()) {
            return;
        }
        int n4 = view.getTop();
        int n5 = n4 - n3;
        if (n3 > 0) {
            if (n5 < this.c) {
                arrn[1] = n4 - this.c;
                bo.e(view, - arrn[1]);
                this.b(3);
            } else {
                arrn[1] = n3;
                bo.e(view, - n3);
                this.b(1);
            }
        } else if (n3 < 0 && !bo.b(view2, -1)) {
            if (n5 <= this.d || this.e) {
                arrn[1] = n3;
                bo.e(view, - n3);
                this.b(1);
            } else {
                arrn[1] = n4 - this.d;
                bo.e(view, - arrn[1]);
                this.b(4);
            }
        }
        this.c(view.getTop());
        this.i = n3;
        this.j = true;
    }

    public void a(boolean bl2) {
        this.e = bl2;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int n2) {
        if (this.f != 1 && this.f != 2) {
            coordinatorLayout.a(view, n2);
        }
        this.k = coordinatorLayout.getHeight();
        this.c = Math.max(0, this.k - view.getHeight());
        this.d = this.k - this.b;
        if (this.f == 3) {
            bo.e(view, this.c);
        } else if (this.e && this.f == 5) {
            bo.e(view, this.k);
        } else if (this.f == 4) {
            bo.e(view, this.d);
        }
        if (this.g == null) {
            this.g = android.support.v4.widget.bj.a(coordinatorLayout, this.s);
        }
        this.l = new WeakReference<View>(view);
        this.m = new WeakReference<View>(this.a(view));
        return true;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int n2 = 1;
        if (!view.isShown()) {
            return false;
        }
        int n3 = at.a(motionEvent);
        if (n3 == 0) {
            this.a();
        }
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
        this.o.addMovement(motionEvent);
        switch (n3) {
            case 1: 
            case 3: {
                this.r = false;
                this.p = -1;
                if (!this.h) break;
                this.h = false;
                return false;
            }
            case 0: {
                int n4 = (int)motionEvent.getX();
                this.q = (int)motionEvent.getY();
                View view2 = (View)this.m.get();
                if (view2 != null && coordinatorLayout.a(view2, n4, this.q)) {
                    this.p = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.r = n2;
                }
                int n5 = this.p == -1 && !coordinatorLayout.a(view, n4, this.q) ? n2 : 0;
                this.h = n5;
            }
        }
        if (!this.h && this.g.a(motionEvent)) {
            return (boolean)n2;
        }
        View view3 = (View)this.m.get();
        if (n3 != 2) return (boolean)0;
        if (view3 == null) return (boolean)0;
        if (this.h) return (boolean)0;
        if (this.f == n2) return (boolean)0;
        if (coordinatorLayout.a(view3, (int)motionEvent.getX(), (int)motionEvent.getY())) return (boolean)0;
        if (Math.abs((float)this.q - motionEvent.getY()) <= (float)this.g.a()) return (boolean)0;
        return (boolean)n2;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, float f2, float f3) {
        if (view2 != this.m.get()) return false;
        if (this.f != 3) return true;
        if (!super.a(coordinatorLayout, view, view2, f2, f3)) return false;
        return true;
    }

    @Override
    public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n2) {
        this.i = 0;
        this.j = false;
        int n3 = n2 & 2;
        boolean bl2 = false;
        if (n3 == 0) return bl2;
        return true;
    }

    @Override
    public Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
        return new BottomSheetBehavior$SavedState(super.b(coordinatorLayout, view), this.f);
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean bl2 = true;
        if (!view.isShown()) {
            return false;
        }
        int n2 = at.a(motionEvent);
        if (this.f == bl2) {
            if (n2 == 0) return bl2;
        }
        this.g.b(motionEvent);
        if (n2 == 0) {
            this.a();
        }
        if (this.o == null) {
            this.o = VelocityTracker.obtain();
        }
        this.o.addMovement(motionEvent);
        if (n2 != 2) return bl2;
        if (Math.abs((float)this.q - motionEvent.getY()) <= (float)this.g.a()) return bl2;
        this.g.a(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
        return bl2;
    }
}

