/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.r;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;
import org.json.JSONObject;

final class cc
implements ce {
    cc() {
    }

    private void a(hb hb2) {
        fp.c("Received support message, responding.");
        b b2 = hb2.g();
        boolean bl2 = false;
        if (b2 != null) {
            r r2 = b2.c;
            bl2 = false;
            if (r2 != null) {
                bl2 = r2.a();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", (Object)"checkSupport");
            jSONObject.put("supports", bl2);
            hb2.a("appStreaming", jSONObject);
            return;
        }
        catch (Throwable var5_6) {
            return;
        }
    }

    @Override
    public void a(hb hb2, Map map) {
        if ("checkSupport".equals(map.get("action"))) {
            this.a(hb2);
            return;
        }
        c c2 = hb2.h();
        if (c2 == null) return;
        c2.a(hb2, map);
    }
}

