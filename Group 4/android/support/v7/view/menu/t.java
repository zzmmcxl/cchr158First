/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.d.a.b;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.p;
import android.support.v7.view.menu.u;
import android.view.ActionProvider;

@TargetApi(value=16)
class t
extends o {
    t(Context context, b b2) {
        super(context, b2);
    }

    @Override
    p a(ActionProvider actionProvider) {
        return new u(this, this.a, actionProvider);
    }
}

