package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.zzc.zza;

public final class zzg extends com.google.android.gms.dynamic.zzg<zzc> {
    private static final zzg zzbeq;

    static {
        zzbeq = new zzg();
    }

    private zzg() {
        super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
    }

    public static View zza(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) zze.zzp(((zzc) zzbeq.zzaB(context)).zza(zze.zzC(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzdT(iBinder);
    }

    protected zzc zzdT(IBinder iBinder) {
        return zza.zzdQ(iBinder);
    }
}
