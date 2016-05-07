/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager$SavedState;

final class de
implements Parcelable.Creator {
    de() {
    }

    public LinearLayoutManager$SavedState a(Parcel parcel) {
        return new LinearLayoutManager$SavedState(parcel);
    }

    public LinearLayoutManager$SavedState[] a(int n2) {
        return new LinearLayoutManager$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

