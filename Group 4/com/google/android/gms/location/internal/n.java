/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.location.internal.l;

class n
implements l {
    private IBinder a;

    n(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public void a(int n2, PendingIntent pendingIntent) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(n2);
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(3, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    @Override
    public void a(int n2, String[] arrstring) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(n2);
            parcel.writeStringArray(arrstring);
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

    @Override
    public void b(int n2, String[] arrstring) {
        Parcel parcel = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGeofencerCallbacks");
            parcel.writeInt(n2);
            parcel.writeStringArray(arrstring);
            this.a.transact(2, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }
}

