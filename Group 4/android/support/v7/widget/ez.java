/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView$SavedState;

final class ez
implements Parcelable.Creator {
    ez() {
    }

    public RecyclerView$SavedState a(Parcel parcel) {
        return new RecyclerView$SavedState(parcel);
    }

    public RecyclerView$SavedState[] a(int n2) {
        return new RecyclerView$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

