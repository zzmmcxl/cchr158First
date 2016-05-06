package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaMetadataCompat$1 implements Parcelable$Creator<MediaMetadataCompat> {
    MediaMetadataCompat$1() {
        super();
    }
    
    public MediaMetadataCompat createFromParcel(final Parcel parcel) {
        return new MediaMetadataCompat(parcel, null);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public MediaMetadataCompat[] newArray(final int n) {
        return new MediaMetadataCompat[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}