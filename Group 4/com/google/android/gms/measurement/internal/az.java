/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ae;
import com.google.android.gms.measurement.internal.ax;
import java.util.ArrayList;
import java.util.List;

class az
implements ax {
    private IBinder a;

    az(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public List a(AppMetadata appMetadata, boolean bl2) {
        int n2 = 1;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                parcel.writeInt(1);
                appMetadata.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
        }
        catch (Throwable var6_7) {
            parcel2.recycle();
            parcel.recycle();
            throw var6_7;
        }
        if (!bl2) {
            n2 = 0;
        }
        parcel.writeInt(n2);
        this.a.transact(7, parcel, parcel2, 0);
        parcel2.readException();
        ArrayList arrayList = parcel2.createTypedArrayList((Parcelable.Creator)UserAttributeParcel.CREATOR);
        parcel2.recycle();
        parcel.recycle();
        return arrayList;
    }

    @Override
    public void a(AppMetadata appMetadata) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                parcel.writeInt(1);
                appMetadata.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(4, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(EventParcel eventParcel, AppMetadata appMetadata) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                parcel.writeInt(1);
                eventParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (appMetadata != null) {
                parcel.writeInt(1);
                appMetadata.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(1, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(EventParcel eventParcel, String string, String string2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (eventParcel != null) {
                parcel.writeInt(1);
                eventParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(string);
            parcel.writeString(string2);
            this.a.transact(5, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (userAttributeParcel != null) {
                parcel.writeInt(1);
                userAttributeParcel.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (appMetadata != null) {
                parcel.writeInt(1);
                appMetadata.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    @Override
    public void b(AppMetadata appMetadata) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
            if (appMetadata != null) {
                parcel.writeInt(1);
                appMetadata.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(6, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

