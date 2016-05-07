/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.b.d;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.gn;
import com.google.android.gms.b.go;
import com.google.android.gms.b.gp;
import com.google.android.gms.b.gq;
import com.google.android.gms.b.gr;
import com.google.android.gms.b.gy;
import com.google.android.gms.b.hy;
import com.google.android.gms.b.iq;
import com.google.android.gms.b.jl;
import com.google.android.gms.b.jm;
import java.util.Map;

@fi
public class gm {
    public static final gq a;
    private static iq b;
    private static final Object c;

    static {
        c = new Object();
        a = new gn();
    }

    public gm(Context context) {
        b = gm.a(context);
    }

    private static iq a(Context context) {
        Object object = c;
        // MONITORENTER : object
        if (b == null) {
            b = d.a(context.getApplicationContext());
        }
        iq iq2 = b;
        // MONITOREXIT : object
        return iq2;
    }

    public gy a(String string, Map map) {
        gr gr2 = new gr(this, null);
        gp gp2 = new gp(this, string, gr2, new go(this, string, gr2), map);
        b.a(gp2);
        return gr2;
    }
}

