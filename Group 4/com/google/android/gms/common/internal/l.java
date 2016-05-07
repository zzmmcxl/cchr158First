/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.g;
import java.util.Arrays;

final class l
extends g {
    final /* synthetic */ char[] p;

    l(char[] arrc) {
        this.p = arrc;
    }

    @Override
    public boolean b(char c2) {
        if (Arrays.binarySearch(this.p, c2) < 0) return false;
        return true;
    }
}

