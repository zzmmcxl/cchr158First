/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.overlay.p;
import com.google.android.gms.b.aq;
import com.google.android.gms.b.av;
import com.google.android.gms.b.ay;
import com.google.android.gms.b.az;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.common.internal.bf;

@fi
public class ha {
    private final hb a;
    private final Context b;
    private final ViewGroup c;
    private p d;

    public ha(Context context, ViewGroup viewGroup, hb hb2) {
        this(context, viewGroup, hb2, null);
    }

    ha(Context context, ViewGroup viewGroup, hb hb2, p p2) {
        this.b = context;
        this.c = viewGroup;
        this.a = hb2;
        this.d = p2;
    }

    public p a() {
        bf.b("getAdVideoUnderlay must be called from the UI thread.");
        return this.d;
    }

    public void a(int n2, int n3, int n4, int n5) {
        bf.b("The underlay may only be modified from the UI thread.");
        if (this.d == null) return;
        this.d.a(n2, n3, n4, n5);
    }

    public void a(int n2, int n3, int n4, int n5, int n6) {
        if (this.d != null) {
            return;
        }
        aq.a(this.a.u().a(), this.a.t(), "vpr");
        av av2 = aq.a(this.a.u().a());
        this.d = new p(this.b, this.a, n6, this.a.u().a(), av2);
        this.c.addView((View)this.d, 0, new ViewGroup.LayoutParams(-1, -1));
        this.d.a(n2, n3, n4, n5);
        this.a.k().a(false);
    }

    public void b() {
        bf.b("onPause must be called from the UI thread.");
        if (this.d == null) return;
        this.d.b();
    }

    public void c() {
        bf.b("onDestroy must be called from the UI thread.");
        if (this.d == null) return;
        this.d.g();
    }
}

