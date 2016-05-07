/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.d;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.an;
import com.google.android.gms.b.fi;
import com.google.android.gms.b.fp;

@fi
public class c {
    private d a;
    private boolean b;
    private boolean c;

    public c() {
        this.c = (Boolean)an.i.c();
    }

    public c(boolean bl2) {
        this.c = bl2;
    }

    public void a(String string) {
        fp.a("Action was blocked because no click was detected.");
        if (this.a == null) return;
        this.a.a(string);
    }

    public boolean a() {
        if (!this.c) return true;
        if (!this.b) return false;
        return true;
    }
}

