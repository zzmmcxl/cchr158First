/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.content.Intent;
import com.google.android.gms.b.fk;
import com.google.android.gms.b.lt;

public class a
extends lt {
    private Intent b;

    public a() {
    }

    public a(fk fk2) {
        super(fk2);
    }

    @Override
    public String getMessage() {
        if (this.b == null) return super.getMessage();
        return "User needs to (re)enter credentials.";
    }
}

