/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.bf;

final class al {
    private final String a;
    private final ComponentName b;

    public al(String string) {
        this.a = bf.a(string);
        this.b = null;
    }

    public Intent a() {
        if (this.a == null) return new Intent().setComponent(this.b);
        return new Intent(this.a).setPackage("com.google.android.gms");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof al)) {
            return false;
        }
        al al2 = (al)object;
        if (!bc.a((Object)this.a, (Object)al2.a)) return false;
        if (bc.a((Object)this.b, (Object)al2.b)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b};
        return bc.a(arrobject);
    }

    public String toString() {
        if (this.a != null) return this.a;
        return this.b.flattenToString();
    }
}

