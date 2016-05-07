/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.s;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class GestureRequest
implements SafeParcelable {
    public static final s CREATOR;
    private static final List a;
    private static final List b;
    private static final List c;
    private static final List d;
    private final int e;
    private final List f;

    static {
        Integer[] arrinteger = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        a = Collections.unmodifiableList(Arrays.asList(arrinteger));
        Integer[] arrinteger2 = new Integer[]{1};
        b = Collections.unmodifiableList(Arrays.asList(arrinteger2));
        Integer[] arrinteger3 = new Integer[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 19};
        c = Collections.unmodifiableList(Arrays.asList(arrinteger3));
        Integer[] arrinteger4 = new Integer[]{3, 5, 7, 9, 11, 13, 15, 17};
        d = Collections.unmodifiableList(Arrays.asList(arrinteger4));
        CREATOR = new s();
    }

    GestureRequest(int n2, List list) {
        this.e = n2;
        this.f = list;
    }

    public int a() {
        return this.e;
    }

    public List b() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        s.a(this, parcel, n2);
    }
}

