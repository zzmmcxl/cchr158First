/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.ho;

@fi
@TargetApi(value=14)
public final class hx
extends ho {
    public hx(hb hb2) {
        super(hb2);
    }

    public void onShowCustomView(View view, int n2, WebChromeClient.CustomViewCallback customViewCallback) {
        this.a(view, n2, customViewCallback);
    }
}

