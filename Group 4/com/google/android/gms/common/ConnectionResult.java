/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionResult
implements SafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final ConnectionResult a;
    final int b;
    private final int c;
    private final PendingIntent d;
    private final String e;

    static {
        a = new ConnectionResult(0);
        CREATOR = new i();
    }

    public ConnectionResult(int n2) {
        this(n2, null, null);
    }

    ConnectionResult(int n2, int n3, PendingIntent pendingIntent, String string) {
        this.b = n2;
        this.c = n3;
        this.d = pendingIntent;
        this.e = string;
    }

    public ConnectionResult(int n2, PendingIntent pendingIntent) {
        this(n2, pendingIntent, null);
    }

    public ConnectionResult(int n2, PendingIntent pendingIntent, String string) {
        this(1, n2, pendingIntent, string);
    }

    static String a(int n2) {
        switch (n2) {
            default: {
                return "UNKNOWN_ERROR_CODE(" + n2 + ")";
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 13: {
                return "CANCELED";
            }
            case 14: {
                return "TIMEOUT";
            }
            case 15: {
                return "INTERRUPTED";
            }
            case 16: {
                return "API_UNAVAILABLE";
            }
            case 17: {
                return "SIGN_IN_FAILED";
            }
            case 18: {
                return "SERVICE_UPDATING";
            }
            case 19: {
                return "SERVICE_MISSING_PERMISSION";
            }
            case 20: 
        }
        return "RESTRICTED_PROFILE";
    }

    public void a(Activity activity, int n2) {
        if (!this.a()) {
            return;
        }
        activity.startIntentSenderForResult(this.d.getIntentSender(), n2, null, 0, 0, 0);
    }

    public boolean a() {
        if (this.c == 0) return false;
        if (this.d == null) return false;
        return true;
    }

    public boolean b() {
        if (this.c != 0) return false;
        return true;
    }

    public int c() {
        return this.c;
    }

    public PendingIntent d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult)object;
        if (this.c != connectionResult.c) return false;
        if (!bc.a((Object)this.d, (Object)connectionResult.d)) return false;
        if (bc.a((Object)this.e, (Object)connectionResult.e)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.c, this.d, this.e};
        return bc.a(arrobject);
    }

    public String toString() {
        return bc.a((Object)this).a("statusCode", ConnectionResult.a(this.c)).a("resolution", (Object)this.d).a("message", this.e).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        i.a(this, parcel, n2);
    }
}

