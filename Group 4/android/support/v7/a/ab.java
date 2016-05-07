/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.support.v7.a.aa;
import android.support.v7.a.x;
import android.support.v7.a.y;
import android.support.v7.view.b;
import android.support.v7.view.c;
import android.support.v7.view.h;
import android.view.ActionMode;
import android.view.Window;

class ab
extends y {
    final /* synthetic */ aa b;

    ab(aa aa2, Window.Callback callback) {
        this.b = aa2;
        super(aa2, callback);
    }

    final ActionMode a(ActionMode.Callback callback) {
        h h2 = new h(this.b.a, callback);
        b b2 = this.b.b(h2);
        if (b2 == null) return null;
        return h2.b(b2);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (!this.b.m()) return super.onWindowStartingActionMode(callback);
        return this.a(callback);
    }
}

