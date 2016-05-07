/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.av;
import com.google.android.gms.b.az;
import com.google.android.gms.b.fi;

@fi
public class aq {
    public static av a(az az2) {
        if (az2 != null) return az2.a();
        return null;
    }

    public static av a(az az2, long l2) {
        if (az2 != null) return az2.a(l2);
        return null;
    }

    public static /* varargs */ boolean a(az az2, av av2, long l2, String ... arrstring) {
        if (az2 == null) return false;
        if (av2 != null) return az2.a(av2, l2, arrstring);
        return false;
    }

    public static /* varargs */ boolean a(az az2, av av2, String ... arrstring) {
        if (az2 == null) return false;
        if (av2 != null) return az2.a(av2, arrstring);
        return false;
    }
}

