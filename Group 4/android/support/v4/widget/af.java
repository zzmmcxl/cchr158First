/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.widget.NestedScrollView$SavedState;

final class af
implements Parcelable.Creator {
    af() {
    }

    public NestedScrollView$SavedState a(Parcel parcel) {
        return new NestedScrollView$SavedState(parcel);
    }

    public NestedScrollView$SavedState[] a(int n2) {
        return new NestedScrollView$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

