/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.b.m;
import com.google.android.gms.b.p;
import com.google.android.gms.b.r;

class s
implements ValueCallback {
    final /* synthetic */ r a;

    s(r r2) {
        this.a = r2;
    }

    public void a(String string) {
        this.a.e.a(this.a.b, this.a.c, string, this.a.d);
    }

    public /* synthetic */ void onReceiveValue(Object object) {
        this.a((String)object);
    }
}

