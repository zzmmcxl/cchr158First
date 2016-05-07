/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hp;
import com.google.android.gms.b.hq;
import com.google.android.gms.b.hr;
import com.google.android.gms.b.hs;
import com.google.android.gms.b.ht;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hv;

@fi
@TargetApi(value=11)
public class ho
extends WebChromeClient {
    private final hb a;

    public ho(hb hb2) {
        this.a = hb2;
    }

    private final Context a(WebView webView) {
        if (!(webView instanceof hb)) {
            return webView.getContext();
        }
        hb hb2 = (hb)webView;
        Context context = hb2.e();
        if (context != null) return context;
        return hb2.getContext();
    }

    private static void a(AlertDialog.Builder builder, String string, JsResult jsResult) {
        builder.setMessage((CharSequence)string).setPositiveButton(17039370, (DialogInterface.OnClickListener)new hr(jsResult)).setNegativeButton(17039360, (DialogInterface.OnClickListener)new hq(jsResult)).setOnCancelListener((DialogInterface.OnCancelListener)new hp(jsResult)).create().show();
    }

    private static void a(Context context, AlertDialog.Builder builder, String string, String string2, JsPromptResult jsPromptResult) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText((CharSequence)string);
        EditText editText = new EditText(context);
        editText.setText((CharSequence)string2);
        linearLayout.addView((View)textView);
        linearLayout.addView((View)editText);
        builder.setView((View)linearLayout).setPositiveButton(17039370, (DialogInterface.OnClickListener)new hu(jsPromptResult, editText)).setNegativeButton(17039360, (DialogInterface.OnClickListener)new ht(jsPromptResult)).setOnCancelListener((DialogInterface.OnCancelListener)new hs(jsPromptResult)).create().show();
    }

    private final boolean a() {
        if (g.c().a(this.a.getContext().getPackageManager(), this.a.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION")) return true;
        if (!g.c().a(this.a.getContext().getPackageManager(), this.a.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) return false;
        return true;
    }

    protected final void a(View view, int n2, WebChromeClient.CustomViewCallback customViewCallback) {
        c c2 = this.a.h();
        if (c2 == null) {
            fp.d("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        c2.a(view, customViewCallback);
        c2.a(n2);
    }

    protected boolean a(Context context, String string, String string2, String string3, JsResult jsResult, JsPromptResult jsPromptResult, boolean bl2) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle((CharSequence)string);
            if (bl2) {
                ho.a(context, builder, string2, string3, jsPromptResult);
                return true;
            }
            ho.a(builder, string2, jsResult);
            return true;
        }
        catch (WindowManager.BadTokenException var9_9) {
            fp.c("Fail to display Dialog.", (Throwable)var9_9);
        }
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof hb)) {
            fp.d("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        c c2 = ((hb)webView).h();
        if (c2 == null) {
            fp.d("Tried to close an AdWebView not associated with an overlay.");
            return;
        }
        c2.a();
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String string = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (string.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (hv.a[consoleMessage.messageLevel().ordinal()]) {
            default: {
                fp.c(string);
                return super.onConsoleMessage(consoleMessage);
            }
            case 1: {
                fp.b(string);
                return super.onConsoleMessage(consoleMessage);
            }
            case 2: {
                fp.d(string);
                return super.onConsoleMessage(consoleMessage);
            }
            case 3: 
            case 4: {
                fp.c(string);
                return super.onConsoleMessage(consoleMessage);
            }
            case 5: 
        }
        fp.a(string);
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean bl2, boolean bl3, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport)message.obj;
        WebView webView2 = new WebView(webView.getContext());
        webView2.setWebViewClient((WebViewClient)this.a.k());
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String string, String string2, long l2, long l3, long l4, WebStorage.QuotaUpdater quotaUpdater) {
        long l5 = 0x500000 - l4;
        if (l5 <= 0) {
            quotaUpdater.updateQuota(l2);
            return;
        }
        if (l2 == 0) {
            if (l3 > l5 || l3 > 0x100000) {
                l3 = 0;
            }
        } else if (l3 == 0) {
            l3 = Math.min(l2 + Math.min(131072, l5), 0x100000);
        } else {
            if (l3 <= Math.min(0x100000 - l2, l5)) {
                l2 += l3;
            }
            l3 = l2;
        }
        quotaUpdater.updateQuota(l3);
    }

    public final void onGeolocationPermissionsShowPrompt(String string, GeolocationPermissions.Callback callback) {
        if (callback == null) return;
        callback.invoke(string, this.a(), true);
    }

    public final void onHideCustomView() {
        c c2 = this.a.h();
        if (c2 == null) {
            fp.d("Could not get ad overlay when hiding custom view.");
            return;
        }
        c2.b();
    }

    public final boolean onJsAlert(WebView webView, String string, String string2, JsResult jsResult) {
        return this.a(this.a(webView), string, string2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String string, String string2, JsResult jsResult) {
        return this.a(this.a(webView), string, string2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String string, String string2, JsResult jsResult) {
        return this.a(this.a(webView), string, string2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String string, String string2, String string3, JsPromptResult jsPromptResult) {
        return this.a(this.a(webView), string, string2, string3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long l2, long l3, WebStorage.QuotaUpdater quotaUpdater) {
        long l4 = 0x500000 - l3;
        long l5 = 131072 + l2;
        if (l4 < l5) {
            quotaUpdater.updateQuota(0);
            return;
        }
        quotaUpdater.updateQuota(l5);
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.a(view, -1, customViewCallback);
    }
}

