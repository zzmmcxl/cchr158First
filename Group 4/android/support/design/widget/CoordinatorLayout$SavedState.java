/*
 * Decompiled with CFR 0_115.
 */
package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.v;
import android.support.v4.e.d;
import android.util.SparseArray;
import android.view.View;

public class CoordinatorLayout$SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator CREATOR = d.a(new v());
    SparseArray a;

    public CoordinatorLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel);
        int n2 = parcel.readInt();
        int[] arrn = new int[n2];
        parcel.readIntArray(arrn);
        Parcelable[] arrparcelable = parcel.readParcelableArray(classLoader);
        this.a = new SparseArray(n2);
        int n3 = 0;
        while (n3 < n2) {
            this.a.append(arrn[n3], (Object)arrparcelable[n3]);
            ++n3;
        }
    }

    public CoordinatorLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        int n3 = 0;
        super.writeToParcel(parcel, n2);
        int n4 = this.a != null ? this.a.size() : 0;
        parcel.writeInt(n4);
        int[] arrn = new int[n4];
        Parcelable[] arrparcelable = new Parcelable[n4];
        do {
            if (n3 >= n4) {
                parcel.writeIntArray(arrn);
                parcel.writeParcelableArray(arrparcelable, n2);
                return;
            }
            arrn[n3] = this.a.keyAt(n3);
            arrparcelable[n3] = (Parcelable)this.a.valueAt(n3);
            ++n3;
        } while (true);
    }
}

