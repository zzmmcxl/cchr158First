package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.vision.barcode.Barcode;

public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String zzgw(int i) {
        switch (i) {
            case Barcode.ALL_FORMATS /*0*/:
                return "PUBLIC";
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "SOCIAL";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "SOCIAL_1P";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
