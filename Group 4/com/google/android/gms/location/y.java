/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.w;

class y
implements w {
    private IBinder a;

    y(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(Location location) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
            if (location != null) {
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
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

