/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.b;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.ao;
import com.google.android.gms.b.aq;
import com.google.android.gms.b.av;
import com.google.android.gms.b.ay;
import com.google.android.gms.b.az;
import com.google.android.gms.b.cq;
import com.google.android.gms.b.ef;
import com.google.android.gms.b.f;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.gw;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hl;
import com.google.android.gms.b.hm;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.kn;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@fi
class hk
extends WebView
implements ViewTreeObserver.OnGlobalLayoutListener,
DownloadListener,
hb {
    private int A = -1;
    private Map B;
    private final WindowManager C;
    private final hm a;
    private final Object b = new Object();
    private final f c;
    private final VersionInfoParcel d;
    private final b e;
    private hc f;
    private c g;
    private AdSizeParcel h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private Boolean m;
    private int n;
    private boolean o = true;
    private String p = "";
    private av q;
    private av r;
    private av s;
    private ay t;
    private WeakReference u;
    private c v;
    private gw w;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    protected hk(hm hm2, AdSizeParcel adSizeParcel, boolean bl2, boolean bl3, f f2, VersionInfoParcel versionInfoParcel, az az2, b b2) {
        super((Context)hm2);
        this.a = hm2;
        this.h = adSizeParcel;
        this.k = bl2;
        this.n = -1;
        this.c = f2;
        this.d = versionInfoParcel;
        this.e = b2;
        this.C = (WindowManager)this.getContext().getSystemService("window");
        this.setBackgroundColor(0);
        WebSettings webSettings = this.getSettings();
        webSettings.setAllowFileAccess(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setSupportMultipleWindows(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(0);
        }
        g.c().a((Context)hm2, versionInfoParcel.b, webSettings);
        g.e().a(this.getContext(), webSettings);
        this.setDownloadListener((DownloadListener)this);
        this.B();
        if (kn.d()) {
            this.addJavascriptInterface((Object)new hn(this), "googleAdsJsInterface");
        }
        this.w = new gw(this.a.a(), this, null);
        this.a(az2);
    }

    private void A() {
        aq.a(this.t.a(), this.q, "aeh");
    }

    private void B() {
        Object object = this.b;
        // MONITORENTER : object
        if (this.k || this.h.e) {
            if (Build.VERSION.SDK_INT < 14) {
                fp.a("Disabling hardware acceleration on an overlay.");
                this.C();
                // MONITOREXIT : object
                return;
            }
            fp.a("Enabling hardware acceleration on an overlay.");
            this.D();
            return;
        }
        if (Build.VERSION.SDK_INT < 18) {
            fp.a("Disabling hardware acceleration on an AdView.");
            this.C();
            return;
        }
        fp.a("Enabling hardware acceleration on an AdView.");
        this.D();
    }

    private void C() {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.l) {
            g.e().b((View)this);
        }
        this.l = true;
        // MONITOREXIT : object
        return;
    }

    private void D() {
        Object object = this.b;
        // MONITORENTER : object
        if (this.l) {
            g.e().a((View)this);
        }
        this.l = false;
        // MONITOREXIT : object
        return;
    }

    private void E() {
        Object object = this.b;
        // MONITORENTER : object
        if (this.B != null) {
            Iterator iterator = this.B.values().iterator();
            while (iterator.hasNext()) {
                ((cq)iterator.next()).a();
            }
        }
        // MONITOREXIT : object
        return;
    }

    private void F() {
        if (this.t == null) {
            return;
        }
        az az2 = this.t.a();
        if (az2 == null) return;
        if (g.f().a() == null) return;
        g.f().a().a(az2);
    }

    static hk a(Context context, AdSizeParcel adSizeParcel, boolean bl2, boolean bl3, f f2, VersionInfoParcel versionInfoParcel, az az2, b b2) {
        return new hk(new hm(context), adSizeParcel, bl2, bl3, f2, versionInfoParcel, az2, b2);
    }

    private void a(az az2) {
        this.F();
        this.t = new ay(new az(true, "make_wv", this.h.b));
        this.t.a().a(az2);
        this.r = aq.a(this.t.a());
        this.t.a("native:view_create", this.r);
        this.s = null;
        this.q = null;
    }

    static /* synthetic */ void a(hk hk2) {
        hk2.destroy();
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void z() {
        var1_1 = this.b;
        // MONITORENTER : var1_1
        var3_2 = this.m = g.f().c();
        if (var3_2 != null) ** GOTO lbl8
        try {
            this.evaluateJavascript("(function(){})()", null);
            this.a((Boolean)true);
lbl8: // 2 sources:
            // MONITOREXIT : var1_1
            return;
        }
        catch (IllegalStateException var4_3) {
            this.a((Boolean)false);
            return;
        }
    }

    @Override
    public WebView a() {
        return this;
    }

    @Override
    public void a(int n2) {
        this.A();
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put("closetype", String.valueOf(n2));
        hashMap.put("version", this.d.b);
        this.a("onhide", hashMap);
    }

    @Override
    public void a(Context context) {
        this.a.setBaseContext(context);
        this.w.a(this.a.a());
    }

    @Override
    public void a(AdSizeParcel adSizeParcel) {
        Object object = this.b;
        // MONITORENTER : object
        this.h = adSizeParcel;
        this.requestLayout();
        // MONITOREXIT : object
        return;
    }

    @Override
    public void a(c c2) {
        Object object = this.b;
        // MONITORENTER : object
        this.g = c2;
        // MONITOREXIT : object
        return;
    }

    void a(Boolean bl2) {
        this.m = bl2;
        g.f().a(bl2);
    }

    @Override
    public void a(String string) {
        Object object = this.b;
        // MONITORENTER : object
        try {
            super.loadUrl(string);
            // MONITOREXIT : object
            return;
        }
        catch (Throwable var4_3) {
            fp.d("Could not call loadUrl. " + var4_3);
            return;
        }
    }

    @TargetApi(value=19)
    protected void a(String string, ValueCallback valueCallback) {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            this.evaluateJavascript(string, valueCallback);
            return;
        } else {
            fp.d("The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object)null);
                return;
            }
        }
        // MONITOREXIT : object
        return;
    }

    @Override
    public void a(String string, Map map) {
        JSONObject jSONObject;
        try {
            jSONObject = g.c().a(map);
        }
        catch (JSONException var3_4) {
            fp.d("Could not convert parameters to JSON.");
            return;
        }
        this.a(string, jSONObject);
    }

    @Override
    public void a(String string, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(string);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(string2);
        stringBuilder.append(");");
        fp.e("Dispatching AFMA event: " + stringBuilder.toString());
        this.c(stringBuilder.toString());
    }

    @Override
    public void a(boolean bl2) {
        Object object = this.b;
        // MONITORENTER : object
        this.k = bl2;
        this.B();
        // MONITOREXIT : object
        return;
    }

    @Override
    public View b() {
        return this;
    }

    @Override
    public void b(int n2) {
        Object object = this.b;
        // MONITORENTER : object
        this.n = n2;
        if (this.g != null) {
            this.g.a(this.n);
        }
        // MONITOREXIT : object
        return;
    }

    @Override
    public void b(c c2) {
        Object object = this.b;
        // MONITORENTER : object
        this.v = c2;
        // MONITOREXIT : object
        return;
    }

    protected void b(String string) {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            this.loadUrl(string);
            // MONITOREXIT : object
            return;
        }
        fp.d("The webview is destroyed. Ignoring action.");
        return;
    }

    @Override
    public void b(boolean bl2) {
        Object object = this.b;
        // MONITORENTER : object
        if (this.g != null) {
            this.g.a(this.f.b(), bl2);
            // MONITOREXIT : object
            return;
        }
        this.i = bl2;
        return;
    }

    @Override
    public void c() {
        this.A();
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.d.b);
        this.a("onhide", hashMap);
    }

    protected void c(String string) {
        if (!kn.f()) {
            this.b("javascript:" + string);
            return;
        }
        if (this.y() == null) {
            this.z();
        }
        if (this.y().booleanValue()) {
            this.a(string, (ValueCallback)null);
            return;
        }
        this.b("javascript:" + string);
    }

    @Override
    public void c(boolean bl2) {
        Object object = this.b;
        // MONITORENTER : object
        this.o = bl2;
        // MONITOREXIT : object
        return;
    }

    @Override
    public void d() {
        if (this.q == null) {
            aq.a(this.t.a(), this.s, "aes");
            this.q = aq.a(this.t.a());
            this.t.a("native:view_show", this.q);
        }
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.d.b);
        this.a("onshow", hashMap);
    }

    public void destroy() {
        Object object = this.b;
        // MONITORENTER : object
        this.F();
        this.w.b();
        if (this.g != null) {
            this.g.a();
            this.g.k();
            this.g = null;
        }
        this.f.e();
        if (this.j) {
            // MONITOREXIT : object
            return;
        }
        g.k().a(this);
        this.E();
        this.j = true;
        fp.e("Initiating WebView self destruct sequence in 3...");
        this.f.c();
        // MONITOREXIT : object
        return;
    }

    @Override
    public Activity e() {
        return this.a.a();
    }

    @TargetApi(value=19)
    public void evaluateJavascript(String string, ValueCallback valueCallback) {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            super.evaluateJavascript(string, valueCallback);
            // MONITOREXIT : object
            return;
        }
        fp.d("The webview is destroyed. Ignoring action.");
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object)null);
        }
        // MONITOREXIT : object
        return;
    }

    @Override
    public Context f() {
        return this.a.b();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void finalize() {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.j) {
            g.k().a(this);
            this.E();
        }
        // MONITOREXIT : object
        super.finalize();
    }

    @Override
    public b g() {
        return this.e;
    }

    @Override
    public c h() {
        Object object = this.b;
        // MONITORENTER : object
        c c2 = this.g;
        // MONITOREXIT : object
        return c2;
    }

    @Override
    public c i() {
        Object object = this.b;
        // MONITORENTER : object
        c c2 = this.v;
        // MONITOREXIT : object
        return c2;
    }

    @Override
    public AdSizeParcel j() {
        Object object = this.b;
        // MONITORENTER : object
        AdSizeParcel adSizeParcel = this.h;
        // MONITOREXIT : object
        return adSizeParcel;
    }

    @Override
    public hc k() {
        return this.f;
    }

    @Override
    public boolean l() {
        return this.i;
    }

    public void loadData(String string, String string2, String string3) {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            super.loadData(string, string2, string3);
            // MONITOREXIT : object
            return;
        }
        fp.d("The webview is destroyed. Ignoring action.");
        return;
    }

    @Override
    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            super.loadDataWithBaseURL(string, string2, string3, string4, string5);
            // MONITOREXIT : object
            return;
        }
        fp.d("The webview is destroyed. Ignoring action.");
        return;
    }

    @Override
    public void loadUrl(String string) {
        Object object = this.b;
        // MONITORENTER : object
        boolean bl2 = this.p();
        if (!bl2) {
            try {
                super.loadUrl(string);
                // MONITOREXIT : object
                return;
            }
            catch (Throwable var5_4) {
                fp.d("Could not call loadUrl. " + var5_4);
                return;
            }
        }
        fp.d("The webview is destroyed. Ignoring action.");
        return;
    }

    @Override
    public f m() {
        return this.c;
    }

    @Override
    public VersionInfoParcel n() {
        return this.d;
    }

    @Override
    public boolean o() {
        Object object = this.b;
        // MONITORENTER : object
        boolean bl2 = this.k;
        // MONITOREXIT : object
        return bl2;
    }

    protected void onAttachedToWindow() {
        Object object = this.b;
        // MONITORENTER : object
        super.onAttachedToWindow();
        if (!this.p()) {
            this.w.c();
        }
        // MONITOREXIT : object
        return;
    }

    protected void onDetachedFromWindow() {
        Object object = this.b;
        // MONITORENTER : object
        if (!this.p()) {
            this.w.d();
        }
        super.onDetachedFromWindow();
        // MONITOREXIT : object
        return;
    }

    public void onDownloadStart(String string, String string2, String string3, String string4, long l2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((String)string), string4);
            g.c().a(this.getContext(), intent);
            return;
        }
        catch (ActivityNotFoundException var8_7) {
            fp.a("Couldn't find an Activity to view url/mimetype: " + string + " / " + string4);
            return;
        }
    }

    @TargetApi(value=21)
    protected void onDraw(Canvas canvas) {
        if (this.p()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated()) {
            if (!this.isAttachedToWindow()) return;
        }
        super.onDraw(canvas);
    }

    public void onGlobalLayout() {
        boolean bl2 = this.x();
        c c2 = this.h();
        if (c2 == null) return;
        if (!bl2) return;
        c2.o();
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = Integer.MAX_VALUE;
        Object object = this.b;
        // MONITORENTER : object
        if (this.p()) {
            this.setMeasuredDimension(0, 0);
            // MONITOREXIT : object
            return;
        }
        if (this.isInEditMode() || this.k || this.h.i || this.h.j) {
            super.onMeasure(n2, n3);
            // MONITOREXIT : object
            return;
        }
        if (this.h.e) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.C.getDefaultDisplay().getMetrics(displayMetrics);
            this.setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
            // MONITOREXIT : object
            return;
        }
        int n5 = View.MeasureSpec.getMode((int)n2);
        int n6 = View.MeasureSpec.getSize((int)n2);
        int n7 = View.MeasureSpec.getMode((int)n3);
        int n8 = View.MeasureSpec.getSize((int)n3);
        int n9 = n5 != Integer.MIN_VALUE && n5 != 1073741824 ? n4 : n6;
        if (n7 == Integer.MIN_VALUE || n7 == 1073741824) {
            n4 = n8;
        }
        if (this.h.g > n9 || this.h.d > n4) {
            float f2 = this.a.getResources().getDisplayMetrics().density;
            fp.d("Not enough space to show ad. Needs " + (int)((float)this.h.g / f2) + "x" + (int)((float)this.h.d / f2) + " dp, but only has " + (int)((float)n6 / f2) + "x" + (int)((float)n8 / f2) + " dp.");
            if (this.getVisibility() != 8) {
                this.setVisibility(4);
            }
            this.setMeasuredDimension(0, 0);
            // MONITOREXIT : object
            return;
        }
        if (this.getVisibility() != 8) {
            this.setVisibility(0);
        }
        this.setMeasuredDimension(this.h.g, this.h.d);
    }

    @Override
    public void onPause() {
        if (this.p()) {
            return;
        }
        try {
            if (!kn.a()) return;
            super.onPause();
            return;
        }
        catch (Exception var1_1) {
            fp.b("Could not pause webview.", var1_1);
            return;
        }
    }

    @Override
    public void onResume() {
        if (this.p()) {
            return;
        }
        try {
            if (!kn.a()) return;
            super.onResume();
            return;
        }
        catch (Exception var1_1) {
            fp.b("Could not resume webview.", var1_1);
            return;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c != null) {
            this.c.a(motionEvent);
        }
        if (!this.p()) return super.onTouchEvent(motionEvent);
        return false;
    }

    @Override
    public boolean p() {
        Object object = this.b;
        // MONITORENTER : object
        boolean bl2 = this.j;
        // MONITOREXIT : object
        return bl2;
    }

    @Override
    public void q() {
        Object object = this.b;
        // MONITORENTER : object
        fp.e("Destroying WebView!");
        fx.a.post((Runnable)new hl(this));
        // MONITOREXIT : object
        return;
    }

    @Override
    public boolean r() {
        Object object = this.b;
        // MONITORENTER : object
        aq.a(this.t.a(), this.q, "aebb");
        boolean bl2 = this.o;
        // MONITOREXIT : object
        return bl2;
    }

    @Override
    public ha s() {
        return null;
    }

    @Override
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.u = new WeakReference<View.OnClickListener>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (!(webViewClient instanceof hc)) return;
        this.f = (hc)webViewClient;
    }

    public void stopLoading() {
        if (this.p()) {
            return;
        }
        try {
            super.stopLoading();
            return;
        }
        catch (Exception var1_1) {
            fp.b("Could not stop loading webview.", var1_1);
            return;
        }
    }

    @Override
    public av t() {
        return this.s;
    }

    @Override
    public ay u() {
        return this.t;
    }

    @Override
    public void v() {
        this.w.a();
    }

    @Override
    public void w() {
        if (this.s != null) return;
        this.s = aq.a(this.t.a());
        this.t.a("native:view_load", this.s);
    }

    public boolean x() {
        int n2;
        int n3;
        if (!this.k().b()) {
            return false;
        }
        DisplayMetrics displayMetrics = g.c().a(this.C);
        int n4 = n.a().b(displayMetrics, displayMetrics.widthPixels);
        int n5 = n.a().b(displayMetrics, displayMetrics.heightPixels);
        Activity activity = this.e();
        if (activity == null || activity.getWindow() == null) {
            n3 = n5;
            n2 = n4;
        } else {
            int[] arrn = g.c().a(activity);
            n2 = n.a().b(displayMetrics, arrn[0]);
            n3 = n.a().b(displayMetrics, arrn[1]);
        }
        if (this.y == n4 && this.x == n5 && this.z == n2) {
            if (this.A == n3) return false;
        }
        boolean bl2 = this.y != n4 || this.x != n5;
        this.y = n4;
        this.x = n5;
        this.z = n2;
        this.A = n3;
        new ef(this).a(n4, n5, n2, n3, displayMetrics.density, this.C.getDefaultDisplay().getRotation());
        return bl2;
    }

    Boolean y() {
        Object object = this.b;
        // MONITORENTER : object
        Boolean bl2 = this.m;
        // MONITOREXIT : object
        return bl2;
    }
}

