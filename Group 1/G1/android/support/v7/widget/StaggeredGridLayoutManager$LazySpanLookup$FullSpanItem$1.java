package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1 implements Parcelable$Creator<FullSpanItem> {
    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$1() {
        super();
    }
    
    public FullSpanItem createFromParcel(final Parcel parcel) {
        return new FullSpanItem(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public FullSpanItem[] newArray(final int n) {
        return new FullSpanItem[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}