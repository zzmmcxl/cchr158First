/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.cy;
import android.support.v4.h.db;
import android.view.View;
import android.view.ViewParent;

class cz
extends cy {
    cz() {
    }

    @Override
    public void a(ViewParent viewParent, View view) {
        db.a(viewParent, view);
    }

    @Override
    public void a(ViewParent viewParent, View view, int n2, int n3, int n4, int n5) {
        db.a(viewParent, view, n2, n3, n4, n5);
    }

    @Override
    public void a(ViewParent viewParent, View view, int n2, int n3, int[] arrn) {
        db.a(viewParent, view, n2, n3, arrn);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, float f2, float f3) {
        return db.a(viewParent, view, f2, f3);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, float f2, float f3, boolean bl2) {
        return db.a(viewParent, view, f2, f3, bl2);
    }

    @Override
    public boolean a(ViewParent viewParent, View view, View view2, int n2) {
        return db.a(viewParent, view, view2, n2);
    }

    @Override
    public void b(ViewParent viewParent, View view, View view2, int n2) {
        db.b(viewParent, view, view2, n2);
    }
}

