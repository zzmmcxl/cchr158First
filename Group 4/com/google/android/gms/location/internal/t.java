/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.internal.r;

class t
implements r {
    private IBinder a;

    t(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(LocationSettingsResult locationSettingsResult) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.ISettingsCallbacks");
            if (locationSettingsResult != null) {
                parcel.writeInt(1);
                locationSettingsResult.writeToParcel(parcel, 0);
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

