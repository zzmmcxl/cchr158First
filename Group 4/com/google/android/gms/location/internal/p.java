/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.aq;
import com.google.android.gms.common.api.internal.ar;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.ParcelableGeofence;
import com.google.android.gms.location.internal.aa;
import com.google.android.gms.location.internal.ab;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.j;
import com.google.android.gms.location.internal.l;
import com.google.android.gms.location.internal.m;
import com.google.android.gms.location.internal.o;
import com.google.android.gms.location.internal.q;
import com.google.android.gms.location.internal.r;
import com.google.android.gms.location.internal.z;
import com.google.android.gms.location.s;
import com.google.android.gms.location.w;
import com.google.android.gms.location.x;
import java.util.ArrayList;
import java.util.List;

public abstract class p
extends Binder
implements o {
    public static o a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (iInterface == null) return new q(iBinder);
        if (!(iInterface instanceof o)) return new q(iBinder);
        return (o)iInterface;
    }

    public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        switch (n2) {
            default: {
                return super.onTransact(n2, parcel, parcel2, n3);
            }
            case 1598968902: {
                parcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                return true;
            }
            case 1: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                ArrayList arrayList = parcel.createTypedArrayList((Parcelable.Creator)ParcelableGeofence.CREATOR);
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a((List)arrayList, pendingIntent, m.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 57: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                GeofencingRequest geofencingRequest = parcel.readInt() != 0 ? (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(parcel) : null;
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(geofencingRequest, pendingIntent, m.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 2: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(pendingIntent, m.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 3: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.a(parcel.createStringArray(), m.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 4: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.a(m.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 5: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                long l2 = parcel.readLong();
                boolean bl2 = parcel.readInt() != 0;
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(l2, bl2, pendingIntent);
                parcel2.writeNoException();
                return true;
            }
            case 6: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(pendingIntent);
                parcel2.writeNoException();
                return true;
            }
            case 64: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                ActivityRecognitionResult activityRecognitionResult = this.a(parcel.readString());
                parcel2.writeNoException();
                if (activityRecognitionResult != null) {
                    parcel2.writeInt(1);
                    activityRecognitionResult.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 65: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 66: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.b(pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 60: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                GestureRequest gestureRequest = parcel.readInt() != 0 ? GestureRequest.CREATOR.a(parcel) : null;
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(gestureRequest, pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 61: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.c(pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 68: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.d(pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 69: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.e(pendingIntent, ar.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 7: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location = this.a();
                parcel2.writeNoException();
                if (location != null) {
                    parcel2.writeInt(1);
                    location.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 8: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                int n4 = parcel.readInt();
                LocationRequest locationRequest = null;
                if (n4 != 0) {
                    locationRequest = LocationRequest.CREATOR.a(parcel);
                }
                this.a(locationRequest, x.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 20: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                int n5 = parcel.readInt();
                LocationRequest locationRequest = null;
                if (n5 != 0) {
                    locationRequest = LocationRequest.CREATOR.a(parcel);
                }
                this.a(locationRequest, x.a(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            case 9: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationRequest locationRequest = parcel.readInt() != 0 ? LocationRequest.CREATOR.a(parcel) : null;
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(locationRequest, pendingIntent);
                parcel2.writeNoException();
                return true;
            }
            case 52: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                int n6 = parcel.readInt();
                LocationRequestInternal locationRequestInternal = null;
                if (n6 != 0) {
                    locationRequestInternal = LocationRequestInternal.CREATOR.a(parcel);
                }
                this.a(locationRequestInternal, x.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 53: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationRequestInternal locationRequestInternal = parcel.readInt() != 0 ? LocationRequestInternal.CREATOR.a(parcel) : null;
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.a(locationRequestInternal, pendingIntent);
                parcel2.writeNoException();
                return true;
            }
            case 10: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.a(x.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 11: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel) : null;
                this.b(pendingIntent);
                parcel2.writeNoException();
                return true;
            }
            case 59: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                int n7 = parcel.readInt();
                LocationRequestUpdateData locationRequestUpdateData = null;
                if (n7 != 0) {
                    locationRequestUpdateData = LocationRequestUpdateData.CREATOR.a(parcel);
                }
                this.a(locationRequestUpdateData);
                parcel2.writeNoException();
                return true;
            }
            case 12: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                int n8 = parcel.readInt();
                boolean bl3 = false;
                if (n8 != 0) {
                    bl3 = true;
                }
                this.a(bl3);
                parcel2.writeNoException();
                return true;
            }
            case 13: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location = parcel.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel) : null;
                this.a(location);
                parcel2.writeNoException();
                return true;
            }
            case 21: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location = this.b(parcel.readString());
                parcel2.writeNoException();
                if (location != null) {
                    parcel2.writeInt(1);
                    location.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 26: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                Location location = parcel.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel) : null;
                this.a(location, parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            case 67: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                this.a(j.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            case 34: {
                parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                LocationAvailability locationAvailability = this.c(parcel.readString());
                parcel2.writeNoException();
                if (locationAvailability != null) {
                    parcel2.writeInt(1);
                    locationAvailability.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            }
            case 63: 
        }
        parcel.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LocationSettingsRequest locationSettingsRequest = parcel.readInt() != 0 ? (LocationSettingsRequest)LocationSettingsRequest.CREATOR.createFromParcel(parcel) : null;
        this.a(locationSettingsRequest, com.google.android.gms.location.internal.s.a(parcel.readStrongBinder()), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}

