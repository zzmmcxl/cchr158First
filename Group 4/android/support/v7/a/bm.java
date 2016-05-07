/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.b.y;
import android.support.v7.a.bl;
import android.support.v7.a.bn;
import android.support.v7.a.bo;
import android.util.Log;
import java.util.Calendar;

class bm {
    private static final bo a = new bo(null);
    private final Context b;
    private final LocationManager c;

    bm(Context context) {
        this.b = context;
        this.c = (LocationManager)context.getSystemService("location");
    }

    private Location a(String string) {
        if (this.c == null) return null;
        try {
            if (!this.c.isProviderEnabled(string)) return null;
            return this.c.getLastKnownLocation(string);
        }
        catch (Exception var2_3) {
            Log.d((String)"TwilightManager", (String)"Failed to get last known location", (Throwable)var2_3);
        }
        return null;
    }

    private void a(Location location) {
        long l2;
        bo bo2 = a;
        long l3 = System.currentTimeMillis();
        bl bl2 = bl.a();
        bl2.a(l3 - 86400000, location.getLatitude(), location.getLongitude());
        long l4 = bl2.a;
        bl2.a(l3, location.getLatitude(), location.getLongitude());
        boolean bl3 = bl2.c == 1;
        long l5 = bl2.b;
        long l6 = bl2.a;
        bl2.a(86400000 + l3, location.getLatitude(), location.getLongitude());
        long l7 = bl2.b;
        if (l5 == -1 || l6 == -1) {
            l2 = 43200000 + l3;
        } else {
            long l8 = l3 > l6 ? 0 + l7 : (l3 > l5 ? 0 + l6 : 0 + l5);
            l2 = l8 + 60000;
        }
        bo2.a = bl3;
        bo2.b = l4;
        bo2.c = l5;
        bo2.d = l6;
        bo2.e = l7;
        bo2.f = l2;
    }

    private boolean a(bo bo2) {
        if (bo2 == null) return false;
        if (bo2.f <= System.currentTimeMillis()) return false;
        return true;
    }

    private Location b() {
        Location location = y.a(this.b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? this.a("network") : null;
        int n2 = y.a(this.b, "android.permission.ACCESS_FINE_LOCATION");
        Location location2 = null;
        if (n2 != 0) return location;
        location2 = this.a("gps");
        if (location2 != null && location != null) {
            if (location2.getTime() <= location.getTime()) return location;
            return location2;
        }
        if (location2 == null) return location;
        return location2;
    }

    boolean a() {
        bo bo2 = a;
        if (this.a(bo2)) {
            return bo2.a;
        }
        Location location = this.b();
        if (location != null) {
            this.a(location);
            return bo2.a;
        }
        Log.i((String)"TwilightManager", (String)"Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int n2 = Calendar.getInstance().get(11);
        if (n2 < 6) return true;
        if (n2 < 22) return false;
        return true;
    }
}

