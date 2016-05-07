/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.BottomSheetBehavior$SavedState;

final class k
implements Parcelable.Creator {
    k() {
    }

    public BottomSheetBehavior$SavedState a(Parcel parcel) {
        return new BottomSheetBehavior$SavedState(parcel);
    }

    public BottomSheetBehavior$SavedState[] a(int n2) {
        return new BottomSheetBehavior$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

