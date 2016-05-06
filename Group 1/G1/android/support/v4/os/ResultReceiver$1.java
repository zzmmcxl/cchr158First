package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class ResultReceiver$1 implements Parcelable$Creator<ResultReceiver> {
    ResultReceiver$1() {
        super();
    }
    
    public ResultReceiver createFromParcel(final Parcel parcel) {
        return new ResultReceiver(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public ResultReceiver[] newArray(final int n) {
        return new ResultReceiver[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}