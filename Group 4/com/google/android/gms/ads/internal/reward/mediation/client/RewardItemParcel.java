/*
 * Decompiled with CFR 0_115.
 */
package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.mediation.client.d;
import com.google.android.gms.b.fi;
import com.google.android.gms.common.internal.bc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@fi
public final class RewardItemParcel
implements SafeParcelable {
    public static final d CREATOR = new d();
    public final int a;
    public final String b;
    public final int c;

    public RewardItemParcel(int n2, String string, int n3) {
        this.a = n2;
        this.b = string;
        this.c = n3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof RewardItemParcel)) {
            return false;
        }
        RewardItemParcel rewardItemParcel = (RewardItemParcel)object;
        if (!bc.a((Object)this.b, (Object)rewardItemParcel.b)) return false;
        if (!bc.a((Object)this.c, (Object)rewardItemParcel.c)) return false;
        return true;
    }

    public int hashCode() {
        Object[] arrobject = new Object[]{this.b, this.c};
        return bc.a(arrobject);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        d.a(this, parcel, n2);
    }
}

