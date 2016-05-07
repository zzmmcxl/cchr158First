/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.av;
import com.google.android.gms.b.ay;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import java.util.Map;
import org.json.JSONObject;

@fi
class hj
extends FrameLayout
implements hb {
    private final hb a;
    private final ha b;

    public hj(hb hb2) {
        super(hb2.getContext());
        this.a = hb2;
        this.b = new ha(hb2.f(), (ViewGroup)this, this);
        hc hc2 = this.a.k();
        if (hc2 != null) {
            hc2.a(this);
        }
        this.addView(this.a.b());
    }

    @Override
    public WebView a() {
        return this.a.a();
    }

    @Override
    public void a(int n2) {
        this.a.a(n2);
    }

    @Override
    public void a(Context context) {
        this.a.a(context);
    }

    @Override
    public void a(AdSizeParcel adSizeParcel) {
        this.a.a(adSizeParcel);
    }

    @Override
    public void a(c c2) {
        this.a.a(c2);
    }

    @Override
    public void a(String string) {
        this.a.a(string);
    }

    @Override
    public void a(String string, Map map) {
        this.a.a(string, map);
    }

    @Override
    public void a(String string, JSONObject jSONObject) {
        this.a.a(string, jSONObject);
    }

    @Override
    public void a(boolean bl2) {
        this.a.a(bl2);
    }

    @Override
    public View b() {
        return this;
    }

    @Override
    public void b(int n2) {
        this.a.b(n2);
    }

    @Override
    public void b(c c2) {
        this.a.b(c2);
    }

    @Override
    public void b(boolean bl2) {
        this.a.b(bl2);
    }

    @Override
    public void c() {
        this.a.c();
    }

    @Override
    public void c(boolean bl2) {
        this.a.c(bl2);
    }

    @Override
    public void d() {
        this.a.d();
    }

    @Override
    public Activity e() {
        return this.a.e();
    }

    @Override
    public Context f() {
        return this.a.f();
    }

    @Override
    public b g() {
        return this.a.g();
    }

    @Override
    public c h() {
        return this.a.h();
    }

    @Override
    public c i() {
        return this.a.i();
    }

    @Override
    public AdSizeParcel j() {
        return this.a.j();
    }

    @Override
    public hc k() {
        return this.a.k();
    }

    @Override
    public boolean l() {
        return this.a.l();
    }

    @Override
    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        this.a.loadDataWithBaseURL(string, string2, string3, string4, string5);
    }

    @Override
    public void loadUrl(String string) {
        this.a.loadUrl(string);
    }

    @Override
    public f m() {
        return this.a.m();
    }

    @Override
    public VersionInfoParcel n() {
        return this.a.n();
    }

    @Override
    public boolean o() {
        return this.a.o();
    }

    @Override
    public void onPause() {
        this.b.b();
        this.a.onPause();
    }

    @Override
    public void onResume() {
        this.a.onResume();
    }

    @Override
    public boolean p() {
        return this.a.p();
    }

    @Override
    public void q() {
        this.b.c();
        this.a.q();
    }

    @Override
    public boolean r() {
        return this.a.r();
    }

    @Override
    public ha s() {
        return this.b;
    }

    @Override
    public void setBackgroundColor(int n2) {
        this.a.setBackgroundColor(n2);
    }

    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }

    @Override
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.a.setOnTouchListener(onTouchListener);
    }

    @Override
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.a.setWebChromeClient(webChromeClient);
    }

    @Override
    public void setWebViewClient(WebViewClient webViewClient) {
        this.a.setWebViewClient(webViewClient);
    }

    @Override
    public av t() {
        return this.a.t();
    }

    @Override
    public ay u() {
        return this.a.u();
    }

    @Override
    public void v() {
        this.a.v();
    }

    @Override
    public void w() {
        this.a.w();
    }
}

