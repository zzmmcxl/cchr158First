/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.StaggeredGridLayoutManager$SavedState;

final class gb
implements Parcelable.Creator {
    gb() {
    }

    public StaggeredGridLayoutManager$SavedState a(Parcel parcel) {
        return new StaggeredGridLayoutManager$SavedState(parcel);
    }

    public StaggeredGridLayoutManager$SavedState[] a(int n2) {
        return new StaggeredGridLayoutManager$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

