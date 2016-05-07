/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.internal.PlaceLocalization;
import com.google.android.gms.location.places.internal.a;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl
implements SafeParcelable,
com.google.android.gms.location.places.a {
    public static final a CREATOR = new a();
    final int a;
    private final String b;
    private final Bundle c;
    @Deprecated
    private final PlaceLocalization d;
    private final LatLng e;
    private final float f;
    private final LatLngBounds g;
    private final String h;
    private final Uri i;
    private final boolean j;
    private final float k;
    private final int l;
    private final long m;
    private final List n;
    private final List o;
    private final String p;
    private final String q;
    private final String r;
    private final String s;
    private final List t;
    private final Map u;
    private final TimeZone v;
    private Locale w;

    PlaceImpl(int n2, String string, List list, List list2, Bundle bundle, String string2, String string3, String string4, String string5, List list3, LatLng latLng, float f2, LatLngBounds latLngBounds, String string6, Uri uri, boolean bl2, float f3, int n3, long l2, PlaceLocalization placeLocalization) {
        this.a = n2;
        this.b = string;
        this.o = Collections.unmodifiableList(list);
        this.n = list2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.c = bundle;
        this.p = string2;
        this.q = string3;
        this.r = string4;
        this.s = string5;
        if (list3 == null) {
            list3 = Collections.emptyList();
        }
        this.t = list3;
        this.e = latLng;
        this.f = f2;
        this.g = latLngBounds;
        if (string6 == null) {
            string6 = "UTC";
        }
        this.h = string6;
        this.i = uri;
        this.j = bl2;
        this.k = f3;
        this.l = n3;
        this.m = l2;
        this.u = Collections.unmodifiableMap(new HashMap());
        this.v = null;
        this.w = null;
        this.d = placeLocalization;
    }

    @Override
    public /* synthetic */ CharSequence a() {
        return this.h();
    }

    @Override
    public /* synthetic */ CharSequence b() {
        return this.g();
    }

    @Override
    public LatLng c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public List e() {
        return this.o;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl)object;
        if (!this.b.equals(placeImpl.b)) return false;
        if (!bc.a((Object)this.w, (Object)placeImpl.w)) return false;
        if (this.m == placeImpl.m) return true;
        return false;
    }

    public List f() {
        return this.n;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.q;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.w, this.m};
        return bc.a(arrobject);
    }

    public float i() {
        return this.f;
    }

    public LatLngBounds j() {
        return this.g;
    }

    public Uri k() {
        return this.i;
    }

    public String l() {
        return this.r;
    }

    public String m() {
        return this.s;
    }

    public List n() {
        return this.t;
    }

    public boolean o() {
        return this.j;
    }

    public float p() {
        return this.k;
    }

    public int q() {
        return this.l;
    }

    public long r() {
        return this.m;
    }

    public Bundle s() {
        return this.c;
    }

    public String t() {
        return this.h;
    }

    @SuppressLint(value={"DefaultLocale"})
    public String toString() {
        return bc.a((Object)this).a("id", this.b).a("placeTypes", this.o).a("locale", this.w).a("name", this.p).a("address", this.q).a("phoneNumber", this.r).a("latlng", this.e).a("viewport", this.g).a("websiteUri", (Object)this.i).a("isPermanentlyClosed", this.j).a("priceLevel", this.l).a("timestampSecs", this.m).toString();
    }

    @Deprecated
    public PlaceLocalization u() {
        return this.d;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        a.a(this, parcel, n2);
    }
}

