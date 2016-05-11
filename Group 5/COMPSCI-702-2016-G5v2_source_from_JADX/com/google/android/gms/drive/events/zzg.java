package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.vision.barcode.Barcode;

public class zzg {
    public static boolean zza(int i, DriveId driveId) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
            case Barcode.URL /*8*/:
                return driveId != null;
            case Barcode.PHONE /*4*/:
            case Barcode.TEXT /*7*/:
                return driveId == null;
            default:
                return false;
        }
    }
}
