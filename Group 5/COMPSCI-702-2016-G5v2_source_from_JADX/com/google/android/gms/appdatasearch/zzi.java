package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzi implements Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, registerSectionInfo.name, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, registerSectionInfo.mVersionCode);
        zzb.zza(parcel, 2, registerSectionInfo.zzUd, false);
        zzb.zza(parcel, 3, registerSectionInfo.zzUe);
        zzb.zzc(parcel, 4, registerSectionInfo.weight);
        zzb.zza(parcel, 5, registerSectionInfo.zzUf);
        zzb.zza(parcel, 6, registerSectionInfo.zzUg, false);
        zzb.zza(parcel, 7, registerSectionInfo.zzUh, i, false);
        zzb.zza(parcel, 8, registerSectionInfo.zzUi, false);
        zzb.zza(parcel, 11, registerSectionInfo.zzUj, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzx(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzaq(i);
    }

    public RegisterSectionInfo[] zzaq(int i) {
        return new RegisterSectionInfo[i];
    }

    public RegisterSectionInfo zzx(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 1;
        int[] iArr = null;
        Feature[] featureArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
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
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    featureArr = (Feature[]) zza.zzb(parcel, zzat, Feature.CREATOR);
                    break;
                case Barcode.URL /*8*/:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                case Barcode.CALENDAR_EVENT /*11*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RegisterSectionInfo(i2, str4, str3, z2, i, z, str2, featureArr, iArr, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
