/*
 * Decompiled with CFR 0_115.
 */
package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;

final class ga
implements Parcelable.Creator {
    ga() {
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem a(Parcel parcel) {
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(parcel);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[] a(int n2) {
        return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[n2];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return this.a(parcel);
    }

    public /* synthetic */ Object[] newArray(int n2) {
        return this.a(n2);
    }
}

