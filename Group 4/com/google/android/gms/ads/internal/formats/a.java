/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
implements Parcelable.Creator {
    static void a(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, nativeAdOptionsParcel.a);
        c.a(parcel, 2, nativeAdOptionsParcel.b);
        c.a(parcel, 3, nativeAdOptionsParcel.c);
        c.a(parcel, 4, nativeAdOptionsParcel.d);
        c.a(parcel, n3);
    }

    public NativeAdOptionsParcel a(Parcel parcel) {
        boolean bl2 = false;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n3 = 0;
        boolean bl3 = false;
        int n4 = 0;
        block6 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new NativeAdOptionsParcel(n4, bl3, n3, bl2);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n5 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n5)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n5);
                    continue block6;
                }
                case 1: {
                    n4 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block6;
                }
                case 2: {
                    bl3 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n5);
                    continue block6;
                }
                case 3: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n5);
                    continue block6;
                }
                case 4: 
            }
            bl2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, n5);
        } while (true);
    }

    public NativeAdOptionsParcel[] a(int n2) {
        return new NativeAdOptionsParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

