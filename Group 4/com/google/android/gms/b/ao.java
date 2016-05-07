/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ar;
import com.google.android.gms.b.az;
import com.google.android.gms.b.fi;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

@fi
public class ao {
    BlockingQueue a;
    Map b;

    public ar a(String string) {
        ar ar2 = (ar)this.b.get(string);
        if (ar2 == null) return ar.a;
        return ar2;
    }

    public boolean a(az az2) {
        return this.a.offer(az2);
    }
}

