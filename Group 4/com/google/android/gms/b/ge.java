/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;
import com.google.android.gms.b.gc;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hx;

@TargetApi(value=14)
public class ge
extends gc {
    @Override
    public String a(SslError sslError) {
        return sslError.getUrl();
    }

    @Override
    public WebChromeClient c(hb hb2) {
        return new hx(hb2);
    }
}

