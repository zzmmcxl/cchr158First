/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

import java.util.LinkedHashMap;
import java.util.Map;

class y
extends LinkedHashMap {
    private final int a;

    public y(int n2) {
        this.a = n2;
    }

    protected boolean removeEldestEntry(Map.Entry entry) {
        if (this.size() <= this.a) return false;
        return true;
    }
}

