package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzi extends zzak {
    private static final String ID;
    private final Context mContext;

    static {
        ID = zzad.APP_VERSION_NAME.toString();
    }

    public zzi(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean zzFW() {
        return true;
    }

    public zza zzP(Map<String, zza> map) {
        try {
            return zzdf.zzR(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName);
        } catch (NameNotFoundException e) {
            zzbg.m11e("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzdf.zzHF();
        }
    }
}
