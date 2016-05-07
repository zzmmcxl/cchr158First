/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.gr;
import android.view.View;

public class Toolbar$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = new gr();
    int a;
    boolean b;

    public Toolbar$SavedState(Parcel parcel) {
        super(parcel);
        this.a = parcel.readInt();
        boolean bl2 = parcel.readInt() != 0;
        this.b = bl2;
    }

    public Toolbar$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeInt(this.a);
        int n3 = this.b ? 1 : 0;
        parcel.writeInt(n3);
    }
}

