/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentManagerState;

final class ar
implements Parcelable.Creator {
    ar() {
    }

    public FragmentManagerState a(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    public FragmentManagerState[] a(int n2) {
        return new FragmentManagerState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

