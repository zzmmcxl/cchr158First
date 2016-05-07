/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.cf;
import com.google.android.gms.b.ck;
import com.google.android.gms.b.cl;
import com.google.android.gms.b.dv;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import com.google.android.gms.b.hc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Future;

@fi
public final class cj
implements ce {
    private final cf a;
    private final c b;
    private final dv c;

    public cj(cf cf2, c c2, dv dv2) {
        this.a = cf2;
        this.b = c2;
        this.c = dv2;
    }

    private void a(boolean bl2) {
        if (this.c == null) return;
        this.c.a(bl2);
    }

    private static boolean a(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int b(Map map) {
        String string = (String)map.get("o");
        if (string == null) return -1;
        if ("p".equalsIgnoreCase(string)) {
            return g.e().b();
        }
        if ("l".equalsIgnoreCase(string)) {
            return g.e().a();
        }
        if (!"c".equalsIgnoreCase(string)) return -1;
        return g.e().c();
    }

    private static void b(hb hb2, Map map) {
        String string = (String)map.get("u");
        if (TextUtils.isEmpty((CharSequence)string)) {
            fp.d("Destination url cannot be empty.");
            return;
        }
        new ck(hb2, string).b();
    }

    private static void c(hb hb2, Map map) {
        Context context = hb2.getContext();
        if (TextUtils.isEmpty((CharSequence)((String)map.get("u")))) {
            fp.d("Destination url cannot be empty.");
            return;
        }
        hc hc2 = hb2.k();
        Intent intent = new cl(hb2).a(context, map);
        try {
            hc2.a(new AdLauncherIntentInfoParcel(intent));
            return;
        }
        catch (ActivityNotFoundException var5_5) {
            fp.d(var5_5.getMessage());
            return;
        }
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("a");
        if (string == null) {
            fp.d("Action missing from an open GMSG.");
            return;
        }
        if (this.b != null && !this.b.a()) {
            this.b.a((String)map.get("u"));
            return;
        }
        hc hc2 = hb2.k();
        if ("expand".equalsIgnoreCase(string)) {
            if (hb2.o()) {
                fp.d("Cannot expand WebView that is already expanded.");
                return;
            }
            this.a(false);
            hc2.a(cj.a(map), cj.b(map));
            return;
        }
        if ("webapp".equalsIgnoreCase(string)) {
            String string2 = (String)map.get("u");
            this.a(false);
            if (string2 != null) {
                hc2.a(cj.a(map), cj.b(map), string2);
                return;
            }
            hc2.a(cj.a(map), cj.b(map), (String)map.get("html"), (String)map.get("baseurl"));
            return;
        }
        if ("in_app_purchase".equalsIgnoreCase(string)) {
            String string3 = (String)map.get("product_id");
            String string4 = (String)map.get("report_urls");
            if (this.a == null) return;
            if (string4 != null && !string4.isEmpty()) {
                String[] arrstring = string4.split(" ");
                this.a.a(string3, new ArrayList<String>(Arrays.asList(arrstring)));
                return;
            }
            this.a.a(string3, new ArrayList());
            return;
        }
        if ("app".equalsIgnoreCase(string) && "true".equalsIgnoreCase((String)map.get("play_store"))) {
            cj.b(hb2, map);
            return;
        }
        if ("app".equalsIgnoreCase(string) && "true".equalsIgnoreCase((String)map.get("system_browser"))) {
            this.a(true);
            cj.c(hb2, map);
            return;
        }
        this.a(true);
        String string5 = (String)map.get("u");
        String string6 = !TextUtils.isEmpty((CharSequence)string5) ? g.c().a(hb2, string5) : string5;
        hc2.a(new AdLauncherIntentInfoParcel((String)map.get("i"), string6, (String)map.get("m"), (String)map.get("p"), (String)map.get("c"), (String)map.get("f"), (String)map.get("e")));
    }
}

