/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.bf;
import com.google.android.gms.common.internal.g;

final class i
extends g {
    i() {
    }

    @Override
    public g a(g g2) {
        return (g)bf.a(g2);
    }

    @Override
    public boolean b(char c2) {
        return false;
    }

    @Override
    public boolean b(CharSequence charSequence) {
        if (charSequence.length() != 0) return false;
        return true;
    }
}

