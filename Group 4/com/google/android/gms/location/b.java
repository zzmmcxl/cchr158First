/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import com.google.android.gms.location.DetectedActivity;
import java.util.Comparator;

final class b
implements Comparator {
    b() {
    }

    public int a(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        int n2 = Integer.valueOf(detectedActivity2.b()).compareTo(detectedActivity.b());
        if (n2 != 0) return n2;
        return Integer.valueOf(detectedActivity.a()).compareTo(detectedActivity2.a());
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((DetectedActivity)object, (DetectedActivity)object2);
    }
}

