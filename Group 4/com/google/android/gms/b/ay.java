/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.aq;
import com.google.android.gms.b.av;
import com.google.android.gms.b.az;
import com.google.android.gms.b.fi;
import java.util.HashMap;
import java.util.Map;

@fi
public class ay {
    private final Map a;
    private final az b;

    public ay(az az2) {
        this.b = az2;
        this.a = new HashMap();
    }

    public az a() {
        return this.b;
    }

    public void a(String string, av av2) {
        this.a.put(string, av2);
    }

    public void a(String string, String string2, long l2) {
        aq.a(this.b, (av)this.a.get(string2), l2, string);
        this.a.put(string, aq.a(this.b, l2));
    }
}

