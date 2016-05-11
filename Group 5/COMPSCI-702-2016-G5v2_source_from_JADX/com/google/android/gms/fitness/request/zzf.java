package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;

public class zzf implements Creator<DataReadRequest> {
    static void zza(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, dataReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 2, dataReadRequest.getDataSources(), false);
        zzb.zza(parcel, 3, dataReadRequest.zzlO());
        zzb.zza(parcel, 4, dataReadRequest.zzud());
        zzb.zzc(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        zzb.zzc(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        zzb.zzc(parcel, 7, dataReadRequest.getBucketType());
        zzb.zza(parcel, 8, dataReadRequest.zzuR());
        zzb.zza(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        zzb.zzc(parcel, 10, dataReadRequest.getLimit());
        zzb.zza(parcel, 12, dataReadRequest.zzuQ());
        zzb.zza(parcel, 13, dataReadRequest.zzuP());
        zzb.zza(parcel, 14, dataReadRequest.getCallbackBinder(), false);
        zzb.zzc(parcel, 16, dataReadRequest.zzuS(), false);
        zzb.zzc(parcel, GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE, dataReadRequest.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdl(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfl(i);
    }

    public DataReadRequest zzdl(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        List list5 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case CompletionEvent.STATUS_FAILURE /*1*/:
                    list = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case CompletionEvent.STATUS_CONFLICT /*2*/:
                    list2 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case CompletionEvent.STATUS_CANCELED /*3*/:
                    j = zza.zzi(parcel, zzat);
                    break;
                case Barcode.PHONE /*4*/:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case Barcode.PRODUCT /*5*/:
                    list3 = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case Barcode.SMS /*6*/:
                    list4 = zza.zzc(parcel, zzat, DataSource.CREATOR);
                    break;
                case Barcode.TEXT /*7*/:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.URL /*8*/:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case Barcode.WIFI /*9*/:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case Barcode.GEO /*10*/:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case Barcode.DRIVER_LICENSE /*12*/:
                    z = zza.zzc(parcel, zzat);
                    break;
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case Place.TYPE_BUS_STATION /*14*/:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case Barcode.DATA_MATRIX /*16*/:
                    list5 = zza.zzc(parcel, zzat, Device.CREATOR);
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
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2, iBinder, list5);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataReadRequest[] zzfl(int i) {
        return new DataReadRequest[i];
    }
}
