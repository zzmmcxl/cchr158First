/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.b.jx;
import com.google.android.gms.b.ka;

class kc
implements ka {
    private IBinder a;

    kc(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(jx jx2) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
            IBinder iBinder = null;
            if (jx2 != null) {
                iBinder = jx2.asBinder();
            }
            parcel.writeStrongBinder(iBinder);
            this.a.transact(1, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

