package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaBrowserCompat$MediaItem$1 implements Parcelable$Creator<MediaItem> {
    MediaBrowserCompat$MediaItem$1() {
        super();
    }
    
    public MediaItem createFromParcel(final Parcel parcel) {
        return new MediaItem(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public MediaItem[] newArray(final int n) {
        return new MediaItem[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}