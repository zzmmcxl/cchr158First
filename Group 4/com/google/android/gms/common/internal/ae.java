/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.y;
import java.util.Set;

public class ae
implements s {
    final /* synthetic */ y a;

    public ae(y y2) {
        this.a = y2;
    }

    @Override
    public void a(ConnectionResult connectionResult) {
        if (connectionResult.b()) {
            this.a.a(null, y.e(this.a));
            return;
        }
        if (y.f(this.a) == null) return;
        y.f(this.a).a(connectionResult);
    }
}

