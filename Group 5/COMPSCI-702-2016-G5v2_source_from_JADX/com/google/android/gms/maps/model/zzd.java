package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzd implements Creator<LatLngBounds> {
    static void zza(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, latLngBounds.getVersionCode());
        zzb.zza(parcel, 2, latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, latLngBounds.northeast, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzim(i);
    }

    public LatLngBounds zzfy(Parcel parcel) {
        LatLng latLng = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzg;
            LatLng latLng3;
            int zzat = zza.zzat(parcel);
            LatLng latLng4;
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    latLng4 = latLng;
                    latLng = latLng2;
                    zzg = zza.zzg(parcel, zzat);
                    latLng3 = latLng4;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    zzg = i;
                    latLng4 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    latLng3 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    latLng = latLng2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    latLng3 = latLng;
                    latLng = latLng2;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == zzau) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LatLngBounds[] zzim(int i) {
        return new LatLngBounds[i];
    }
}
