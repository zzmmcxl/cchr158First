package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class ParcelableVolumeInfo$1 implements Parcelable$Creator<ParcelableVolumeInfo> {
    ParcelableVolumeInfo$1() {
        super();
    }
    
    public ParcelableVolumeInfo createFromParcel(final Parcel parcel) {
        return new ParcelableVolumeInfo(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public ParcelableVolumeInfo[] newArray(final int n) {
        return new ParcelableVolumeInfo[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}