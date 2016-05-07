/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

public class ac {
    final long a;
    final String b;
    final int c;

    ac(long l2, String string, int n2) {
        this.a = l2;
        this.b = string;
        this.c = n2;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof ac)) {
            return false;
        }
        if (((ac)object).a != this.a) return false;
        if (((ac)object).c != this.c) return false;
        return true;
    }

    public int hashCode() {
        return (int)this.a;
    }
}

