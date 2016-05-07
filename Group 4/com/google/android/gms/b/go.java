/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import com.google.android.gms.b.fp;
import com.google.android.gms.b.gm;
import com.google.android.gms.b.gr;
import com.google.android.gms.b.jl;
import com.google.android.gms.b.lt;

class go
implements jl {
    final /* synthetic */ String a;
    final /* synthetic */ gr b;
    final /* synthetic */ gm c;

    go(gm gm2, String string, gr gr2) {
        this.c = gm2;
        this.a = string;
        this.b = gr2;
    }

    @Override
    public void a(lt lt2) {
        fp.d("Failed to load URL: " + this.a + "\n" + lt2.toString());
        this.b.a(null);
    }
}

