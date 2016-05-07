/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.l;
import com.google.android.gms.b.lt;

public class jk {
    public final Object a;
    public final l b;
    public final lt c;
    public boolean d = false;

    private jk(lt lt2) {
        this.a = null;
        this.b = null;
        this.c = lt2;
    }

    private jk(Object object, l l2) {
        this.a = object;
        this.b = l2;
        this.c = null;
    }

    public static jk a(lt lt2) {
        return new jk(lt2);
    }

    public static jk a(Object object, l l2) {
        return new jk(object, l2);
    }

    public boolean a() {
        if (this.c != null) return false;
        return true;
    }
}

