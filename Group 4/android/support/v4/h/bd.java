/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.bo;
import android.support.v4.h.cv;
import android.view.View;
import android.view.ViewParent;

public class bd {
    private final View a;
    private ViewParent b;
    private boolean c;
    private int[] d;

    public bd(View view) {
        this.a = view;
    }

    public void a(boolean bl2) {
        if (this.c) {
            bo.z(this.a);
        }
        this.c = bl2;
    }

    public boolean a() {
        return this.c;
    }

    public boolean a(float f2, float f3) {
        if (!this.a()) return false;
        if (this.b == null) return false;
        return cv.a(this.b, this.a, f2, f3);
    }

    public boolean a(float f2, float f3, boolean bl2) {
        if (!this.a()) return false;
        if (this.b == null) return false;
        return cv.a(this.b, this.a, f2, f3, bl2);
    }

    public boolean a(int n2) {
        if (this.b()) {
            return true;
        }
        if (!this.a()) return false;
        ViewParent viewParent = this.a.getParent();
        View view = this.a;
        while (viewParent != null) {
            if (cv.a(viewParent, view, this.a, n2)) {
                this.b = viewParent;
                cv.b(viewParent, view, this.a, n2);
                return true;
            }
            if (viewParent instanceof View) {
                view = (View)viewParent;
            }
            viewParent = viewParent.getParent();
        }
        return false;
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn) {
        int n6;
        int n7;
        boolean bl2 = this.a();
        boolean bl3 = false;
        if (!bl2) return bl3;
        ViewParent viewParent = this.b;
        bl3 = false;
        if (viewParent == null) return bl3;
        if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
            bl3 = false;
            if (arrn == null) return bl3;
            arrn[0] = 0;
            arrn[1] = 0;
            return false;
        }
        if (arrn != null) {
            this.a.getLocationInWindow(arrn);
            int n8 = arrn[0];
            n6 = arrn[1];
            n7 = n8;
        } else {
            n6 = 0;
            n7 = 0;
        }
        cv.a(this.b, this.a, n2, n3, n4, n5);
        if (arrn == null) return true;
        this.a.getLocationInWindow(arrn);
        arrn[0] = arrn[0] - n7;
        arrn[1] = arrn[1] - n6;
        return true;
    }

    public boolean a(int n2, int n3, int[] arrn, int[] arrn2) {
        int n4;
        int n5;
        boolean bl2 = this.a();
        boolean bl3 = false;
        if (!bl2) return bl3;
        ViewParent viewParent = this.b;
        bl3 = false;
        if (viewParent == null) return bl3;
        if (n2 == 0 && n3 == 0) {
            bl3 = false;
            if (arrn2 == null) return bl3;
            arrn2[0] = 0;
            arrn2[1] = 0;
            return false;
        }
        if (arrn2 != null) {
            this.a.getLocationInWindow(arrn2);
            n4 = arrn2[0];
            n5 = arrn2[1];
        } else {
            n5 = 0;
            n4 = 0;
        }
        if (arrn == null) {
            if (this.d == null) {
                this.d = new int[2];
            }
            arrn = this.d;
        }
        arrn[0] = 0;
        arrn[1] = 0;
        cv.a(this.b, this.a, n2, n3, arrn);
        if (arrn2 != null) {
            this.a.getLocationInWindow(arrn2);
            arrn2[0] = arrn2[0] - n4;
            arrn2[1] = arrn2[1] - n5;
        }
        if (arrn[0] != 0) return true;
        int n6 = arrn[1];
        bl3 = false;
        if (n6 == 0) return bl3;
        return true;
    }

    public boolean b() {
        if (this.b == null) return false;
        return true;
    }

    public void c() {
        if (this.b == null) return;
        cv.a(this.b, this.a);
        this.b = null;
    }
}

