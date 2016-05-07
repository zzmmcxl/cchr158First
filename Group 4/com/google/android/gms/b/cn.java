/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.Handler;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.co;
import com.google.android.gms.b.cq;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fn;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.hb;

@fi
public class cn
extends fn {
    final hb a;
    final cq b;
    private final String c;

    cn(hb hb2, cq cq2, String string) {
        this.a = hb2;
        this.b = cq2;
        this.c = string;
        g.k().a(this);
    }

    @Override
    public void a() {
        try {
            this.b.a(this.c);
            return;
        }
        finally {
            fx.a.post((Runnable)new co(this));
        }
    }
}

