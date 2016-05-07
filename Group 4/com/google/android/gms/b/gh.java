/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebSettings;
import com.google.android.gms.b.ge;

@TargetApi(value=16)
public class gh
extends ge {
    @Override
    public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null) return;
        if (window.getDecorView() == null) return;
        if (window.getDecorView().getViewTreeObserver() == null) return;
        this.a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    @Override
    public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    @Override
    public boolean a(Context context, WebSettings webSettings) {
        super.a(context, webSettings);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }
}

