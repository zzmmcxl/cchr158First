/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.c;

public class ClientIdentity
implements SafeParcelable {
    public static final c CREATOR = new c();
    public final int a;
    public final String b;
    private final int c;

    ClientIdentity(int n2, int n3, String string) {
        this.c = n2;
        this.a = n3;
        this.b = string;
    }

    int a() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null) return false;
        if (!(object instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity)object;
        if (clientIdentity.a != this.a) return false;
        if (bc.a((Object)clientIdentity.b, (Object)this.b)) return true;
        return false;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.a, this.b};
        return String.format("%d:%s", arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        c.a(this, parcel, n2);
    }
}

