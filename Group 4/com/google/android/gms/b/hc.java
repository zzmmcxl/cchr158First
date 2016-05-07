/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.j;
import com.google.android.gms.ads.internal.overlay.l;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.bp;
import com.google.android.gms.b.bq;
import com.google.android.gms.b.bs;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.cf;
import com.google.android.gms.b.cg;
import com.google.android.gms.b.ch;
import com.google.android.gms.b.ci;
import com.google.android.gms.b.cj;
import com.google.android.gms.b.dv;
import com.google.android.gms.b.ee;
import com.google.android.gms.b.eg;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.g;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hd;
import com.google.android.gms.b.he;
import com.google.android.gms.b.hf;
import com.google.android.gms.b.hg;
import com.google.android.gms.b.hh;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@fi
public class hc
extends WebViewClient {
    private static final String[] b = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] c = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    protected hb a;
    private final HashMap d = new HashMap();
    private final Object e = new Object();
    private a f;
    private l g;
    private he h;
    private bq i;
    private hf j;
    private boolean k = false;
    private cf l;
    private ch m;
    private boolean n;
    private boolean o;
    private t p;
    private final ee q;
    private c r;
    private dv s;
    private eg t;
    private boolean u;
    private boolean v;
    private boolean w;
    private int x;

    public hc(hb hb2, boolean bl2) {
        this(hb2, bl2, new ee(hb2, hb2.f(), new ad(hb2.getContext())), null);
    }

    hc(hb hb2, boolean bl2, ee ee2, dv dv2) {
        this.a = hb2;
        this.n = bl2;
        this.q = ee2;
        this.s = dv2;
    }

    static /* synthetic */ hf a(hc hc2, hf hf2) {
        hc2.j = hf2;
        return hf2;
    }

    private String a(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return "";
        }
        Uri uri = Uri.parse((String)string);
        if (uri.getHost() == null) return "";
        return uri.getHost();
    }

    private void a(Context context, String string, String string2, String string3) {
        if (!((Boolean)an.ao.c()).booleanValue()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("err", string);
        bundle.putString("code", string2);
        bundle.putString("host", this.a(string3));
        com.google.android.gms.ads.internal.g.c().a(context, this.a.n().b, "gmob-apps", bundle, true);
    }

    static /* synthetic */ void a(hc hc2) {
        hc2.g();
    }

    static /* synthetic */ void b(hc hc2) {
        hc2.h();
    }

    private static boolean b(Uri uri) {
        String string = uri.getScheme();
        if ("http".equalsIgnoreCase(string)) return true;
        if (!"https".equalsIgnoreCase(string)) return false;
        return true;
    }

    static /* synthetic */ void c(hc hc2) {
        hc2.i();
    }

    static /* synthetic */ hf d(hc hc2) {
        return hc2.j;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void g() {
        Object object = this.e;
        // MONITORENTER : object
        this.o = true;
        // MONITOREXIT : object
        this.x = 1 + this.x;
        this.d();
    }

    private void h() {
        this.x = -1 + this.x;
        this.d();
    }

    private void i() {
        this.w = true;
        this.d();
    }

    public c a() {
        return this.r;
    }

    public void a(int n2, int n3) {
        if (this.s == null) return;
        this.s.c(n2, n3);
    }

    public void a(Uri uri) {
        String string = uri.getPath();
        List list = (List)this.d.get(string);
        if (list == null) {
            fp.e("No GMSG handler found for GMSG: " + (Object)uri);
            return;
        }
        Map map = com.google.android.gms.ads.internal.g.c().a(uri);
        if (fp.a(2)) {
            fp.e("Received GMSG: " + string);
            for (String string2 : map.keySet()) {
                fp.e("  " + string2 + ": " + (String)map.get(string2));
            }
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((ce)iterator.next()).a(this.a, map);
        }
    }

    public void a(a a2, l l2, bq bq2, t t2, boolean bl2, cf cf2, ch ch2, c c2, eg eg2) {
        if (c2 == null) {
            c2 = new c(false);
        }
        this.s = new dv(this.a, eg2);
        this.a("/appEvent", new bp(bq2));
        this.a("/backButton", bs.k);
        this.a("/canOpenURLs", bs.b);
        this.a("/canOpenIntents", bs.c);
        this.a("/click", bs.d);
        this.a("/close", bs.e);
        this.a("/customClose", bs.g);
        this.a("/instrument", bs.n);
        this.a("/delayPageLoaded", new hh(this, null));
        this.a("/httpTrack", bs.h);
        this.a("/log", bs.i);
        this.a("/mraid", new ci(c2, this.s));
        this.a("/mraidLoaded", this.q);
        this.a("/open", new cj(cf2, c2, this.s));
        this.a("/precache", bs.m);
        this.a("/touch", bs.j);
        this.a("/video", bs.l);
        this.a("/appStreaming", bs.f);
        if (ch2 != null) {
            this.a("/setInterstitialProperties", new cg(ch2));
        }
        this.f = a2;
        this.g = l2;
        this.i = bq2;
        this.l = cf2;
        this.p = t2;
        this.r = c2;
        this.t = eg2;
        this.m = ch2;
        this.a(bl2);
    }

    public final void a(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        boolean bl2 = this.a.o();
        a a2 = bl2 && !this.a.j().e ? null : this.f;
        l l2 = null;
        if (!bl2) {
            l2 = this.g;
        }
        this.a(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, a2, l2, this.p, this.a.n()));
    }

    public void a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean bl2 = this.s != null ? this.s.b() : false;
        j j2 = com.google.android.gms.ads.internal.g.b();
        Context context = this.a.getContext();
        boolean bl3 = false;
        if (!bl2) {
            bl3 = true;
        }
        j2.a(context, adOverlayInfoParcel, bl3);
    }

    public void a(hb hb2) {
        this.a = hb2;
    }

    public void a(he he2) {
        this.h = he2;
    }

    public void a(String string, ce ce2) {
        Object object = this.e;
        // MONITORENTER : object
        CopyOnWriteArrayList<ce> copyOnWriteArrayList = (CopyOnWriteArrayList<ce>)this.d.get(string);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<ce>();
            this.d.put(string, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(ce2);
        // MONITOREXIT : object
        return;
    }

    public void a(boolean bl2) {
        this.k = bl2;
    }

    public final void a(boolean bl2, int n2) {
        a a2 = this.a.o() && !this.a.j().e ? null : this.f;
        this.a(new AdOverlayInfoParcel(a2, this.g, this.p, this.a, bl2, n2, this.a.n()));
    }

    public final void a(boolean bl2, int n2, String string) {
        boolean bl3 = this.a.o();
        a a2 = bl3 && !this.a.j().e ? null : this.f;
        hg hg2 = null;
        if (!bl3) {
            hg2 = new hg(this.a, this.g);
        }
        this.a(new AdOverlayInfoParcel(a2, hg2, this.i, this.p, this.a, bl2, n2, string, this.a.n(), this.l));
    }

    public final void a(boolean bl2, int n2, String string, String string2) {
        boolean bl3 = this.a.o();
        a a2 = bl3 && !this.a.j().e ? null : this.f;
        hg hg2 = bl3 ? null : new hg(this.a, this.g);
        this.a(new AdOverlayInfoParcel(a2, hg2, this.i, this.p, this.a, bl2, n2, string, string2, this.a.n(), this.l));
    }

    public boolean b() {
        Object object = this.e;
        // MONITORENTER : object
        boolean bl2 = this.n;
        // MONITOREXIT : object
        return bl2;
    }

    public void c() {
        Object object = this.e;
        // MONITORENTER : object
        fp.e("Loading blank page in WebView, 2...");
        this.u = true;
        this.a.a("about:blank");
        // MONITOREXIT : object
        return;
    }

    public final void d() {
        if (this.h != null && (this.v && this.x <= 0 || this.w)) {
            he he2 = this.h;
            hb hb2 = this.a;
            boolean bl2 = !this.w;
            he2.a(hb2, bl2);
            this.h = null;
        }
        this.a.w();
    }

    public final void e() {
        Object object = this.e;
        // MONITORENTER : object
        this.d.clear();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.k = false;
        this.n = false;
        this.o = false;
        this.l = null;
        this.p = null;
        this.j = null;
        if (this.s != null) {
            this.s.a(true);
            this.s = null;
        }
        // MONITOREXIT : object
        return;
    }

    public final void f() {
        Object object = this.e;
        // MONITORENTER : object
        this.k = false;
        this.n = true;
        fx.a(new hd(this));
        // MONITOREXIT : object
        return;
    }

    public final void onLoadResource(WebView webView, String string) {
        fp.e("Loading resource: " + string);
        Uri uri = Uri.parse((String)string);
        if (!"gmsg".equalsIgnoreCase(uri.getScheme())) return;
        if (!"mobileads.google.com".equalsIgnoreCase(uri.getHost())) return;
        this.a(uri);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onPageFinished(WebView webView, String string) {
        Object object = this.e;
        // MONITORENTER : object
        if (this.u) {
            fp.e("Blank page loaded, 1...");
            this.a.q();
            // MONITOREXIT : object
            return;
        }
        // MONITOREXIT : object
        this.v = true;
        this.d();
    }

    public final void onReceivedError(WebView webView, int n2, String string, String string2) {
        String string3 = n2 < 0 && -1 + (- n2) < b.length ? b[-1 + (- n2)] : String.valueOf(n2);
        this.a(this.a.getContext(), "http_err", string3, string2);
        super.onReceivedError(webView, n2, string, string2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int n2 = sslError.getPrimaryError();
            String string = n2 >= 0 && n2 < c.length ? c[n2] : String.valueOf(n2);
            this.a(this.a.getContext(), "ssl_err", string, com.google.android.gms.ads.internal.g.e().a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            default: {
                return false;
            }
            case 79: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 222: 
        }
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
        Uri uri;
        fp.e("AdWebView shouldOverrideUrlLoading: " + string);
        Uri uri2 = Uri.parse((String)string);
        if ("gmsg".equalsIgnoreCase(uri2.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri2.getHost())) {
            this.a(uri2);
            return true;
        }
        if (this.k && webView == this.a.a() && hc.b(uri2)) {
            if (this.f == null) return super.shouldOverrideUrlLoading(webView, string);
            if ((Boolean)an.W.c() == false) return super.shouldOverrideUrlLoading(webView, string);
            this.f.a();
            this.f = null;
            return super.shouldOverrideUrlLoading(webView, string);
        }
        if (this.a.a().willNotDraw()) {
            fp.d("AdWebView unable to handle URL: " + string);
            return true;
        }
        try {
            f f2 = this.a.m();
            if (f2 != null && f2.b(uri2)) {
                Uri uri3;
                uri2 = uri3 = f2.a(uri2, this.a.getContext());
            }
            uri = uri2;
        }
        catch (g var4_7) {
            fp.d("Unable to append parameter to URL: " + string);
            uri = uri2;
        }
        if (this.r == null || this.r.a()) {
            this.a(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            return true;
        }
        this.r.a(string);
        return true;
    }
}

