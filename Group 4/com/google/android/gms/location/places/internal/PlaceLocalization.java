/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.internal.b;
import java.util.List;

@Deprecated
public final class PlaceLocalization
implements SafeParcelable {
    public static final b CREATOR = new b();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;

    public PlaceLocalization(int n2, String string, String string2, String string3, String string4, List list) {
        this.a = n2;
        this.b = string;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = list;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization)object;
        if (!bc.a((Object)this.b, (Object)placeLocalization.b)) return false;
        if (!bc.a((Object)this.c, (Object)placeLocalization.c)) return false;
        if (!bc.a((Object)this.d, (Object)placeLocalization.d)) return false;
        if (!bc.a((Object)this.e, (Object)placeLocalization.e)) return false;
        if (bc.a((Object)this.f, (Object)placeLocalization.f)) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.c, this.d, this.e};
        return bc.a(arrobject);
    }

    public String toString() {
        return bc.a((Object)this).a("name", this.b).a("address", this.c).a("internationalPhoneNumber", this.d).a("regularOpenHours", this.e).a("attributions", this.f).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

