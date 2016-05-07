/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ce;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hd;
import java.util.Map;
import java.util.Set;

class hh
implements ce {
    final /* synthetic */ hc a;

    private hh(hc hc2) {
        this.a = hc2;
    }

    /* synthetic */ hh(hc hc2, hd hd2) {
        this(hc2);
    }

    @Override
    public void a(hb hb2, Map map) {
        if (map.keySet().contains("start")) {
            hc.a(this.a);
            return;
        }
        if (map.keySet().contains("stop")) {
            hc.b(this.a);
            return;
        }
        if (!map.keySet().contains("cancel")) return;
        hc.c(this.a);
    }
}

