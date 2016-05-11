package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzm implements Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, locationRequestInternal.zzaBp, i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, locationRequestInternal.getVersionCode());
        zzb.zza(parcel, 2, locationRequestInternal.zzaOP);
        zzb.zza(parcel, 3, locationRequestInternal.zzaOQ);
        zzb.zza(parcel, 4, locationRequestInternal.zzaOR);
        zzb.zzc(parcel, 5, locationRequestInternal.zzaOS, false);
        zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        zzb.zza(parcel, 7, locationRequestInternal.zzaOT);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzeX(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhD(i);
    }

    public LocationRequestInternal zzeX(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int zzau = zza.zzau(parcel);
        List list = LocationRequestInternal.zzaOO;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzat, LocationRequest.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list = zza.zzc(parcel, zzat, ClientIdentity.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocationRequestInternal[] zzhD(int i) {
        return new LocationRequestInternal[i];
    }
}
