/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

final class cb
implements ce {
    cb() {
    }

    @Override
    public void a(hb hb2, Map map) {
        c c2 = hb2.h();
        if (c2 != null) {
            c2.a();
            return;
        }
        c c3 = hb2.i();
        if (c3 != null) {
            c3.a();
            return;
        }
        fp.d("A GMSG tried to close something that wasn't an overlay.");
    }
}

