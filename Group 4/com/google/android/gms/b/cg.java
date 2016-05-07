/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.ce;
import com.google.android.gms.b.ch;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;
import com.google.android.gms.b.hb;
import java.util.Map;

@fi
public class cg
implements ce {
    private final ch a;

    public cg(ch ch2) {
        this.a = ch2;
    }

    @Override
    public void a(hb hb2, Map map) {
        float f2;
        boolean bl2;
        boolean bl3;
        block3 : {
            block2 : {
                bl2 = "1".equals(map.get("transparentBackground"));
                bl3 = "1".equals(map.get("blur"));
                try {
                    float f3;
                    if (map.get("blurRadius") == null) break block2;
                    f2 = f3 = Float.parseFloat((String)map.get("blurRadius"));
                    break block3;
                }
                catch (NumberFormatException var5_7) {
                    fp.b("Fail to parse float", var5_7);
                }
            }
            f2 = 0.0f;
        }
        this.a.a(bl2);
        this.a.a(bl3, f2);
    }
}

