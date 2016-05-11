package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzs implements Creator<PlacesParams> {
    static void zza(PlacesParams placesParams, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placesParams.zzaQX, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, placesParams.versionCode);
        zzb.zza(parcel, 2, placesParams.zzaQY, false);
        zzb.zza(parcel, 3, placesParams.zzaQZ, false);
        zzb.zza(parcel, 4, placesParams.zzaPU, false);
        zzb.zzc(parcel, 6, placesParams.zzaRa);
        zzb.zzc(parcel, 7, placesParams.zzaRb);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfo(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzib(i);
    }

    public PlacesParams zzfo(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlacesParams(i3, str4, str3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlacesParams[] zzib(int i) {
        return new PlacesParams[i];
    }
}
