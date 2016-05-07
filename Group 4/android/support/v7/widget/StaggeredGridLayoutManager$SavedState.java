/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import android.support.v7.widget.gb;
import java.util.ArrayList;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR = new gb();
    int a;
    int b;
    int c;
    int[] d;
    int e;
    int[] f;
    List g;
    boolean h;
    boolean i;
    boolean j;

    public StaggeredGridLayoutManager$SavedState() {
    }

    StaggeredGridLayoutManager$SavedState(Parcel parcel) {
        int n2 = 1;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        if (this.c > 0) {
            this.d = new int[this.c];
            parcel.readIntArray(this.d);
        }
        this.e = parcel.readInt();
        if (this.e > 0) {
            this.f = new int[this.e];
            parcel.readIntArray(this.f);
        }
        int n3 = parcel.readInt() == n2 ? n2 : 0;
        this.h = n3;
        int n4 = parcel.readInt() == n2 ? n2 : 0;
        this.i = n4;
        if (parcel.readInt() != n2) {
            n2 = 0;
        }
        this.j = n2;
        this.g = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
    }

    public StaggeredGridLayoutManager$SavedState(StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState) {
        this.c = staggeredGridLayoutManager$SavedState.c;
        this.a = staggeredGridLayoutManager$SavedState.a;
        this.b = staggeredGridLayoutManager$SavedState.b;
        this.d = staggeredGridLayoutManager$SavedState.d;
        this.e = staggeredGridLayoutManager$SavedState.e;
        this.f = staggeredGridLayoutManager$SavedState.f;
        this.h = staggeredGridLayoutManager$SavedState.h;
        this.i = staggeredGridLayoutManager$SavedState.i;
        this.j = staggeredGridLayoutManager$SavedState.j;
        this.g = staggeredGridLayoutManager$SavedState.g;
    }

    void a() {
        this.d = null;
        this.c = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
    }

    void b() {
        this.d = null;
        this.c = 0;
        this.a = -1;
        this.b = -1;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        int n3 = 1;
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        if (this.c > 0) {
            parcel.writeIntArray(this.d);
        }
        parcel.writeInt(this.e);
        if (this.e > 0) {
            parcel.writeIntArray(this.f);
        }
        int n4 = this.h ? n3 : 0;
        parcel.writeInt(n4);
        int n5 = this.i ? n3 : 0;
        parcel.writeInt(n5);
        if (!this.j) {
            n3 = 0;
        }
        parcel.writeInt(n3);
        parcel.writeList(this.g);
    }
}

