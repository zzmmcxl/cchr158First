/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.be;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AutocompleteFilter
implements SafeParcelable {
    public static final b CREATOR = new b();
    final int a;
    final boolean b;
    final List c;
    final int d;

    AutocompleteFilter(int n2, boolean bl2, List list) {
        int n3 = 1;
        this.a = n2;
        this.c = list;
        this.d = AutocompleteFilter.a(list);
        if (this.a >= n3) {
            this.b = bl2;
            return;
        }
        if (bl2) {
            n3 = 0;
        }
        this.b = n3;
    }

    private static int a(Collection collection) {
        if (collection == null) return 0;
        if (!collection.isEmpty()) return (Integer)collection.iterator().next();
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter)object;
        if (this.d != this.d) return false;
        if (this.b == autocompleteFilter.b) return true;
        return false;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.d};
        return bc.a(arrobject);
    }

    public String toString() {
        return bc.a((Object)this).a("includeQueryPredictions", this.b).a("typeFilter", this.d).toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        b.a(this, parcel, n2);
    }
}

