/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.ab;
import android.support.v4.h.af;
import android.view.LayoutInflater;

class aa {
    static af a(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (!(factory instanceof ab)) return null;
        return ((ab)factory).a;
    }

    static void a(LayoutInflater layoutInflater, af af2) {
        ab ab2 = af2 != null ? new ab(af2) : null;
        layoutInflater.setFactory((LayoutInflater.Factory)ab2);
    }
}

