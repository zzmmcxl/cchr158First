package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public final class TimeSpan {
    private TimeSpan() {
        throw new AssertionError("Uninstantiable");
    }

    public static String zzgw(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return "DAILY";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "WEEKLY";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
