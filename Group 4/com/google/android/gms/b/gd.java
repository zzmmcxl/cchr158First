/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.b.gc;
import java.io.File;
import java.util.concurrent.Callable;

class gd
implements Callable {
    final /* synthetic */ Context a;
    final /* synthetic */ gc b;

    gd(gc gc2, Context context) {
        this.b = gc2;
        this.a = context;
    }

    public File a() {
        return this.a.getCacheDir();
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

