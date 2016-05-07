/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.client.f;
import com.google.android.gms.ads.internal.client.g;
import com.google.android.gms.ads.internal.client.k;
import com.google.android.gms.ads.internal.client.o;
import com.google.android.gms.ads.internal.client.p;
import com.google.android.gms.ads.internal.client.r;
import com.google.android.gms.ads.internal.client.t;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.client.z;
import com.google.android.gms.b.be;
import com.google.android.gms.b.bg;
import com.google.android.gms.b.et;
import com.google.android.gms.b.fb;
import com.google.android.gms.b.fi;

@fi
public class b {
    private com.google.android.gms.ads.a a;
    private a b;
    private t c;
    private c[] d;
    private String e;
    private ViewGroup f;
    private com.google.android.gms.ads.a.a g;
    private com.google.android.gms.ads.purchase.b h;
    private com.google.android.gms.ads.purchase.c i;
    private com.google.android.gms.ads.a.c j;
    private boolean k;
    private com.google.android.gms.ads.f l;
    private boolean m;

    private static AdSizeParcel a(Context context, c[] arrc, boolean bl2) {
        AdSizeParcel adSizeParcel = new AdSizeParcel(context, arrc);
        adSizeParcel.a(bl2);
        return adSizeParcel;
    }

    public com.google.android.gms.ads.a a() {
        return this.a;
    }

    public void a(com.google.android.gms.ads.a.a a2) {
        try {
            this.g = a2;
            if (this.c == null) return;
            t t2 = this.c;
            k k2 = a2 != null ? new k(a2) : null;
            t2.a(k2);
            return;
        }
        catch (RemoteException var2_4) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AppEventListener.", (Throwable)var2_4);
            return;
        }
    }

    public void a(com.google.android.gms.ads.a.c c2) {
        this.j = c2;
        try {
            if (this.c == null) return;
            t t2 = this.c;
            bg bg2 = c2 != null ? new bg(c2) : null;
            t2.a(bg2);
            return;
        }
        catch (RemoteException var2_4) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the onCustomRenderedAdLoadedListener.", (Throwable)var2_4);
            return;
        }
    }

    public void a(com.google.android.gms.ads.a a2) {
        try {
            this.a = a2;
            if (this.c == null) return;
            t t2 = this.c;
            g g2 = a2 != null ? new g(a2) : null;
            t2.a(g2);
            return;
        }
        catch (RemoteException var2_4) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AdListener.", (Throwable)var2_4);
            return;
        }
    }

    public void a(com.google.android.gms.ads.f f2) {
        this.l = f2;
        try {
            o o2;
            if (this.c == null) return;
            t t2 = this.c;
            o o3 = this.l == null ? null : (o2 = this.l.a());
            t2.a(o3);
            return;
        }
        catch (RemoteException var2_5) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set correlator.", (Throwable)var2_5);
        }
    }

    public void a(a a2) {
        try {
            this.b = a2;
            if (this.c == null) return;
            t t2 = this.c;
            f f2 = a2 != null ? new f(a2) : null;
            t2.a(f2);
            return;
        }
        catch (RemoteException var2_4) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the AdClickListener.", (Throwable)var2_4);
            return;
        }
    }

    public void a(com.google.android.gms.ads.purchase.b b2) {
        if (this.i != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.h = b2;
            if (this.c == null) return;
            t t2 = this.c;
            fb fb2 = b2 != null ? new fb(b2) : null;
            t2.a(fb2);
            return;
        }
        catch (RemoteException var2_4) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the InAppPurchaseListener.", (Throwable)var2_4);
            return;
        }
    }

    public void a(String string) {
        if (this.e != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.e = string;
    }

    public void a(boolean bl2) {
        this.k = bl2;
        try {
            if (this.c == null) return;
            this.c.a(this.k);
            return;
        }
        catch (RemoteException var2_2) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set manual impressions.", (Throwable)var2_2);
            return;
        }
    }

    public /* varargs */ void a(c ... arrc) {
        if (this.d != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        this.b(arrc);
    }

    public c b() {
        try {
            AdSizeParcel adSizeParcel;
            if (this.c != null && (adSizeParcel = this.c.a()) != null) {
                return adSizeParcel.a();
            }
        }
        catch (RemoteException var1_3) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to get the current AdSize.", (Throwable)var1_3);
        }
        if (this.d == null) return null;
        return this.d[0];
    }

    public /* varargs */ void b(c ... arrc) {
        this.d = arrc;
        try {
            if (this.c != null) {
                this.c.a(b.a(this.f.getContext(), this.d, this.m));
            }
        }
        catch (RemoteException var2_2) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to set the ad size.", (Throwable)var2_2);
        }
        this.f.requestLayout();
    }

    public c[] c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public com.google.android.gms.ads.a.a e() {
        return this.g;
    }

    public com.google.android.gms.ads.purchase.b f() {
        return this.h;
    }

    public com.google.android.gms.ads.a.c g() {
        return this.j;
    }

    public String h() {
        try {
            if (this.c == null) return null;
            return this.c.b();
        }
        catch (RemoteException var1_2) {
            com.google.android.gms.ads.internal.util.client.b.c("Failed to get the mediation adapter class name.", (Throwable)var1_2);
        }
        return null;
    }
}

