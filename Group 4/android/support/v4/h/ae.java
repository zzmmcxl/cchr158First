/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.h;

import android.support.v4.h.ad;
import android.support.v4.h.af;
import android.view.LayoutInflater;

class ae {
    static void a(LayoutInflater layoutInflater, af af2) {
        ad ad2 = af2 != null ? new ad(af2) : null;
        layoutInflater.setFactory2((LayoutInflater.Factory2)ad2);
    }
}

