/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.g;
import com.google.android.gms.b.gt;
import com.google.android.gms.b.hb;
import java.util.Map;
import java.util.concurrent.Future;

final class ca
implements ce {
    ca() {
    }

    @Override
    public void a(hb hb2, Map map) {
        Uri uri;
        block4 : {
            Uri uri2;
            block3 : {
                String string = (String)map.get("u");
                if (string == null) {
                    fp.d("URL missing from click GMSG.");
                    return;
                }
                uri2 = Uri.parse((String)string);
                try {
                    Uri uri3;
                    f f2 = hb2.m();
                    if (f2 == null || !f2.b(uri2)) break block3;
                    uri = uri3 = f2.a(uri2, hb2.getContext());
                    break block4;
                }
                catch (g var5_9) {
                    fp.d("Unable to append parameter to URL: " + string);
                }
            }
            uri = uri2;
        }
        String string = uri.toString();
        new gt(hb2.getContext(), hb2.n().b, string).b();
    }
}

