package com.google.android.gms.games.internal.constants;

import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
    private RequestType() {
    }

    public static String zzgw(int i) {
        switch (i) {
            case CompletionEvent.STATUS_FAILURE /*1*/:
                return "GIFT";
            case CompletionEvent.STATUS_CONFLICT /*2*/:
                return "WISH";
            default:
                GamesLog.zzA("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
