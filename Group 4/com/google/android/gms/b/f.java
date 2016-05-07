/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.b.e;
import com.google.android.gms.b.g;

public class f {
    private static final String[] c = new String[]{"/aclk", "/pcs/click"};
    private String a;
    private String[] b;
    private e d;

    private Uri a(Uri uri, Context context, String string, boolean bl2) {
        boolean bl3;
        try {
            bl3 = this.a(uri);
            if (bl3) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new g("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new g("Query parameter already exists: ms");
            }
        }
        catch (UnsupportedOperationException var5_6) {
            throw new g("Provided Uri is not in a valid state");
        }
        String string2 = bl2 ? this.d.a(context, string) : this.d.a(context);
        if (!bl3) return this.a(uri, "ms", string2);
        return this.b(uri, "dc_ms", string2);
    }

    private Uri a(Uri uri, String string, String string2) {
        String string3 = uri.toString();
        int n2 = string3.indexOf("&adurl");
        if (n2 == -1) {
            n2 = string3.indexOf("?adurl");
        }
        if (n2 == -1) return uri.buildUpon().appendQueryParameter(string, string2).build();
        return Uri.parse((String)(string3.substring(0, n2 + 1) + string + "=" + string2 + "&" + string3.substring(n2 + 1)));
    }

    private Uri b(Uri uri, String string, String string2) {
        String string3 = uri.toString();
        int n2 = string3.indexOf(";adurl");
        if (n2 != -1) {
            return Uri.parse((String)(string3.substring(0, n2 + 1) + string + "=" + string2 + ";" + string3.substring(n2 + 1)));
        }
        String string4 = uri.getEncodedPath();
        int n3 = string3.indexOf(string4);
        return Uri.parse((String)(string3.substring(0, n3 + string4.length()) + ";" + string + "=" + string2 + ";" + string3.substring(n3 + string4.length())));
    }

    public Uri a(Uri uri, Context context) {
        try {
            return this.a(uri, context, uri.getQueryParameter("ai"), true);
        }
        catch (UnsupportedOperationException var3_4) {
            throw new g("Provided Uri is not in a valid state");
        }
    }

    public e a() {
        return this.d;
    }

    public void a(MotionEvent motionEvent) {
        this.d.a(motionEvent);
    }

    public boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.a);
        }
        catch (NullPointerException var2_3) {
            return false;
        }
    }

    public boolean b(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String string = uri.getHost();
            String[] arrstring = this.b;
            int n2 = arrstring.length;
            int n3 = 0;
            do {
                boolean bl2 = false;
                if (n3 >= n2) return bl2;
                boolean bl3 = string.endsWith(arrstring[n3]);
                if (bl3) {
                    return true;
                }
                ++n3;
            } while (true);
        }
        catch (NullPointerException var2_8) {
            return false;
        }
    }

    public boolean c(Uri uri) {
        boolean bl2 = this.b(uri);
        boolean bl3 = false;
        if (!bl2) return bl3;
        String[] arrstring = c;
        int n2 = arrstring.length;
        int n3 = 0;
        do {
            bl3 = false;
            if (n3 >= n2) return bl3;
            String string = arrstring[n3];
            if (uri.getPath().endsWith(string)) {
                return true;
            }
            ++n3;
        } while (true);
    }
}

