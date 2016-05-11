package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;

public class zzai implements Creator<GetCapabilityResponse> {
    static void zza(GetCapabilityResponse getCapabilityResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, getCapabilityResponse.statusCode);
        zzb.zza(parcel, 3, getCapabilityResponse.zzbsB, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzio(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlS(i);
    }

    public GetCapabilityResponse zzio(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        CapabilityInfoParcelable capabilityInfoParcelable = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    capabilityInfoParcelable = (CapabilityInfoParcelable) zza.zza(parcel, zzat, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetCapabilityResponse(i2, i, capabilityInfoParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetCapabilityResponse[] zzlS(int i) {
        return new GetCapabilityResponse[i];
    }
}
