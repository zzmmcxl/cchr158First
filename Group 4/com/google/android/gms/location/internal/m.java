/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.internal.l;
import com.google.android.gms.location.internal.n;

public abstract class m
extends Binder
implements l {
    public m() {
        this.attachInterface((IInterface)this, "com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    public static l a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        if (iInterface == null) return new n(iBinder);
        if (!(iInterface instanceof l)) return new n(iBinder);
        return (l)iInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.location.internal.IGeofencerCallbacks");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                this.a(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
                this.b(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            case 3: 
        }
        parcel.enforceInterface("com.google.android.gms.location.internal.IGeofencerCallbacks");
        int n4 = parcel.readInt();
        PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
        this.a(n4, pendingIntent);
        return true;
    }
}

