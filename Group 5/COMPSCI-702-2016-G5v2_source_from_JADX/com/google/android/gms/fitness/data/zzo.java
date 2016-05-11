package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zzo implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzawj);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, rawDataPoint.mVersionCode);
        zzb.zza(parcel, 2, rawDataPoint.zzawk);
        zzb.zza(parcel, 3, rawDataPoint.zzawl, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzaxg);
        zzb.zzc(parcel, 5, rawDataPoint.zzaxh);
        zzb.zza(parcel, 6, rawDataPoint.zzawn);
        zzb.zza(parcel, 7, rawDataPoint.zzawo);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzeY(i);
    }

    public RawDataPoint zzcZ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    valueArr = (Value[]) zza.zzb(parcel, zzat, Value.CREATOR);
                    break;
                case Barcode.PHONE /*4*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.SMS /*6*/:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case Barcode.TEXT /*7*/:
                    j4 = zza.zzi(parcel, zzat);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RawDataPoint[] zzeY(int i) {
        return new RawDataPoint[i];
    }
}
