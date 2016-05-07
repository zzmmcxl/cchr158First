/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.az;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hj;
import com.google.android.gms.b.hk;

@fi
public class hi {
    public hb a(Context context, AdSizeParcel adSizeParcel, boolean bl2, boolean bl3, f f2, VersionInfoParcel versionInfoParcel, az az2, b b2) {
        hj hj2 = new hj(hk.a(context, adSizeParcel, bl2, bl3, f2, versionInfoParcel, az2, b2));
        hj2.setWebViewClient(g.e().a(hj2, bl3));
        hj2.setWebChromeClient(g.e().c(hj2));
        return hj2;
    }
}

