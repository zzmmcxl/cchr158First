/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.support.v7.a.aa;
import android.support.v7.a.ab;
import android.support.v7.a.ac;
import android.view.ActionMode;
import android.view.Window;

class ad
extends ab {
    final /* synthetic */ ac c;

    ad(ac ac2, Window.Callback callback) {
        this.c = ac2;
        super(ac2, callback);
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n2) {
        if (!this.c.m()) return super.onWindowStartingActionMode(callback, n2);
        switch (n2) {
            default: {
                return super.onWindowStartingActionMode(callback, n2);
            }
            case 0: 
        }
        return this.a(callback);
    }
}

