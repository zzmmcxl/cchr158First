/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.b.ae;
import com.google.android.gms.b.al;
import java.util.concurrent.Callable;

class am
implements Callable {
    final /* synthetic */ ae a;
    final /* synthetic */ al b;

    am(al al2, ae ae2) {
        this.b = al2;
        this.a = ae2;
    }

    public Object call() {
        return this.a.a(al.a(this.b));
    }
}

