/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.util.SparseArray;

public class fc {
    int a = 0;
    private int b = -1;
    private int c = 1;
    private SparseArray d;
    private int e = 0;
    private int f = 0;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    static /* synthetic */ int a(fc fc2) {
        return fc2.c;
    }

    static /* synthetic */ int a(fc fc2, int n2) {
        int n3;
        fc2.f = n3 = n2 + fc2.f;
        return n3;
    }

    static /* synthetic */ boolean a(fc fc2, boolean bl2) {
        fc2.g = bl2;
        return bl2;
    }

    static /* synthetic */ int b(fc fc2, int n2) {
        fc2.c = n2;
        return n2;
    }

    static /* synthetic */ boolean b(fc fc2) {
        return fc2.j;
    }

    static /* synthetic */ boolean b(fc fc2, boolean bl2) {
        fc2.l = bl2;
        return bl2;
    }

    static /* synthetic */ int c(fc fc2, int n2) {
        fc2.f = n2;
        return n2;
    }

    static /* synthetic */ boolean c(fc fc2) {
        return fc2.i;
    }

    static /* synthetic */ boolean c(fc fc2, boolean bl2) {
        fc2.h = bl2;
        return bl2;
    }

    static /* synthetic */ int d(fc fc2, int n2) {
        fc2.e = n2;
        return n2;
    }

    static /* synthetic */ boolean d(fc fc2) {
        return fc2.k;
    }

    static /* synthetic */ boolean d(fc fc2, boolean bl2) {
        fc2.i = bl2;
        return bl2;
    }

    static /* synthetic */ int e(fc fc2, int n2) {
        fc2.b = n2;
        return n2;
    }

    static /* synthetic */ boolean e(fc fc2) {
        return fc2.g;
    }

    static /* synthetic */ boolean e(fc fc2, boolean bl2) {
        fc2.j = bl2;
        return bl2;
    }

    static /* synthetic */ boolean f(fc fc2) {
        return fc2.h;
    }

    static /* synthetic */ boolean f(fc fc2, boolean bl2) {
        fc2.k = bl2;
        return bl2;
    }

    void a(int n2) {
        if ((n2 & this.c) != 0) return;
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(n2) + " but it is " + Integer.toBinaryString(this.c));
    }

    public boolean a() {
        return this.h;
    }

    public boolean b() {
        return this.j;
    }

    public int c() {
        return this.b;
    }

    public boolean d() {
        if (this.b == -1) return false;
        return true;
    }

    public int e() {
        if (!this.h) return this.a;
        return this.e - this.f;
    }

    public String toString() {
        return "State{mTargetPosition=" + this.b + ", mData=" + (Object)this.d + ", mItemCount=" + this.a + ", mPreviousLayoutItemCount=" + this.e + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
    }
}

