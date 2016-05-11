package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class zznv {
    private static int zzazC;

    static {
        zzazC = -1;
    }

    public static boolean zzaD(Context context) {
        return zzaG(context) == 3;
    }

    private static int zzaE(Context context) {
        return ((zzaF(context) % GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE) / 100) + 5;
    }

    private static int zzaF(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("Fitness", "Could not find package info for Google Play Services");
            return -1;
        }
    }

    public static int zzaG(Context context) {
        if (zzazC == -1) {
            switch (zzaE(context)) {
                case Barcode.URL /*8*/:
                case ConnectionsStatusCodes.STATUS_ERROR /*13*/:
                    zzazC = 0;
                    break;
                case Barcode.GEO /*10*/:
                    zzazC = 3;
                    break;
                default:
                    zzazC = zzaH(context) ? 1 : 2;
                    break;
            }
        }
        return zzazC;
    }

    private static boolean zzaH(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0;
        } catch (Throwable e) {
            Log.wtf("Fitness", "Unable to determine type of device, assuming phone.  Version: " + zzaF(context), e);
            return true;
        }
    }
}
