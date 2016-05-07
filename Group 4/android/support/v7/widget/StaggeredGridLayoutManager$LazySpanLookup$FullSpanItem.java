/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.ga;
import java.util.Arrays;

class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new ga();
    int a;
    int b;
    int[] c;
    boolean d;

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel parcel) {
        int n2 = 1;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        if (parcel.readInt() != n2) {
            n2 = 0;
        }
        this.d = n2;
        int n3 = parcel.readInt();
        if (n3 <= 0) return;
        this.c = new int[n3];
        parcel.readIntArray(this.c);
    }

    int a(int n2) {
        if (this.c != null) return this.c[n2];
        return 0;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FullSpanItem{mPosition=" + this.a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.d + ", mGapPerSpan=" + Arrays.toString(this.c) + '}';
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        int n3 = this.d ? 1 : 0;
        parcel.writeInt(n3);
        if (this.c != null && this.c.length > 0) {
            parcel.writeInt(this.c.length);
            parcel.writeIntArray(this.c);
            return;
        }
        parcel.writeInt(0);
    }
}

