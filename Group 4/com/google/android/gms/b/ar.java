/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.as;
import com.google.android.gms.b.at;
import com.google.android.gms.b.au;
import com.google.android.gms.b.fi;
import java.util.Map;

@fi
public abstract class ar {
    @fi
    public static final ar a = new as();
    @fi
    public static final ar b = new at();
    @fi
    public static final ar c = new au();

    public abstract String a(String var1, String var2);

    public final void a(Map map, String string, String string2) {
        map.put(string, this.a((String)map.get(string), string2));
    }
}

