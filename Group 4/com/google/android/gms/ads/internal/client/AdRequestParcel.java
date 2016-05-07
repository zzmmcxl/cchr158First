/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.i;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@fi
public final class AdRequestParcel
implements SafeParcelable {
    public static final i CREATOR = new i();
    public final int a;
    public final long b;
    public final Bundle c;
    public final int d;
    public final List e;
    public final boolean f;
    public final int g;
    public final boolean h;
    public final String i;
    public final SearchAdRequestParcel j;
    public final Location k;
    public final String l;
    public final Bundle m;
    public final Bundle n;
    public final List o;
    public final String p;
    public final String q;
    public final boolean r;

    public AdRequestParcel(int n2, long l2, Bundle bundle, int n3, List list, boolean bl2, int n4, boolean bl3, String string, SearchAdRequestParcel searchAdRequestParcel, Location location, String string2, Bundle bundle2, Bundle bundle3, List list2, String string3, String string4, boolean bl4) {
        this.a = n2;
        this.b = l2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.c = bundle;
        this.d = n3;
        this.e = list;
        this.f = bl2;
        this.g = n4;
        this.h = bl3;
        this.i = string;
        this.j = searchAdRequestParcel;
        this.k = location;
        this.l = string2;
        this.m = bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = string3;
        this.q = string4;
        this.r = bl4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (!(object instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel)object;
        if (this.a != adRequestParcel.a) return false;
        if (this.b != adRequestParcel.b) return false;
        if (!bc.a((Object)this.c, (Object)adRequestParcel.c)) return false;
        if (this.d != adRequestParcel.d) return false;
        if (!bc.a((Object)this.e, (Object)adRequestParcel.e)) return false;
        if (this.f != adRequestParcel.f) return false;
        if (this.g != adRequestParcel.g) return false;
        if (this.h != adRequestParcel.h) return false;
        if (!bc.a((Object)this.i, (Object)adRequestParcel.i)) return false;
        if (!bc.a((Object)this.j, (Object)adRequestParcel.j)) return false;
        if (!bc.a((Object)this.k, (Object)adRequestParcel.k)) return false;
        if (!bc.a((Object)this.l, (Object)adRequestParcel.l)) return false;
        if (!bc.a((Object)this.m, (Object)adRequestParcel.m)) return false;
        if (!bc.a((Object)this.n, (Object)adRequestParcel.n)) return false;
        if (!bc.a((Object)this.o, (Object)adRequestParcel.o)) return false;
        if (!bc.a((Object)this.p, (Object)adRequestParcel.p)) return false;
        if (!bc.a((Object)this.q, (Object)adRequestParcel.q)) return false;
        if (this.r != adRequestParcel.r) return false;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r};
        return bc.a(arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        i.a(this, parcel, n2);
    }
}

