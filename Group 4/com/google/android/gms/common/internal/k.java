/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.g;

final class k
extends g {
    final /* synthetic */ char p;
    final /* synthetic */ char q;

    k(char c2, char c3) {
        this.p = c2;
        this.q = c3;
    }

    @Override
    public boolean b(char c2) {
        if (c2 == this.p) return true;
        if (c2 != this.q) return false;
        return true;
    }
}

