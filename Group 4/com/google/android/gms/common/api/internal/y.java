/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.ak;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.z;
import java.util.Collections;
import java.util.Set;

public class y
implements ak {
    private final al a;

    public y(al al2) {
        this.a = al2;
    }

    @Override
    public c a(c c2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override
    public void a() {
        this.a.i();
        this.a.g.d = Collections.emptySet();
    }

    @Override
    public void a(int n2) {
    }

    @Override
    public void a(Bundle bundle) {
    }

    @Override
    public void a(ConnectionResult connectionResult, a a2, int n2) {
    }

    @Override
    public boolean b() {
        return true;
    }

    @Override
    public void c() {
        this.a.e();
    }
}

