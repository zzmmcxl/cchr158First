/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.al;
import com.google.android.gms.common.api.q;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.bf;

public class g
implements q,
r {
    public final a a;
    private final int b;
    private al c;

    public g(a a2, int n2) {
        this.a = a2;
        this.b = n2;
    }

    private void a() {
        bf.a(this.c, (Object)"Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    @Override
    public void a(int n2) {
        this.a();
        this.c.a(n2);
    }

    @Override
    public void a(Bundle bundle) {
        this.a();
        this.c.a(bundle);
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        this.a();
        this.c.a(connectionResult, this.a, this.b);
    }

    public void a(al al2) {
        this.c = al2;
    }
}

