/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.ga;
import com.google.android.gms.b.gb;
import com.google.android.gms.b.gc;
import com.google.android.gms.b.ge;
import com.google.android.gms.b.gf;
import com.google.android.gms.b.gg;
import com.google.android.gms.b.gh;
import com.google.android.gms.b.gi;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@fi
@TargetApi(value=8)
public class fz {
    private fz() {
    }

    /* synthetic */ fz(ga ga2) {
        this();
    }

    public static fz a(int n2) {
        if (n2 >= 19) {
            return new gi();
        }
        if (n2 >= 18) {
            return new gg();
        }
        if (n2 >= 17) {
            return new gf();
        }
        if (n2 >= 16) {
            return new gh();
        }
        if (n2 >= 14) {
            return new ge();
        }
        if (n2 >= 11) {
            return new gc();
        }
        if (n2 < 9) return new fz();
        return new gb();
    }

    public int a() {
        return 0;
    }

    public Drawable a(Context context, Bitmap bitmap, boolean bl2, float f2) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public hc a(hb hb2, boolean bl2) {
        return new hc(hb2, bl2);
    }

    public String a(Context context) {
        return "";
    }

    public String a(SslError sslError) {
        return "";
    }

    public Set a(Uri uri) {
        int n2;
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String string = uri.getEncodedQuery();
        if (string == null) {
            return Collections.emptySet();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        int n3 = 0;
        do {
            int n4;
            if ((n2 = string.indexOf(38, n3)) == -1) {
                n2 = string.length();
            }
            if ((n4 = string.indexOf(61, n3)) > n2 || n4 == -1) {
                n4 = n2;
            }
            linkedHashSet.add(Uri.decode((String)string.substring(n3, n4)));
        } while ((n3 = n2 + 1) < string.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void a(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null) return;
        if (window.getDecorView() == null) return;
        if (window.getDecorView().getViewTreeObserver() == null) return;
        this.a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean a(DownloadManager.Request request) {
        return false;
    }

    public boolean a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean a(View view) {
        return false;
    }

    public boolean a(Window window) {
        return false;
    }

    public boolean a(hb hb2) {
        if (hb2 == null) {
            return false;
        }
        hb2.onPause();
        return true;
    }

    public int b() {
        return 1;
    }

    public boolean b(View view) {
        return false;
    }

    public boolean b(hb hb2) {
        if (hb2 == null) {
            return false;
        }
        hb2.onResume();
        return true;
    }

    public int c() {
        return 5;
    }

    public WebChromeClient c(hb hb2) {
        return null;
    }
}

