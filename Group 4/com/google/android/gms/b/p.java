/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.b.fh;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.kn;
import com.google.android.gms.b.m;
import com.google.android.gms.b.n;
import com.google.android.gms.b.o;
import com.google.android.gms.b.q;
import com.google.android.gms.b.r;
import com.google.android.gms.b.t;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@fi
@TargetApi(value=14)
public class p
extends Thread {
    private boolean a;
    private boolean b;
    private final Object c;
    private final o d;
    private final n e;
    private final fh f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;

    t a(View view, m m2) {
        int n2 = 0;
        if (view == null) {
            return new t(this, 0, 0);
        }
        boolean bl2 = view.getGlobalVisibleRect(new Rect());
        if (view instanceof TextView && !(view instanceof EditText)) {
            CharSequence charSequence = ((TextView)view).getText();
            if (TextUtils.isEmpty((CharSequence)charSequence)) return new t(this, 0, 0);
            m2.b(charSequence.toString(), bl2);
            return new t(this, 1, 0);
        }
        if (view instanceof WebView && !(view instanceof hb)) {
            m2.d();
            if (!this.a((WebView)view, m2, bl2)) return new t(this, 0, 0);
            return new t(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) return new t(this, 0, 0);
        ViewGroup viewGroup = (ViewGroup)view;
        int n3 = 0;
        int n4 = 0;
        while (n2 < viewGroup.getChildCount()) {
            t t2 = this.a(viewGroup.getChildAt(n2), m2);
            n4 += t2.a;
            n3 += t2.b;
            ++n2;
        }
        return new t(this, n4, n3);
    }

    void a(Activity activity) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        View view = null;
        if (window == null) return;
        View view2 = activity.getWindow().getDecorView();
        view = null;
        if (view2 == null) return;
        view = activity.getWindow().getDecorView().findViewById(16908290);
        if (view == null) return;
        this.a(view);
    }

    void a(m m2, WebView webView, String string, boolean bl2) {
        m2.c();
        try {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                String string2 = new JSONObject(string).optString("text");
                if (!TextUtils.isEmpty((CharSequence)webView.getTitle())) {
                    m2.a(webView.getTitle() + "\n" + string2, bl2);
                } else {
                    m2.a(string2, bl2);
                }
            }
            if (!m2.a()) return;
            this.e.b(m2);
            return;
        }
        catch (JSONException var6_6) {
            fp.a("Json string may be malformed.");
            return;
        }
        catch (Throwable var5_7) {
            fp.a("Failed to get webview content.", var5_7);
            this.f.a(var5_7, true);
        }
    }

    boolean a() {
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
            Context context = this.d.b();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService("keyguard");
            if (activityManager == null) return false;
            if (keyguardManager == null) {
                return false;
            }
            List list = activityManager.getRunningAppProcesses();
            if (list == null) {
                return false;
            }
            Iterator iterator = list.iterator();
            do {
                if (!iterator.hasNext()) return false;
                runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)iterator.next();
            } while (Process.myPid() != runningAppProcessInfo.pid);
            if (!this.a(runningAppProcessInfo)) return false;
            if (keyguardManager.inKeyguardRestrictedInputMode()) return false;
            boolean bl2 = this.a(context);
            if (!bl2) return false;
            return true;
        }
        catch (Throwable var1_8) {
            return false;
        }
    }

    boolean a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        if (runningAppProcessInfo.importance != 100) return false;
        return true;
    }

    boolean a(Context context) {
        PowerManager powerManager = (PowerManager)context.getSystemService("power");
        if (powerManager != null) return powerManager.isScreenOn();
        return false;
    }

    boolean a(View view) {
        if (view == null) {
            return false;
        }
        view.post((Runnable)new q(this, view));
        return true;
    }

    @TargetApi(value=19)
    boolean a(WebView webView, m m2, boolean bl2) {
        if (!kn.f()) {
            return false;
        }
        m2.d();
        webView.post((Runnable)new r(this, m2, webView, bl2));
        return true;
    }

    public void b() {
        Object object = this.c;
        // MONITORENTER : object
        this.a = true;
        fp.a("ContentFetchThread: paused, mPause = " + this.a);
        // MONITOREXIT : object
        return;
    }

    void b(View view) {
        try {
            m m2 = new m(this.h, this.i, this.j, this.k);
            t t2 = this.a(view, m2);
            m2.e();
            if (t2.a == 0 && t2.b == 0) {
                return;
            }
            if (t2.b == 0) {
                if (m2.f() == 0) return;
            }
            if (t2.b == 0) {
                if (this.e.a(m2)) return;
            }
            this.e.c(m2);
            return;
        }
        catch (Exception var3_4) {
            fp.b("Exception in fetchContentOnUIThread", var3_4);
            this.f.a(var3_4, true);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        while (!this.b) {
            boolean bl2;
            try {
                if (this.a()) {
                    Activity activity = this.d.a();
                    if (activity == null) {
                        fp.a("ContentFetchThread: no activity");
                        continue;
                    }
                    this.a(activity);
                } else {
                    fp.a("ContentFetchTask: sleeping");
                    this.b();
                }
                Thread.sleep(1000 * this.g);
            }
            catch (Throwable var1_1) {
                fp.b("Error in ContentFetchTask", var1_1);
                this.f.a(var1_1, true);
            }
            Object object = this.c;
            // MONITORENTER : object
            while (bl2 = this.a) {
                try {
                    fp.a("ContentFetchTask: waiting");
                    this.c.wait();
                }
                catch (InterruptedException var5_4) {}
            }
            {
                // MONITOREXIT : object
                continue;
            }
        }
    }
}

