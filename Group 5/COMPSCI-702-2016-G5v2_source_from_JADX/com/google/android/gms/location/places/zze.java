package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzyV());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzyY());
        zzb.zza(parcel, 3, nearbyAlertRequest.zzyZ(), i, false);
        zzb.zza(parcel, 4, nearbyAlertRequest.zzza(), i, false);
        zzb.zza(parcel, 5, nearbyAlertRequest.zzzb());
        zzb.zzc(parcel, 6, nearbyAlertRequest.zzzc());
        zzb.zzc(parcel, 7, nearbyAlertRequest.getPriority());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfd(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzhN(i);
    }

    public NearbyAlertRequest zzfd(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = -1;
        int i3 = 0;
        boolean z = false;
        PlaceFilter placeFilter = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzat, PlaceFilter.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzat, NearbyAlertFilter.CREATOR);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NearbyAlertRequest(i5, i4, i2, placeFilter, nearbyAlertFilter, z, i3, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyAlertRequest[] zzhN(int i) {
        return new NearbyAlertRequest[i];
    }
}
