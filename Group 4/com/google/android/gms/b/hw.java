/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.gm;
import com.google.android.gms.b.gy;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@fi
@TargetApi(value=11)
public class hw
extends hc {
    public hw(hb hb2, boolean bl2) {
        super(hb2, bl2);
    }

    protected WebResourceResponse a(Context context, String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("User-Agent", g.c().a(context, string));
        hashMap.put("Cache-Control", "max-stale=3600");
        String string3 = (String)new gm(context).a(string2, hashMap).get(60, TimeUnit.SECONDS);
        if (string3 != null) return new WebResourceResponse("application/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(string3.getBytes("UTF-8")));
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public WebResourceResponse shouldInterceptRequest(WebView var1_1, String var2_2) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(var2_2).getName())) {
                return super.shouldInterceptRequest(var1_1, var2_2);
            }
            if (!(var1_1 instanceof hb)) {
                fp.d("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(var1_1, var2_2);
            }
            var4_3 = (hb)var1_1;
            var4_3.k().f();
            var5_4 = var4_3.j().e != false ? (String)an.F.c() : (var4_3.o() != false ? (String)an.E.c() : (String)an.D.c());
            fp.e("shouldInterceptRequest(" + var5_4 + ")");
            return this.a(var4_3.getContext(), this.a.n().b, var5_4);
        }
        catch (InterruptedException var3_5) {}
        ** GOTO lbl-1000
        catch (TimeoutException var3_7) {
            ** GOTO lbl-1000
        }
        catch (IOException var3_8) {
            ** GOTO lbl-1000
        }
        catch (ExecutionException var3_9) {}
lbl-1000: // 4 sources:
        {
            fp.d("Could not fetch MRAID JS. " + var3_6.getMessage());
            return super.shouldInterceptRequest(var1_1, var2_2);
        }
    }
}

