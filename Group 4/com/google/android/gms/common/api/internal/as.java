/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.aq;

class as
implements aq {
    private IBinder a;

    as(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(Status status) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.common.api.internal.IStatusCallback");
            if (status != null) {
                parcel.writeInt(1);
                status.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
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

