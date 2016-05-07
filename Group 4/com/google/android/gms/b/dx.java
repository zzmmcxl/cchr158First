/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

@fi
public class dx {
    private final hb a;
    private final boolean b;
    private final String c;

    public dx(hb hb2, Map map) {
        this.a = hb2;
        this.c = (String)map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.b = Boolean.parseBoolean((String)map.get("allowOrientationChange"));
            return;
        }
        this.b = true;
    }

    public void a() {
        if (this.a == null) {
            fp.d("AdWebView is null");
            return;
        }
        int n2 = "portrait".equalsIgnoreCase(this.c) ? g.e().b() : ("landscape".equalsIgnoreCase(this.c) ? g.e().a() : (this.b ? -1 : g.e().c()));
        this.a.b(n2);
    }
}

