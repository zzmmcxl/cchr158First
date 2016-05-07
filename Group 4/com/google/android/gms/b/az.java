/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.g;
import com.google.android.gms.b.ao;
import com.google.android.gms.b.ar;
import com.google.android.gms.b.av;
import com.google.android.gms.b.fi;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@fi
public class az {
    boolean a;
    private final List b = new LinkedList();
    private final Map c = new LinkedHashMap();
    private final Object d = new Object();
    private az e;

    public az(boolean bl2, String string, String string2) {
        this.a = bl2;
        this.c.put("action", string);
        this.c.put("ad_format", string2);
    }

    public av a() {
        return this.a(g.g().b());
    }

    public av a(long l2) {
        if (this.a) return new av(l2, null, null);
        return null;
    }

    public void a(az az2) {
        Object object = this.d;
        // MONITORENTER : object
        this.e = az2;
        // MONITOREXIT : object
        return;
    }

    public void a(String string, String string2) {
        if (!this.a) return;
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return;
        }
        ao ao2 = g.f().a();
        if (ao2 == null) return;
        Object object = this.d;
        // MONITORENTER : object
        ao2.a(string).a(this.c, string, string2);
        // MONITOREXIT : object
        return;
    }

    public /* varargs */ boolean a(av av2, long l2, String ... arrstring) {
        Object object = this.d;
        // MONITORENTER : object
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            av av3 = new av(l2, arrstring[i2], av2);
            this.b.add(av3);
        }
        // MONITOREXIT : object
        return true;
    }

    public /* varargs */ boolean a(av av2, String ... arrstring) {
        if (!this.a) return false;
        if (av2 != null) return this.a(av2, g.g().b(), arrstring);
        return false;
    }
}

