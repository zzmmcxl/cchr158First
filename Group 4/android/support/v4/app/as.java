/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentState;

final class as
implements Parcelable.Creator {
    as() {
    }

    public FragmentState a(Parcel parcel) {
        return new FragmentState(parcel);
    }

    public FragmentState[] a(int n2) {
        return new FragmentState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

