/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.av;
import com.google.android.gms.b.ay;
import com.google.android.gms.b.cx;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hc;
import java.util.Map;

@fi
public interface hb
extends cx {
    public WebView a();

    public void a(int var1);

    public void a(Context var1);

    public void a(AdSizeParcel var1);

    public void a(c var1);

    public void a(String var1);

    public void a(String var1, Map var2);

    public void a(boolean var1);

    public View b();

    public void b(int var1);

    public void b(c var1);

    public void b(boolean var1);

    public void c();

    public void c(boolean var1);

    public void d();

    public Activity e();

    public Context f();

    public b g();

    public Context getContext();

    public ViewGroup.LayoutParams getLayoutParams();

    public void getLocationOnScreen(int[] var1);

    public int getMeasuredHeight();

    public int getMeasuredWidth();

    public ViewParent getParent();

    public c h();

    public c i();

    public AdSizeParcel j();

    public hc k();

    public boolean l();

    public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5);

    public void loadUrl(String var1);

    public f m();

    public void measure(int var1, int var2);

    public VersionInfoParcel n();

    public boolean o();

    public void onPause();

    public void onResume();

    public boolean p();

    public void q();

    public boolean r();

    public ha s();

    public void setBackgroundColor(int var1);

    public void setOnClickListener(View.OnClickListener var1);

    public void setOnTouchListener(View.OnTouchListener var1);

    public void setWebChromeClient(WebChromeClient var1);

    public void setWebViewClient(WebViewClient var1);

    public av t();

    public ay u();

    public void v();

    public void w();
}

