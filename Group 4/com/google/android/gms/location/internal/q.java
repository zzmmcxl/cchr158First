/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.aq;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.internal.LocationRequestInternal;
import com.google.android.gms.location.internal.LocationRequestUpdateData;
import com.google.android.gms.location.internal.i;
import com.google.android.gms.location.internal.l;
import com.google.android.gms.location.internal.o;
import com.google.android.gms.location.internal.r;
import com.google.android.gms.location.k;
import com.google.android.gms.location.w;
import java.util.List;

class q
implements o {
    private IBinder a;

    q(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override
    public Location a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            this.a.transact(7, parcel, parcel2, 0);
            parcel2.readException();
            Location location = parcel2.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel2) : null;
            return location;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public ActivityRecognitionResult a(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            ActivityRecognitionResult activityRecognitionResult;
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(string);
            this.a.transact(64, parcel, parcel2, 0);
            parcel2.readException();
            ActivityRecognitionResult activityRecognitionResult2 = parcel2.readInt() != 0 ? (activityRecognitionResult = ActivityRecognitionResult.CREATOR.a(parcel2)) : null;
            return activityRecognitionResult2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(long l2, boolean bl2, PendingIntent pendingIntent) {
        int n2 = 1;
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeLong(l2);
            if (!bl2) {
                n2 = 0;
            }
            parcel.writeInt(n2);
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
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
    public void a(PendingIntent pendingIntent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
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

    @Override
    public void a(PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(65, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(PendingIntent pendingIntent, l l2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = l2 != null ? l2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
            this.a.transact(2, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(Location location) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location != null) {
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(13, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(Location location, int n2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (location != null) {
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(n2);
            this.a.transact(26, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, l l2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (geofencingRequest != null) {
                parcel.writeInt(1);
                geofencingRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = l2 != null ? l2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(57, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(GestureRequest gestureRequest, PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (gestureRequest != null) {
                parcel.writeInt(1);
                gestureRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(60, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequest locationRequest, PendingIntent pendingIntent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequest != null) {
                parcel.writeInt(1);
                locationRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(9, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequest locationRequest, w w2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequest != null) {
                parcel.writeInt(1);
                locationRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = w2 != null ? w2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(8, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequest locationRequest, w w2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequest != null) {
                parcel.writeInt(1);
                locationRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = w2 != null ? w2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
            this.a.transact(20, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationSettingsRequest locationSettingsRequest, r r2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationSettingsRequest != null) {
                parcel.writeInt(1);
                locationSettingsRequest.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = r2 != null ? r2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
            this.a.transact(63, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequestInternal != null) {
                parcel.writeInt(1);
                locationRequestInternal.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(53, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequestInternal locationRequestInternal, w w2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequestInternal != null) {
                parcel.writeInt(1);
                locationRequestInternal.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = w2 != null ? w2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(52, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(LocationRequestUpdateData locationRequestUpdateData) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (locationRequestUpdateData != null) {
                parcel.writeInt(1);
                locationRequestUpdateData.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(59, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(i i2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder iBinder = i2 != null ? i2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(67, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(l l2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder iBinder = l2 != null ? l2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
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
    public void a(w w2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            IBinder iBinder = w2 != null ? w2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(10, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(List list, PendingIntent pendingIntent, l l2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeTypedList(list);
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = l2 != null ? l2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
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
    public void a(boolean bl2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            int n2 = 0;
            if (bl2) {
                n2 = 1;
            }
            parcel.writeInt(n2);
            this.a.transact(12, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void a(String[] arrstring, l l2, String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeStringArray(arrstring);
            IBinder iBinder = l2 != null ? l2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            parcel.writeString(string);
            this.a.transact(3, parcel, parcel2, 0);
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
    public Location b(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(string);
            this.a.transact(21, parcel, parcel2, 0);
            parcel2.readException();
            Location location = parcel2.readInt() != 0 ? (Location)Location.CREATOR.createFromParcel(parcel2) : null;
            return location;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void b(PendingIntent pendingIntent) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            this.a.transact(11, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void b(PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(66, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public LocationAvailability c(String string) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            LocationAvailability locationAvailability;
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            parcel.writeString(string);
            this.a.transact(34, parcel, parcel2, 0);
            parcel2.readException();
            LocationAvailability locationAvailability2 = parcel2.readInt() != 0 ? (locationAvailability = LocationAvailability.CREATOR.a(parcel2)) : null;
            return locationAvailability2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void c(PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(61, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void d(PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(68, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    @Override
    public void e(PendingIntent pendingIntent, aq aq2) {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
            parcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (pendingIntent != null) {
                parcel.writeInt(1);
                pendingIntent.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            IBinder iBinder = aq2 != null ? aq2.asBinder() : null;
            parcel.writeStrongBinder(iBinder);
            this.a.transact(69, parcel, parcel2, 0);
            parcel2.readException();
            return;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }
}

