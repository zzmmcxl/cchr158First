package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable$Creator;

static final class MediaSessionCompat$QueueItem$1 implements Parcelable$Creator<QueueItem> {
    MediaSessionCompat$QueueItem$1() {
        super();
    }
    
    public QueueItem createFromParcel(final Parcel parcel) {
        return new QueueItem(parcel);
    }
    
    public /* bridge */ Object createFromParcel(final Parcel parcel) {
        return this.createFromParcel(parcel);
    }
    
    public QueueItem[] newArray(final int n) {
        return new QueueItem[n];
    }
    
    public /* bridge */ Object[] newArray(final int n) {
        return this.newArray(n);
    }
}