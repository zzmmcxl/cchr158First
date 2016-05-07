/*
 * Decompiled with CFR 0_115.
 */
package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.FragmentState;
import android.support.v4.app.ar;

final class FragmentManagerState
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new ar();
    FragmentState[] a;
    int[] b;
    BackStackState[] c;

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.a = (FragmentState[])parcel.createTypedArray(FragmentState.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (BackStackState[])parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeTypedArray(this.a, n2);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray(this.c, n2);
    }
}

