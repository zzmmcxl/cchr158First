package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zze implements Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataInsertRequest.getDataSet(), i, false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataInsertRequest.getVersionCode());
        zzb.zza(parcel, 2, dataInsertRequest.getCallbackBinder(), false);
        zzb.zza(parcel, 4, dataInsertRequest.zzuO());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdk(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfk(i);
    }

    public DataInsertRequest zzdk(Parcel parcel) {
        IBinder iBinder = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        DataSet dataSet = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataSet dataSet2;
            boolean z2;
            IBinder iBinder2;
            int zzat = zza.zzat(parcel);
            boolean z3;
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    i2 = i;
                    IBinder iBinder3 = iBinder;
                    dataSet2 = (DataSet) zza.zza(parcel, zzat, DataSet.CREATOR);
                    z2 = z;
                    iBinder2 = iBinder3;
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    dataSet2 = dataSet;
                    i2 = i;
                    z3 = z;
                    iBinder2 = zza.zzq(parcel, zzat);
                    z2 = z3;
                    break;
                case Barcode.PHONE /*4*/:
                    z2 = zza.zzc(parcel, zzat);
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
                case GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    z3 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = zza.zzg(parcel, zzat);
                    z2 = z3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    z2 = z;
                    iBinder2 = iBinder;
                    dataSet2 = dataSet;
                    i2 = i;
                    break;
            }
            i = i2;
            dataSet = dataSet2;
            iBinder = iBinder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzau) {
            return new DataInsertRequest(i, dataSet, iBinder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataInsertRequest[] zzfk(int i) {
        return new DataInsertRequest[i];
    }
}
