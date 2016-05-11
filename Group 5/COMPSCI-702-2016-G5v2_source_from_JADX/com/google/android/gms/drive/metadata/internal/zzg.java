package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzg extends zza<Long> {
    public zzg(String str, int i) {
        super(str, i);
    }

    protected void zza(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzh(dataHolder, i, i2);
    }

    protected Long zzh(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.zzb(getName(), i, i2));
    }

    protected /* synthetic */ Object zzn(Bundle bundle) {
        return zzr(bundle);
    }

    protected Long zzr(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
