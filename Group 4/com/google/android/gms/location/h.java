/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcelable;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {
    private final int a;
    private final int b;
    private final List c;
    private final Location d;

    private h(int n2, int n3, List list, Location location) {
        this.a = n2;
        this.b = n3;
        this.c = list;
        this.d = location;
    }

    public static h a(Intent intent) {
        if (intent != null) return new h(intent.getIntExtra("gms_error_code", -1), h.b(intent), h.c(intent), (Location)intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
        return null;
    }

    private static int b(Intent intent) {
        int n2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (n2 == -1) {
            return -1;
        }
        if (n2 == 1) return n2;
        if (n2 == 2) return n2;
        if (n2 != 4) return -1;
        return n2;
    }

    private static List c(Intent intent) {
        ArrayList arrayList = (ArrayList)intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList<ParcelableGeofence> arrayList2 = new ArrayList<ParcelableGeofence>(arrayList.size());
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            arrayList2.add(ParcelableGeofence.a((byte[])iterator.next()));
        }
        return arrayList2;
    }

    public boolean a() {
        if (this.a == -1) return false;
        return true;
    }

    public int b() {
        return this.b;
    }

    public List c() {
        return this.c;
    }
}

