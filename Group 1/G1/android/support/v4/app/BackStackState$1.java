package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class BackStackState$1 implements Parcelable$Creator<BackStackState> {
    BackStackState$1() {
        super();
    }
    
    public BackStackState createFromParcel(final Parcel parcel) {
        return new BackStackState(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public BackStackState[] newArray(final int n) {
        return new BackStackState[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}