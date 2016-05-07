/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.e;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;

@fi
public class g {
    public final int a;
    public final ViewGroup.LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public g(hb hb2) {
        this.b = hb2.getLayoutParams();
        ViewParent viewParent = hb2.getParent();
        this.d = hb2.f();
        if (viewParent == null) throw new e("Could not get the parent of the WebView for an overlay.");
        if (!(viewParent instanceof ViewGroup)) throw new e("Could not get the parent of the WebView for an overlay.");
        this.c = (ViewGroup)viewParent;
        this.a = this.c.indexOfChild(hb2.b());
        this.c.removeView(hb2.b());
        hb2.a(true);
    }
}

