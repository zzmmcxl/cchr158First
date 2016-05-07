/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

class SearchView$SavedState
extends View.BaseSavedState {
    boolean a;

    SearchView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode((Object)this)) + " isIconified=" + this.a + "}";
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeValue((Object)this.a);
    }
}

