package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaSessionCompat$ResultReceiverWrapper$1 implements Parcelable$Creator<ResultReceiverWrapper> {
    MediaSessionCompat$ResultReceiverWrapper$1() {
        super();
    }
    
    public ResultReceiverWrapper createFromParcel(final Parcel parcel) {
        return new ResultReceiverWrapper(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public ResultReceiverWrapper[] newArray(final int n) {
        return new ResultReceiverWrapper[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}