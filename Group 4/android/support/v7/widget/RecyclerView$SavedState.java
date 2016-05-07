/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ep;
import android.support.v7.widget.ez;
import android.view.View;

public class RecyclerView$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new ez();
    Parcelable a;

    RecyclerView$SavedState(Parcel parcel) {
        super(parcel);
        this.a = parcel.readParcelable(ep.class.getClassLoader());
    }

    RecyclerView$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private void a(RecyclerView$SavedState recyclerView$SavedState) {
        this.a = recyclerView$SavedState.a;
    }

    static /* synthetic */ void a(RecyclerView$SavedState recyclerView$SavedState, RecyclerView$SavedState recyclerView$SavedState2) {
        recyclerView$SavedState.a(recyclerView$SavedState2);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeParcelable(this.a, 0);
    }
}

