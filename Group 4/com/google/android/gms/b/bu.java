/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.gt;
import com.google.android.gms.b.hb;
import java.util.Map;
import java.util.concurrent.Future;

final class bu
implements ce {
    bu() {
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("u");
        if (string == null) {
            fp.d("URL missing from httpTrack GMSG.");
            return;
        }
        new gt(hb2.getContext(), hb2.n().b, string).b();
    }
}

