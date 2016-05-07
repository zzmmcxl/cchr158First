/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.y;
import com.google.android.gms.common.internal.z;

public final class af
extends z {
    public final IBinder e;
    final /* synthetic */ y f;

    public af(y y2, int n2, IBinder iBinder, Bundle bundle) {
        this.f = y2;
        super(y2, n2, bundle);
        this.e = iBinder;
    }

    @Override
    protected void a(ConnectionResult connectionResult) {
        if (y.f(this.f) != null) {
            y.f(this.f).a(connectionResult);
        }
        this.f.a(connectionResult);
    }

    @Override
    protected boolean a() {
        String string;
        try {
            string = this.e.getInterfaceDescriptor();
        }
        catch (RemoteException var1_2) {
            Log.w((String)"GmsClient", (String)"service probably died");
            return false;
        }
        if (!this.f.b().equals(string)) {
            Log.e((String)"GmsClient", (String)("service descriptor mismatch: " + this.f.b() + " vs. " + string));
            return false;
        }
        IInterface iInterface = this.f.b(this.e);
        if (iInterface == null) return false;
        if (!y.a(this.f, 2, 3, iInterface)) return false;
        Bundle bundle = this.f.b_();
        if (y.c(this.f) == null) return true;
        y.c(this.f).a(bundle);
        return true;
    }
}

