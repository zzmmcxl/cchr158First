/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.internal.z;

public final class ag
extends z {
    final /* synthetic */ y e;

    public ag(y y2, int n2) {
        this.e = y2;
        super(y2, n2, null);
    }

    @Override
    protected void a(ConnectionResult connectionResult) {
        y.b(this.e).a(connectionResult);
        this.e.a(connectionResult);
    }

    @Override
    protected boolean a() {
        y.b(this.e).a(ConnectionResult.a);
        return true;
    }
}

