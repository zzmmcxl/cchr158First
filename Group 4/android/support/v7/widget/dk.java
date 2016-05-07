/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.content.Context;
import android.os.SystemClock;
import android.support.v4.h.at;
import android.support.v7.widget.df;
import android.support.v7.widget.dg;
import android.support.v7.widget.dj;
import android.support.v7.widget.dl;
import android.support.v7.widget.dm;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class dk
implements View.OnTouchListener {
    private final float a;
    private final int b;
    private final int c;
    private final View d;
    private Runnable e;
    private Runnable f;
    private boolean g;
    private boolean h;
    private int i;
    private final int[] j = new int[2];

    public dk(View view) {
        this.d = view;
        this.a = ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.b = ViewConfiguration.getTapTimeout();
        this.c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    static /* synthetic */ View a(dk dk2) {
        return dk2.d;
    }

    private boolean a(MotionEvent motionEvent) {
        View view = this.d;
        if (!view.isEnabled()) {
            return false;
        }
        switch (at.a(motionEvent)) {
            default: {
                return false;
            }
            case 0: {
                this.i = motionEvent.getPointerId(0);
                this.h = false;
                if (this.e == null) {
                    this.e = new dl(this, null);
                }
                view.postDelayed(this.e, (long)this.b);
                if (this.f == null) {
                    this.f = new dm(this, null);
                }
                view.postDelayed(this.f, (long)this.c);
                return false;
            }
            case 2: {
                int n2 = motionEvent.findPointerIndex(this.i);
                if (n2 < 0) return false;
                if (dk.a(view, motionEvent.getX(n2), motionEvent.getY(n2), this.a)) return false;
                this.d();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            case 1: 
            case 3: 
        }
        this.d();
        return false;
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        if (f2 < - f4) return false;
        if (f3 < - f4) return false;
        if (f2 >= f4 + (float)(view.getRight() - view.getLeft())) return false;
        if (f3 >= f4 + (float)(view.getBottom() - view.getTop())) return false;
        return true;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] arrn = this.j;
        view.getLocationOnScreen(arrn);
        motionEvent.offsetLocation((float)(- arrn[0]), (float)(- arrn[1]));
        return true;
    }

    static /* synthetic */ void b(dk dk2) {
        dk2.e();
    }

    private boolean b(MotionEvent motionEvent) {
        boolean bl2 = true;
        View view = this.d;
        df df2 = this.a();
        if (df2 == null) return false;
        if (!df2.k()) {
            return false;
        }
        dj dj2 = df.a(df2);
        if (dj2 == null) return false;
        if (!dj2.isShown()) return false;
        MotionEvent motionEvent2 = MotionEvent.obtainNoHistory((MotionEvent)motionEvent);
        this.b(view, motionEvent2);
        this.a((View)dj2, motionEvent2);
        boolean bl3 = dj2.a(motionEvent2, this.i);
        motionEvent2.recycle();
        boolean bl4 = at.a(motionEvent);
        boolean bl5 = bl4 != bl2 && !bl4 ? bl2 : false;
        if (!bl3) return false;
        if (!bl5) return false;
        return bl2;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        int[] arrn = this.j;
        view.getLocationOnScreen(arrn);
        motionEvent.offsetLocation((float)arrn[0], (float)arrn[1]);
        return true;
    }

    private void d() {
        if (this.f != null) {
            this.d.removeCallbacks(this.f);
        }
        if (this.e == null) return;
        this.d.removeCallbacks(this.e);
    }

    private void e() {
        this.d();
        View view = this.d;
        if (!view.isEnabled()) return;
        if (view.isLongClickable()) {
            return;
        }
        if (!this.b()) return;
        view.getParent().requestDisallowInterceptTouchEvent(true);
        long l2 = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
        view.onTouchEvent(motionEvent);
        motionEvent.recycle();
        this.g = true;
        this.h = true;
    }

    public abstract df a();

    protected boolean b() {
        df df2 = this.a();
        if (df2 == null) return true;
        if (df2.k()) return true;
        df2.c();
        return true;
    }

    protected boolean c() {
        df df2 = this.a();
        if (df2 == null) return true;
        if (!df2.k()) return true;
        df2.i();
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl2;
        boolean bl3 = this.g;
        if (bl3) {
            bl2 = this.h ? this.b(motionEvent) : this.b(motionEvent) || !this.c();
        } else {
            boolean bl4 = this.a(motionEvent) && this.b();
            if (bl4) {
                long l2 = SystemClock.uptimeMillis();
                MotionEvent motionEvent2 = MotionEvent.obtain((long)l2, (long)l2, (int)3, (float)0.0f, (float)0.0f, (int)0);
                this.d.onTouchEvent(motionEvent2);
                motionEvent2.recycle();
            }
            bl2 = bl4;
        }
        this.g = bl2;
        if (bl2) return true;
        boolean bl5 = false;
        if (!bl3) return bl5;
        return true;
    }
}

