/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.g;

final class j
extends g {
    final /* synthetic */ char p;

    j(char c2) {
        this.p = c2;
    }

    @Override
    public g a(g g2) {
        if (!g2.b(this.p)) return super.a(g2);
        return g2;
    }

    @Override
    public boolean b(char c2) {
        if (c2 != this.p) return false;
        return true;
    }
}

