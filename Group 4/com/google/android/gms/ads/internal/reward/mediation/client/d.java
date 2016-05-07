/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class d
implements Parcelable.Creator {
    static void a(RewardItemParcel rewardItemParcel, Parcel parcel, int n2) {
        int n3 = c.a(parcel);
        c.a(parcel, 1, rewardItemParcel.a);
        c.a(parcel, 2, rewardItemParcel.b, false);
        c.a(parcel, 3, rewardItemParcel.c);
        c.a(parcel, n3);
    }

    public RewardItemParcel a(Parcel parcel) {
        int n2 = 0;
        int n3 = a.b(parcel);
        String string = null;
        int n4 = 0;
        block5 : do {
            if (parcel.dataPosition() >= n3) {
                if (parcel.dataPosition() == n3) return new RewardItemParcel(n4, string, n2);
                throw new b("Overread allowed size end=" + n3, parcel);
            }
            int n5 = a.a(parcel);
            switch (a.a(n5)) {
                default: {
                    a.b(parcel, n5);
                    continue block5;
                }
                case 1: {
                    n4 = a.e(parcel, n5);
                    continue block5;
                }
                case 2: {
                    string = a.l(parcel, n5);
                    continue block5;
                }
                case 3: 
            }
            n2 = a.e(parcel, n5);
        } while (true);
    }

    public RewardItemParcel[] a(int n2) {
        return new RewardItemParcel[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

