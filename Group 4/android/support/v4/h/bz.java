/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v4.h.bg;
import android.support.v4.h.by;
import android.support.v4.h.ck;
import android.support.v4.h.dw;
import android.view.View;

class bz
extends by {
    bz() {
    }

    @Override
    public PorterDuff.Mode A(View view) {
        return ck.e(view);
    }

    @Override
    public void B(View view) {
        ck.f(view);
    }

    @Override
    public float D(View view) {
        return ck.g(view);
    }

    @Override
    public dw a(View view, dw dw2) {
        return ck.a(view, dw2);
    }

    @Override
    public void a(View view, ColorStateList colorStateList) {
        ck.a(view, colorStateList);
    }

    @Override
    public void a(View view, PorterDuff.Mode mode) {
        ck.a(view, mode);
    }

    @Override
    public void a(View view, bg bg2) {
        ck.a(view, bg2);
    }

    @Override
    public void d(View view, float f2) {
        ck.a(view, f2);
    }

    @Override
    public void t(View view) {
        ck.a(view);
    }

    @Override
    public float u(View view) {
        return ck.b(view);
    }

    @Override
    public float v(View view) {
        return ck.c(view);
    }

    @Override
    public ColorStateList z(View view) {
        return ck.d(view);
    }
}

