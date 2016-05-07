/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.az;
import com.google.android.gms.common.api.internal.z;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.w;

class ad
implements r {
    final /* synthetic */ az a;
    final /* synthetic */ z b;

    ad(z z2, az az2) {
        this.b = z2;
        this.a = az2;
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        this.a.a(new Status(8));
    }
}

