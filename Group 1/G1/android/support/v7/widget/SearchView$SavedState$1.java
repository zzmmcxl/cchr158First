package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class SearchView$SavedState$1 implements Parcelable$Creator<SavedState> {
    SearchView$SavedState$1() {
        super();
    }
    
    public SavedState createFromParcel(final Parcel parcel) {
        return new SavedState(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public SavedState[] newArray(final int n) {
        return new SavedState[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}