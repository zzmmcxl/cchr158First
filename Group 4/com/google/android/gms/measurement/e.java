/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.bf;
import com.google.android.gms.d;

public final class e {
    private static volatile e e;
    private final String a;
    private final Status b;
    private final boolean c;
    private final boolean d;

    e(Context context) {
        boolean bl2 = true;
        Resources resources = context.getResources();
        String string = resources.getResourcePackageName(d.common_google_play_services_unknown_issue);
        int n2 = resources.getIdentifier("google_app_measurement_enable", "integer", string);
        if (n2 != 0) {
            boolean bl3 = resources.getInteger(n2) != 0 ? bl2 : false;
            if (bl3) {
                bl2 = false;
            }
            this.d = bl2;
            bl2 = bl3;
        } else {
            this.d = false;
        }
        this.c = bl2;
        int n3 = resources.getIdentifier("google_app_id", "string", string);
        if (n3 == 0) {
            this.b = this.c ? new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.") : Status.a;
            this.a = null;
            return;
        }
        String string2 = resources.getString(n3);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.a = string2;
            this.b = Status.a;
            return;
        }
        this.b = this.c ? new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + string2 + "'.") : Status.a;
        this.a = null;
    }

    e(Context context, String string, boolean bl2) {
        this.a = string;
        this.b = Status.a;
        this.c = bl2;
        boolean bl3 = !bl2;
        this.d = bl3;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Status a(Context context) {
        bf.a((Object)context, (Object)"Context must not be null.");
        if (e != null) return e.e.b;
        // MONITORENTER : com.google.android.gms.measurement.e.class
        if (e == null) {
            e = new e(context);
        }
        // MONITOREXIT : com.google.android.gms.measurement.e.class
        return e.e.b;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Status a(Context context, String string, boolean bl2) {
        bf.a((Object)context, (Object)"Context must not be null.");
        bf.a(string, (Object)"App ID must be nonempty.");
        // MONITORENTER : com.google.android.gms.measurement.e.class
        if (e != null) {
            Status status = e.a(string);
            // MONITOREXIT : com.google.android.gms.measurement.e.class
            return status;
        }
        e = new e(context, string, bl2);
        // MONITOREXIT : com.google.android.gms.measurement.e.class
        return e.e.b;
    }

    public static String a() {
        if (e != null) return e.b();
        // MONITORENTER : com.google.android.gms.measurement.e.class
        if (e != null) return e.b();
        throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
    }

    public static boolean c() {
        if (e != null) return e.e();
        // MONITORENTER : com.google.android.gms.measurement.e.class
        if (e != null) return e.e();
        throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
    }

    public static boolean d() {
        if (e != null) return e.e.d;
        // MONITORENTER : com.google.android.gms.measurement.e.class
        if (e != null) return e.e.d;
        throw new IllegalStateException("Initialize must be called before isMeasurementExplicitlyDisabled.");
    }

    Status a(String string) {
        if (this.a == null) return Status.a;
        if (this.a.equals(string)) return Status.a;
        return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + this.a + "'.");
    }

    String b() {
        return this.a;
    }

    boolean e() {
        if (!this.b.e()) return false;
        if (!this.c) return false;
        return true;
    }
}

