/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin.internal;

public class j {
    static int a = 31;
    private int b = 1;

    public int a() {
        return this.b;
    }

    public j a(Object object) {
        int n2 = a * this.b;
        int n3 = object == null ? 0 : object.hashCode();
        this.b = n3 + n2;
        return this;
    }

    public j a(boolean bl2) {
        int n2 = a * this.b;
        int n3 = bl2 ? 1 : 0;
        this.b = n3 + n2;
        return this;
    }
}

