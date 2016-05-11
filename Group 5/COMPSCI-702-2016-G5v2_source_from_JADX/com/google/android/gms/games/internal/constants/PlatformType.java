package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public final class PlatformType {
    private PlatformType() {
    }

    public static String zzgw(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return "ANDROID";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "IOS";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
