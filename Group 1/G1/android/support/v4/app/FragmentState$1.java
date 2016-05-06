package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class FragmentState$1 implements Parcelable$Creator<FragmentState> {
    FragmentState$1() {
        super();
    }
    
    public FragmentState createFromParcel(final Parcel parcel) {
        return new FragmentState(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public FragmentState[] newArray(final int n) {
        return new FragmentState[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}