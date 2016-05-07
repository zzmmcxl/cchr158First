/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.hb;
import java.util.Map;

final class bx
implements ce {
    bx() {
    }

    @Override
    public void a(hb hb2, Map map) {
        if (!((Boolean)an.at.c()).booleanValue()) {
            return;
        }
        boolean bl2 = !Boolean.parseBoolean((String)map.get("disabled"));
        hb2.c(bl2);
    }
}

