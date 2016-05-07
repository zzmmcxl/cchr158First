/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.Toolbar$SavedState;

final class gr
implements Parcelable.Creator {
    gr() {
    }

    public Toolbar$SavedState a(Parcel parcel) {
        return new Toolbar$SavedState(parcel);
    }

    public Toolbar$SavedState[] a(int n2) {
        return new Toolbar$SavedState[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

