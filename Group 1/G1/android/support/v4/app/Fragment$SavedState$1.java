package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class Fragment$SavedState$1 implements Parcelable$Creator<SavedState> {
    Fragment$SavedState$1() {
        super();
    }
    
    public SavedState createFromParcel(final Parcel parcel) {
        return new SavedState(parcel, null);
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