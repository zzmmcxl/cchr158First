/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ce;
import com.google.android.gms.b.e;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

final class bw
implements ce {
    bw() {
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("tx");
        String string2 = (String)map.get("ty");
        String string3 = (String)map.get("td");
        try {
            int n2 = Integer.parseInt(string);
            int n3 = Integer.parseInt(string2);
            int n4 = Integer.parseInt(string3);
            f f2 = hb2.m();
            if (f2 == null) return;
            f2.a().a(n2, n3, n4);
            return;
        }
        catch (NumberFormatException var6_10) {
            fp.d("Could not parse touch parameters from gmsg.");
            return;
        }
    }
}

