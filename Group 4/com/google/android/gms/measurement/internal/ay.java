/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.AppMetadata;
import com.google.android.gms.measurement.internal.EventParcel;
import com.google.android.gms.measurement.internal.UserAttributeParcel;
import com.google.android.gms.measurement.internal.ae;
import com.google.android.gms.measurement.internal.ah;
import com.google.android.gms.measurement.internal.au;
import com.google.android.gms.measurement.internal.ax;
import com.google.android.gms.measurement.internal.az;
import java.util.List;

public abstract class ay
extends Binder
implements ax {
    public ay() {
        this.attachInterface((IInterface)this, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public static ax a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        if (iInterface == null) return new az(iBinder);
        if (!(iInterface instanceof ax)) return new az(iBinder);
        return (ax)iInterface;
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
                parcel2.writeString("com.google.android.gms.measurement.internal.IMeasurementService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                EventParcel eventParcel = parcel.readInt() != 0 ? EventParcel.CREATOR.a(parcel) : null;
                int n4 = parcel.readInt();
                AppMetadata appMetadata = null;
                if (n4 != 0) {
                    appMetadata = AppMetadata.CREATOR.a(parcel);
                }
                this.a(eventParcel, appMetadata);
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                UserAttributeParcel userAttributeParcel = parcel.readInt() != 0 ? UserAttributeParcel.CREATOR.a(parcel) : null;
                int n5 = parcel.readInt();
                AppMetadata appMetadata = null;
                if (n5 != 0) {
                    appMetadata = AppMetadata.CREATOR.a(parcel);
                }
                this.a(userAttributeParcel, appMetadata);
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                int n6 = parcel.readInt();
                AppMetadata appMetadata = null;
                if (n6 != 0) {
                    appMetadata = AppMetadata.CREATOR.a(parcel);
                }
                this.a(appMetadata);
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                int n7 = parcel.readInt();
                EventParcel eventParcel = null;
                if (n7 != 0) {
                    eventParcel = EventParcel.CREATOR.a(parcel);
                }
                this.a(eventParcel, parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                int n8 = parcel.readInt();
                AppMetadata appMetadata = null;
                if (n8 != 0) {
                    appMetadata = AppMetadata.CREATOR.a(parcel);
                }
                this.b(appMetadata);
                parcel2.writeNoException();
                return true;
            }
            case 7: 
        }
        parcel.enforceInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        int n9 = parcel.readInt();
        AppMetadata appMetadata = null;
        if (n9 != 0) {
            appMetadata = AppMetadata.CREATOR.a(parcel);
        }
        boolean bl2 = parcel.readInt() != 0;
        List list = this.a(appMetadata, bl2);
        parcel2.writeNoException();
        parcel2.writeTypedList(list);
        return true;
    }
}

