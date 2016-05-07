/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;

final class t
implements Parcelable.Creator {
    t() {
    }

    public BackStackState a(Parcel parcel) {
        return new BackStackState(parcel);
    }

    public BackStackState[] a(int n2) {
        return new BackStackState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

