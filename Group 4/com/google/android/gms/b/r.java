/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.b.m;
import com.google.android.gms.b.p;
import com.google.android.gms.b.s;

class r
implements Runnable {
    ValueCallback a;
    final /* synthetic */ m b;
    final /* synthetic */ WebView c;
    final /* synthetic */ boolean d;
    final /* synthetic */ p e;

    r(p p2, m m2, WebView webView, boolean bl2) {
        this.e = p2;
        this.b = m2;
        this.c = webView;
        this.d = bl2;
        this.a = new s(this);
    }

    @Override
    public void run() {
        if (!this.c.getSettings().getJavaScriptEnabled()) return;
        try {
            this.c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.a);
            return;
        }
        catch (Throwable var1_1) {
            this.a.onReceiveValue((Object)"");
            return;
        }
    }
}

