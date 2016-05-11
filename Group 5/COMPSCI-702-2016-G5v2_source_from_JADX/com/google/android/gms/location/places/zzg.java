package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placeFilter.zzaPk, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placeFilter.mVersionCode);
        zzb.zza(parcel, 3, placeFilter.zzaPA);
        zzb.zzc(parcel, 4, placeFilter.zzaPl, false);
        zzb.zzb(parcel, 6, placeFilter.zzaPj, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfe(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhO(i);
    }

    public PlaceFilter zzfe(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzau = zza.zzau(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list3 = zza.zzC(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    list = zza.zzc(parcel, zzat, UserDataType.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    list2 = zza.zzD(parcel, zzat);
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
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceFilter[] zzhO(int i) {
        return new PlaceFilter[i];
    }
}
