package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class FragmentManagerState$1 implements Parcelable$Creator<FragmentManagerState> {
    FragmentManagerState$1() {
        super();
    }
    
    public FragmentManagerState createFromParcel(final Parcel parcel) {
        return new FragmentManagerState(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public FragmentManagerState[] newArray(final int n) {
        return new FragmentManagerState[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}