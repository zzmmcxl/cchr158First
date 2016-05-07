/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.b.gb;
import com.google.android.gms.b.gd;
import com.google.android.gms.b.gv;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.ho;
import com.google.android.gms.b.hw;
import java.io.File;
import java.util.Set;

@TargetApi(value=11)
public class gc
extends gb {
    @Override
    public hc a(hb hb2, boolean bl2) {
        return new hw(hb2, bl2);
    }

    @Override
    public Set a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    @Override
    public boolean a(DownloadManager.Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    @Override
    public boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        if ((File)gv.a(new gd(this, context)) != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowContentAccess(false);
        return true;
    }

    @Override
    public boolean a(View view) {
        view.setLayerType(0, null);
        return true;
    }

    @Override
    public boolean a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    @Override
    public boolean b(View view) {
        view.setLayerType(1, null);
        return true;
    }

    @Override
    public WebChromeClient c(hb hb2) {
        return new ho(hb2);
    }
}

