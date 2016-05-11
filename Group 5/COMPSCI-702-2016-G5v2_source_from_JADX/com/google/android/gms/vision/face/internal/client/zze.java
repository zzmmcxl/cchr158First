package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<LandmarkParcel> {
    static void zza(LandmarkParcel landmarkParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, landmarkParcel.versionCode);
        zzb.zza(parcel, 2, landmarkParcel.f26x);
        zzb.zza(parcel, 3, landmarkParcel.f27y);
        zzb.zzc(parcel, 4, landmarkParcel.type);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhm(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzkK(i);
    }

    public LandmarkParcel zzhm(Parcel parcel) {
        int i = 0;
        float f = 0.0f;
        int zzau = zza.zzau(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    f2 = zza.zzl(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f = zza.zzl(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LandmarkParcel(i2, f2, f, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LandmarkParcel[] zzkK(int i) {
        return new LandmarkParcel[i];
    }
}
