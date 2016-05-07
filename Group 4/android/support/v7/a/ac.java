/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.support.v7.a.aa;
import android.support.v7.a.ad;
import android.support.v7.a.v;
import android.view.Window;

class ac
extends aa {
    ac(Context context, Window window, v v2) {
        super(context, window, v2);
    }

    @Override
    Window.Callback a(Window.Callback callback) {
        return new ad(this, callback);
    }
}

