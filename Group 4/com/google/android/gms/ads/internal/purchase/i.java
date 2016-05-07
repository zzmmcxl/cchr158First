/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.purchase.j;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;

@fi
public class i {
    private final String a;

    public String a() {
        return g.c().b();
    }

    public boolean a(String string, int n2, Intent intent) {
        if (string == null) return false;
        if (intent == null) {
            return false;
        }
        String string2 = g.j().b(intent);
        String string3 = g.j().c(intent);
        if (string2 == null) return false;
        if (string3 == null) return false;
        if (!string.equals(g.j().a(string2))) {
            fp.d("Developer payload not match.");
            return false;
        }
        if (this.a == null) return true;
        if (j.a(this.a, string2, string3)) return true;
        fp.d("Fail to verify signature.");
        return false;
    }
}

