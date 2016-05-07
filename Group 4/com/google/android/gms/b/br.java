/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ay;
import com.google.android.gms.b.az;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

@fi
public final class br
implements ce {
    private long a(long l2) {
        long l3 = g.g().a();
        return g.g().b() + (l2 - l3);
    }

    private void b(hb hb2, Map map) {
        long l2;
        String string = (String)map.get("label");
        String string2 = (String)map.get("start_label");
        String string3 = (String)map.get("timestamp");
        if (TextUtils.isEmpty((CharSequence)string)) {
            fp.d("No label given for CSI tick.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string3)) {
            fp.d("No timestamp given for CSI tick.");
            return;
        }
        try {
            l2 = this.a(Long.parseLong(string3));
        }
        catch (NumberFormatException var6_7) {
            fp.c("Malformed timestamp for CSI tick.", var6_7);
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = "native:view_load";
        }
        hb2.u().a(string, string2, l2);
    }

    private void c(hb hb2, Map map) {
        String string = (String)map.get("value");
        if (TextUtils.isEmpty((CharSequence)string)) {
            fp.d("No value given for CSI experiment.");
            return;
        }
        az az2 = hb2.u().a();
        if (az2 == null) {
            fp.d("No ticker for WebView, dropping experiment ID.");
            return;
        }
        az2.a("e", string);
    }

    private void d(hb hb2, Map map) {
        String string = (String)map.get("name");
        String string2 = (String)map.get("value");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            fp.d("No value given for CSI extra.");
            return;
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            fp.d("No name given for CSI extra.");
            return;
        }
        az az2 = hb2.u().a();
        if (az2 == null) {
            fp.d("No ticker for WebView, dropping extra parameter.");
            return;
        }
        az2.a(string, string2);
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("action");
        if ("tick".equals(string)) {
            this.b(hb2, map);
            return;
        }
        if ("experiment".equals(string)) {
            this.c(hb2, map);
            return;
        }
        if (!"extra".equals(string)) return;
        this.d(hb2, map);
    }
}

