/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.view.KeyEvent;

public abstract class a {
    public abstract int a();

    public b a(c c2) {
        return null;
    }

    public void a(float f2) {
        if (f2 == 0.0f) return;
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void a(Configuration configuration) {
    }

    public void a(CharSequence charSequence) {
    }

    public void a(boolean bl2) {
    }

    public boolean a(int n2, KeyEvent keyEvent) {
        return false;
    }

    public void b(boolean bl2) {
        if (!bl2) return;
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public abstract boolean b();

    public Context c() {
        return null;
    }

    public void c(boolean bl2) {
    }

    public int d() {
        return 0;
    }

    public void d(boolean bl2) {
    }

    public void e(boolean bl2) {
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    boolean g() {
        return false;
    }

    void h() {
    }
}

