/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.d;

public final class h
extends Enum {
    public static final /* enum */ h a = new h("google.com", d.auth_google_play_services_client_google_display_name, "https://accounts.google.com");
    public static final /* enum */ h b = new h("facebook.com", d.auth_google_play_services_client_facebook_display_name, "https://www.facebook.com");
    private static final /* synthetic */ h[] f;
    private final String c;
    private final int d;
    private final String e;

    static {
        h[] arrh = new h[]{a, b};
        f = arrh;
    }

    private h(String string2, int n3, String string3) {
        super(string, n2);
        this.c = string2;
        this.d = n3;
        this.e = string3;
    }

    public static h a(String string) {
        if (string == null) return null;
        h[] arrh = h.values();
        int n2 = arrh.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                Log.w((String)"IdProvider", (String)("Unrecognized providerId: " + string));
                return null;
            }
            h h2 = arrh[n3];
            if (h2.a().equals(string)) {
                return h2;
            }
            ++n3;
        } while (true);
    }

    public static h valueOf(String string) {
        return (h)((Object)Enum.valueOf(h.class, string));
    }

    public static h[] values() {
        return (h[])f.clone();
    }

    public CharSequence a(Context context) {
        return context.getResources().getString(this.d);
    }

    public String a() {
        return this.c;
    }

    public String toString() {
        return this.c;
    }
}

