/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.k;
import android.view.View;

public class BottomSheetBehavior$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new k();
    final int a;

    public BottomSheetBehavior$SavedState(Parcel parcel) {
        super(parcel);
        this.a = parcel.readInt();
    }

    public BottomSheetBehavior$SavedState(Parcelable parcelable, int n2) {
        super(parcelable);
        this.a = n2;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeInt(this.a);
    }
}

