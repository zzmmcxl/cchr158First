package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, activityRecognitionResult.zzaNu, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, activityRecognitionResult.getVersionCode());
        zzb.zza(parcel, 2, activityRecognitionResult.zzaNv);
        zzb.zza(parcel, 3, activityRecognitionResult.zzaNw);
        zzb.zzc(parcel, 4, activityRecognitionResult.zzaNx);
        zzb.zza(parcel, 5, activityRecognitionResult.extras, false);
        zzb.zzI(parcel, zzav);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        Bundle bundle = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        long j2 = 0;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzat, DetectedActivity.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    i = zza.zzg(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    bundle = zza.zzr(parcel, zzat);
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
            return new ActivityRecognitionResult(i2, list, j2, j, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
