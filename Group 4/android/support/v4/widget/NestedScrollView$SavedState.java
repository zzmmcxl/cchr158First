/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.widget.af;
import android.view.View;

class NestedScrollView$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new af();
    public int a;

    public NestedScrollView$SavedState(Parcel parcel) {
        super(parcel);
        this.a = parcel.readInt();
    }

    NestedScrollView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " scrollPosition=" + this.a + "}";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeInt(this.a);
    }
}

