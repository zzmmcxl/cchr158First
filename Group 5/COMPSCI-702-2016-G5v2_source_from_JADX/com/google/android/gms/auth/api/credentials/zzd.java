package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzd implements Creator<HintRequest> {
    static void zza(HintRequest hintRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, hintRequest.getHintPickerConfig(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, hintRequest.mVersionCode);
        zzb.zza(parcel, 2, hintRequest.isEmailAddressIdentifierSupported());
        zzb.zza(parcel, 3, hintRequest.zzmy());
        zzb.zza(parcel, 4, hintRequest.getAccountTypes(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzH(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaC(i);
    }

    public HintRequest zzH(Parcel parcel) {
        String[] strArr = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    credentialPickerConfig = (CredentialPickerConfig) zza.zza(parcel, zzat, CredentialPickerConfig.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    strArr = zza.zzB(parcel, zzat);
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
            return new HintRequest(i, credentialPickerConfig, z2, z, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public HintRequest[] zzaC(int i) {
        return new HintRequest[i];
    }
}
