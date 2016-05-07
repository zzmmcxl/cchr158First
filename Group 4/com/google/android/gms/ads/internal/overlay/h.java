/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.overlay.d;
import com.google.android.gms.ads.internal.overlay.i;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fn;
import com.google.android.gms.b.fx;

@fi
class h
extends fn {
    final /* synthetic */ c a;

    private h(c c2) {
        this.a = c2;
    }

    /* synthetic */ h(c c2, d d2) {
        this(c2);
    }

    @Override
    public void a() {
        Bitmap bitmap = g.c().b((Context)c.a(this.a), this.a.b.q.d);
        if (bitmap == null) return;
        Drawable drawable = g.e().a((Context)c.a(this.a), bitmap, this.a.b.q.e, this.a.b.q.f);
        fx.a.post((Runnable)new i(this, drawable));
    }
}

