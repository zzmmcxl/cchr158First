/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
implements Parcelable.Creator {
    static void a(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, gInAppPurchaseManagerInfoParcel.a);
        c.a(parcel, 3, gInAppPurchaseManagerInfoParcel.b(), false);
        c.a(parcel, 4, gInAppPurchaseManagerInfoParcel.c(), false);
        c.a(parcel, 5, gInAppPurchaseManagerInfoParcel.d(), false);
        c.a(parcel, 6, gInAppPurchaseManagerInfoParcel.a(), false);
        c.a(parcel, n3);
    }

    public GInAppPurchaseManagerInfoParcel a(Parcel parcel) {
        IBinder iBinder = null;
        int n2 = com.google.android.gms.common.internal.safeparcel.a.b(parcel);
        int n3 = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        block7 : do {
            if (parcel.dataPosition() >= n2) {
                if (parcel.dataPosition() == n2) return new GInAppPurchaseManagerInfoParcel(n3, iBinder4, iBinder3, iBinder2, iBinder);
                throw new b("Overread allowed size end=" + n2, parcel);
            }
            int n4 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(n4)) {
                default: {
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, n4);
                    continue block7;
                }
                case 1: {
                    n3 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, n4);
                    continue block7;
                }
                case 3: {
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block7;
                }
                case 4: {
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block7;
                }
                case 5: {
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
                    continue block7;
                }
                case 6: 
            }
            iBinder = com.google.android.gms.common.internal.safeparcel.a.m(parcel, n4);
        } while (true);
    }

    public GInAppPurchaseManagerInfoParcel[] a(int n2) {
        return new GInAppPurchaseManagerInfoParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

