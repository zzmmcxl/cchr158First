/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.c;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.ds;
import com.google.android.gms.b.dv;
import com.google.android.gms.b.dx;
import com.google.android.gms.b.dy;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.kg;
import java.util.Map;

@fi
public class ci
implements ce {
    static final Map a = kg.a((Object)"resize", (Object)1, (Object)"playVideo", (Object)2, (Object)"storePicture", (Object)3, (Object)"createCalendarEvent", (Object)4, (Object)"setOrientationProperties", (Object)5, (Object)"closeResizedAd", (Object)6);
    private final c b;
    private final dv c;

    public ci(c c2, dv dv2) {
        this.b = c2;
        this.c = dv2;
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("a");
        int n2 = (Integer)a.get(string);
        if (n2 != 5 && this.b != null && !this.b.a()) {
            this.b.a(null);
            return;
        }
        switch (n2) {
            default: {
                fp.c("Unknown MRAID command called.");
                return;
            }
            case 1: {
                this.c.a(map);
                return;
            }
            case 4: {
                new ds(hb2, map).a();
                return;
            }
            case 3: {
                new dy(hb2, map).a();
                return;
            }
            case 5: {
                new dx(hb2, map).a();
                return;
            }
            case 6: 
        }
        this.c.a(true);
    }
}

