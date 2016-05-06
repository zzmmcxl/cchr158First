package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class RatingCompat$1 implements Parcelable$Creator<RatingCompat> {
    RatingCompat$1() {
        super();
    }
    
    public RatingCompat createFromParcel(final Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat(), null);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public RatingCompat[] newArray(final int n) {
        return new RatingCompat[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}