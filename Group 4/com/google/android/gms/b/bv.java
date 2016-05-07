/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

final class bv
implements ce {
    bv() {
    }

    @Override
    public void a(hb hb2, Map map) {
        fp.c("Received log message: " + (String)map.get("string"));
    }
}

