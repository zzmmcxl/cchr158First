package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzu implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zzuv());
        zzb.zza(parcel, 4, value.zzuA(), false);
        zzb.zza(parcel, 5, value.zzuB(), false);
        zzb.zza(parcel, 6, value.zzuC(), false);
        zzb.zza(parcel, 7, value.zzuD(), false);
        zzb.zza(parcel, 8, value.zzuE(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzde(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfe(i);
    }

    public Value zzde(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        float f = 0.0f;
        float[] fArr = null;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    f = zza.zzl(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    str = zza.zzp(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    fArr = zza.zzy(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    bArr = zza.zzs(parcel, zzat);
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
            return new Value(i2, i, z, f, str, bundle, iArr, fArr, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Value[] zzfe(int i) {
        return new Value[i];
    }
}
