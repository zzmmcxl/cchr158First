/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.bq;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

@fi
public final class bp
implements ce {
    private final bq a;

    public bp(bq bq2) {
        this.a = bq2;
    }

    @Override
    public void a(hb hb2, Map map) {
        String string = (String)map.get("name");
        if (string == null) {
            fp.d("App event with no name parameter.");
            return;
        }
        this.a.a(string, (String)map.get("info"));
    }
}

