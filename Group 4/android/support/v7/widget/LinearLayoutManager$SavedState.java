/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.de;

public class LinearLayoutManager$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new de();
    int a;
    int b;
    boolean c;

    public LinearLayoutManager$SavedState() {
    }

    LinearLayoutManager$SavedState(Parcel parcel) {
        int n2 = 1;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        if (parcel.readInt() != n2) {
            n2 = 0;
        }
        this.c = n2;
    }

    public LinearLayoutManager$SavedState(LinearLayoutManager$SavedState linearLayoutManager$SavedState) {
        this.a = linearLayoutManager$SavedState.a;
        this.b = linearLayoutManager$SavedState.b;
        this.c = linearLayoutManager$SavedState.c;
    }

    boolean a() {
        if (this.a < 0) return false;
        return true;
    }

    void b() {
        this.a = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        int n3 = this.c ? 1 : 0;
        parcel.writeInt(n3);
    }
}

