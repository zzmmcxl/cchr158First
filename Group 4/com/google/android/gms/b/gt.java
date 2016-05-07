/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fn;
import com.google.android.gms.b.fp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@fi
public final class gt
extends fn {
    private final String a;
    private final Context b;
    private final String c;
    private String d = null;

    public gt(Context context, String string, String string2) {
        this.b = context;
        this.a = string;
        this.c = string2;
    }

    public gt(Context context, String string, String string2, String string3) {
        this.b = context;
        this.a = string;
        this.c = string2;
        this.d = string3;
    }

    @Override
    public void a() {
        HttpURLConnection httpURLConnection;
        block12 : {
            fp.e("Pinging URL: " + this.c);
            httpURLConnection = (HttpURLConnection)new URL(this.c).openConnection();
            try {
                int n2;
                if (TextUtils.isEmpty((CharSequence)this.d)) {
                    g.c().a(this.b, this.a, true, httpURLConnection);
                } else {
                    g.c().a(this.b, this.a, true, httpURLConnection, this.d);
                }
                if ((n2 = httpURLConnection.getResponseCode()) >= 200 && n2 < 300) break block12;
                fp.d("Received non-success response code " + n2 + " from pinging URL: " + this.c);
            }
            catch (Throwable var5_3) {
                try {
                    httpURLConnection.disconnect();
                    throw var5_3;
                }
                catch (IndexOutOfBoundsException var3_4) {
                    fp.d("Error while parsing ping URL: " + this.c + ". " + var3_4.getMessage());
                    return;
                }
                catch (IOException var2_5) {
                    fp.d("Error while pinging URL: " + this.c + ". " + var2_5.getMessage());
                    return;
                }
                catch (RuntimeException var1_6) {
                    fp.d("Error while pinging URL: " + this.c + ". " + var1_6.getMessage());
                    return;
                }
            }
        }
        httpURLConnection.disconnect();
    }
}

