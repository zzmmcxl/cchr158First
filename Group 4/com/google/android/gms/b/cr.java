/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.cn;
import com.google.android.gms.b.cp;
import com.google.android.gms.b.cq;
import com.google.android.gms.b.cs;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.common.internal.d;
import java.util.Map;
import java.util.concurrent.Future;

@fi
public class cr
implements ce {
    @Override
    public void a(hb hb2, Map map) {
        int n2;
        cp cp2 = g.k();
        if (map.containsKey("abort")) {
            if (cp2.a(hb2)) return;
            fp.d("Precache abort but no preload task running.");
            return;
        }
        String string = (String)map.get("src");
        if (string == null) {
            fp.d("Precache video action is missing the src parameter.");
            return;
        }
        try {
            int n3;
            n2 = n3 = Integer.parseInt((String)map.get("player"));
        }
        catch (NumberFormatException var5_8) {
            n2 = 0;
        }
        String string2 = map.containsKey("mimetype") ? (String)map.get("mimetype") : "";
        if (cp2.b(hb2)) {
            fp.d("Precache task already running.");
            return;
        }
        d.a(hb2.g());
        new cn(hb2, hb2.g().a.a(hb2, n2, string2), string).b();
    }
}

